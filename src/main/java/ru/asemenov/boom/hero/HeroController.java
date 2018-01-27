package ru.asemenov.boom.hero;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.asemenov.boom.common.AbstractController;
import ru.asemenov.boom.common.list.Filter;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @author a.semenov
 */
@RestController
@RequestMapping("/api/heroes")
public class HeroController extends AbstractController {
    @Autowired
    private HeroService service;

    @RequestMapping(method = GET)
    public ResponseEntity<?> list(final HttpServletRequest request) {
        return wrap(service.list(new Filter()), OK);
    }

    @RequestMapping(method = POST)
    public ResponseEntity<?> post(@RequestBody HeroIn hero) {
        return wrap(service.add(hero), CREATED);
    }
}
