package com.facebook.analytics.immediateactiveseconds;

import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: task_triggered */
public class ImmediateActiveSecondsConfig$Params {
    public final long f1272a;
    public final long f1273b;

    public ImmediateActiveSecondsConfig$Params(long j, long j2) {
        this.f1272a = j;
        this.f1273b = j2;
    }

    public final boolean m1511a() {
        return this.f1273b != -1 && this.f1272a > 0;
    }
}
