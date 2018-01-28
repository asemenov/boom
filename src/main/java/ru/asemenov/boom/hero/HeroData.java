package ru.asemenov.boom.hero;

import ru.asemenov.boom.common.NamedEntity;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.joining;

/**
 * @author a.semenov
 */
public class HeroData extends NamedEntity {
    private String pseudonym;
    private String firstAppearanceDate;
    private List<String> skills = new ArrayList<>();
    private Long publisher;
    private List<Long> allies;

    public String getPseudonym() {
        return pseudonym;
    }

    public void setPseudonym(String pseudonym) {
        this.pseudonym = pseudonym;
    }

    public String getFirstAppearanceDate() {
        return firstAppearanceDate;
    }

    public void setFirstAppearanceDate(String firstAppearanceDate) {
        this.firstAppearanceDate = firstAppearanceDate;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public Long getPublisher() {
        return publisher;
    }

    public void setPublisher(Long publisher) {
        this.publisher = publisher;
    }

    public void setAllies(List<Long> allies) {
        this.allies = allies;
    }

    public List<Long> getAllies() {
        return allies;
    }

    @Override
    public String toString() {
        return "hero [" + getName() + "]" + (skills == null || skills.isEmpty() ? " <no skills>" : " skills = " + skills.stream().collect(joining(", ")));
    }
}
