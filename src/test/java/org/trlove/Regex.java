package org.trlove;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by aguda on 16/7/7.
 */
public class Regex {

    public static void main(String[] args) {
        System.out.println("hello/hello\\/".replaceAll("[/|\\\\]+$", ""));

        /*String pattern = "[A-Za-z0-9]|\t|\r|\n";
        Pattern p = Pattern.compile(pattern);
        Matcher matcher = p.matcher("ab\tc");
        if(matcher.find()){
            System.out.println("a");
        }
        String result = matcher.replaceAll("");
        System.out.println(result);
        System.out.println("/uD835/uDD6B".codePointCount(0,2));
        System.out.println("/uD835/uDD6B".codePointAt(1));
        System.out.println("/uD835/uDD6B");*/
    }
}
