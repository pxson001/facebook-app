package com.facebook.ads.internal.server;

import com.facebook.ads.internal.util.C1994r;
import java.util.Locale;

public enum AdPlacementType {
    UNKNOWN("unknown"),
    BANNER("banner"),
    INTERSTITIAL("interstitial"),
    NATIVE("native");
    
    private String f14246a;

    private AdPlacementType(String str) {
        this.f14246a = str;
    }

    public static AdPlacementType fromString(String str) {
        if (C1994r.m14486a(str)) {
            return UNKNOWN;
        }
        try {
            return valueOf(str.toUpperCase(Locale.US));
        } catch (Exception e) {
            return UNKNOWN;
        }
    }

    public final String toString() {
        return this.f14246a;
    }
}
