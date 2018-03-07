package com.google.common.util.concurrent;

import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.AbstractFuture.TrustedFuture;
import com.google.common.util.concurrent.AggregateFuture.RunningState.C05871;
import com.google.common.util.concurrent.MoreExecutors.DirectExecutor;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@GwtCompatible
@Beta
/* compiled from: video-player-readable-cache */
public final class Futures extends GwtFuturesCatchingSpecialization {
    private static final AsyncFunction<ListenableFuture<Object>, Object> f1261a = new C00824();

    /* compiled from: video-player-readable-cache */
    final class C00824 implements AsyncFunction<ListenableFuture<Object>, Object> {
        C00824() {
        }

        public final ListenableFuture mo352a(Object obj) {
            return (ListenableFuture) obj;
        }
    }

    /* compiled from: video-player-readable-cache */
    final class C00836 implements Runnable {
        final /* synthetic */ ListenableFuture f1262a;
        final /* synthetic */ FutureCallback f1263b;

        C00836(ListenableFuture listenableFuture, FutureCallback futureCallback) {
            this.f1262a = listenableFuture;
            this.f1263b = futureCallback;
        }

        public final void run() {
            try {
                this.f1263b.onSuccess(Uninterruptibles.m1584a(this.f1262a));
            } catch (ExecutionException e) {
                this.f1263b.onFailure(e.getCause());
            } catch (Throwable e2) {
                this.f1263b.onFailure(e2);
            } catch (Throwable e22) {
                this.f1263b.onFailure(e22);
            }
        }
    }

    /* compiled from: video-player-readable-cache */
    class ImmediateSuccessfulFuture<V> extends ImmediateFuture<V> {
        static final ImmediateSuccessfulFuture<Object> f2781a = new ImmediateSuccessfulFuture(null);
        @Nullable
        private final V f2782b;

        ImmediateSuccessfulFuture(@Nullable V v) {
            this.f2782b = v;
        }

        public V get() {
            return this.f2782b;
        }
    }

    /* compiled from: video-player-readable-cache */
    abstract class ImmediateFuture<V> implements ListenableFuture<V> {
        private static final Logger f2783a = Logger.getLogger(ImmediateFuture.class.getName());

        public final void mo223a(Runnable runnable, Executor executor) {
            Preconditions.checkNotNull(runnable, "Runnable was null.");
            Preconditions.checkNotNull(executor, "Executor was null.");
            try {
                ExecutorDetour.a(executor, runnable, 1648202336);
            } catch (Throwable e) {
                f2783a.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, e);
            }
        }

        public boolean cancel(boolean z) {
            return false;
        }

        public V get(long j, TimeUnit timeUnit) {
            Preconditions.checkNotNull(timeUnit);
            return FutureDetour.a(this, -1840742161);
        }

        public boolean isCancelled() {
            return false;
        }

        public boolean isDone() {
            return true;
        }
    }

    /* compiled from: video-player-readable-cache */
    final class ChainingFuture<I, O> extends AbstractChainingFuture<I, O, Function<? super I, ? extends O>> {
        final void mo2650a(Object obj, Object obj2) {
            mo221a(((Function) obj).apply(obj2));
        }

        ChainingFuture(ListenableFuture<? extends I> listenableFuture, Function<? super I, ? extends O> function) {
            super(listenableFuture, function);
        }
    }

    /* compiled from: video-player-readable-cache */
    abstract class AbstractChainingFuture<I, O, F> extends TrustedFuture<O> implements Runnable {
        @Nullable
        ListenableFuture<? extends I> f13560a;
        @Nullable
        F f13561b;

        abstract void mo2650a(F f, I i);

        AbstractChainingFuture(ListenableFuture<? extends I> listenableFuture, F f) {
            this.f13560a = (ListenableFuture) Preconditions.checkNotNull(listenableFuture);
            this.f13561b = Preconditions.checkNotNull(f);
        }

        public final void run() {
            int i = 1;
            try {
                int i2;
                Future future = this.f13560a;
                Object obj = this.f13561b;
                boolean isCancelled = isCancelled();
                if (future == null) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                i2 |= isCancelled;
                if (obj != null) {
                    i = 0;
                }
                if ((i | i2) == 0) {
                    this.f13560a = null;
                    this.f13561b = null;
                    try {
                        mo2650a(obj, Uninterruptibles.m1584a(future));
                    } catch (CancellationException e) {
                        cancel(false);
                    } catch (ExecutionException e2) {
                        mo222a(e2.getCause());
                    }
                }
            } catch (UndeclaredThrowableException e3) {
                mo222a(e3.getCause());
            } catch (Throwable th) {
                mo222a(th);
            }
        }

        final void mo2651c() {
            Future future = this.f13560a;
            if (((future != null ? 1 : 0) & isCancelled()) != 0) {
                future.cancel(m1565b());
            }
            this.f13560a = null;
            this.f13561b = null;
        }
    }

    /* compiled from: video-player-readable-cache */
    final class ListFuture<V> extends CollectionFuture<V, List<V>> {

        /* compiled from: video-player-readable-cache */
        final class ListFutureRunningState extends CollectionFutureRunningState {
            final /* synthetic */ ListFuture f14006c;

            ListFutureRunningState(ListFuture listFuture, ImmutableCollection<? extends ListenableFuture<? extends V>> immutableCollection, boolean z) {
                this.f14006c = listFuture;
                super(listFuture, immutableCollection, z);
            }

            public final Object mo2694a(List list) {
                List a = Lists.m1296a();
                for (Optional optional : list) {
                    a.add(optional != null ? optional.orNull() : null);
                }
                return Collections.unmodifiableList(a);
            }
        }

        ListFuture(ImmutableCollection<? extends ListenableFuture<? extends V>> immutableCollection, boolean z) {
            Runnable listFutureRunningState = new ListFutureRunningState(this, immutableCollection, z);
            this.f13936b = listFutureRunningState;
            if (listFutureRunningState.f14010b.isEmpty()) {
                listFutureRunningState.mo2697b();
            } else if (listFutureRunningState.f14011c) {
                Iterator it = listFutureRunningState.f14010b.iterator();
                int i = 0;
                while (it.hasNext()) {
                    ListenableFuture listenableFuture = (ListenableFuture) it.next();
                    int i2 = i + 1;
                    listenableFuture.mo223a(new C05871(listFutureRunningState, i, listenableFuture), DirectExecutor.INSTANCE);
                    i = i2;
                }
            } else {
                Iterator it2 = listFutureRunningState.f14010b.iterator();
                while (it2.hasNext()) {
                    ((ListenableFuture) it2.next()).mo223a(listFutureRunningState, DirectExecutor.INSTANCE);
                }
            }
        }
    }

    /* compiled from: video-player-readable-cache */
    final class AsyncChainingFuture<I, O> extends AbstractChainingFuture<I, O, AsyncFunction<? super I, ? extends O>> {
        final void mo2650a(Object obj, Object obj2) {
            ListenableFuture a = ((AsyncFunction) obj).mo352a(obj2);
            Preconditions.checkNotNull(a, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)?");
            mo220a(a);
        }

        AsyncChainingFuture(ListenableFuture<? extends I> listenableFuture, AsyncFunction<? super I, ? extends O> asyncFunction) {
            super(listenableFuture, asyncFunction);
        }
    }

    /* compiled from: video-player-readable-cache */
    final class C05852 implements Executor {
        volatile boolean f14002a = true;
        final /* synthetic */ Executor f14003b;
        final /* synthetic */ AbstractFuture f14004c;

        C05852(Executor executor, AbstractFuture abstractFuture) {
            this.f14003b = executor;
            this.f14004c = abstractFuture;
        }

        public final void execute(final Runnable runnable) {
            try {
                ExecutorDetour.a(this.f14003b, new Runnable(this) {
                    final /* synthetic */ C05852 f14994b;

                    public void run() {
                        this.f14994b.f14002a = false;
                        runnable.run();
                    }
                }, 196802666);
            } catch (Throwable e) {
                if (this.f14002a) {
                    this.f14004c.mo222a(e);
                }
            }
        }
    }

    private Futures() {
    }

    @CheckReturnValue
    public static <V> ListenableFuture<V> m2452a(@Nullable V v) {
        if (v == null) {
            return ImmediateSuccessfulFuture.f2781a;
        }
        return new ImmediateSuccessfulFuture(v);
    }

    @CheckReturnValue
    public static <V> ListenableFuture<V> m2453a(Throwable th) {
        Preconditions.checkNotNull(th);
        return new ImmediateFailedFuture(th);
    }

    @CheckReturnValue
    @GwtIncompatible("TODO")
    public static <V> ListenableFuture<V> m2447a() {
        return new ImmediateCancelledFuture();
    }

    @CheckReturnValue
    @GwtIncompatible("TODO")
    public static <V, X extends Exception> CheckedFuture<V, X> m2446a(X x) {
        Preconditions.checkNotNull(x);
        return new ImmediateFailedCheckedFuture(x);
    }

    public static <V> void m2457a(ListenableFuture<V> listenableFuture, FutureCallback<? super V> futureCallback) {
        m2458a((ListenableFuture) listenableFuture, (FutureCallback) futureCallback, (Executor) DirectExecutor.INSTANCE);
    }

    public static <I, O> ListenableFuture<O> m2460b(ListenableFuture<I> listenableFuture, AsyncFunction<? super I, ? extends O> asyncFunction) {
        Object asyncChainingFuture = new AsyncChainingFuture(listenableFuture, asyncFunction);
        listenableFuture.mo223a(asyncChainingFuture, DirectExecutor.INSTANCE);
        return asyncChainingFuture;
    }

    public static <I, O> ListenableFuture<O> m2461b(ListenableFuture<I> listenableFuture, AsyncFunction<? super I, ? extends O> asyncFunction, Executor executor) {
        Preconditions.checkNotNull(executor);
        AbstractFuture asyncChainingFuture = new AsyncChainingFuture(listenableFuture, asyncFunction);
        listenableFuture.mo223a(asyncChainingFuture, m2456a(executor, asyncChainingFuture));
        return asyncChainingFuture;
    }

    private static Executor m2456a(Executor executor, AbstractFuture<?> abstractFuture) {
        Preconditions.checkNotNull(executor);
        return executor == DirectExecutor.INSTANCE ? executor : new C05852(executor, abstractFuture);
    }

    public static <I, O> ListenableFuture<O> m2449a(ListenableFuture<I> listenableFuture, Function<? super I, ? extends O> function) {
        Preconditions.checkNotNull(function);
        Object chainingFuture = new ChainingFuture(listenableFuture, function);
        listenableFuture.mo223a(chainingFuture, DirectExecutor.INSTANCE);
        return chainingFuture;
    }

    public static <I, O> ListenableFuture<O> m2450a(ListenableFuture<I> listenableFuture, Function<? super I, ? extends O> function, Executor executor) {
        Preconditions.checkNotNull(function);
        AbstractFuture chainingFuture = new ChainingFuture(listenableFuture, function);
        listenableFuture.mo223a(chainingFuture, m2456a(executor, chainingFuture));
        return chainingFuture;
    }

    @CheckReturnValue
    public static <V> ListenableFuture<V> m2448a(ListenableFuture<? extends ListenableFuture<? extends V>> listenableFuture) {
        return m2460b(listenableFuture, f1261a);
    }

    @CheckReturnValue
    @SafeVarargs
    @Beta
    public static <V> ListenableFuture<List<V>> m2454a(ListenableFuture<? extends V>... listenableFutureArr) {
        return new ListFuture(ImmutableList.copyOf((Object[]) listenableFutureArr), true);
    }

    @CheckReturnValue
    @Beta
    public static <V> ListenableFuture<List<V>> m2451a(Iterable<? extends ListenableFuture<? extends V>> iterable) {
        return new ListFuture(ImmutableList.copyOf((Iterable) iterable), true);
    }

    @CheckReturnValue
    @GwtIncompatible("TODO")
    public static <V> ListenableFuture<V> m2459b(ListenableFuture<V> listenableFuture) {
        return new NonCancellationPropagatingFuture(listenableFuture);
    }

    @CheckReturnValue
    @SafeVarargs
    @Beta
    public static <V> ListenableFuture<List<V>> m2463b(ListenableFuture<? extends V>... listenableFutureArr) {
        return new ListFuture(ImmutableList.copyOf((Object[]) listenableFutureArr), false);
    }

    @CheckReturnValue
    @Beta
    public static <V> ListenableFuture<List<V>> m2462b(Iterable<? extends ListenableFuture<? extends V>> iterable) {
        return new ListFuture(ImmutableList.copyOf((Iterable) iterable), false);
    }

    public static <V> void m2458a(ListenableFuture<V> listenableFuture, FutureCallback<? super V> futureCallback, Executor executor) {
        Preconditions.checkNotNull(futureCallback);
        listenableFuture.mo223a(new C00836(listenableFuture, futureCallback), executor);
    }

    @GwtIncompatible("TODO")
    public static <V> V m2455a(Future<V> future) {
        Preconditions.checkNotNull(future);
        try {
            return Uninterruptibles.m1584a((Future) future);
        } catch (ExecutionException e) {
            m2464b(e.getCause());
            throw new AssertionError();
        }
    }

    @GwtIncompatible("TODO")
    private static void m2464b(Throwable th) {
        if (th instanceof Error) {
            throw new ExecutionError((Error) th);
        }
        throw new UncheckedExecutionException(th);
    }
}
