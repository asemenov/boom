package ru.asemenov.boom.common;

/**
 * @author a.semenov
 */
public class Builders {
    public static <E> E given(Builder<E> builder) {
        return builder.build();
    }
}
