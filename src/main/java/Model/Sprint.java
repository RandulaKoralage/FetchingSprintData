package Model;

import java.util.ArrayList;

public class Sprint {
    private String sprintId;
    private String sprintName;
    private String sprintState;
    private String sprintStartDate;
    private String sprintEndDate;
    private String sprintCompleteDate;
    private String total;
    private String completedIssuesCount;
    private String issuesNotCompletedInCurrentSprint;
    private String puntedIssues;
    private String issuesCompletedInAnotherSprint;
    private String issueKeysAddedDuringSprint;
    private String completedIssuesInitialEstimateSum;
    private String completedIssuesEstimateSum;
    private String puntedIssuesInitialEstimateSum;
    private String puntedIssuesEstimateSum;
    private String issuesNotCompletedInitialEstimateSum;
    private String issuesNotCompletedEstimateSum;
    private String issuesCompletedInAnotherSprintInitialEstimateSum;
    private String issuesCompletedInAnotherSprintEstimateSum;
    private ArrayList<SummarizedStory> summarizedStories;

    public Sprint(String sprintId, String sprintName, String sprintState, String sprintStartDate, String sprintEndDate,
                  String sprintCompleteDate, String total, String completedIssuesCount, String
                          issuesNotCompletedInCurrentSprint, String puntedIssues, String issuesCompletedInAnotherSprint,
                  String issueKeysAddedDuringSprint, String completedIssuesInitialEstimateSum,
                  String completedIssuesEstimateSum, String puntedIssuesInitialEstimateSum, String puntedIssuesEstimateSum,
                  String issuesNotCompletedInitialEstimateSum, String issuesNotCompletedEstimateSum,
                  String issuesCompletedInAnotherSprintInitialEstimateSum,
                  String issuesCompletedInAnotherSprintEstimateSum) {
        this.sprintId = sprintId;
        this.sprintName = sprintName;
        this.sprintState = sprintState;
        this.sprintStartDate = sprintStartDate;
        this.sprintEndDate = sprintEndDate;
        this.sprintCompleteDate = sprintCompleteDate;
        this.total = total;
        this.completedIssuesCount = completedIssuesCount;
        this.issuesNotCompletedInCurrentSprint = issuesNotCompletedInCurrentSprint;
        this.puntedIssues = puntedIssues;
        this.issuesCompletedInAnotherSprint = issuesCompletedInAnotherSprint;
        this.issueKeysAddedDuringSprint = issueKeysAddedDuringSprint;
        this.completedIssuesInitialEstimateSum = completedIssuesInitialEstimateSum;
        this.completedIssuesEstimateSum = completedIssuesEstimateSum;
        this.puntedIssuesInitialEstimateSum = puntedIssuesInitialEstimateSum;
        this.puntedIssuesEstimateSum = puntedIssuesEstimateSum;
        this.issuesNotCompletedInitialEstimateSum = issuesNotCompletedInitialEstimateSum;
        this.issuesNotCompletedEstimateSum = issuesNotCompletedEstimateSum;
        this.issuesCompletedInAnotherSprintInitialEstimateSum = issuesCompletedInAnotherSprintInitialEstimateSum;
        this.issuesCompletedInAnotherSprintEstimateSum = issuesCompletedInAnotherSprintEstimateSum;
    }

    public ArrayList<SummarizedStory> getSummarizedStories() {
        return summarizedStories;
    }

    public void setSummarizedStories(ArrayList<SummarizedStory> summarizedStories) {
        this.summarizedStories = summarizedStories;
    }

    public String getSprintId() {
        return sprintId;
    }

    public void setSprintId(String sprintId) {
        this.sprintId = sprintId;
    }

    public String getSprintName() {
        return sprintName;
    }

    public void setSprintName(String sprintName) {
        this.sprintName = sprintName;
    }

    public String getSprintState() {
        return sprintState;
    }

    public void setSprintState(String sprintState) {
        this.sprintState = sprintState;
    }

    public String getSprintStartDate() {
        return sprintStartDate;
    }

    public void setSprintStartDate(String sprintStartDate) {
        this.sprintStartDate = sprintStartDate;
    }

    public String getSprintEndDate() {
        return sprintEndDate;
    }

    public void setSprintEndDate(String sprintEndDate) {
        this.sprintEndDate = sprintEndDate;
    }

    public String getSprintCompleteDate() {
        return sprintCompleteDate;
    }

    public void setSprintCompleteDate(String sprintCompleteDate) {
        this.sprintCompleteDate = sprintCompleteDate;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getCompletedIssuesCount() {
        return completedIssuesCount;
    }

    public void setCompletedIssuesCount(String completedIssuesCount) {
        this.completedIssuesCount = completedIssuesCount;
    }

    public String getIssuesNotCompletedInCurrentSprint() {
        return issuesNotCompletedInCurrentSprint;
    }

    public void setIssuesNotCompletedInCurrentSprint(String issuesNotCompletedInCurrentSprint) {
        this.issuesNotCompletedInCurrentSprint = issuesNotCompletedInCurrentSprint;
    }

    public String getPuntedIssues() {
        return puntedIssues;
    }

    public void setPuntedIssues(String puntedIssues) {
        this.puntedIssues = puntedIssues;
    }

    public String getIssuesCompletedInAnotherSprint() {
        return issuesCompletedInAnotherSprint;
    }

    public void setIssuesCompletedInAnotherSprint(String issuesCompletedInAnotherSprint) {
        this.issuesCompletedInAnotherSprint = issuesCompletedInAnotherSprint;
    }

    public String getIssueKeysAddedDuringSprint() {
        return issueKeysAddedDuringSprint;
    }

    public void setIssueKeysAddedDuringSprint(String issueKeysAddedDuringSprint) {
        this.issueKeysAddedDuringSprint = issueKeysAddedDuringSprint;
    }

    public String getCompletedIssuesInitialEstimateSum() {
        return completedIssuesInitialEstimateSum;
    }

    public void setCompletedIssuesInitialEstimateSum(String completedIssuesInitialEstimateSum) {
        this.completedIssuesInitialEstimateSum = completedIssuesInitialEstimateSum;
    }

    public String getCompletedIssuesEstimateSum() {
        return completedIssuesEstimateSum;
    }

    public void setCompletedIssuesEstimateSum(String completedIssuesEstimateSum) {
        this.completedIssuesEstimateSum = completedIssuesEstimateSum;
    }

    public String getPuntedIssuesInitialEstimateSum() {
        return puntedIssuesInitialEstimateSum;
    }

    public void setPuntedIssuesInitialEstimateSum(String puntedIssuesInitialEstimateSum) {
        this.puntedIssuesInitialEstimateSum = puntedIssuesInitialEstimateSum;
    }

    public String getPuntedIssuesEstimateSum() {
        return puntedIssuesEstimateSum;
    }

    public void setPuntedIssuesEstimateSum(String puntedIssuesEstimateSum) {
        this.puntedIssuesEstimateSum = puntedIssuesEstimateSum;
    }

    public String getIssuesNotCompletedInitialEstimateSum() {
        return issuesNotCompletedInitialEstimateSum;
    }

    public void setIssuesNotCompletedInitialEstimateSum(String issuesNotCompletedInitialEstimateSum) {
        this.issuesNotCompletedInitialEstimateSum = issuesNotCompletedInitialEstimateSum;
    }

    public String getIssuesNotCompletedEstimateSum() {
        return issuesNotCompletedEstimateSum;
    }

    public void setIssuesNotCompletedEstimateSum(String issuesNotCompletedEstimateSum) {
        this.issuesNotCompletedEstimateSum = issuesNotCompletedEstimateSum;
    }

    public String getIssuesCompletedInAnotherSprintInitialEstimateSum() {
        return issuesCompletedInAnotherSprintInitialEstimateSum;
    }

    public void setIssuesCompletedInAnotherSprintInitialEstimateSum(String issuesCompletedInAnotherSprintInitialEstimateSum) {
        this.issuesCompletedInAnotherSprintInitialEstimateSum = issuesCompletedInAnotherSprintInitialEstimateSum;
    }

    public String getIssuesCompletedInAnotherSprintEstimateSum() {
        return issuesCompletedInAnotherSprintEstimateSum;
    }

    public void setIssuesCompletedInAnotherSprintEstimateSum(String issuesCompletedInAnotherSprintEstimateSum) {
        this.issuesCompletedInAnotherSprintEstimateSum = issuesCompletedInAnotherSprintEstimateSum;
    }
}
