package com.facebook.fbservice.service;

import android.os.Bundle;
import com.facebook.common.callercontext.CallerContext;

/* compiled from: final_failed @ onFailure */
public class Operation {
    public final String f23681a;
    public final String f23682b;
    private final Bundle f23683c;
    private final boolean f23684d;
    private final CallerContext f23685e;

    Operation(String str, String str2, Bundle bundle, boolean z, CallerContext callerContext) {
        this.f23681a = str;
        this.f23682b = str2;
        this.f23683c = bundle;
        this.f23684d = z;
        this.f23685e = callerContext;
    }

    public final String m32101a() {
        return this.f23682b;
    }

    final String m32102b() {
        return this.f23681a;
    }

    public final Bundle m32103c() {
        return this.f23683c;
    }

    public final boolean m32104d() {
        return this.f23684d;
    }

    public final CallerContext m32105e() {
        return this.f23685e;
    }
}
