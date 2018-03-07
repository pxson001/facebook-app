package com.facebook.zero.datacheck;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;

/* compiled from: ै */
class ZeroDataCheckerState$1 implements FutureCallback {
    final /* synthetic */ ZeroDataCheckerState f103a;

    public void onFailure(Throwable th) {
        Class cls = ZeroDataCheckerState.c;
        ZeroDataCheckerState.l(this.f103a);
    }

    public void onSuccess(Object obj) {
        Class cls = ZeroDataCheckerState.c;
        ZeroDataCheckerState zeroDataCheckerState = this.f103a;
        ZeroDataCheckerState.c.getSimpleName();
        Futures.a(((ZeroDataCheckerRequestMaker) zeroDataCheckerState.w.get()).m93a(), new ZeroDataCheckerState$2(zeroDataCheckerState), zeroDataCheckerState.q);
    }

    ZeroDataCheckerState$1(ZeroDataCheckerState zeroDataCheckerState) {
        this.f103a = zeroDataCheckerState;
    }
}
