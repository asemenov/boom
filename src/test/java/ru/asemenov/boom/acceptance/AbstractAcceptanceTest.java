package ru.asemenov.boom.acceptance;

import org.springframework.boot.test.web.client.TestRestTemplate;
import ru.asemenov.boom.acceptance.hero.Heroes;
import ru.asemenov.boom.acceptance.publisher.Publishers;

/**
 * @author a.semenov
 */
public abstract class AbstractAcceptanceTest {
    private String url = "http://localhost:8080/";

    protected final TestRestTemplate template = new TestRestTemplate();

    protected final String url(final String path) {
        return url + path;
    }

    protected final Heroes heroes() {
        return new Heroes(template, url + "/api");
    }

    protected final Publishers publishers() {
        return new Publishers(template, url + "/api");
    }
}
