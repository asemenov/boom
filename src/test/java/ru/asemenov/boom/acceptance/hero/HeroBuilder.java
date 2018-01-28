package ru.asemenov.boom.acceptance.hero;

import org.testng.Assert;
import ru.asemenov.boom.common.Builder;
import ru.asemenov.boom.common.Identified;
import ru.asemenov.boom.hero.HeroData;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE;
import static ru.asemenov.boom.common.TestDataGenerator.newName;
import static ru.asemenov.boom.common.TestDataGenerator.newPseudonym;

/**
 * @author a.semenov
 */
public class HeroBuilder implements Builder<HeroData> {
    private String name = newName();
    private String pseudonym = newPseudonym();
    private LocalDate appearanceDate = LocalDate.now();
    private final List<String> skills = new ArrayList<>();
    private Long publisher;
    private List<Long> allies = new ArrayList<>();

    public HeroData build() {
        final HeroData result = new HeroData();

        result.setName(name);
        result.setPseudonym(pseudonym);
        result.setFirstAppearanceDate(appearanceDate.format(ISO_LOCAL_DATE));
        result.setSkills(skills);
        result.setPublisher(publisher);
        result.setAllies(allies);

        return result;
    }

    static HeroBuilder aHero() {
        return new HeroBuilder();
    }

    public HeroBuilder firstAppeared(String date) {
        appearanceDate = LocalDate.parse(date, ISO_LOCAL_DATE);
        return this;
    }

    public HeroBuilder withSkill(String skill) {
        if (skill != null && !skill.isEmpty()) {
            this.skills.add(skill);
        }
        return this;
    }

    public HeroBuilder withPublisher(Identified<Long> publisher) {
        Assert.assertNotNull(publisher.getId(), "Id must be provided");
        this.publisher = publisher.getId();
        return this;
    }

    public HeroBuilder withAlly(Identified<Long> ally) {
        this.allies.add(ally.getId());
        return this;
    }

    public HeroBuilder withName(String name) {
        this.name = name;
        return this;
    }
}
