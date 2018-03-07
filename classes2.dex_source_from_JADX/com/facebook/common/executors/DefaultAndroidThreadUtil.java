package com.facebook.common.executors;

import android.os.Handler;
import android.os.Looper;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: weigher can not be combined with maximum size */
public class DefaultAndroidThreadUtil {
    private static volatile boolean f868a;
    private final BackgroundWorkLogger f869b;
    @Nullable
    private Handler f870c;

    public static DefaultAndroidThreadUtil m1646b(InjectorLike injectorLike) {
        return new DefaultAndroidThreadUtil(BaseBackgroundWorkLogger.m1660a(injectorLike));
    }

    @Inject
    public DefaultAndroidThreadUtil(BackgroundWorkLogger backgroundWorkLogger) {
        this.f869b = backgroundWorkLogger;
    }

    public final void m1654a(String str) {
        if (!f868a) {
            Preconditions.checkState(m1659c(), str);
        }
    }

    public static DefaultAndroidThreadUtil m1645a(InjectorLike injectorLike) {
        return m1646b(injectorLike);
    }

    public final void m1649a() {
        m1654a("This operation must be run on UI thread.");
    }

    public final void m1658b(String str) {
        if (!f868a) {
            Preconditions.checkState(!m1659c(), str);
        }
    }

    public final void m1655b() {
        m1658b("This operation can't be run on UI thread.");
    }

    public final boolean m1659c() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public final void m1652a(Runnable runnable) {
        if (m1659c()) {
            runnable.run();
        } else {
            HandlerDetour.a(m1647d(), runnable, 313178383);
        }
    }

    public final void m1656b(Runnable runnable) {
        HandlerDetour.a(m1647d(), runnable, -1196278371);
    }

    public final void m1653a(Runnable runnable, long j) {
        HandlerDetour.b(m1647d(), runnable, j, 722338219);
    }

    public final void m1657b(Runnable runnable, long j) {
        HandlerDetour.b(new Handler(), runnable, j, -1471740608);
    }

    public final <T> void m1651a(ListenableFuture<T> listenableFuture, FutureCallback<? super T> futureCallback) {
        Preconditions.checkNotNull(listenableFuture);
        Preconditions.checkNotNull(futureCallback);
        Preconditions.checkNotNull(Looper.myLooper(), "Must be called on a handler thread");
        Futures.m2458a((ListenableFuture) listenableFuture, (FutureCallback) futureCallback, new HandlerListeningExecutorServiceImpl(new Handler()));
    }

    public final void m1650a(long j) {
        Thread.sleep(j);
    }

    public final <Params, Progress, Result> FbAsyncTask<Params, Progress, Result> m1648a(FbAsyncTask<Params, Progress, Result> fbAsyncTask, Params... paramsArr) {
        return fbAsyncTask.a(this.f869b, paramsArr);
    }

    private Handler m1647d() {
        synchronized (this) {
            if (this.f870c == null) {
                this.f870c = new Handler(Looper.getMainLooper());
            }
        }
        return this.f870c;
    }
}
