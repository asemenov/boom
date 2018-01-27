package ru.asemenov.boom.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

/**
 * @author a.semenov
 */
public abstract class AbstractController {
    protected <E> ResponseEntity<?> wrap(Result<E> result, HttpStatus status) {
        if (result.isFailed()) {
            return new ResponseEntity<>(result, BAD_REQUEST);
        } else {
            return new ResponseEntity<>(result.getResult(), status);
        }
    }
}
