package ru.asemenov.boom.acceptance.hero;

import ru.asemenov.boom.common.Builder;
import ru.asemenov.boom.hero.HeroIn;

import static ru.asemenov.boom.common.TestDataGenerator.newName;

/**
 * @author a.semenov
 */
public class HeroBuilder implements Builder<HeroIn> {
    private String name = newName();

    public HeroIn build() {
        final HeroIn result = new HeroIn();

        result.setName(name);

        return result;
    }

    public static HeroBuilder aHero() {
        return new HeroBuilder();
    }
}
