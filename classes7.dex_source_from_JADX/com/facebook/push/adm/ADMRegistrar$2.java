package com.facebook.push.adm;

import com.facebook.push.registration.Registrar.TokenStatus;

/* compiled from: hvcC */
/* synthetic */ class ADMRegistrar$2 {
    static final /* synthetic */ int[] f11224a = new int[TokenStatus.values().length];

    static {
        try {
            f11224a[TokenStatus.CURRENT.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f11224a[TokenStatus.WRONG_TYPE.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f11224a[TokenStatus.EXPIRED.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f11224a[TokenStatus.UPGRADED.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f11224a[TokenStatus.NONE.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
    }
}
