package ru.asemenov.boom.hero;

import org.springframework.data.rest.core.config.Projection;

/**
 * @author a.semenov
 */
@Projection(name = "short", types = {Hero.class})
public interface ShortHeroProjection {
    Long getId();

    String getName();
}
