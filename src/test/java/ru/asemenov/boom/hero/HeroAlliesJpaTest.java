package ru.asemenov.boom.hero;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Date;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.not;
import static ru.asemenov.boom.Group.Dao;
import static ru.asemenov.boom.common.TestDataGenerator.newName;
import static ru.asemenov.boom.common.TestDataGenerator.newPseudonym;

/**
 * @author a.semenov
 */
@DataJpaTest
public class HeroAlliesJpaTest extends AbstractTransactionalTestNGSpringContextTests {
    @Autowired
    private HeroRepository heroes;

    @Test(groups = Dao)
    public void test_MUTUAL_ALLY() {
        final Hero first = newHero();
        heroes.save(first);

        final Hero second = newHero();
        second.setAllies(asList(first));
        heroes.save(second);

        assertThat(second.getAllies(), hasItem(first));
        assertThat(first.getAllies(), hasItem(second));
    }

    @Test(groups = Dao)
    public void test_MUTUAL_ALLY_SHOULD_BE_EXCLUDED_ON_OTHER_SIDE() {
        final Hero first = newHero();
        heroes.save(first);

        final Hero second = newHero();
        second.setAllies(asList(first));
        heroes.save(second);

        assertThat(second.getAllies(), hasItem(first));
        assertThat(first.getAllies(), hasItem(second));

        second.setAllies(new ArrayList<>());

        assertThat(second.getAllies(), not(hasItem(first)));
        assertThat(first.getAllies(), not(hasItem(second)));
    }

    private Hero newHero() {
        final Hero hero = new Hero();

        hero.setName(newName());
        hero.setFirstAppearanceDate(new Date());
        hero.setPseudonym(newPseudonym());

        return hero;
    }
}
