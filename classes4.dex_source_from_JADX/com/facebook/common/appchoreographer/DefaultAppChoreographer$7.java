package com.facebook.common.appchoreographer;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: whitelist */
class DefaultAppChoreographer$7 implements Runnable {
    final /* synthetic */ ListenableFuture f104a;
    final /* synthetic */ DefaultAppChoreographer f105b;

    DefaultAppChoreographer$7(DefaultAppChoreographer defaultAppChoreographer, ListenableFuture listenableFuture) {
        this.f105b = defaultAppChoreographer;
        this.f104a = listenableFuture;
    }

    public void run() {
        this.f105b.b(this.f104a);
    }
}
