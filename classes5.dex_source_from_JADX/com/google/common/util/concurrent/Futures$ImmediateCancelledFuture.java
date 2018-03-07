package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.util.concurrent.Futures.ImmediateFuture;
import java.util.concurrent.CancellationException;

@GwtIncompatible("TODO")
/* compiled from: bug_git_branch */
class Futures$ImmediateCancelledFuture<V> extends ImmediateFuture<V> {
    private final CancellationException f7655a = new CancellationException("Immediate cancelled future.");

    Futures$ImmediateCancelledFuture() {
    }

    public boolean isCancelled() {
        return true;
    }

    public V get() {
        throw AbstractFuture.a("Task was cancelled.", this.f7655a);
    }
}
