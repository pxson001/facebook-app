package com.facebook.feed.environment.impl;

import com.facebook.common.futures.AbstractDisposableFutureCallback;

/* compiled from: must provide a google map api key */
class CanFollowUserImpl$1 extends AbstractDisposableFutureCallback<Void> {
    final /* synthetic */ CanFollowUserImpl f10147a;

    CanFollowUserImpl$1(CanFollowUserImpl canFollowUserImpl) {
        this.f10147a = canFollowUserImpl;
    }

    protected final void m15832a(Throwable th) {
        this.f10147a.c.a(th);
    }
}
