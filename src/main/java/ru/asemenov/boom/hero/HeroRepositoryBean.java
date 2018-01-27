package ru.asemenov.boom.hero;

import org.springframework.stereotype.Repository;
import ru.asemenov.boom.common.repository.AbstractRepository;

/**
 * @author a.semenov
 */
@Repository
public class HeroRepositoryBean extends AbstractRepository implements HeroRepository {
    @Override
    public void save(Hero hero) {

    }
}
