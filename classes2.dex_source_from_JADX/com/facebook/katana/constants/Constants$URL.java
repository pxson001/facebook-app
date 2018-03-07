package com.facebook.katana.constants;

import android.content.Context;
import android.net.Uri;
import com.facebook.common.util.FacebookUriUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.config.server.NetworkLogUrl;

/* compiled from: timeline_interstitial */
public class Constants$URL {
    public static String m24644c(Context context) {
        return NetworkLogUrl.m12161a(context, "https://api.%s/restserver.php");
    }

    public static String m24645d(Context context) {
        return NetworkLogUrl.m12161a(context, "https://api-read.%s/restserver.php");
    }

    public static String m24647e(Context context) {
        return NetworkLogUrl.m12161a(context, "https://graph.%s/");
    }

    public static String m24648n(Context context) {
        return NetworkLogUrl.m12161a(context, "https://api.%s/");
    }

    public static String m24649p(Context context) {
        return NetworkLogUrl.m12161a(context, "https://m.%s/root.php");
    }

    public static String m24650q(Context context) {
        return NetworkLogUrl.m12161a(context, "https://m.%s/auth.php");
    }

    public static boolean m24642a(String str) {
        return str.startsWith("/");
    }

    public static boolean m24643b(String str) {
        Uri parse = Uri.parse(str);
        return FacebookUriUtil.m20919c(parse) && parse.getHost().startsWith("m.");
    }

    public static boolean m24646d(String str) {
        return !StringUtil.m3589a((CharSequence) str) && FacebookUriUtil.m20919c(Uri.parse(str));
    }
}
