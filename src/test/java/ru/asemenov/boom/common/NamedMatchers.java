package ru.asemenov.boom.common;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import ru.asemenov.boom.hero.HeroData;

import java.util.Objects;

import static org.hamcrest.Matchers.hasItem;

/**
 * @author a.semenov
 */
public class NamedMatchers {
    public static Matcher<Named> namedAs(String name) {
        return new TypeSafeMatcher<Named>() {
            @Override
            protected boolean matchesSafely(Named item) {
                return Objects.equals(name, item.getName());
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("entity with name ").appendValue(name);
            }
        };
    }

    public static Matcher<HeroData> withPseudonym(String expected) {
        return new TypeSafeMatcher<HeroData>() {
            @Override
            protected boolean matchesSafely(HeroData item) {
                return Objects.equals(expected, item.getPseudonym());
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("entity with pseudonym ").appendValue(expected);
            }
        };
    }

    public static Matcher<HeroData> withAppearanceDate(String expected) {
        return new TypeSafeMatcher<HeroData>() {
            @Override
            protected boolean matchesSafely(HeroData item) {
                return Objects.equals(expected, item.getFirstAppearanceDate());
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("entity with appearance date ").appendValue(expected);
            }
        };
    }

    public static Matcher<HeroData> withSkill(String expected) {
        return new TypeSafeMatcher<HeroData>() {
            @Override
            protected boolean matchesSafely(HeroData item) {
                return hasItem(expected).matches(item.getSkills());
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("entity with skill ").appendValue(expected);
            }
        };
    }
}
