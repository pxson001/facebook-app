package com.facebook.video.abtest;

import com.facebook.qe.api.QeAccessor;

/* compiled from: phonetic_name */
public class AutoplayFeedRunnableConfig {
    public final boolean f4956a;
    public final int f4957b;

    public AutoplayFeedRunnableConfig(QeAccessor qeAccessor) {
        this.f4956a = qeAccessor.a(ExperimentsForVideoAbTestModule.e, false);
        this.f4957b = qeAccessor.a(ExperimentsForVideoAbTestModule.d, 200);
    }

    public final boolean m5347a() {
        return this.f4956a;
    }

    public final int m5348b() {
        return this.f4957b;
    }
}
