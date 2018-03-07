package com.google.common.util.concurrent;

import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ThreadFactoryBuilder.C08711;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

@Beta
/* compiled from: bug_desc */
public final class JdkFutureAdapters {

    /* compiled from: bug_desc */
    class ListenableFutureAdapter<V> extends ForwardingFuture<V> implements ListenableFuture<V> {
        private static final ThreadFactory f7664a;
        private static final Executor f7665b;
        private final Executor f7666c;
        public final ExecutionList f7667d;
        private final AtomicBoolean f7668e;
        public final Future<V> f7669f;

        /* compiled from: bug_desc */
        class C08701 implements Runnable {
            final /* synthetic */ ListenableFutureAdapter f7663a;

            C08701(ListenableFutureAdapter listenableFutureAdapter) {
                this.f7663a = listenableFutureAdapter;
            }

            public void run() {
                try {
                    Uninterruptibles.a(this.f7663a.f7669f);
                } catch (Throwable th) {
                }
                this.f7663a.f7667d.a();
            }
        }

        protected final /* synthetic */ Object m13840e() {
            return m13838a();
        }

        static {
            ThreadFactory threadFactory;
            ThreadFactoryBuilder threadFactoryBuilder = new ThreadFactoryBuilder();
            threadFactoryBuilder.f7680b = Boolean.valueOf(true);
            threadFactoryBuilder = threadFactoryBuilder;
            String str = "ListenableFutureAdapter-thread-%d";
            ThreadFactoryBuilder.m13846b(str, Integer.valueOf(0));
            threadFactoryBuilder.f7679a = str;
            threadFactoryBuilder = threadFactoryBuilder;
            String str2 = threadFactoryBuilder.f7679a;
            Boolean bool = threadFactoryBuilder.f7680b;
            Integer num = threadFactoryBuilder.f7681c;
            UncaughtExceptionHandler uncaughtExceptionHandler = threadFactoryBuilder.f7682d;
            if (threadFactoryBuilder.f7683e != null) {
                threadFactory = threadFactoryBuilder.f7683e;
            } else {
                threadFactory = Executors.defaultThreadFactory();
            }
            C08711 c08711 = new C08711(threadFactory, str2, str2 != null ? new AtomicLong(0) : null, bool, num, uncaughtExceptionHandler);
            f7664a = c08711;
            f7665b = Executors.newCachedThreadPool(c08711);
        }

        ListenableFutureAdapter(Future<V> future) {
            this(future, f7665b);
        }

        private ListenableFutureAdapter(Future<V> future, Executor executor) {
            this.f7667d = new ExecutionList();
            this.f7668e = new AtomicBoolean(false);
            this.f7669f = (Future) Preconditions.checkNotNull(future);
            this.f7666c = (Executor) Preconditions.checkNotNull(executor);
        }

        protected final Future<V> m13838a() {
            return this.f7669f;
        }

        public final void m13839a(Runnable runnable, Executor executor) {
            this.f7667d.a(runnable, executor);
            if (!this.f7668e.compareAndSet(false, true)) {
                return;
            }
            if (this.f7669f.isDone()) {
                this.f7667d.a();
            } else {
                ExecutorDetour.a(this.f7666c, new C08701(this), 183996);
            }
        }
    }

    public static <V> ListenableFuture<V> m13841a(Future<V> future) {
        if (future instanceof ListenableFuture) {
            return (ListenableFuture) future;
        }
        return new ListenableFutureAdapter(future);
    }

    private JdkFutureAdapters() {
    }
}
