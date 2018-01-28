package ru.asemenov.boom.common;

import java.util.Objects;

/**
 * @author a.semenov
 */
public interface Identified<T> {
    T getId();

    default <E extends Identified<T>> boolean sameAs(E entity) {
        return Objects.equals(getId(), entity.getId());
    }
}
