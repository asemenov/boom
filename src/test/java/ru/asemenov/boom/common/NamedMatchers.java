package ru.asemenov.boom.common;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import java.util.Objects;

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
}
