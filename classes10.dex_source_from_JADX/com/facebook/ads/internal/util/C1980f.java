package com.facebook.ads.internal.util;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import com.facebook.ads.internal.adapters.C1895a;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;

public class C1980f {
    public static Collection<String> m14453a(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        Set hashSet = new HashSet();
        for (int i = 0; i < jSONArray.length(); i++) {
            hashSet.add(jSONArray.optString(i));
        }
        return hashSet;
    }

    public static boolean m14454a(Context context, C1895a c1895a) {
        C1979e a = c1895a.mo731a();
        if (a == null || a == C1979e.NONE) {
            return false;
        }
        Collection<String> c = c1895a.mo733c();
        if (c == null || c.isEmpty()) {
            return false;
        }
        for (String a2 : c) {
            if (C1980f.m14455a(context, a2)) {
                int i = 1;
                break;
            }
        }
        boolean z = false;
        if (a == C1979e.INSTALLED) {
            int i2 = 1;
        } else {
            boolean z2 = false;
        }
        if (i != i2) {
            return false;
        }
        if (C1994r.m14486a(c1895a.mo732b())) {
            return true;
        }
        new C1991o().execute(new String[]{a2});
        return false;
    }

    public static boolean m14455a(Context context, String str) {
        if (C1994r.m14486a(str)) {
            return false;
        }
        try {
            context.getPackageManager().getPackageInfo(str, 1);
            return true;
        } catch (NameNotFoundException e) {
            return false;
        }
    }
}
