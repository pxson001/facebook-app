package com.facebook.common.futures;

import com.facebook.debug.log.BLog;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.Uninterruptibles;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.Nullable;

/* compiled from: maybe a (non-standard) comment? (not recognized as one since Feature 'ALLOW_COMMENTS' not enabled for parser) */
public class FutureUtils {

    /* compiled from: maybe a (non-standard) comment? (not recognized as one since Feature 'ALLOW_COMMENTS' not enabled for parser) */
    final class C06341 implements Runnable {
        final /* synthetic */ ListenableFuture f14747a;
        final /* synthetic */ FutureCallback f14748b;

        C06341(ListenableFuture listenableFuture, FutureCallback futureCallback) {
            this.f14747a = listenableFuture;
            this.f14748b = futureCallback;
        }

        public final void run() {
            try {
                this.f14748b.onSuccess(Uninterruptibles.m1584a(this.f14747a));
            } catch (ExecutionException e) {
                if (e.getCause() instanceof Error) {
                    throw ((Error) e.getCause());
                }
                this.f14748b.onFailure(e.getCause());
            } catch (Throwable e2) {
                this.f14748b.onFailure(e2);
            }
        }
    }

    @Nullable
    public static <T> T m21154a(Future<T> future) {
        Throwable e;
        try {
            return FutureDetour.a(future, 757062729);
        } catch (InterruptedException e2) {
            e = e2;
            Thread.currentThread().interrupt();
            BLog.b(future.getClass(), "Exception while blocking for future result", e);
            return null;
        } catch (ExecutionException e3) {
            e = e3;
            BLog.b(future.getClass(), "Exception while blocking for future result", e);
            return null;
        } catch (CancellationException e4) {
            e = e4;
            BLog.b(future.getClass(), "Exception while blocking for future result", e);
            return null;
        }
    }

    @Nullable
    public static <T> T m21157b(Future<T> future) {
        T t = null;
        try {
            t = FutureDetour.a(future, 1423872167);
        } catch (ExecutionException e) {
            throw e;
        } catch (Throwable e2) {
            Thread.currentThread().interrupt();
            BLog.b(future.getClass(), "Interrupted while blocking for future result", e2);
        } catch (Throwable e22) {
            BLog.b(future.getClass(), "Future cancelled while blocking for result", e22);
        }
        return t;
    }

    @Nullable
    public static <T> T m21155a(Future<T> future, long j) {
        Throwable e;
        try {
            return FutureDetour.a(future, j, TimeUnit.MILLISECONDS, 885449474);
        } catch (InterruptedException e2) {
            e = e2;
            Thread.currentThread().interrupt();
            BLog.b(future.getClass(), "Exception while blocking for future result", e);
            return null;
        } catch (ExecutionException e3) {
            e = e3;
            BLog.b(future.getClass(), "Exception while blocking for future result", e);
            return null;
        } catch (CancellationException e4) {
            e = e4;
            BLog.b(future.getClass(), "Exception while blocking for future result", e);
            return null;
        } catch (TimeoutException e5) {
            future.getClass();
            return null;
        }
    }

    public static <T> boolean m21158c(Future<T> future) {
        if (future.isDone() && m21154a(future) == null) {
            return true;
        }
        return false;
    }

    public static <V> void m21156a(ListenableFuture<V> listenableFuture, FutureCallback<? super V> futureCallback, Executor executor) {
        Preconditions.checkNotNull(futureCallback);
        listenableFuture.mo223a(new C06341(listenableFuture, futureCallback), executor);
    }
}
