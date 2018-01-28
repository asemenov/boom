package ru.asemenov.boom.common.context;

/**
 * @author a.semenov
 */
public interface BuilderContext<T> {
    void add(String key, Object value);

    T result();
}
