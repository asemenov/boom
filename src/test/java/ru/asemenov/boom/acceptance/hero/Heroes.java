package ru.asemenov.boom.acceptance.hero;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestOperations;
import ru.asemenov.boom.common.FilterBuilder;
import ru.asemenov.boom.common.NamedEntity;
import ru.asemenov.boom.common.context.UrlBuilderContext;
import ru.asemenov.boom.common.list.CountedList;

import static org.springframework.http.HttpStatus.CREATED;
import static org.testng.Assert.assertEquals;

/**
 * @author a.semenov
 */
public class Heroes {
    private final RestOperations template;
    private final String url;

    public Heroes(RestOperations template, String url) {
        this.template = template;
        this.url = url;
    }

    private String url(String path) {
        return url + path;
    }

    public CountedList list(final FilterBuilder filter) {
        final UrlBuilderContext context = new UrlBuilderContext();

        filter.build(context);

        return template.getForEntity(url("/heroes?" + context.result()), CountedList.class).getBody();
    }

    public NamedEntity add(HeroBuilder builder) {
        final ResponseEntity<NamedEntity> entity = template.postForEntity(url("/heroes"), builder.build(), NamedEntity.class);

        assertEquals(entity.getStatusCode(), CREATED);

        return entity.getBody();
    }
}
