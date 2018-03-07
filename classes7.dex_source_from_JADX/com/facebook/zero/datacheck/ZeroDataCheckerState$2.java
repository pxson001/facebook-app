package com.facebook.zero.datacheck;

import com.google.common.util.concurrent.FutureCallback;

/* compiled from: ै */
public class ZeroDataCheckerState$2 implements FutureCallback {
    final /* synthetic */ ZeroDataCheckerState f104a;

    public void onFailure(Throwable th) {
        Class cls = ZeroDataCheckerState.c;
        ZeroDataCheckerState.j(this.f104a);
    }

    public void onSuccess(Object obj) {
        Class cls = ZeroDataCheckerState.c;
        ZeroDataCheckerState.l(this.f104a);
    }

    public ZeroDataCheckerState$2(ZeroDataCheckerState zeroDataCheckerState) {
        this.f104a = zeroDataCheckerState;
    }
}
