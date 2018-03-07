package com.google.common.util.concurrent;

import com.google.common.util.concurrent.Futures.ImmediateFuture;
import java.util.concurrent.ExecutionException;

/* compiled from: bug_git_branch */
class Futures$ImmediateFailedFuture<V> extends ImmediateFuture<V> {
    private final Throwable f7657a;

    Futures$ImmediateFailedFuture(Throwable th) {
        this.f7657a = th;
    }

    public V get() {
        throw new ExecutionException(this.f7657a);
    }
}
