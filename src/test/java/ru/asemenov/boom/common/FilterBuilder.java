package ru.asemenov.boom.common;

import ru.asemenov.boom.common.context.BuilderContext;

/**
 * @author a.semenov
 */
public class FilterBuilder {
    private String name;

    public static FilterBuilder all() {
        return new FilterBuilder();
    }

    public void build(BuilderContext context) {
        context.add("name", name);
    }

    public FilterBuilder withName(String name) {
        this.name = name;
        return this;
    }
}
