package com.facebook.ads.internal.server;

import com.facebook.ads.internal.dto.C1923a;
import com.facebook.ads.internal.dto.C1926c;
import com.facebook.ads.internal.dto.C1927d;
import com.facebook.ads.internal.server.C1956c.C1955a;
import com.facebook.ads.internal.util.C1994r;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class C1954b {
    private static C1954b f14260a = new C1954b();

    public static synchronized C1954b m14389a() {
        C1954b c1954b;
        synchronized (C1954b.class) {
            c1954b = f14260a;
        }
        return c1954b;
    }

    private C1958e m14390b(JSONObject jSONObject) {
        try {
            return new C1958e(jSONObject.optString("message", ""), jSONObject.optInt("code", 0), new C1926c(C1927d.m14336a(jSONObject.getJSONArray("placements").getJSONObject(0).getJSONObject("definition"))));
        } catch (JSONException e) {
            return C1954b.m14391c(jSONObject);
        }
    }

    private static C1958e m14391c(JSONObject jSONObject) {
        return new C1958e(jSONObject.optString("message", ""), jSONObject.optInt("code", 0), null);
    }

    public final C1956c m14392a(String str) {
        if (!C1994r.m14486a(str)) {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("type");
            Object obj = -1;
            switch (optString.hashCode()) {
                case 96432:
                    if (optString.equals("ads")) {
                        obj = null;
                        break;
                    }
                    break;
                case 96784904:
                    if (optString.equals("error")) {
                        obj = 1;
                        break;
                    }
                    break;
            }
            switch (obj) {
                case null:
                    int i = 0;
                    JSONObject jSONObject2 = jSONObject.getJSONArray("placements").getJSONObject(0);
                    C1927d a = C1927d.m14336a(jSONObject2.getJSONObject("definition"));
                    C1926c c1926c = new C1926c(a);
                    AdPlacementType adPlacementType = a.f14143a;
                    if (jSONObject2.has("ads")) {
                        JSONArray jSONArray = jSONObject2.getJSONArray("ads");
                        while (i < jSONArray.length()) {
                            C1923a c1923a = new C1923a(adPlacementType);
                            JSONObject jSONObject3 = jSONArray.getJSONObject(i);
                            c1923a.f14131b = jSONObject3.getString("adapter");
                            JSONObject jSONObject4 = jSONObject3.getJSONObject("data");
                            JSONArray optJSONArray = jSONObject3.optJSONArray("trackers");
                            if (optJSONArray != null) {
                                jSONObject4.put("trackers", optJSONArray);
                            }
                            c1923a.f14132c = jSONObject4;
                            c1926c.f14139a.add(c1923a);
                            i++;
                        }
                    }
                    return new C1957d(c1926c);
                case 1:
                    return m14390b(jSONObject);
                default:
                    JSONObject optJSONObject = jSONObject.optJSONObject("error");
                    if (optJSONObject != null) {
                        return C1954b.m14391c(optJSONObject);
                    }
                    break;
            }
        }
        return new C1956c(C1955a.UNKNOWN, null);
    }
}
