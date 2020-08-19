package Model;

public class SummarizedStory {
    private String projectID;
    private String sprintId;
    private String type;
    private String status;
    private String id;
    private String key;
    private String summary;
    private String priorityId;
    private String assignee;
    private String lengthOfInitialSP;
    private String lengthOfcurrentSP;

    public SummarizedStory(String projectID, String sprintId, String type, String id, String key,
                           String summary, String priorityId, String assignee, String lengthOfInitialSP,
                           String lengthOfcurrentSP) {
        this.projectID = projectID;
        this.sprintId = sprintId;
        this.type = type;
        this.id = id;
        this.key = key;
        this.summary = summary;
        this.priorityId = priorityId;
        this.assignee = assignee;
        this.lengthOfInitialSP = lengthOfInitialSP;
        this.lengthOfcurrentSP = lengthOfcurrentSP;
    }



    public String getProjectID() {
        return projectID;
    }

    public void setProjectID(String projectID) {
        this.projectID = projectID;
    }

    public String getSprintId() {
        return sprintId;
    }

    public void setSprintId(String sprintId) {
        this.sprintId = sprintId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getPriorityId() {
        return priorityId;
    }

    public void setPriorityId(String priorityId) {
        this.priorityId = priorityId;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getLengthOfInitialSP() {
        return lengthOfInitialSP;
    }

    public void setLengthOfInitialSP(String lengthOfInitialSP) {
        this.lengthOfInitialSP = lengthOfInitialSP;
    }

    public String getLengthOfcurrentSP() {
        return lengthOfcurrentSP;
    }

    public void setLengthOfcurrentSP(String lengthOfcurrentSP) {
        this.lengthOfcurrentSP = lengthOfcurrentSP;
    }
}
