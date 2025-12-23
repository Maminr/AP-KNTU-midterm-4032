package ir.ac.kntu.t4032.midterm.q1;

import java.lang.classfile.Attributes;
import java.util.*;

public class HTMLData {

    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //String html = in.nextLine();
        extractAllTags("<p>test</p><DIV   Id=2></div><h1>heading1</h1><Div>div2</div><img Src=logo.png id=id1> </imG>\n" +
                "<div>test2</diV><P>paragraph…</p>");

        /*List<String> tags = findElementsByTagName(html,"div");
        printData(tags);
        System.out.println(findElementById(html, "id1"));
        System.out.println(findAttribueValue("<img src=1.jpg></img>", "SRC"));*/
    }

    public static void printData(List<String> tags) {
        for (String t : tags)
            System.out.println(t);
    }

    public static List<String> extractAllTags(String html) {
        Map<String, String> TagAttributes;

        Map<String, Map<String, String>> AllTags;

        String lowerHTML = html.toLowerCase(); // case-insensitive
        //System.out.println(lowerHTML.length());

        List<String> tagName = new ArrayList<>();
        boolean tagStarted = false;
        boolean attributeStarted = false;

        int startIndex = 0;
        int endIndex = 0;

        int endIndexofTagName = 0;
        for (int i = 0; i < lowerHTML.length(); i++) {


            if (lowerHTML.charAt(i) == '<' && lowerHTML.charAt(i+1) == '/' && tagStarted) {
                tagStarted = false;
                System.out.println(tagName);
                tagName = new ArrayList<>();
                endIndex = i;
                System.out.println(lowerHTML.substring(startIndex, endIndex));
                System.out.println("Content: " + lowerHTML.substring(endIndexofTagName+1, endIndex));
                System.out.println("Tag Details: " + lowerHTML.substring(startIndex+1, endIndexofTagName));
                System.out.println("Tag Name: " + lowerHTML.substring(startIndex+1, endIndexofTagName).split(" ")[0]);

                List<String> attrs = new ArrayList<>(List.of(lowerHTML.substring(startIndex + 1, endIndexofTagName).split(" ")));
                TagAttributes =  new HashMap<>();

                for (int j = 1; j < attrs.size(); j++) {
                    attrs.set(j, attrs.get(j).replace(" ", ""));
                    if(!Objects.equals(attrs.get(j), "")){
                        String[] attr = attrs.get(j).split("=");
                        TagAttributes.put(attr[0], attr[1]);
                    }
                }

                System.out.println("Tag Attrs: " + TagAttributes);
            }

            if (lowerHTML.charAt(i) == '>' && tagStarted) {
                endIndexofTagName = i;
                continue;
            }

            if (lowerHTML.charAt(i) == '<' && lowerHTML.charAt(i+1) != '/' && !tagStarted) {
                tagStarted = true;
                startIndex = i;
                continue;
            }

            /*if (lowerHTML.charAt(i) == ' ' && tagStarted) {
                tagStarted = false;
                attributeStarted = true;
                System.out.println(tagName);
                tagName = new ArrayList<>();
            }

            if (tagStarted) {
                tagName.add(lowerHTML.substring(i, i + 1));
            }*/


        }

        return null;
    }

    public static List<String> findElementsByTagName(String html, String tagName) {
        return null;
    }

    public static String findElementById(String html, String id) {
        return null;
    }

    public static String findAttribueValue(String tag, String attributeName) {
        return null;
    }

}
