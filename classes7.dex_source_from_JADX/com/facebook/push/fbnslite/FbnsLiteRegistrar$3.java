package com.facebook.push.fbnslite;

import com.facebook.push.registration.Registrar.TokenStatus;

/* compiled from: high_temperature */
/* synthetic */ class FbnsLiteRegistrar$3 {
    static final /* synthetic */ int[] f11265a = new int[TokenStatus.values().length];

    static {
        try {
            f11265a[TokenStatus.CURRENT.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f11265a[TokenStatus.UPGRADED.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f11265a[TokenStatus.NONE.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
    }
}
