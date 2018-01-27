package ru.asemenov.boom.hero;

import ru.asemenov.boom.common.NamedIdentified;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author a.semenov
 */
@Entity
@Table(name = "HERO")
public class Hero implements NamedIdentified<Long> {
    @Id
    private Long id;

    @Column(name = "NAME")
    private String name;

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
}
