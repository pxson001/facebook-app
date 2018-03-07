package com.facebook.places.future;

import android.os.Handler;
import android.os.Looper;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.Map.Entry;
import java.util.WeakHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import javax.inject.Inject;

/* compiled from: formatted_time_for_display */
public class SimpleExecutor {
    private static final Class<?> f14720b = SimpleExecutor.class;
    @VisibleForTesting
    final List<MutableObject<FutureCallback>> f14721a = Lists.a();
    private Handler f14722c;
    private final ExecutorService f14723d;
    public List<Runnable> f14724e = null;
    private WeakHashMap<Future, Boolean> f14725f = new WeakHashMap();

    /* compiled from: formatted_time_for_display */
    public class MutableObject<T> {
        public T f14719a;

        public MutableObject(T t) {
            this.f14719a = t;
        }
    }

    public static SimpleExecutor m22275b(InjectorLike injectorLike) {
        return new SimpleExecutor((ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike));
    }

    public static SimpleExecutor m22272a(InjectorLike injectorLike) {
        return m22275b(injectorLike);
    }

    @Inject
    public SimpleExecutor(ExecutorService executorService) {
        this.f14723d = executorService;
    }

    public final <T> void m22280a(final Callable<T> callable, FutureCallback<T> futureCallback) {
        m22276d();
        m22277e();
        final MutableObject a = m22271a((FutureCallback) futureCallback);
        this.f14725f.put(ExecutorDetour.a(this.f14723d, new Runnable(this) {
            final /* synthetic */ SimpleExecutor f14710c;

            public void run() {
                try {
                    SimpleExecutor.m22273a(this.f14710c, a, callable.call());
                } catch (Throwable e) {
                    SimpleExecutor.m22274a(this.f14710c, a, e);
                }
            }
        }, 1113222178), Boolean.valueOf(true));
    }

    public final <T> void m22279a(ListenableFuture<T> listenableFuture, FutureCallback<T> futureCallback) {
        m22276d();
        m22277e();
        final MutableObject a = m22271a((FutureCallback) futureCallback);
        Futures.a(listenableFuture, new FutureCallback<T>(this) {
            final /* synthetic */ SimpleExecutor f14712b;

            public void onSuccess(T t) {
                SimpleExecutor.m22273a(this.f14712b, a, (Object) t);
            }

            public void onFailure(Throwable th) {
                SimpleExecutor.m22274a(this.f14712b, a, th);
            }
        });
        this.f14725f.put(listenableFuture, Boolean.valueOf(true));
    }

    private void m22276d() {
        if (this.f14722c == null) {
            this.f14722c = new Handler();
        }
    }

    public static void m22273a(SimpleExecutor simpleExecutor, final MutableObject mutableObject, final Object obj) {
        HandlerDetour.a(simpleExecutor.f14722c, new Runnable(simpleExecutor) {
            final /* synthetic */ SimpleExecutor f14715c;

            public void run() {
                if (this.f14715c.f14724e != null) {
                    this.f14715c.f14724e.add(this);
                    return;
                }
                FutureCallback futureCallback = (FutureCallback) mutableObject.f14719a;
                if (futureCallback != null) {
                    this.f14715c.f14721a.remove(mutableObject);
                    futureCallback.onSuccess(obj);
                }
            }
        }, -178534590);
    }

    public static void m22274a(SimpleExecutor simpleExecutor, final MutableObject mutableObject, final Throwable th) {
        BLog.b(f14720b, "Exception in background task", th);
        HandlerDetour.a(simpleExecutor.f14722c, new Runnable(simpleExecutor) {
            final /* synthetic */ SimpleExecutor f14718c;

            public void run() {
                if (this.f14718c.f14724e != null) {
                    this.f14718c.f14724e.add(this);
                    return;
                }
                FutureCallback futureCallback = (FutureCallback) mutableObject.f14719a;
                if (futureCallback != null) {
                    this.f14718c.f14721a.remove(mutableObject);
                    futureCallback.onFailure(th);
                }
            }
        }, 1690514129);
    }

    private MutableObject<FutureCallback> m22271a(FutureCallback futureCallback) {
        MutableObject<FutureCallback> mutableObject = new MutableObject(futureCallback);
        this.f14721a.add(mutableObject);
        return mutableObject;
    }

    public final void m22278a() {
        m22277e();
        this.f14724e = Lists.a();
    }

    public final void m22281b() {
        m22277e();
        if (this.f14724e != null) {
            for (Runnable a : this.f14724e) {
                HandlerDetour.a(this.f14722c, a, 1747877387);
            }
            this.f14724e = null;
        }
    }

    public final void m22282c() {
        m22277e();
        for (MutableObject mutableObject : this.f14721a) {
            mutableObject.f14719a = null;
        }
        this.f14721a.clear();
        this.f14724e = null;
        for (Entry key : this.f14725f.entrySet()) {
            ((Future) key.getKey()).cancel(true);
        }
    }

    private void m22277e() {
        if (this.f14722c != null && this.f14722c.getLooper() != Looper.myLooper()) {
            throw new IllegalStateException("SimpleExecutor is not thread-safe and should be called from a single Looper thread");
        }
    }
}
