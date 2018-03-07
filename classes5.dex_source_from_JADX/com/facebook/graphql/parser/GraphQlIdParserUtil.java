package com.facebook.graphql.parser;

/* compiled from: eglChooseConfig */
public class GraphQlIdParserUtil {
    public static String m9588a(String str) {
        if (str == null) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf(95);
        return (lastIndexOf == -1 || lastIndexOf >= str.length()) ? str : str.substring(lastIndexOf + 1);
    }
}
