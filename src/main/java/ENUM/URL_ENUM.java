package ENUM;

public enum URL_ENUM {
    AURORA("https://issues.apache.org/jira"),
    MESO("https://issues.apache.org/jira"),
    SPRING_XD("https://jira.spring.io"),
    USER_GRID("https://issues.apache.org/jira");

    private String url;

    URL_ENUM(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
