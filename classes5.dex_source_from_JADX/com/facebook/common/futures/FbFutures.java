package com.facebook.common.futures;

import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* compiled from: split_flow_url */
public class FbFutures {

    /* compiled from: split_flow_url */
    final class C01761 implements ListenableFuture<O> {
        final /* synthetic */ ListenableFuture f2599a;
        final /* synthetic */ Function f2600b;

        C01761(ListenableFuture listenableFuture, Function function) {
            this.f2599a = listenableFuture;
            this.f2600b = function;
        }

        public final void m3702a(Runnable runnable, Executor executor) {
            this.f2599a.a(runnable, executor);
        }

        public final boolean cancel(boolean z) {
            return this.f2599a.cancel(z);
        }

        public final boolean isCancelled() {
            return this.f2599a.isCancelled();
        }

        public final boolean isDone() {
            return this.f2599a.isDone();
        }

        public final O get() {
            return m3701a(FutureDetour.a(this.f2599a, 1629664747));
        }

        public final O get(long j, TimeUnit timeUnit) {
            return m3701a(FutureDetour.a(this.f2599a, j, timeUnit, 1170399786));
        }

        private O m3701a(I i) {
            try {
                return this.f2600b.apply(i);
            } catch (Throwable th) {
                ExecutionException executionException = new ExecutionException(th);
            }
        }
    }

    /* compiled from: split_flow_url */
    public final class C01772 implements FutureCallback<T> {
        final /* synthetic */ SettableFuture f2601a;

        public C01772(SettableFuture settableFuture) {
            this.f2601a = settableFuture;
        }

        public final void onSuccess(@Nullable T t) {
            FutureDetour.a(this.f2601a, t, -1541239599);
        }

        public final void onFailure(Throwable th) {
            FutureDetour.a(this.f2601a, null, -1423596232);
        }
    }

    public static <I, O> ListenableFuture<O> m3703a(ListenableFuture<I> listenableFuture, Function<? super I, ? extends O> function) {
        Preconditions.checkNotNull(listenableFuture);
        Preconditions.checkNotNull(function);
        return new C01761(listenableFuture, function);
    }

    private static <T> T m3705a(Future<T> future, T t) {
        return future.isDone() ? Futures.a(future) : t;
    }

    @Nullable
    public static <T> T m3704a(Future<T> future) {
        return m3705a((Future) future, null);
    }
}
