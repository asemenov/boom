package ru.asemenov.boom.hero;

import ru.asemenov.boom.common.NamedEntity;
import ru.asemenov.boom.common.Result;
import ru.asemenov.boom.common.list.CountedList;
import ru.asemenov.boom.common.list.Filter;

/**
 * @author a.semenov
 */
public interface HeroService {
    Result<CountedList> list(Filter filter);

    Result<NamedEntity> add(HeroIn source);
}
