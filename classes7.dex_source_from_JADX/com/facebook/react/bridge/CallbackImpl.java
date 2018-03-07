package com.facebook.react.bridge;

/* compiled from: groups_sort_filter/ */
public final class CallbackImpl implements Callback {
    private final CatalystInstance f11467a;
    private final ExecutorToken f11468b;
    private final int f11469c;

    public CallbackImpl(CatalystInstance catalystInstance, ExecutorToken executorToken, int i) {
        this.f11467a = catalystInstance;
        this.f11468b = executorToken;
        this.f11469c = i;
    }

    public final void mo642a(Object... objArr) {
        this.f11467a.invokeCallback(this.f11468b, this.f11469c, Arguments.m13387a(objArr));
    }
}
