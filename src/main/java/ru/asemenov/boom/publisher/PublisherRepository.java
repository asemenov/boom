package ru.asemenov.boom.publisher;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

/**
 * @author a.semenov
 */
@RepositoryRestResource(collectionResourceRel = "items", path = "publishers")
public interface PublisherRepository extends PagingAndSortingRepository<Publisher, Long> {
    @RestResource(path = "byName", rel = "items")
    List<Publisher> findByName(@Param("name") String name);
}
