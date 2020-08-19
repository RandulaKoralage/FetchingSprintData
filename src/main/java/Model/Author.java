package Model;

public class Author {
    private String userName;
    private  String password;
    private  String uri;
    private  String projectName;

    public Author(String userName, String password, String uri, String projectName) {
        this.userName = userName;
        this.password = password;
        this.uri = uri;
        this.projectName = projectName;
    }

    public String getUserName() {
        return userName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
