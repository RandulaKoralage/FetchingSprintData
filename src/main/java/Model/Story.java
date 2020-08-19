package Model;

public class Story {
    private String key;
    private String issueType;
    private String sprint;
    private String status;
    private String summary;
    private String description;
    private String storyPoint;
    private String priority;
    private String watchcount;
    private String fixVersions;
    private String affectedVersions;
    private String assignee;
    private String creator;
    private String reporter;
    private String commentCount;
    private String votes;
    private String issueLinks;
    private String blockedBy;
    private String blocks;
    private String dependedOnBy;
    private String dependedOn;
    private String subtasks;

    public Story(String key, String issueType, String sprint, String status, String summary, String description,
                 String storyPoint, String priority, String watchcount, String fixVersions, String affectedVersions,
                 String assignee, String creator, String reporter, String commentCount, String votes, String issueLinks,
                 String blockedBy, String blocks, String dependedOnBy, String dependedOn, String subtasks) {
        this.key = key;
        this.issueType = issueType;
        this.sprint = sprint;
        this.status = status;
        this.summary = summary;
        this.description = description;
        this.storyPoint = storyPoint;
        this.priority = priority;
        this.watchcount = watchcount;
        this.fixVersions = fixVersions;
        this.affectedVersions = affectedVersions;
        this.assignee = assignee;
        this.creator = creator;
        this.reporter = reporter;
        this.commentCount = commentCount;
        this.votes = votes;
        this.issueLinks = issueLinks;
        this.blockedBy = blockedBy;
        this.blocks = blocks;
        this.dependedOnBy = dependedOnBy;
        this.dependedOn = dependedOn;
        this.subtasks = subtasks;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getIssueType() {
        return issueType;
    }

    public void setIssueType(String issueType) {
        this.issueType = issueType;
    }

    public String getSprint() {
        return sprint;
    }

    public void setSprint(String sprint) {
        this.sprint = sprint;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStoryPoint() {
        return storyPoint;
    }

    public void setStoryPoint(String storyPoint) {
        this.storyPoint = storyPoint;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getWatchcount() {
        return watchcount;
    }

    public void setWatchcount(String watchcount) {
        this.watchcount = watchcount;
    }

    public String getFixVersions() {
        return fixVersions;
    }

    public void setFixVersions(String fixVersions) {
        this.fixVersions = fixVersions;
    }

    public String getAffectedVersions() {
        return affectedVersions;
    }

    public void setAffectedVersions(String affectedVersions) {
        this.affectedVersions = affectedVersions;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getReporter() {
        return reporter;
    }

    public void setReporter(String reporter) {
        this.reporter = reporter;
    }

    public String getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(String commentCount) {
        this.commentCount = commentCount;
    }

    public String getVotes() {
        return votes;
    }

    public void setVotes(String votes) {
        this.votes = votes;
    }

    public String getIssueLinks() {
        return issueLinks;
    }

    public void setIssueLinks(String issueLinks) {
        this.issueLinks = issueLinks;
    }

    public String getBlockedBy() {
        return blockedBy;
    }

    public void setBlockedBy(String blockedBy) {
        this.blockedBy = blockedBy;
    }

    public String getBlocks() {
        return blocks;
    }

    public void setBlocks(String blocks) {
        this.blocks = blocks;
    }

    public String getDependedOnBy() {
        return dependedOnBy;
    }

    public void setDependedOnBy(String dependedOnBy) {
        this.dependedOnBy = dependedOnBy;
    }

    public String getDependedOn() {
        return dependedOn;
    }

    public void setDependedOn(String dependedOn) {
        this.dependedOn = dependedOn;
    }

    public String getSubtasks() {
        return subtasks;
    }

    public void setSubtasks(String subtasks) {
        this.subtasks = subtasks;
    }
}
