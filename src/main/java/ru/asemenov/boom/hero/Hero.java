package ru.asemenov.boom.hero;

import ru.asemenov.boom.common.NamedIdentified;
import ru.asemenov.boom.publisher.Publisher;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author a.semenov
 */
@Entity
@Table(name = "HERO")
public class Hero implements NamedIdentified<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PSEUDONYM")
    private String pseudonym;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PUBLISHER")
    private Publisher publisher;

    @Column(name = "FIRST_APPEARANCE_DATE", nullable = false)
    private Date firstAppearanceDate;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "ALLIES",
            joinColumns = @JoinColumn(name = "FIRST_ALLY", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "SECOND_ALLY", referencedColumnName = "ID"))
    private List<Hero> allies = new ArrayList<>();

    @Column(name = "skills")
    @ElementCollection(targetClass = String.class)
    private List<String> skills = new ArrayList<>();

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPseudonym() {
        return pseudonym;
    }

    public void setPseudonym(String pseudonym) {
        this.pseudonym = pseudonym;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Date getFirstAppearanceDate() {
        return firstAppearanceDate;
    }

    public void setFirstAppearanceDate(Date firstAppearanceDate) {
        this.firstAppearanceDate = firstAppearanceDate;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public void publisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public List<Hero> getAllies() {
        return allies;
    }

    public void setAllies(final List<Hero> allies) {
        for (Hero ally : this.allies) {
            if (!allies.contains(ally)) {
                ally.remove(this);
            }
        }

        this.allies = allies;
        for (final Hero ally : allies) {
            ally.add(this);
        }
    }

    private void remove(Hero ally) {
        this.allies.remove(ally);
    }

    private void add(Hero ally) {
        if (!this.allies.contains(ally)) {
            this.allies.add(ally);
        }
    }

    @Override
    public String toString() {
        return "hero [" + getName() + "]";
    }
}
