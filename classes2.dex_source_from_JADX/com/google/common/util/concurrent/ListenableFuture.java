package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

@GwtCompatible
/* compiled from: whistle_failure */
public interface ListenableFuture<V> extends Future<V> {
    void mo223a(Runnable runnable, Executor executor);
}
