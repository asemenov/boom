package ru.asemenov.boom.hero;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

/**
 * @author a.semenov
 */
@RepositoryRestResource(collectionResourceRel = "items", path = "heroes", excerptProjection = ShortHeroProjection.class)
public interface HeroRepository extends PagingAndSortingRepository<Hero, Long> {

    @RestResource(path = "byName", rel = "items")
    List<Hero> findByName(@Param("name") String name);
}
