package ru.asemenov.boom.acceptance.hero;

import org.testng.annotations.Test;
import ru.asemenov.boom.acceptance.AbstractAcceptanceTest;
import ru.asemenov.boom.common.NamedEntity;
import ru.asemenov.boom.common.StandardResponse;
import ru.asemenov.boom.common.TestDataGenerator;
import ru.asemenov.boom.hero.HeroData;
import ru.asemenov.boom.publisher.PublisherData;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.not;
import static org.testng.Assert.*;
import static ru.asemenov.boom.Group.Acceptance;
import static ru.asemenov.boom.acceptance.hero.HeroBuilder.aHero;
import static ru.asemenov.boom.common.FilterBuilder.all;
import static ru.asemenov.boom.common.NamedMatchers.*;
import static ru.asemenov.boom.common.TestDataGenerator.anyDate;
import static ru.asemenov.boom.common.TestDataGenerator.nextNumeric;

/**
 * @author a.semenov
 */
public class HeroAcceptanceTest extends AbstractAcceptanceTest {
    @Test(groups = Acceptance)
    public void test_LIST_HEROES() {
        final List<StandardResponse.Item> list = heroes().list(all());

        assertThat(list, not(hasItem(namedAs("unknown hero"))));
    }

    @Test(groups = Acceptance)
    public void test_SEARCH_BY_NAME() {
        final HeroData first = heroes().add(aHero());
        final HeroData second = heroes().add(aHero());

        final List<StandardResponse.Item> list = heroes().list(all().withName(second.getName()));

        assertThat(list, not(hasItem(namedAs(first.getName()))));
        assertThat(list, hasItem(namedAs(second.getName())));
    }

    @Test(groups = Acceptance)
    public void test_ADD_HERO_WITH_DATE() {
        final String date = anyDate();

        final HeroData hero = heroes().add(aHero().firstAppeared(date));

        assertThat(heroes().list(all().withName(hero.getName())),
                hasItem(namedAs(hero.getName())));

        final Optional<HeroData> result = heroes().byId(hero);
        assertTrue(result.isPresent());

        result.ifPresent(detailed -> {
            assertThat(detailed, withPseudonym(hero.getPseudonym()));
            assertThat(detailed, withAppearanceDate(date));
        });
    }

    @Test(groups = Acceptance)
    public void test_ADD_HERO_WITH_SKILLS() {
        final String skill = TestDataGenerator.anySkill();

        final HeroData hero = heroes().add(aHero().withSkill(skill));

        final Optional<HeroData> result = heroes().byId(hero);
        assertTrue(result.isPresent());

        result.ifPresent(detailed -> {
            assertThat(detailed, withPseudonym(hero.getPseudonym()));
            assertThat(detailed, withSkill(skill));
        });
    }

    @Test(groups = Acceptance)
    public void test_ADD_HERO_WITHOUT_PUBLISHER() {
        final HeroData hero = heroes().add(aHero());

        final Optional<HeroData> result = heroes().byId(hero);
        assertTrue(result.isPresent());

        result.ifPresent(detailed -> {
            final Optional<NamedEntity> publisher = heroes().publisherFor(detailed);

            assertFalse(publisher.isPresent());
        });
    }

    @Test(groups = Acceptance)
    public void test_ADD_HERO_WITH_PUBLISHER() {
        final PublisherData givenPublisher = publishers().any();

        final HeroData hero = heroes().add(aHero()
                .withPublisher(publishers().byName(givenPublisher.getName())));

        final Optional<NamedEntity> publisher = heroes().publisherFor(hero);

        assertTrue(publisher.isPresent());
        assertEquals(publisher.get().getName(), givenPublisher.getName());
    }

    @Test(groups = Acceptance)
    public void test_ADD_HERO_WITH_ALLIES() {
        final HeroData batman = heroes().add(aHero()
                .withName("Batman " + nextNumeric(5)));

        final HeroData robin = heroes().add(aHero()
                .withName("Robin " + nextNumeric(5))
                .withAlly(batman));

        assertThat(heroes().alliedFor(robin), hasItem(namedAs(batman.getName())));
        assertThat(heroes().alliedFor(batman), hasItem(namedAs(robin.getName())));
    }
}
