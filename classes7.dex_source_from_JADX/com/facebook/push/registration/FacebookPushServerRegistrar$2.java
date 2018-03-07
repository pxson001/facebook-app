package com.facebook.push.registration;

/* compiled from: has_top_border */
/* synthetic */ class FacebookPushServerRegistrar$2 {
    static final /* synthetic */ int[] f11342a = new int[FacebookPushServerRegistrar$RegistrationStatus.values().length];
    static final /* synthetic */ int[] f11343b = new int[ServiceType.values().length];

    static {
        try {
            f11343b[ServiceType.ADM.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f11343b[ServiceType.FBNS.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f11343b[ServiceType.GCM.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f11343b[ServiceType.NNA.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f11343b[ServiceType.FBNS_LITE.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
        try {
            f11342a[FacebookPushServerRegistrar$RegistrationStatus.CURRENT.ordinal()] = 1;
        } catch (NoSuchFieldError e6) {
        }
        try {
            f11342a[FacebookPushServerRegistrar$RegistrationStatus.EXPIRED.ordinal()] = 2;
        } catch (NoSuchFieldError e7) {
        }
        try {
            f11342a[FacebookPushServerRegistrar$RegistrationStatus.WRONG_USER.ordinal()] = 3;
        } catch (NoSuchFieldError e8) {
        }
        try {
            f11342a[FacebookPushServerRegistrar$RegistrationStatus.NONE.ordinal()] = 4;
        } catch (NoSuchFieldError e9) {
        }
    }
}
