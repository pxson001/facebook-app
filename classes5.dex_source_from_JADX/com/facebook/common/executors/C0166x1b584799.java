package com.facebook.common.executors;

import android.annotation.TargetApi;
import android.os.Handler;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;

@TargetApi(9)
/* compiled from: stale_modal */
class C0166x1b584799<V> extends ListenableScheduledFutureImpl<V> implements RunnableFuture<V> {
    public C0166x1b584799(Handler handler, Callable<V> callable) {
        super(handler, callable);
    }

    public C0166x1b584799(Handler handler, Runnable runnable, V v) {
        super(handler, runnable, v);
    }
}
