package com.facebook.http.common.prioritization;

import com.facebook.http.observer.ConnectionQuality;

/* compiled from: display_height */
public /* synthetic */ class PrioritizationPolicyFactory$1 {
    public static final /* synthetic */ int[] f4993a = new int[ConnectionQuality.values().length];

    static {
        try {
            f4993a[ConnectionQuality.EXCELLENT.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f4993a[ConnectionQuality.GOOD.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f4993a[ConnectionQuality.MODERATE.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f4993a[ConnectionQuality.POOR.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
    }
}
