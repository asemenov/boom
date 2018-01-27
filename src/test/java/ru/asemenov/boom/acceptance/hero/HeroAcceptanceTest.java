package ru.asemenov.boom.acceptance.hero;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import ru.asemenov.boom.acceptance.AbstractAcceptanceTest;
import ru.asemenov.boom.common.Named;
import ru.asemenov.boom.common.NamedEntity;
import ru.asemenov.boom.common.list.CountedList;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static ru.asemenov.boom.Group.Acceptance;
import static ru.asemenov.boom.acceptance.hero.HeroBuilder.aHero;
import static ru.asemenov.boom.common.FilterBuilder.all;
import static ru.asemenov.boom.common.NamedMatchers.namedAs;

/**
 * @author a.semenov
 */
public class HeroAcceptanceTest extends AbstractAcceptanceTest {
    @Test(groups = Acceptance)
    public void test_LIST_HEROES() {
        final CountedList list = heroes().list(all());

        assertThat((List<Named>) list.getItems(), Matchers.not(hasItem(namedAs("unknown hero"))));
    }

    @Test(groups = Acceptance, enabled = false)
    public void test_ADD_HERO() {
        final NamedEntity hero = heroes().add(aHero());

        final CountedList list = heroes().list(all().withName(hero.getName()));

        assertThat((List<Named>) list.getItems(), hasItem(namedAs(hero.getName())));
    }
}
