package com.facebook.zero.datacheck;

import com.google.common.util.concurrent.FutureCallback;

/* compiled from: ै */
class ZeroDataCheckerState$4 implements FutureCallback {
    final /* synthetic */ ZeroDataCheckerState f106a;

    ZeroDataCheckerState$4(ZeroDataCheckerState zeroDataCheckerState) {
        this.f106a = zeroDataCheckerState;
    }

    public void onSuccess(Object obj) {
        ZeroDataCheckerState.c();
        synchronized (ZeroDataCheckerState.class) {
            ZeroDataCheckerState.g(this.f106a);
        }
        ZeroDataCheckerState.k(this.f106a);
    }

    public void onFailure(Throwable th) {
        ZeroDataCheckerState.c();
        synchronized (ZeroDataCheckerState.class) {
            ZeroDataCheckerState.h(this.f106a);
        }
        ZeroDataCheckerState.k(this.f106a);
    }
}
