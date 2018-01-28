package ru.asemenov.boom.hero;

import org.springframework.data.rest.core.config.Projection;

import java.util.Date;
import java.util.List;

/**
 * @author a.semenov
 */
@Projection(name = "detailed", types = {Hero.class})
public interface DetailedHeroProjection {
    Long getId();

    String getName();

    String getPseudonym();

    List<String> getSkills();

    Date getFirstAppearanceDate();

    /*@Value("#{target.publisherName()}")
    String getPublisher();*/
}
