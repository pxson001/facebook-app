package com.facebook.katana.service;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import com.facebook.config.application.FbAppType;
import com.facebook.inject.FbInjector;
import com.facebook.katana.constants.Constants.URL;
import com.facebook.katana.util.SignatureBuilder;
import com.facebook.katana.util.URLQueryBuilder;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: top_level_call_button_video */
public class FacebookPlatform {
    public static String m1201a(Context context, String str) {
        AppSession b = AppSession.b(context, false);
        Map treeMap = new TreeMap();
        treeMap.put("api_key", ((FbAppType) FbInjector.get(context).getInstance(FbAppType.class)).d());
        treeMap.put("t", String.valueOf(System.currentTimeMillis() / 1000));
        treeMap.put("uid", String.valueOf(b.b().userId));
        treeMap.put("url", str);
        treeMap.put("session_key", b.b().sessionKey);
        try {
            treeMap.put("sig", SignatureBuilder.a(treeMap, b.b().sessionSecret));
            Builder buildUpon = Uri.parse(URL.q(context)).buildUpon();
            buildUpon.encodedQuery(URLQueryBuilder.a(treeMap).toString());
            return buildUpon.build().toString();
        } catch (Throwable th) {
            return null;
        }
    }
}
