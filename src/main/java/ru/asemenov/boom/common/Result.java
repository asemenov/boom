package ru.asemenov.boom.common;

/**
 * @author a.semenov
 */
public class Result<T> {
    private boolean failed = false;
    private String message;
    private T result;

    public boolean isFailed() {
        return failed;
    }

    public T getResult() {
        return result;
    }

    public String getMessage() {
        return message;
    }

    public static <E> Result<E> ok(E entity) {
        final Result<E> result = new Result<>();
        result.result = entity;
        return result;
    }
}
