package com.facebook.common.noncriticalinit;

import com.facebook.common.appchoreographer.AppChoreographer;
import com.facebook.common.appchoreographer.AppChoreographer.Priority;
import com.facebook.common.appchoreographer.AppChoreographer.ThreadType;
import com.facebook.common.appchoreographer.DefaultAppChoreographer;
import com.facebook.common.build.BuildConstants;
import com.facebook.common.executors.CrashingFutureCallback;
import com.facebook.common.init.AppInitLock;
import com.facebook.common.init.INeedInit;
import com.facebook.debug.log.BLog;
import com.facebook.inject.Lazy;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.util.concurrent.Futures;
import java.util.Set;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/* compiled from: must have even number of flattened headers */
public class NonCriticalInitializer implements INeedInit {
    private final Lazy<Set<INeedInit>> f7330a;
    private final Lazy<AppInitLock> f7331b;
    private final DefaultAppChoreographer f7332c;
    private final Executor f7333d;
    private final CrashingFutureCallback f7334e;

    /* compiled from: must have even number of flattened headers */
    class C03511 implements Runnable {
        final /* synthetic */ NonCriticalInitializer f7336a;

        C03511(NonCriticalInitializer nonCriticalInitializer) {
            this.f7336a = nonCriticalInitializer;
        }

        public void run() {
            this.f7336a.m7663a();
        }
    }

    @Inject
    public NonCriticalInitializer(Lazy<Set<INeedInit>> lazy, Lazy<AppInitLock> lazy2, AppChoreographer appChoreographer, Executor executor, CrashingFutureCallback crashingFutureCallback) {
        this.f7330a = lazy;
        this.f7331b = lazy2;
        this.f7332c = appChoreographer;
        this.f7333d = executor;
        this.f7334e = crashingFutureCallback;
    }

    public void init() {
        Futures.a(this.f7332c.a("NonCriticalInitializer", new C03511(this), Priority.APPLICATION_LOADED_UI_IDLE_HIGH_PRIORITY, ThreadType.BACKGROUND), this.f7334e, this.f7333d);
    }

    @VisibleForTesting
    final void m7663a() {
        INeedInit[] iNeedInitArr = (INeedInit[]) ((Set) this.f7330a.get()).toArray(new INeedInit[0]);
        if (iNeedInitArr.length > 0) {
            m7664a(iNeedInitArr, 0);
        } else {
            m7662b();
        }
    }

    @VisibleForTesting
    final void m7664a(final INeedInit[] iNeedInitArr, int i) {
        try {
            iNeedInitArr[i].init();
        } catch (Throwable e) {
            if (BuildConstants.e()) {
                throw e;
            }
            BLog.c("NonCriticalInitializer", e, "INeedInit failed: %s", new Object[]{iNeedInitArr[i].getClass().getName()});
        }
        final int i2 = i + 1;
        if (i2 < iNeedInitArr.length) {
            Futures.a(this.f7332c.a("NonCriticalInitializer", new Runnable(this) {
                final /* synthetic */ NonCriticalInitializer f9541c;

                public void run() {
                    this.f9541c.m7664a(iNeedInitArr, i2);
                }
            }, Priority.APPLICATION_LOADED_UI_IDLE_HIGH_PRIORITY, ThreadType.BACKGROUND), this.f7334e, this.f7333d);
        } else {
            m7662b();
        }
    }

    @VisibleForTesting
    private void m7662b() {
        try {
            ((AppInitLock) this.f7331b.get()).a();
        } catch (Throwable e) {
            BLog.c("NonCriticalInitializer", e, "AppInitLock failed", new Object[0]);
        }
    }
}
