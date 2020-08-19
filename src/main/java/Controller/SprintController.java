package Controller;

import Model.Author;
import Model.Sprint;
import Model.SummarizedSprint;
import Model.SummarizedStory;
import Service.SprintService;

import java.io.IOException;
import java.util.ArrayList;

public class SprintController {
    SprintService sprintService = new SprintService();
    Author author;

    public SprintController(Author author) {
        this.author = author;
    }
    /* To print sprint with summarized Issues set printIssue = true*/
    public void getSummaryDataOfSprints(String viewId,boolean printSummariedIssues) throws IOException {
        ArrayList<SummarizedSprint> summarizedSprints;
        summarizedSprints = sprintService.getAllSprintsOfProject(viewId, this.author);
            printSprintsAndSummaryOfIssues(viewId,summarizedSprints, printSummariedIssues);
    }

    private void printSprintsAndSummaryOfIssues(String viewId, ArrayList<SummarizedSprint> summarizedSprints,boolean printIssues)
            throws IOException {
        for (SummarizedSprint sprint : summarizedSprints) {
            Sprint sprintInfo = sprintService.getSprintSpecificData(viewId, sprint.getId(), this.author);
            printAllSprints(sprintInfo,printIssues);
        }
    }
    private void printAllSprints(Sprint sprintInfo, Boolean printSummariedIssues) throws IOException {
        String line = sprintInfo.getSprintId() + "," + sprintInfo.getSprintName() + "," + sprintInfo.getSprintState()
                + "," + sprintInfo.getSprintStartDate() + "," + sprintInfo.getSprintEndDate() + "," +
                sprintInfo.getSprintCompleteDate() + "," + sprintInfo.getTotal() + "," +
                sprintInfo.getCompletedIssuesCount() + "," + sprintInfo.getIssuesNotCompletedInCurrentSprint()
                + "," + sprintInfo.getPuntedIssues() + "," + sprintInfo.getIssuesCompletedInAnotherSprint() + "," + sprintInfo.getIssueKeysAddedDuringSprint() + ","
                + sprintInfo.getCompletedIssuesInitialEstimateSum() + ","
                + sprintInfo.getCompletedIssuesEstimateSum() + ","
                + sprintInfo.getPuntedIssuesInitialEstimateSum() + ","
                + sprintInfo.getPuntedIssuesEstimateSum() + ","
                + sprintInfo.getIssuesNotCompletedInitialEstimateSum()
                + "," + sprintInfo.getIssuesNotCompletedEstimateSum()
                + "," + sprintInfo.getIssuesCompletedInAnotherSprintInitialEstimateSum()
                + "," + sprintInfo.getIssuesCompletedInAnotherSprintEstimateSum();
        String heading1 = "sprintId,sprintName, sprintState , sprintStartDate,sprintEndDate,sprintCompleteDate,total,completedIssuesCount,issuesNotCompletedInCurrentSprint ,puntedIssues ,issuesCompletedInAnotherSprint,issueKeysAddedDuringSprint,completedIssuesInitialEstimateSum , completedIssuesEstimateSum , puntedIssuesInitialEstimateSum , puntedIssuesEstimateSum , issuesNotCompletedInitialEstimateSum +, issuesNotCompletedEstimateSum , issuesCompletedInAnotherSprintInitialEstimateSum , issuesCompletedInAnotherSprintEstimateSum";
        new DocumentPrinter().printDocumentHeader(heading1, author.getProjectName()+" sprints" );
        System.out.println("Sprint " + sprintInfo.getSprintId() + " Writing...");
        new DocumentPrinter().printDocument(line, author.getProjectName()+" sprints" );
        if(printSummariedIssues){
            printSIssueSummayOfSprints(sprintInfo.getSummarizedStories());
        }
    }
    private void printSIssueSummayOfSprints(ArrayList<SummarizedStory> summarizedStories) throws IOException {
        String summaryLine=null;
        for (SummarizedStory summarizedStory:summarizedStories) {
            summaryLine =summarizedStory.getProjectID()+","+summarizedStory.getSprintId()+","
                    +summarizedStory.getType()+","+summarizedStory.getId()+","+summarizedStory.getKey()+","
                    +summarizedStory.getSummary()+","+summarizedStory.getPriorityId()+","
                    +summarizedStory.getAssignee()+","+summarizedStory.getLengthOfInitialSP()+","
                    +summarizedStory.getLengthOfcurrentSP();
        }
        String heading2 =  "projectID,sprintId,type,id,key,summary,priorityId,assignee,lengthOfInitialSP,lengthOfcurrentSP";
        new DocumentPrinter().printDocumentHeader(heading2, author.getProjectName()+" Issue Summary" );
        new DocumentPrinter().printDocument(summaryLine, author.getProjectName()+" Issue Summary" );
    }
}
