package com.facebook.katana.util;

import android.os.Bundle;
import com.facebook.debug.log.BLog;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Map;

/* compiled from: p2p_initiate_risk */
public class URLQueryBuilder {
    public static StringBuilder m7882a(Map<String, String> map) {
        if (map == null) {
            return new StringBuilder("");
        }
        StringBuilder stringBuilder = new StringBuilder();
        Object obj = 1;
        for (String str : map.keySet()) {
            Object obj2;
            if (obj != null) {
                obj2 = null;
            } else {
                stringBuilder.append("&");
                obj2 = obj;
            }
            String str2 = (String) map.get(str);
            try {
                stringBuilder.append(URLEncoder.encode(str, "UTF-8")).append("=").append(str2 != null ? URLEncoder.encode(str2, "UTF-8") : "");
                obj = obj2;
            } catch (Throwable e) {
                BLog.b("URLQueryBuilder", "UTF-8 encoding not supported on this system.", e);
                return null;
            }
        }
        return stringBuilder;
    }

    public static Bundle m7881a(String str) {
        if (str == null) {
            return new Bundle();
        }
        Bundle bundle = new Bundle();
        for (String split : str.split("&")) {
            String[] split2 = split.split("=");
            bundle.putString(URLDecoder.decode(split2[0]), split2.length > 1 ? URLDecoder.decode(split2[1]) : "");
        }
        return bundle;
    }
}
