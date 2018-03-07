package com.facebook.richdocument.utils;

import com.facebook.common.util.StringUtil;

/* compiled from: people_entity_cards_page */
public class BookmarkUtils {
    public static String m6848a(String str, String str2) {
        if (m6849c(str, str2)) {
            return str;
        }
        if (StringUtil.a(str)) {
            return str2;
        }
        return str + "," + str2;
    }

    public static boolean m6849c(String str, String str2) {
        for (String equals : StringUtil.a(str, ',')) {
            if (equals.equals(str2)) {
                return true;
            }
        }
        return false;
    }
}
