package ru.asemenov.boom.hero;

import org.mockito.ArgumentCaptor;
import org.testng.annotations.Test;
import ru.asemenov.boom.common.AbstractServiceTest;
import ru.asemenov.boom.common.NamedEntity;
import ru.asemenov.boom.common.Result;

import static org.mockito.Mockito.verify;
import static org.testng.Assert.*;
import static ru.asemenov.boom.acceptance.hero.HeroBuilder.aHero;
import static ru.asemenov.boom.common.Builders.given;

/**
 * @author a.semenov
 */
public class HeroServiceTest extends AbstractServiceTest {

    final ArgumentCaptor<Hero> heroCaptor = ArgumentCaptor.forClass(Hero.class);

    @Test
    public void test_HERO_CAN_BE_SAVED() {
        final HeroIn source = given(aHero());

        final Result<NamedEntity> result = heroService.add(source);

        assertNotNull(result);
        assertFalse(result.isFailed());
        assertEquals(result.getResult().getName(), source.getName());

        verify(heroRepository).save(heroCaptor.capture());
        assertEquals(heroCaptor.getValue().getName(), source.getName());
    }
}
