package ENUM;

public enum AUTH_CREDENTIAL_ENUM {
    UDER_NAME("user"),
    PASSWORD("user123");

    private String credentials;

    AUTH_CREDENTIAL_ENUM(String credentials) {
        this.credentials = credentials;
    }

    public String getCredentials() {
        return credentials;
    }

    public void setCredentials(String credentials) {
        this.credentials = credentials;
    }
}
