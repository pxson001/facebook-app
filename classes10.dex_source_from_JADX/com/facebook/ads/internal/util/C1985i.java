package com.facebook.ads.internal.util;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class C1985i {
    public final String f14334a;
    public final String f14335b;
    public final String f14336c;
    private final List<String> f14337d;
    private final String f14338e;
    private final String f14339f;

    private C1985i(String str, String str2, String str3, List<String> list, String str4, String str5) {
        this.f14334a = str;
        this.f14335b = str2;
        this.f14336c = str3;
        this.f14337d = list;
        this.f14338e = str4;
        this.f14339f = str5;
    }

    public static C1985i m14473a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("package");
        String optString2 = jSONObject.optString("appsite");
        String optString3 = jSONObject.optString("appsite_url");
        JSONArray optJSONArray = jSONObject.optJSONArray("key_hashes");
        List arrayList = new ArrayList();
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                arrayList.add(optJSONArray.optString(i));
            }
        }
        return new C1985i(optString, optString2, optString3, arrayList, jSONObject.optString("market_uri"), jSONObject.optString("fallback_url"));
    }
}
