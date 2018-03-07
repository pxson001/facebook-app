package com.facebook.common.init.impl;

import com.google.common.base.Throwables;

/* compiled from: source_type */
class FbAppInitializerInternal$6 implements Runnable {
    final /* synthetic */ Throwable f2630a;
    final /* synthetic */ FbAppInitializerInternal f2631b;

    FbAppInitializerInternal$6(FbAppInitializerInternal fbAppInitializerInternal, Throwable th) {
        this.f2631b = fbAppInitializerInternal;
        this.f2630a = th;
    }

    public void run() {
        throw Throwables.propagate(this.f2630a);
    }
}
