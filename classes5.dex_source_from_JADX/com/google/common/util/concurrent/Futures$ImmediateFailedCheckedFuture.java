package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.util.concurrent.Futures.ImmediateFuture;
import java.util.concurrent.ExecutionException;

@GwtIncompatible("TODO")
/* compiled from: bug_git_branch */
public class Futures$ImmediateFailedCheckedFuture<V, X extends Exception> extends ImmediateFuture<V> implements CheckedFuture<V, X> {
    private final X f7656a;

    Futures$ImmediateFailedCheckedFuture(X x) {
        this.f7656a = x;
    }

    public V get() {
        throw new ExecutionException(this.f7656a);
    }
}
