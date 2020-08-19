package Service;

import Model.Author;
import Model.Sprint;
import Model.SummarizedSprint;
import Model.SummarizedStory;
import org.json.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Base64;

public class SprintService {
    boolean isLast;
    public ArrayList<SummarizedSprint> getAllSprintsOfProject(String viewId, Author author) throws IOException {
        ArrayList<SummarizedSprint> allSprints = new ArrayList<SummarizedSprint>();

        int startAt = 0;
        int maxResults = 50;
        int queryOutputItemsCount = 0;
        do {
            String url = author.getUri() + "/rest/agile/1.0/board/" + viewId + "/sprint/?startAt=" + startAt;
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            //Setting the Request Method header as GET
            con.setRequestMethod("GET");

            //Prepairing credentials
            String cred = author.getUserName() + ":" + author.getPassword();
            byte[] encoded = Base64.getEncoder().encode(cred.getBytes());
            String credentials = new String(encoded);

            //Setting the Authorization Header as 'Basic' with the given credentials
            con.setRequestProperty("Authorization", "Basic " + credentials);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream())
            );

            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            JSONObject jsonObject = new JSONObject(response.toString());
            in.close();

            JSONArray values = new JSONArray(jsonObject.get("values").toString());
            isLast = jsonObject.get("isLast").toString().equals("true");


            for (Object value : values) {
                JSONObject jo = new JSONObject(value.toString());
                String startDate;
                String closedDate;
                String endDate;
                try {
                    endDate = jo.get("endDate").toString();
                    startDate = jo.get("startDate").toString();
                    closedDate = jo.get("completeDate").toString();
                } catch (JSONException exc) {
                    closedDate = null;
                    startDate = null;
                    endDate = null;
                }
                System.out.println("Sprint "+jo.get("id") + " Fetching...");
                allSprints.add(new SummarizedSprint(jo.get("id").toString(), jo.get("name").toString(), startDate, endDate, closedDate, jo.get("state").toString()));
            }
            startAt = startAt + maxResults;
        } while (!isLast == true);


        return allSprints;
    }

    public Sprint getSprintSpecificData(String viewId, String id, Author author) throws IOException {
        Sprint sprint = null;
        String url = author.getUri() + "/rest/greenhopper/1.0/rapid/charts/sprintreport?rapidViewId=" + viewId + "&sprintId=" + id;
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");

        String cred = author.getUserName() + ":" + author.getPassword();
        byte[] encoded = Base64.getEncoder().encode(cred.getBytes());
        String credentials = new String(encoded);


        con.setRequestProperty("Authorization", "Basic " + credentials);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream())
        );

        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        JSONObject jsonObject = new JSONObject(response.toString());
        in.close();

        JSONObject contents = new JSONObject(jsonObject.get("contents").toString());
        JSONObject sprintData = new JSONObject(jsonObject.get("sprint").toString());

        int completedIssuesCount = new JSONArray(contents.get("completedIssues").toString()).length();
        int issuesNotCompletedInCurrentSprint = new JSONArray(contents.get("issuesNotCompletedInCurrentSprint").toString()).length();
        int puntedIssues = new JSONArray(contents.get("puntedIssues").toString()).length();
        int issuesCompletedInAnotherSprint = new JSONArray(contents.get("issuesCompletedInAnotherSprint").toString()).length();
        int issueKeysAddedDuringSprint = new JSONObject(contents.get("issueKeysAddedDuringSprint").toString()).length();
        int total = completedIssuesCount + issuesNotCompletedInCurrentSprint + puntedIssues + puntedIssues + issuesCompletedInAnotherSprint;
        String sprintId = sprintData.get("id").toString();
        String sprintName = sprintData.get("name").toString();
        String sprintState = sprintData.get("state").toString();
        String sprintStartDate = sprintData.get("startDate").toString();
        String sprintEndDate = sprintData.get("endDate").toString();
        String sprintCompleteDate = sprintData.get("completeDate").toString();
        String completedIssuesInitialEstimateSum = new JSONObject(contents.get("completedIssuesInitialEstimateSum").toString()).get("text").toString();
        String completedIssuesEstimateSum = new JSONObject(contents.get("completedIssuesEstimateSum").toString()).get("text").toString();
        String puntedIssuesInitialEstimateSum = new JSONObject(contents.get("puntedIssuesInitialEstimateSum").toString()).get("text").toString();
        String puntedIssuesEstimateSum = new JSONObject(contents.get("puntedIssuesEstimateSum").toString()).get("text").toString();
        String issuesNotCompletedInitialEstimateSum = new JSONObject(contents.get("issuesNotCompletedInitialEstimateSum").toString()).get("text").toString();
        String issuesNotCompletedEstimateSum = new JSONObject(contents.get("issuesNotCompletedEstimateSum").toString()).get("text").toString();
        String issuesCompletedInAnotherSprintInitialEstimateSum = new JSONObject(contents.get("issuesCompletedInAnotherSprintInitialEstimateSum").toString()).get("text").toString();
        String issuesCompletedInAnotherSprintEstimateSum = new JSONObject(contents.get("issuesCompletedInAnotherSprintEstimateSum").toString()).get("text").toString();

        Sprint sprintInfo = new Sprint(sprintId, sprintName, sprintState, sprintStartDate, sprintEndDate,
                sprintCompleteDate,
                Integer.toString(total), Integer.toString(completedIssuesCount),
                Integer.toString(issuesNotCompletedInCurrentSprint), Integer.toString(puntedIssues),
                Integer.toString(issuesCompletedInAnotherSprint), Integer.toString(issueKeysAddedDuringSprint),
                completedIssuesInitialEstimateSum, completedIssuesEstimateSum, puntedIssuesInitialEstimateSum,
                puntedIssuesEstimateSum, issuesNotCompletedInitialEstimateSum, issuesNotCompletedEstimateSum,
                issuesCompletedInAnotherSprintInitialEstimateSum, issuesCompletedInAnotherSprintEstimateSum);

        ArrayList<SummarizedStory> summarizedStories = loadAllIssues(contents,viewId,sprintId);
      //  System.out.println(sprintInfo.getSummarizedStories().get(0).getKey());
        sprintInfo.setSummarizedStories(summarizedStories);
        //System.out.println(sprintInfo.getSummarizedStories().get(0).getKey());
        return sprintInfo;
    }

    public  ArrayList<SummarizedStory>  loadAllIssues(JSONObject contents, String viewId, String sprintId) throws IOException {
        ArrayList<SummarizedStory> summarizedStories = new ArrayList<>();
        JSONArray completedIssues = new JSONArray(contents.get("completedIssues").toString());
        JSONArray issuesNotCompletedInCurrentSprint = new JSONArray(contents.get("issuesNotCompletedInCurrentSprint").toString());
        JSONArray puntedIssues = new JSONArray(contents.get("puntedIssues").toString());
        JSONArray issuesCompletedInAnotherSprint = new JSONArray(contents.get("issuesCompletedInAnotherSprint").toString());
        if (completedIssues.length() > 0) {
            summarizedStories = iterateStoryArray(summarizedStories, completedIssues, "Completed", viewId, sprintId);
        }
        if (issuesNotCompletedInCurrentSprint.length() > 0) {
            summarizedStories = iterateStoryArray(summarizedStories,issuesNotCompletedInCurrentSprint, "NotCompletedWithinSprint", viewId, sprintId);
        }
        if (puntedIssues.length() > 0) {
            summarizedStories = iterateStoryArray(summarizedStories,puntedIssues, "Punted", viewId, sprintId);
        }
        if (issuesCompletedInAnotherSprint.length() > 0) {
            summarizedStories = iterateStoryArray(summarizedStories,issuesCompletedInAnotherSprint, "CompletedInNotherSprint", viewId, sprintId);
        }
        return summarizedStories;
    }

    private ArrayList<SummarizedStory> iterateStoryArray(ArrayList<SummarizedStory> summarizedStories, JSONArray issueArrayOfSprint, String type, String viewId, String sprintId) {

        for (Object o : issueArrayOfSprint) {
            JSONObject jo = new JSONObject(o.toString());

            Object currentSP = new JSONObject(jo.get("currentEstimateStatistic").toString()).get("statFieldValue");
            Object initialSP = new JSONObject(jo.get("estimateStatistic").toString()).get("statFieldValue");
            String lengthOfInitialSP = new JSONObject(initialSP.toString()).length() != 0 ? new JSONObject(initialSP.toString()).get("value").toString() : "0";
            String lengthOfcurrentSP = new JSONObject(currentSP.toString()).length() != 0 ? new JSONObject(currentSP.toString()).get("value").toString() : "0";
            String assignee = null;
            try {
                assignee = jo.get("assignee").toString();
            } catch (JSONException e) {
                assignee = null;
            }
            summarizedStories.add(new SummarizedStory(viewId, sprintId, type,jo.get("id").toString(),jo.get("key").toString(),
                    jo.get("summary").toString(),jo.get("priorityId").toString(),assignee,lengthOfInitialSP, lengthOfcurrentSP));
        }
        return summarizedStories;
    }

}