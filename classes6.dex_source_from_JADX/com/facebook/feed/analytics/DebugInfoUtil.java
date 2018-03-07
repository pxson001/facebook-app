package com.facebook.feed.analytics;

import com.facebook.common.util.StringUtil;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import java.util.ArrayList;

/* compiled from: neko_di_app_details_back_pressed */
public class DebugInfoUtil {
    private static final ArrayList<String> f10109a = Lists.a(new String[]{"query_ids", "query_id", "serialized"});

    public static String m15793a(String str, String str2) {
        if (StringUtil.a(str) || StringUtil.a(str2)) {
            return null;
        }
        if (!f10109a.contains(str2)) {
            return null;
        }
        ArrayList a = Lists.a(Splitter.on(',').split(str.replaceAll("[\\{\\}\"]", "")));
        for (int i = 0; i < a.size(); i++) {
            ArrayList a2 = Lists.a(Splitter.on(':').split((CharSequence) a.get(i)));
            if (a2.size() == 2 && ((String) a2.get(0)).equals(str2)) {
                return (String) a2.get(1);
            }
        }
        return null;
    }
}
