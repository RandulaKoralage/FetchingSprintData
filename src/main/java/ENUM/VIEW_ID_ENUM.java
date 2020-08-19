package ENUM;

public enum VIEW_ID_ENUM {
    AURORA("37"),
    MESO("62"),
    SPRING_XD("43"),
    USER_GRID("23");

    private String viewId;
    VIEW_ID_ENUM(String viewId) {
        this.viewId = viewId;
    }

    public String getViewId() {
        return viewId;
    }

    public void setViewId(String viewId) {
        this.viewId = viewId;
    }
}
