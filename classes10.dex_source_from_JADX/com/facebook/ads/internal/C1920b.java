package com.facebook.ads.internal;

import com.facebook.ads.AdError;
import com.facebook.ads.internal.util.C1994r;

public class C1920b {
    public final AdErrorType f14107a;
    private final String f14108b;

    public C1920b(AdErrorType adErrorType, String str) {
        if (C1994r.m14486a(str)) {
            str = adErrorType.getDefaultErrorMessage();
        }
        this.f14107a = adErrorType;
        this.f14108b = str;
    }

    public final AdError m14328b() {
        return this.f14107a.m14205a() ? new AdError(this.f14107a.getErrorCode(), this.f14108b) : new AdError(AdErrorType.UNKNOWN_ERROR.getErrorCode(), AdErrorType.UNKNOWN_ERROR.getDefaultErrorMessage());
    }
}
