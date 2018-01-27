package ru.asemenov.boom.common;

import org.mockito.Mockito;
import org.testng.annotations.BeforeClass;
import ru.asemenov.boom.hero.HeroRepository;
import ru.asemenov.boom.hero.HeroService;
import ru.asemenov.boom.hero.HeroServiceBean;

/**
 * @author a.semenov
 */
public abstract class AbstractServiceTest {
    protected HeroService heroService;

    protected HeroRepository heroRepository;

    @BeforeClass
    public void beforeClass() {
        heroRepository = Mockito.mock(HeroRepository.class);
        heroService = new HeroServiceBean(heroRepository);
    }
}
