package Service;
import ENUM.CUST_FIELD_ENUM;
import Model.Author;
import Model.Story;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;

public class StoryService {
    public ArrayList<Story>  getFullIssueDetails(String viewId, String sprint, Author author) throws IOException {
        ArrayList<Story> stories =new ArrayList<>();
        String url = author.getUri()+"/rest/agile/1.0/board/" + viewId + "/sprint/" + sprint + "/issue";
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
        JSONArray a = new JSONArray(jsonObject.get("issues").toString());

        for (Object e : a) {
            JSONObject jo = new JSONObject(e.toString());
            JSONObject jo2 = new JSONObject(jo.get("fields").toString());

            String key = jo.get("key").toString();
            String issueType = new JSONObject(jo2.get("issuetype").toString()).get("name").toString();
            String summary = jo2.get("summary").toString();
            summary = summary.replaceAll("[\\n\\t]", "");
            String description = jo2.get("description").toString();
            description = description.replaceAll("[\\n\\t]", "");

            String customField = CUST_FIELD_ENUM.valueOf(author.getProjectName()).getCustomField();

            String storyPoint = jo2.get(customField).toString();
            String priority = new JSONObject(jo2.get("priority").toString()).get("id").toString();
            JSONArray fixVersions = new JSONArray(jo2.get("fixVersions").toString());
            JSONArray affectedVersions = new JSONArray(jo2.get("versions").toString());

            String watchcount = new JSONObject(jo2.get("watches").toString()).get("watchCount").toString();
            String assignee = jo2.get("assignee").toString().contains("{") ? new JSONObject(jo2.get("assignee").toString()).get("displayName").toString() : null;
            JSONArray issueLinks = new JSONArray(jo2.get("issuelinks").toString());
            HashMap<String, Integer> likedMap = countLinkedIssues(issueLinks);

            String creator = new JSONObject(jo2.get("creator").toString()).get("displayName").toString();
            String reporter = new JSONObject(jo2.get("reporter").toString()).get("displayName").toString();
            JSONArray subtasksl = new JSONArray(jo2.get("subtasks").toString());
            String status = new JSONObject(jo2.get("status").toString()).get("name").toString();
            String comments = new JSONObject(jo2.get("comment").toString()).get("comments").toString();
            int commentCount = new JSONArray(comments).length();
            String votes = new JSONObject(jo2.get("votes").toString()).get("votes").toString();

            stories.add(new Story( key ,issueType,sprint,status,summary,description,storyPoint,priority,watchcount,Integer.toString(fixVersions.length()),Integer.toString(affectedVersions.length()), assignee,creator ,reporter,Integer.toString(commentCount), votes ,
                    Integer.toString(issueLinks.length()),Integer.toString(likedMap.get("blockedBy")),Integer.toString(likedMap.get("blocks")) ,Integer.toString(likedMap.get("dependedOnBy")),Integer.toString(likedMap.get("dependedOn")),Integer.toString(subtasksl.length())));

        }
        return stories;
    }

    private HashMap<String, Integer> countLinkedIssues(JSONArray linkedIssues) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("blockedBy", 0);
        map.put("blocks", 0);
        map.put("dependedOnBy", 0);
        map.put("dependedOn", 0);

        for (Object el : linkedIssues) {
            JSONObject ob = new JSONObject(el.toString());

            switch (new JSONObject(ob.get("type").toString()).get("inward").toString()) {
                case ("is blocked by"):
                    map.put("blockedBy", map.get("blockedBy") + 1);
                    break;
                case ("is depended on by"):
                    map.put("dependedOnBy", map.get("dependedOnBy") + 1);
                    break;
            }
            switch (new JSONObject(ob.get("type").toString()).get("outward").toString()) {
                case ("blocks"):
                    map.put("blocks", map.get("blocks") + 1);
                    break;
                case ("depends on"):
                    map.put("dependedOn", map.get("dependedOn") + 1);
                    break;
            }
        }

        return map;
    }
}
