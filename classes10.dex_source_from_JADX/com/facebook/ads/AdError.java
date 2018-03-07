package com.facebook.ads;

import com.facebook.ads.internal.util.C1994r;

public class AdError {
    public static final AdError f13882a = new AdError(1000, "Network Error");
    public static final AdError f13883b = new AdError(1001, "No Fill");
    public static final AdError f13884c = new AdError(1002, "Ad was re-loaded too frequently");
    public static final AdError f13885d = new AdError(2000, "Server Error");
    public static final AdError f13886e = new AdError(2001, "Internal Error");
    @Deprecated
    public static final AdError f13887f = new AdError(2002, "Native ad failed to load due to missing properties");
    public final int f13888g;
    public final String f13889h;

    public AdError(int i, String str) {
        if (C1994r.m14486a(str)) {
            str = "unknown error";
        }
        this.f13888g = i;
        this.f13889h = str;
    }
}
