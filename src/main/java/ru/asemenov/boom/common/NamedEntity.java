package ru.asemenov.boom.common;

/**
 * @author a.semenov
 */
public class NamedEntity implements NamedIdentified<Long> {
    private Long id;
    private String name;

    public NamedEntity() {
    }

    public NamedEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public NamedEntity(NamedIdentified<Long> entity) {
        this(entity.getId(), entity.getName());
    }

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
