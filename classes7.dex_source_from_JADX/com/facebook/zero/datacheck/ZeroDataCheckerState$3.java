package com.facebook.zero.datacheck;

import com.google.common.util.concurrent.FutureCallback;

/* compiled from: ै */
class ZeroDataCheckerState$3 implements FutureCallback {
    final /* synthetic */ ZeroDataCheckerState f105a;

    ZeroDataCheckerState$3(ZeroDataCheckerState zeroDataCheckerState) {
        this.f105a = zeroDataCheckerState;
    }

    public void onSuccess(Object obj) {
        ZeroDataCheckerState.c();
        synchronized (ZeroDataCheckerState.class) {
            ZeroDataCheckerState.d(this.f105a);
        }
        ZeroDataCheckerState.k(this.f105a);
    }

    public void onFailure(Throwable th) {
        ZeroDataCheckerState.c();
        synchronized (ZeroDataCheckerState.class) {
            ZeroDataCheckerState.f(this.f105a);
        }
        ZeroDataCheckerState.k(this.f105a);
    }
}
