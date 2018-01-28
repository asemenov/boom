package ru.asemenov.boom.publisher;

import javax.persistence.*;

/**
 * @author a.semenov
 */
@Entity
@Table(name = "PUBLISHER")
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NAME")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
