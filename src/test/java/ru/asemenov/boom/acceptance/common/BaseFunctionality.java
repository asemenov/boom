package ru.asemenov.boom.acceptance.common;

import org.springframework.boot.test.web.client.TestRestTemplate;

/**
 * @author a.semenov
 */
public abstract class BaseFunctionality {
    protected final TestRestTemplate template;
    private final String url;

    public BaseFunctionality(TestRestTemplate template, String url) {
        this.template = template;
        this.url = url;
    }

    protected final String url(String path) {
        return url + path;
    }
}
