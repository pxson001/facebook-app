package com.facebook.faceweb;

import android.net.Uri;
import com.facebook.common.util.FacebookUriUtil;

/* compiled from: no_internet */
public class FacewebUriUtil {
    public static String m15666a(String str, String str2) {
        if (str == null) {
            return str;
        }
        Uri parse = Uri.parse(str);
        if (!parse.isHierarchical() || !"fbrpc".equals(parse.getScheme())) {
            return str;
        }
        String queryParameter = parse.getQueryParameter("market_uri");
        if (queryParameter == null) {
            return str;
        }
        Uri parse2 = Uri.parse(queryParameter);
        if (!parse2.isHierarchical()) {
            return str;
        }
        String queryParameter2 = parse2.getQueryParameter("referrer");
        if (queryParameter2 == null) {
            return str;
        }
        return FacebookUriUtil.a(parse, "market_uri", FacebookUriUtil.a(parse2, "referrer", queryParameter2 + "&fb_source=" + str2).toString()).toString();
    }
}
