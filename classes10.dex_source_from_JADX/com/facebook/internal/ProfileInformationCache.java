package com.facebook.internal;

import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* compiled from: SEND_FAILED_UNKNOWN_EXCEPTION */
public class ProfileInformationCache {
    public static final ConcurrentHashMap<String, JSONObject> f24028a = new ConcurrentHashMap();

    ProfileInformationCache() {
    }

    public static JSONObject m25307a(String str) {
        return (JSONObject) f24028a.get(str);
    }
}
