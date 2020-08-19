import Controller.SprintController;
import Controller.StoryController;
import ENUM.AUTH_CREDENTIAL_ENUM;
import ENUM.URL_ENUM;
import ENUM.VIEW_ID_ENUM;
import Model.Author;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        String projectName = "AURORA"; //Enter the project name as given as in PROJECTS_ENUM
        String username = AUTH_CREDENTIAL_ENUM.valueOf("UDER_NAME").getCredentials();
        String password = AUTH_CREDENTIAL_ENUM.valueOf("PASSWORD").getCredentials();
        String baseUr = URL_ENUM.valueOf(projectName).getUrl();
        String viewId = VIEW_ID_ENUM.valueOf(projectName).getViewId();

        Author author = new Author(username, password,baseUr,projectName);
       // getAllSprintsOfABoard(viewId,author);
        getAllSprintsWithIssueSummary(viewId,author);
       // getFullIssueDetails(viewId,author);
    }

    private static void  getAllSprintsOfABoard(String viewId, Author author){
        SprintController sprintController = new SprintController(author);

        try {
            sprintController.getSummaryDataOfSprints(viewId,false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void  getAllSprintsWithIssueSummary(String viewId,Author author){
        SprintController sprintController = new SprintController(author);

        try {
            sprintController.getSummaryDataOfSprints(viewId,true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void  getFullIssueDetails(String viewId,Author author){
        StoryController storyController = new StoryController(author);

        try {
            storyController.getFullDetailsOFIssues(viewId);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
