package com.facebook.location;

import com.facebook.location.FbLocationManagerParams.Priority;

/* compiled from: د.إ. */
public class GooglePlayServicesParamUtil {

    /* compiled from: د.إ. */
    /* synthetic */ class C00051 {
        static final /* synthetic */ int[] f44a = new int[Priority.values().length];

        static {
            try {
                f44a[Priority.LOW_POWER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f44a[Priority.BALANCED_POWER_AND_ACCURACY.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f44a[Priority.HIGH_ACCURACY.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public static int m34a(Priority priority) {
        switch (C00051.f44a[priority.ordinal()]) {
            case 1:
                return 104;
            case 2:
                return 102;
            case 3:
                return 100;
            default:
                throw new IllegalArgumentException();
        }
    }
}
