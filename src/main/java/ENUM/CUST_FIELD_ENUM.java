package ENUM;//Story points values are stored in Custom fields. That can vary from the repository

public enum CUST_FIELD_ENUM {

    AURORA("customfield_12310293"),
    MESO("customfield_12310293"),
    SPRING_XD("customfield_10142"),
    USER_GRID("customfield_12310293");

    private String customField;

    CUST_FIELD_ENUM(String customField) {
        this.customField = customField;
    }

    public String getCustomField() {
        return customField;
    }

    public void setCustomField(String customField) {
        this.customField = customField;
    }
}
