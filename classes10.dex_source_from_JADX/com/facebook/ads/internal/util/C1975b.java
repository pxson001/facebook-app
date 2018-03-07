package com.facebook.ads.internal.util;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class C1975b {
    public static String f14313a = null;
    private String f14314b;
    private Map<String, Object> f14315c;
    private int f14316d;
    private String f14317e;

    public enum C1974a {
        OPEN_STORE(0),
        OPEN_LINK(1),
        XOUT(2),
        OPEN_URL(3),
        SHOW_INTERSTITIAL(4);
        
        int f14312f;

        private C1974a(int i) {
            this.f14312f = i;
        }
    }

    private C1975b(String str, Map<String, Object> map, int i, String str2) {
        this.f14314b = str;
        this.f14315c = map;
        this.f14316d = i;
        this.f14317e = str2;
    }

    public static C1975b m14442a(long j, C1974a c1974a, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        Map hashMap = new HashMap();
        hashMap.put("Time", String.valueOf(currentTimeMillis - j));
        hashMap.put("AdAction", String.valueOf(c1974a.f14312f));
        return new C1975b("bounceback", hashMap, (int) (currentTimeMillis / 1000), str);
    }

    public static C1975b m14443a(Throwable th, String str) {
        Map hashMap = new HashMap();
        hashMap.put("ex", th.getClass().getSimpleName());
        hashMap.put("ex_msg", th.getMessage());
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        String str2 = "error";
        if (str == null) {
            str = f14313a;
        }
        return new C1975b(str2, hashMap, currentTimeMillis, str);
    }

    public final JSONObject m14444a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", this.f14314b);
            jSONObject.put("data", new JSONObject(this.f14315c));
            jSONObject.put("time", this.f14316d);
            jSONObject.put("request_id", this.f14317e);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
