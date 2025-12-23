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
        return null;
    }

    public static List<String> findElementsByTagName(String html,String tagName) {
        return null;
    }

    public static String findElementById(String html, String id) {
        return null;
    }

    public static String findAttribueValue(String tag, String attributeName) {
        return null;
    }

}
