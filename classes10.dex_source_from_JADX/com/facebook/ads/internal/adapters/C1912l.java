package com.facebook.ads.internal.adapters;

import com.facebook.ads.internal.util.C1979e;
import com.facebook.ads.internal.util.C1980f;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class C1912l implements C1895a {
    public final String f14042a;
    public final String f14043b;
    public final String f14044c;
    private final C1979e f14045d;
    private final String f14046e;
    private final Collection<String> f14047f;
    public final Map<String, String> f14048g;
    public final String f14049h;
    private final int f14050i;
    private final int f14051j;

    private C1912l(String str, String str2, String str3, C1979e c1979e, String str4, Collection<String> collection, Map<String, String> map, String str5, int i, int i2) {
        this.f14042a = str;
        this.f14043b = str2;
        this.f14044c = str3;
        this.f14045d = c1979e;
        this.f14046e = str4;
        this.f14047f = collection;
        this.f14048g = map;
        this.f14049h = str5;
        this.f14050i = i;
        this.f14051j = i2;
    }

    public static C1912l m14296a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        JSONArray jSONArray;
        String optString = jSONObject.optString("markup");
        String optString2 = jSONObject.optString("activation_command");
        String optString3 = jSONObject.optString("native_impression_report_url");
        String optString4 = jSONObject.optString("request_id");
        C1979e a = C1979e.m14452a(jSONObject.optString("invalidation_behavior"));
        String optString5 = jSONObject.optString("invalidation_report_url");
        try {
            jSONArray = new JSONArray(jSONObject.optString("detection_strings"));
        } catch (JSONException e) {
            e.printStackTrace();
            jSONArray = null;
        }
        Collection a2 = C1980f.m14453a(jSONArray);
        JSONObject optJSONObject = jSONObject.optJSONObject("metadata");
        Map hashMap = new HashMap();
        if (optJSONObject != null) {
            Iterator keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                hashMap.put(str, optJSONObject.optString(str));
            }
        }
        int i = 0;
        int i2 = 1000;
        if (hashMap.containsKey("viewability_check_initial_delay")) {
            i = Integer.parseInt((String) hashMap.get("viewability_check_initial_delay"));
        }
        if (hashMap.containsKey("viewability_check_interval")) {
            i2 = Integer.parseInt((String) hashMap.get("viewability_check_interval"));
        }
        return new C1912l(optString, optString2, optString3, a, optString5, a2, hashMap, optString4, i, i2);
    }

    public final C1979e mo731a() {
        return this.f14045d;
    }

    public final String mo732b() {
        return this.f14046e;
    }

    public final Collection<String> mo733c() {
        return this.f14047f;
    }

    public final String m14300e() {
        return this.f14043b;
    }
}
