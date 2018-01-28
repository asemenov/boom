package ru.asemenov.boom.acceptance.hero;

import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.testng.Assert;
import ru.asemenov.boom.acceptance.common.BaseFunctionality;
import ru.asemenov.boom.common.FilterBuilder;
import ru.asemenov.boom.common.Identified;
import ru.asemenov.boom.common.NamedEntity;
import ru.asemenov.boom.common.StandardResponse;
import ru.asemenov.boom.common.context.UrlBuilderContext;
import ru.asemenov.boom.hero.HeroData;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.HttpStatus.*;
import static org.testng.Assert.assertEquals;

/**
 * @author a.semenov
 */
public class Heroes extends BaseFunctionality {
    public Heroes(TestRestTemplate template, String url) {
        super(template, url);
    }

    public List<StandardResponse.Item> list(final FilterBuilder filter) {
        final UrlBuilderContext context = new UrlBuilderContext();

        filter.build(context);

        final String result = context.result();

        if (result.contains("name")) {
            return template.getForEntity(url("/heroes/search/byName?" + result), StandardResponse.class).getBody().getEmbedded().getItems();
        } else {
            return template.getForEntity(url("/heroes?" + result), StandardResponse.class).getBody().getEmbedded().getItems();
        }
    }

    public HeroData add(final HeroBuilder builder) {
        final HeroData data = builder.build();
        final ResponseEntity<HeroData> entity = template.postForEntity(url("/heroes"), asMap(data), HeroData.class);

        assertEquals(entity.getStatusCode(), CREATED);

        final HeroData result = entity.getBody();
        Assert.assertNotNull(result.getId());
        return result;
    }

    private Map asMap(HeroData data) {
        final Map result = new HashMap();

        result.put("name", data.getName());
        result.put("pseudonym", data.getPseudonym());
        result.put("skills", data.getSkills());
        result.put("firstAppearanceDate", data.getFirstAppearanceDate());

        if (data.getPublisher() != null) {
            result.put("publisher", "/api/publishers/" + data.getPublisher());
        }

        if (data.getAllies() != null) {
            result.put("allies", data.getAllies().stream().map(e -> "/api/heroes/" + e).collect(toList()));
        }

        return result;
    }

    public Optional<HeroData> byId(final Identified<Long> identified) {
        final ResponseEntity<HeroData> entity = template
                .getForEntity(url("/heroes/" + identified.getId() + "?projection=detailed"), HeroData.class);

        if (entity.getStatusCode() == OK) {
            return Optional.of(entity.getBody());
        } else {
            return Optional.empty();
        }
    }

    public Optional<NamedEntity> publisherFor(Identified<Long> identified) {
        final ResponseEntity<NamedEntity> entity = template
                .getForEntity(url("/heroes/" + identified.getId() + "/publisher"), NamedEntity.class);

        if (entity.getStatusCode() == OK) {
            return Optional.of(entity.getBody());
        } else if (entity.getStatusCode() == NOT_FOUND) {
            return Optional.empty();
        }

        throw new IllegalStateException("Unexpected status [" + entity.getStatusCode() + "]");
    }

    public List<NamedEntity> alliedFor(Identified<Long> identified) {
        return (List) template
                .getForEntity(url("/heroes/" + identified.getId() + "/allies"), StandardResponse.class)
                .getBody().getEmbedded().getItems();
    }
}
