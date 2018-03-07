package com.facebook.ads.internal.thirdparty.http;

import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;

public class C1964g {
    private void m14421a(Map<String, List<String>> map) {
        if (map != null) {
            for (String str : map.keySet()) {
                for (String str2 : (List) map.get(str)) {
                    m14423a(str + ":" + str2);
                }
            }
        }
    }

    public final void m14422a(C1971n c1971n) {
        if (c1971n != null) {
            m14423a("=== HTTP Response ===");
            m14423a("Receive url: " + c1971n.f14295b);
            m14423a("Status: " + c1971n.f14294a);
            m14421a(c1971n.f14296c);
            m14423a("Content:\n" + c1971n.m14437e());
        }
    }

    public final void m14423a(String str) {
        System.out.println(str);
    }

    public final void m14424a(HttpURLConnection httpURLConnection, Object obj) {
        m14423a("=== HTTP Request ===");
        m14423a(httpURLConnection.getRequestMethod() + " " + httpURLConnection.getURL().toString());
        if (obj instanceof String) {
            m14423a("Content: " + ((String) obj));
        }
        m14421a(httpURLConnection.getRequestProperties());
    }

    public final boolean m14425a() {
        return false;
    }
}
