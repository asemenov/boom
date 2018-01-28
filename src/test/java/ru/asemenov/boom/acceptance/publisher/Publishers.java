package ru.asemenov.boom.acceptance.publisher;

import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import ru.asemenov.boom.acceptance.common.BaseFunctionality;
import ru.asemenov.boom.common.StandardResponse;
import ru.asemenov.boom.publisher.PublisherData;

import static org.springframework.http.HttpStatus.CREATED;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static ru.asemenov.boom.common.TestDataGenerator.newPublisher;

/**
 * @author a.semenov
 */
public class Publishers extends BaseFunctionality {
    public Publishers(TestRestTemplate template, String url) {
        super(template, url);
    }

    public PublisherData any() {
        final ResponseEntity<PublisherData> entity = template.postForEntity(url("/publishers"),
                newPublisher(),
                PublisherData.class);

        assertEquals(entity.getStatusCode(), CREATED);

        final PublisherData data = entity.getBody();
        assertNotNull(data.getId(), "Id must be provided");
        return data;
    }

    public StandardResponse.Item byName(final String name) {
        return template.getForEntity(url("/publishers/search/byName?name=" + name), StandardResponse.class)
                .getBody().getEmbedded()
                .getItems().stream().findFirst().get();
    }
}
