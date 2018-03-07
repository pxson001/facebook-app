package com.facebook.ads.internal;

import android.text.TextUtils;
import org.json.JSONArray;

public enum C1922d {
    APP_AD(0),
    LINK_AD(1),
    APP_AD_V2(2),
    LINK_AD_V2(3),
    APP_ENGAGEMENT_AD(4),
    AD_CHOICES(5),
    JS_TRIGGER(6),
    JS_TRIGGER_NO_AUTO_IMP_LOGGING(7),
    VIDEO_AD(8),
    INLINE_VIDEO_AD(9),
    BANNER_TO_INTERSTITIAL(10),
    NATIVE_CLOSE_BUTTON(11);
    
    private static final C1922d[] f14125n = null;
    private static final String f14126o = null;
    private static final String f14127p = null;
    private final int f14129m;

    static {
        f14125n = new C1922d[]{LINK_AD_V2, APP_ENGAGEMENT_AD, AD_CHOICES, JS_TRIGGER_NO_AUTO_IMP_LOGGING, NATIVE_CLOSE_BUTTON};
        JSONArray jSONArray = new JSONArray();
        C1922d[] c1922dArr = f14125n;
        int length = c1922dArr.length;
        int i;
        while (i < length) {
            jSONArray.put(c1922dArr[i].m14332a());
            i++;
        }
        f14126o = jSONArray.toString();
        f14127p = TextUtils.join(",", f14125n);
    }

    private C1922d(int i) {
        this.f14129m = i;
    }

    public static String m14330b() {
        return null != null ? f14127p : f14126o;
    }

    public static String m14331c() {
        return f14127p;
    }

    final int m14332a() {
        return this.f14129m;
    }

    public final String toString() {
        return String.valueOf(this.f14129m);
    }
}
