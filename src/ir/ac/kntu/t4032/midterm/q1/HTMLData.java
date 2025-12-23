package ir.ac.kntu.t4032.midterm.q1;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HTMLData {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String html = in.nextLine();
        List<String> tags = findElementsByTagName(html,"div");
        printData(tags);
        System.out.println(findElementById(html, "id1"));
        System.out.println(findAttribueValue("<img src=1.jpg></img>", "SRC"));
    }

    public static void printData(List<String> tags) {
        for (String t : tags)
            System.out.println(t);
    }

    public static List<String> extractAllTags(String html){
        List<String> tags = new ArrayList<>();
        int index = 0;
        String lowerHtml = html.toLowerCase();
        while(true){
            int start = html.indexOf("<", index);
            if (start == -1) break;
            if (start + 1 < html.length() && html.charAt(start + 1) == '/'){
                index = start + 1;
                continue;
            }
            int endOfOpen = html.indexOf(">", start);

            String contentInside = html.substring(start + 1, endOfOpen).trim();
            String tagName = contentInside.split("\\s+")[0];
            String closingTagSearch = "</" + tagName.toLowerCase();

            int closeIndex = lowerHtml.indexOf(closingTagSearch, start);

            if (closeIndex != -1){
                int end = closeIndex + closingTagSearch.length();
                tags.add(html.substring(start, end+1));
                index = end;
            }else {
                index = endOfOpen;
            }


        }
        return tags;
    }

    public static List<String> findElementsByTagName(String html,String tagName) {
        List<String> tags = extractAllTags(html);
        List<String> results = new ArrayList<>();

        for (String tag : tags){
            int firstSpace = tag.indexOf(" ");
            int firstClose = tag.indexOf(">");
            int nameEnd = (firstSpace != -1 && firstSpace < firstClose) ? firstSpace : firstClose;
            String currentName = tag.substring(1, nameEnd);

            if (currentName.equalsIgnoreCase(tagName)){
                results.add(tag);
            }
        }
        return results.isEmpty() ? null : results;
    }

    public static String findElementById(String html, String id) {
        List<String> tags = extractAllTags(html);

        for (String tag : tags){
            String newID = findAttribueValue(tag, "id");

            if (newID == null){
                continue;
            }

            if (newID.equalsIgnoreCase(id)){
                return tag;
            }
        }
        return null;
    }

    public static String findAttribueValue(String tag, String attributeName) {
        String regex = attributeName + "\\s*=\\s*([^>\\s]+)";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(tag);

        if (matcher.find()){
            return matcher.group(1);
        }
        return null;
    }

}
