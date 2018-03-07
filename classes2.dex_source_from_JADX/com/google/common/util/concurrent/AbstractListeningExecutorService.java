package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RunnableFuture;
import javax.annotation.Nullable;

@Beta
/* compiled from: wantFirstFrameForThumbnail */
public abstract class AbstractListeningExecutorService extends AbstractExecutorService implements ListeningExecutorService {
    public /* synthetic */ Future submit(Runnable runnable) {
        return mo269a(runnable);
    }

    public /* synthetic */ Future submit(Runnable runnable, @Nullable Object obj) {
        return mo270a(runnable, obj);
    }

    public /* synthetic */ Future submit(Callable callable) {
        return mo271a(callable);
    }

    protected final <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
        return TrustedListenableFutureTask.a(runnable, t);
    }

    protected final <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return TrustedListenableFutureTask.a(callable);
    }

    public final ListenableFuture<?> mo269a(Runnable runnable) {
        return (ListenableFuture) super.submit(runnable);
    }

    public final <T> ListenableFuture<T> mo270a(Runnable runnable, @Nullable T t) {
        return (ListenableFuture) super.submit(runnable, t);
    }

    public final <T> ListenableFuture<T> mo271a(Callable<T> callable) {
        return (ListenableFuture) super.submit(callable);
    }
}
