package ru.asemenov.boom.hero;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.asemenov.boom.common.NamedEntity;
import ru.asemenov.boom.common.Result;
import ru.asemenov.boom.common.list.CountedList;
import ru.asemenov.boom.common.list.Filter;

/**
 * @author a.semenov
 */
@Service
public class HeroServiceBean implements HeroService {
    private HeroRepository heroes;

    @Autowired
    public HeroServiceBean(HeroRepository heroes) {
        this.heroes = heroes;
    }

    @Override
    public Result<NamedEntity> add(final HeroIn source) {
        final Hero entity = new Hero();

        entity.setName(source.getName());

        heroes.save(entity);
        return Result.ok(new NamedEntity(entity));
    }

    @Override
    public Result<CountedList> list(final Filter filter) {
        return Result.ok(new CountedList<>());
    }
}
