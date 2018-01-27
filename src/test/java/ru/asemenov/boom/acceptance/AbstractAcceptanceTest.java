package ru.asemenov.boom.acceptance;

import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;
import ru.asemenov.boom.acceptance.hero.Heroes;

/**
 * @author a.semenov
 */
public abstract class AbstractAcceptanceTest {
    private String url = "http://localhost:8080/";

    protected final RestOperations template = new RestTemplate();

    protected String url(final String path) {
        return url + path;
    }

    protected Heroes heroes() {
        return new Heroes(template, url + "/api");
    }
}
