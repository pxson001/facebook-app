package com.facebook.common.errorreporting;

import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* compiled from: privacy.data_freshness */
public class SoftErrorBuilder {
    public String f4224a;
    public String f4225b;
    public Throwable f4226c;
    public boolean f4227d;
    public int f4228e = 1000;
    public boolean f4229f;

    public final SoftErrorBuilder m4762a(Throwable th) {
        this.f4226c = th;
        return this;
    }

    public final SoftErrorBuilder m4763a(boolean z) {
        this.f4227d = z;
        return this;
    }

    public final SoftErrorBuilder m4761a(int i) {
        this.f4228e = i;
        return this;
    }

    public final SoftErrorBuilder m4764b(boolean z) {
        this.f4229f = z;
        return this;
    }

    public final SoftError m4765g() {
        return new SoftError(this);
    }
}
