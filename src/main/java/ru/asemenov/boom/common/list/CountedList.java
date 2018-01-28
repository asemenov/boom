package ru.asemenov.boom.common.list;

import ru.asemenov.boom.common.NamedEntity;

import java.util.List;

/**
 * @author a.semenov
 */
public class CountedList<T extends NamedEntity> {
    private List<T> items;
    private int count;

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
