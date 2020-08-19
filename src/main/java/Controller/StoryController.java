package Controller;

import Model.Author;
import Model.Story;
import Model.SummarizedSprint;
import Service.SprintService;
import Service.StoryService;

import java.io.IOException;
import java.util.ArrayList;

public class StoryController {
    SprintService sprintService = new SprintService();
    StoryService storyService = new StoryService();
    Author author;

    public StoryController(Author author) {
        this.author = author;
    }

    public void getFullDetailsOFIssues(String viewId) throws IOException {
        ArrayList<SummarizedSprint> summarizedSprints;
        ArrayList<Story> fullIssueDetails;
        summarizedSprints = sprintService.getAllSprintsOfProject(viewId, author);
        for (SummarizedSprint sprint : summarizedSprints) {
            fullIssueDetails = storyService.getFullIssueDetails(viewId, sprint.getId(), author);
            printAllIssues(fullIssueDetails);
        }

    }

    private void printAllIssues(ArrayList<Story> stories) throws IOException {
        for (Story story : stories) {
            String line = story.getKey() + "\t" + story.getIssueType() + "\t" + story.getSprint() + "\t" + story.getStatus()
                    + "\t" + story.getSummary() + "\t" + story.getDescription() + "\t" + story.getStoryPoint() + "\t"
                    + story.getPriority() + "\t" + story.getWatchcount() + "\t" + story.getFixVersions() + "\t"
                    + story.getAffectedVersions() + "\t" + story.getAssignee() + "\t" + story.getCreator() + "\t"
                    + story.getReporter() + "\t" + story.getCommentCount() + "\t" + story.getVotes() + "\t" +
                    story.getIssueLinks() + "\t" + story.getBlockedBy() + "\t" + story.getBlocks() + "\t"
                    + story.getDependedOnBy() + "\t" + story.getDependedOn() + "\t" + story.getSubtasks();
            String heading3 = "key\tissueType\tsprint\tstatus\tsummary\tdescription\tstoryPoint\tpriority\twatchcount\t"
                    + "fixVersions\taffectedVersions\tassignee\tcreator\treporter\tcommentCount\tvotes\tissueLinks\t"
                    + "blockedBy\tblocks\tdependedOnBy\tdependedOn\tsubtasks";
            new DocumentPrinter().printDocumentHeader(heading3, author.getProjectName() + " Issues");
            new DocumentPrinter().printDocument(line, author.getProjectName() + " Issues");
        }
    }
}
