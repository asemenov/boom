package ru.asemenov.boom.common;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.List;
import java.util.Map;

/**
 * @author a.semenov
 */
public class StandardResponse {
    private Embedded<StandardResponse.Item> embedded;

    @JsonGetter("_embedded")
    public Embedded<StandardResponse.Item> getEmbedded() {
        return embedded;
    }

    @JsonSetter("_embedded")
    public void setEmbedded(Embedded<StandardResponse.Item> embedded) {
        this.embedded = embedded;
    }

    public static class Embedded<T> {
        private List<T> items;

        public List<T> getItems() {
            return items;
        }

        public void setItems(List<T> items) {
            this.items = items;
        }
    }

    public static class Link {
        private String href;

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }
    }

    public static class Item extends NamedEntity {
        private Map<String, Link> links;

        @JsonGetter("_links")
        public Map<String, Link> getLinks() {
            return links;
        }

        @JsonSetter("_links")
        public void setLinks(Map<String, Link> links) {
            this.links = links;
        }
    }
}
