package com.haoran.baseutils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * CREATE BY HAORAN QIN
 * ON 2019/12/30
 * https://github.com/haoran1994
 */
public class StringUtils {

    public static String removeAllBank(String str) {
        String s = "";
        if (str != null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            s = m.replaceAll("");
        }
        return s;
    }

    public static String removeAllBank(String str, int count) {
        String s = "";
        if (str != null) {
            Pattern p = Pattern.compile("\\s{" + count + ",}|\t|\r|\n");
            Matcher m = p.matcher(str);
            s = m.replaceAll(" ");
        }
        return s;
    }

}
