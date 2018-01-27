package ru.asemenov.boom.common.context;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author a.semenov
 */
public class UrlBuilderContext implements BuilderContext<String> {
    private final Map<String, Object> values = new HashMap<>();

    @Override
    public String result() {
        return values.entrySet().stream()
                .filter(e -> e.getValue() != null)
                .map(e -> e.getKey() + "=" + e.getValue())
                .collect(Collectors.joining("&"));
    }

    @Override
    public void add(String key, Object value) {
        values.put(key, value);
    }
}
