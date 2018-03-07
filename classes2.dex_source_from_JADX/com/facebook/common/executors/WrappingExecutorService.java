package com.facebook.common.executors;

import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* compiled from: voip_audio_mode_normal_android */
public abstract class WrappingExecutorService implements ExecutorService {
    private final ExecutorService f964a;

    protected abstract <T> Callable<T> a_(Callable<T> callable);

    protected WrappingExecutorService(ExecutorService executorService) {
        this.f964a = (ExecutorService) Preconditions.checkNotNull(executorService);
    }

    protected final Runnable m1950b(final Runnable runnable) {
        final Callable a_ = a_(Executors.callable(runnable, null));
        return new Object(this) {
            final /* synthetic */ WrappingExecutorService f1620c;

            public final String mo502a() {
                return LoggingUtils.a(runnable);
            }

            public void run() {
                try {
                    a_.call();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
        };
    }

    private final <T> ImmutableList<Callable<T>> m1949a(Collection<? extends Callable<T>> collection) {
        Builder builder = ImmutableList.builder();
        for (Callable a_ : collection) {
            builder.m1069c(a_(a_));
        }
        return builder.m1068b();
    }

    public final void execute(Runnable runnable) {
        ExecutorDetour.a(this.f964a, m1950b(runnable), 1169157303);
    }

    public <T> Future<T> submit(Callable<T> callable) {
        return ExecutorDetour.a(this.f964a, a_((Callable) Preconditions.checkNotNull(callable)), -1649372056);
    }

    public Future<?> submit(Runnable runnable) {
        return ExecutorDetour.a(this.f964a, m1950b(runnable), 1862566931);
    }

    public <T> Future<T> submit(Runnable runnable, T t) {
        return ExecutorDetour.a(this.f964a, m1950b(runnable), t, -1924939425);
    }

    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) {
        return this.f964a.invokeAll(m1949a(collection));
    }

    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) {
        return this.f964a.invokeAll(m1949a(collection), j, timeUnit);
    }

    public final <T> T invokeAny(Collection<? extends Callable<T>> collection) {
        return this.f964a.invokeAny(m1949a(collection));
    }

    public final <T> T invokeAny(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) {
        return this.f964a.invokeAny(m1949a(collection), j, timeUnit);
    }

    public final void shutdown() {
        this.f964a.shutdown();
    }

    public final List<Runnable> shutdownNow() {
        return this.f964a.shutdownNow();
    }

    public final boolean isShutdown() {
        return this.f964a.isShutdown();
    }

    public final boolean isTerminated() {
        return this.f964a.isTerminated();
    }

    public final boolean awaitTermination(long j, TimeUnit timeUnit) {
        return this.f964a.awaitTermination(j, timeUnit);
    }
}
