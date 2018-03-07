package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.AbstractFuture.TrustedFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RunnableFuture;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: endcallstats */
class TrustedListenableFutureTask<V> extends TrustedFuture<V> implements RunnableFuture<V> {
    private TrustedFutureInterruptibleTask f13000a;

    /* compiled from: endcallstats */
    final class TrustedFutureInterruptibleTask extends InterruptibleTask {
        final /* synthetic */ TrustedListenableFutureTask f13001a;
        private final Callable<V> f13002b;

        TrustedFutureInterruptibleTask(TrustedListenableFutureTask trustedListenableFutureTask, Callable<V> callable) {
            this.f13001a = trustedListenableFutureTask;
            this.f13002b = (Callable) Preconditions.checkNotNull(callable);
        }

        final void mo936a() {
            if (!this.f13001a.isDone()) {
                try {
                    this.f13001a.a(this.f13002b.call());
                } catch (Throwable th) {
                    this.f13001a.a(th);
                }
            }
        }

        final boolean mo937b() {
            return this.f13001a.b();
        }
    }

    static <V> TrustedListenableFutureTask<V> m13862a(Callable<V> callable) {
        return new TrustedListenableFutureTask(callable);
    }

    static <V> TrustedListenableFutureTask<V> m13861a(Runnable runnable, @Nullable V v) {
        return new TrustedListenableFutureTask(Executors.callable(runnable, v));
    }

    private TrustedListenableFutureTask(Callable<V> callable) {
        this.f13000a = new TrustedFutureInterruptibleTask(this, callable);
    }

    public void run() {
        InterruptibleTask interruptibleTask = this.f13000a;
        if (interruptibleTask != null) {
            interruptibleTask.run();
        }
    }

    final void m13864c() {
        super.c();
        this.f13000a = null;
    }

    @GwtIncompatible("Interruption not supported")
    protected final void m13863a() {
        InterruptibleTask interruptibleTask = this.f13000a;
        if (interruptibleTask != null) {
            Thread thread = interruptibleTask.f13004b;
            if (thread != null) {
                thread.interrupt();
            }
            interruptibleTask.f13005c = true;
        }
    }
}
