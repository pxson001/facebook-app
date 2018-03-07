package com.facebook.ads.internal.util;

import android.os.AsyncTask;
import android.util.Log;
import com.facebook.ads.internal.thirdparty.http.C1961a;
import com.facebook.ads.internal.thirdparty.http.C1972o;
import java.net.URLEncoder;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class C1991o extends AsyncTask<String, Void, Void> {
    private static final String f14356a = C1991o.class.getSimpleName();
    private static final Set<String> f14357b;
    private Map<String, String> f14358c;
    private Map<String, String> f14359d;

    static {
        Set hashSet = new HashSet();
        f14357b = hashSet;
        hashSet.add("#");
        f14357b.add("null");
    }

    public C1991o() {
        this(null, null);
    }

    public C1991o(Map<String, String> map) {
        this(map, null);
    }

    public C1991o(Map<String, String> map, Map<String, String> map2) {
        this.f14358c = map;
        this.f14359d = map2;
    }

    private static String m14481a(String str, String str2, String str3) {
        if (C1994r.m14486a(str) || C1994r.m14486a(str2) || C1994r.m14486a(str3)) {
            return str;
        }
        return str + (str.contains("?") ? "&" : "?") + str2 + "=" + URLEncoder.encode(str3);
    }

    private boolean m14482a(String str) {
        C1961a c = C1983g.m14466c();
        try {
            if (this.f14359d == null || this.f14359d.size() == 0) {
                return c.m14415a(str, null).m14435a() == 200;
            } else {
                C1972o c1972o = new C1972o();
                c1972o.m14438a(this.f14359d);
                return c.m14418b(str, c1972o).m14435a() == 200;
            }
        } catch (Throwable e) {
            Log.e(f14356a, "Error opening url: " + str, e);
            return false;
        }
    }

    private String m14483b(String str) {
        try {
            str = C1991o.m14481a(str, "analog", C1983g.m14458a(C1973a.m14441a()));
        } catch (Exception e) {
        }
        return str;
    }

    protected Object doInBackground(Object[] objArr) {
        String str = ((String[]) objArr)[0];
        if (!C1994r.m14486a(str) && !f14357b.contains(str)) {
            str = m14483b(str);
            if (!(this.f14358c == null || this.f14358c.isEmpty())) {
                String str2 = str;
                for (Entry entry : this.f14358c.entrySet()) {
                    str2 = C1991o.m14481a(str2, (String) entry.getKey(), (String) entry.getValue());
                }
                str = str2;
            }
            int i = 1;
            while (true) {
                int i2 = i + 1;
                if (i > 2 || m14482a(r0)) {
                    break;
                }
                i = i2;
            }
        }
        return null;
    }
}
