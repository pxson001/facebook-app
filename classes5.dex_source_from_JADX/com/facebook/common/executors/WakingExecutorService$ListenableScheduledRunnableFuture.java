package com.facebook.common.executors;

import android.annotation.TargetApi;
import com.facebook.common.executors.WakingExecutorService.WakingListenableScheduledFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;

@TargetApi(9)
/* compiled from: spotlight_snippets_message */
class WakingExecutorService$ListenableScheduledRunnableFuture<V> extends WakingListenableScheduledFuture<V> implements RunnableFuture<V> {
    final /* synthetic */ WakingExecutorService f2586a;

    public WakingExecutorService$ListenableScheduledRunnableFuture(WakingExecutorService wakingExecutorService, Callable<V> callable) {
        this.f2586a = wakingExecutorService;
        super(wakingExecutorService, callable);
    }

    public WakingExecutorService$ListenableScheduledRunnableFuture(WakingExecutorService wakingExecutorService, Runnable runnable, V v) {
        this.f2586a = wakingExecutorService;
        super(wakingExecutorService, runnable, v);
    }
}
