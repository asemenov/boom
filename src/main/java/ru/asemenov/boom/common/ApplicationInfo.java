package ru.asemenov.boom.common;

/**
 * @author a.semenov
 */
public class ApplicationInfo {
    private String name;
    private String version;

    public ApplicationInfo(String name, String version) {
        this.name = name;
        this.version = version;
    }

    public ApplicationInfo() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
