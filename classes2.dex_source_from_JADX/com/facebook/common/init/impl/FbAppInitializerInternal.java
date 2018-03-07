package com.facebook.common.init.impl;

import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import com.facebook.common.appchoreographer.AppChoreographer;
import com.facebook.common.appchoreographer.AppChoreographer$Priority;
import com.facebook.common.appchoreographer.AppChoreographer$ThreadType;
import com.facebook.common.appchoreographer.AppChoreographerController;
import com.facebook.common.appchoreographer.DefaultAppChoreographer;
import com.facebook.common.build.BuildConstants;
import com.facebook.common.cpu.ProcessorInfoUtil;
import com.facebook.common.cpu.ProcessorInfoUtilMethodAutoProvider;
import com.facebook.common.executors.ConstrainedListeningExecutorServiceFactory;
import com.facebook.common.executors.CrashingFutureCallback;
import com.facebook.common.executors.Executor_SameThreadExecutorMethodAutoProvider;
import com.facebook.common.init.AppInitLock;
import com.facebook.common.init.C0063xb7b69945;
import com.facebook.common.init.C0064x7ff1b807;
import com.facebook.common.init.C0065xad6d4fd4;
import com.facebook.common.init.INeedInit;
import com.facebook.common.init.INeedInitIterator;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.util.StringUtil;
import com.facebook.debug.log.BLog;
import com.facebook.debug.tracer.Tracer;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.gk.store.GatekeeperStoreManager;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.api.LoomLogger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.FbSharedPreferencesWriteLatch;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.tools.dextr.runtime.detour.LoomLoggerDetour;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.Uninterruptibles;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;

/* compiled from: weight */
public class FbAppInitializerInternal {
    private static final Class<?> f820a = FbAppInitializerInternal.class;
    private Lazy<FbAppInitializer> f821b;
    private final DefaultAppChoreographer f822c;
    public final DefaultAppChoreographer f823d;
    private final Lazy<AppInitLock> f824e;
    private final Executor f825f;
    private final CrashingFutureCallback f826g;
    private final FbSharedPreferences f827h;
    private final Lazy<Set<INeedInit>> f828i;
    private final Lazy<INeedInitIterator> f829j;
    private Lazy<Set<INeedInit>> f830k;
    private final Lazy<Set<INeedInit>> f831l;
    private final Lazy<QuickPerformanceLogger> f832m;
    private final MonotonicClock f833n;
    public final ConstrainedListeningExecutorServiceFactory f834o;
    private final ProcessorInfoUtil f835p;
    public final GatekeeperStoreImpl f836q;
    private final Lazy<FbSharedPreferencesWriteLatch> f837r;
    private final Comparator<Entry<String, String>> f838s = new TimingComparator();
    @GuardedBy("mHighPriTimings")
    private final Map<String, String> f839t = Maps.m838c();
    private final ReentrantLock f840u = new ReentrantLock();
    @GuardedBy("mFbSharedPrefsLock")
    private volatile boolean f841v = false;
    private boolean f842w;
    private final Lazy<GatekeeperStore> f843x;

    /* compiled from: weight */
    class TimingComparator implements Comparator<Entry<String, String>> {
        public int compare(Object obj, Object obj2) {
            return Integer.parseInt((String) ((Entry) obj).getValue()) - Integer.parseInt((String) ((Entry) obj2).getValue());
        }
    }

    /* compiled from: weight */
    class C00852 implements Runnable {
        final /* synthetic */ FbAppInitializerInternal f1269a;

        C00852(FbAppInitializerInternal fbAppInitializerInternal) {
            this.f1269a = fbAppInitializerInternal;
        }

        public void run() {
            FbAppInitializerInternal.m1618j(this.f1269a);
        }
    }

    /* compiled from: weight */
    class C01143 implements Runnable {
        final /* synthetic */ FbAppInitializerInternal f1713a;

        C01143(FbAppInitializerInternal fbAppInitializerInternal) {
            this.f1713a = fbAppInitializerInternal;
        }

        public void run() {
            this.f1713a.m1620a(new GatekeeperStoreInitializer(this.f1713a.f836q), "INeedInit.HighPriorityInitOnBackgroundThread");
        }
    }

    /* compiled from: weight */
    final class FbSharedPreferenceInitializer implements INeedInit {
        final /* synthetic */ FbAppInitializerInternal f1778a;
        public final FbSharedPreferences f1779b;

        /* compiled from: weight */
        class C01161 implements Runnable {
            final /* synthetic */ FbSharedPreferenceInitializer f1780a;

            C01161(FbSharedPreferenceInitializer fbSharedPreferenceInitializer) {
                this.f1780a = fbSharedPreferenceInitializer;
            }

            public void run() {
                this.f1780a.f1779b.mo288b();
            }
        }

        public FbSharedPreferenceInitializer(FbAppInitializerInternal fbAppInitializerInternal, FbSharedPreferences fbSharedPreferences) {
            this.f1778a = fbAppInitializerInternal;
            this.f1779b = fbSharedPreferences;
        }

        public final void init() {
            this.f1778a.f834o.m2130b("SharedPrefInitTask", 2, 256, 0).mo269a(new C01161(this));
        }
    }

    /* compiled from: weight */
    final class GatekeeperStoreInitializer implements INeedInit {
        private final GatekeeperStoreImpl f1781a;

        public GatekeeperStoreInitializer(GatekeeperStoreImpl gatekeeperStoreImpl) {
            this.f1781a = gatekeeperStoreImpl;
        }

        public final void init() {
            this.f1781a.m2190b();
        }
    }

    public static FbAppInitializerInternal m1607b(InjectorLike injectorLike) {
        return new FbAppInitializerInternal(DefaultAppChoreographer.m1621a(injectorLike), DefaultAppChoreographer.m1621a(injectorLike), Executor_SameThreadExecutorMethodAutoProvider.m1812a(injectorLike), CrashingFutureCallback.m1825a(injectorLike), FbSharedPreferencesImpl.m1826a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 559), C0063xb7b69945.m2124a(injectorLike), IdBasedLazy.m1808a(injectorLike, 561), C0064x7ff1b807.m2125a(injectorLike), C0065xad6d4fd4.m2126a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 3229), AwakeTimeSinceBootClockMethodAutoProvider.m1697a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 562), ConstrainedListeningExecutorServiceFactory.m2127a(injectorLike), ProcessorInfoUtilMethodAutoProvider.m1898a(injectorLike), GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 2128), IdBasedSingletonScopeProvider.m1810b(injectorLike, 3080));
    }

    @Inject
    public FbAppInitializerInternal(AppChoreographer appChoreographer, AppChoreographerController appChoreographerController, Executor executor, CrashingFutureCallback crashingFutureCallback, FbSharedPreferences fbSharedPreferences, Lazy<AppInitLock> lazy, Lazy<Set<INeedInit>> lazy2, Lazy<INeedInitIterator> lazy3, Lazy<Set<INeedInit>> lazy4, Lazy<Set<INeedInit>> lazy5, Lazy<QuickPerformanceLogger> lazy6, MonotonicClock monotonicClock, Lazy<FbAppInitializer> lazy7, ConstrainedListeningExecutorServiceFactory constrainedListeningExecutorServiceFactory, ProcessorInfoUtil processorInfoUtil, GatekeeperStoreManager gatekeeperStoreManager, Lazy<GatekeeperStore> lazy8, Lazy<FbSharedPreferencesWriteLatch> lazy9) {
        this.f822c = appChoreographer;
        this.f823d = appChoreographerController;
        this.f825f = executor;
        this.f826g = crashingFutureCallback;
        this.f827h = fbSharedPreferences;
        this.f824e = lazy;
        this.f828i = lazy2;
        this.f829j = lazy3;
        this.f830k = lazy4;
        this.f831l = lazy5;
        this.f832m = lazy6;
        this.f833n = monotonicClock;
        this.f821b = lazy7;
        this.f834o = constrainedListeningExecutorServiceFactory;
        this.f835p = processorInfoUtil;
        this.f836q = gatekeeperStoreManager;
        this.f843x = lazy8;
        this.f837r = lazy9;
    }

    public final ListenableFuture<?> m1619a() {
        m1608b();
        return m1599a(false);
    }

    private void m1608b() {
        TracerDetour.a("FbAppInitializer-ModuleInit", 674242506);
        try {
            Iterator it = ((Set) this.f831l.get()).iterator();
            while (it.hasNext()) {
                INeedInit iNeedInit = (INeedInit) it.next();
                TracerDetour.a("#%s", iNeedInit.getClass().getCanonicalName(), 237167888);
                LoomLogger.a(LoomLoggerDetour.a(787358818), "canonical name", iNeedInit.getClass().getCanonicalName());
                try {
                    iNeedInit.init();
                    TracerDetour.a(iNeedInit);
                } finally {
                    int i = -1750679499;
                    TracerDetour.a(-1750679499);
                }
            }
        } finally {
            TracerDetour.a(1110402081);
        }
    }

    private ListenableFuture<?> m1599a(boolean z) {
        Preconditions.checkState(!this.f842w, "FbAppInitializer should only be run once.");
        this.f842w = true;
        final ExecutorService c = m1611c();
        ListenableFuture a = this.f822c.m1635a("FbAppInitializer-HiPri", new Runnable(this) {
            final /* synthetic */ FbAppInitializerInternal f1248b;

            public void run() {
                FbAppInitializerInternal.m1600a(this.f1248b, c);
                this.f1248b.f823d.m1643e();
            }
        }, AppChoreographer$Priority.STARTUP_INITIALIZATION, c);
        Futures.m2458a(a, this.f826g, this.f825f);
        if (!z) {
            Futures.m2458a(this.f822c.m1634a("FbAppInitializer-lowPriUiThread", new C00852(this), AppChoreographer$Priority.APPLICATION_LOADED_HIGH_PRIORITY, AppChoreographer$ThreadType.UI), this.f826g, this.f825f);
            m1604a(((Set) this.f830k.get()).iterator());
            this.f830k = null;
        }
        this.f823d.m1642d();
        return a;
    }

    private ListeningExecutorService m1611c() {
        return this.f834o.m2130b("HighPriINeedInitTasks", m1617i() ? 3 : 2, 256, 0);
    }

    public static void m1600a(FbAppInitializerInternal fbAppInitializerInternal, ListeningExecutorService listeningExecutorService) {
        long now = fbAppInitializerInternal.f833n.now();
        TracerDetour.a("FbAppInitializer-HiPri", 1606865405);
        try {
            String str = "initializeGatekeeperStore";
            TracerDetour.a(str, -511272236);
            try {
                fbAppInitializerInternal.m1612c(listeningExecutorService);
                TracerDetour.a(str);
                str = "initializeSharedPrefs";
                TracerDetour.a(str, -370640697);
                try {
                    fbAppInitializerInternal.m1614f();
                    TracerDetour.a(str);
                    fbAppInitializerInternal.m1610b(listeningExecutorService);
                    long now2 = fbAppInitializerInternal.f833n.now() - now;
                    QuickPerformanceLogger quickPerformanceLogger = (QuickPerformanceLogger) fbAppInitializerInternal.f832m.get();
                    quickPerformanceLogger.mo463b(3997697, 5);
                    quickPerformanceLogger.mo453a(3997697, (short) 2, (int) now2);
                    fbAppInitializerInternal.m1602a(quickPerformanceLogger);
                    Tracer.m881a(f820a);
                    fbAppInitializerInternal.m1603a(f820a);
                    fbAppInitializerInternal.m1616h();
                } finally {
                    TracerDetour.a(1702611828);
                }
            } finally {
                TracerDetour.a(684416739);
            }
        } finally {
            Long.valueOf(TracerDetour.b(1786377667));
        }
    }

    private void m1602a(QuickPerformanceLogger quickPerformanceLogger) {
        synchronized (this.f839t) {
            for (Entry entry : this.f839t.entrySet()) {
                quickPerformanceLogger.mo467b(3997697, (String) entry.getKey(), (String) entry.getValue());
            }
        }
    }

    private void m1610b(ListeningExecutorService listeningExecutorService) {
        Set e = m1613e();
        if (m1617i()) {
            m1606a(e, listeningExecutorService);
        } else {
            m1605a(e);
        }
    }

    private Set<INeedInit> m1613e() {
        TracerDetour.a("HiPri-Setup", -12670865);
        try {
            Set<INeedInit> set = (Set) this.f828i.get();
            return set;
        } finally {
            TracerDetour.a(1362763563);
        }
    }

    private void m1614f() {
        this.f840u.lock();
        try {
            if (!this.f841v) {
                m1615g();
            }
            this.f841v = true;
            this.f840u.unlock();
        } catch (Throwable th) {
            this.f841v = true;
            this.f840u.unlock();
        }
    }

    private void m1615g() {
        TracerDetour.a("HiPri-init-call-shared-prefs", -1161295212);
        try {
            m1620a(new FbSharedPreferenceInitializer(this, this.f827h), "INeedInit.HighPriorityInitOnBackgroundThread");
        } finally {
            TracerDetour.a(-1172724321);
        }
    }

    private void m1612c(ListeningExecutorService listeningExecutorService) {
        Futures.m2458a(listeningExecutorService.mo269a(new C01143(this)), this.f826g, this.f825f);
    }

    private void m1606a(Set<INeedInit> set, ListeningExecutorService listeningExecutorService) {
        TracerDetour.a("HiPri-execute-tasks-parallel", -2112304394);
        try {
            List<Future> arrayList = new ArrayList(set.size());
            final Iterator it = set.iterator();
            for (int i = 0; i < set.size(); i++) {
                arrayList.add(listeningExecutorService.mo269a(new Runnable(this) {
                    final /* synthetic */ FbAppInitializerInternal f1783b;

                    public void run() {
                        this.f1783b.m1620a((INeedInit) it.next(), "INeedInit.HighPriorityInitOnBackgroundThread");
                    }
                }));
            }
            for (Future future : arrayList) {
                if (!future.isDone()) {
                    try {
                        Uninterruptibles.m1584a(future);
                    } catch (Throwable e) {
                        Throwable rootCause = Throwables.getRootCause(e);
                        if (rootCause != null) {
                            Throwables.propagateIfPossible(rootCause);
                        }
                        BLog.b(f820a, e, "HighPri init failed because of an exception", new Object[0]);
                    }
                }
            }
        } finally {
            TracerDetour.a(1230479971);
        }
    }

    private void m1605a(Set<INeedInit> set) {
        TracerDetour.a("HiPri-execute-tasks-synch", -1003947006);
        try {
            for (INeedInit a : set) {
                m1620a(a, "INeedInit.HighPriorityInitOnBackgroundThread");
            }
        } finally {
            TracerDetour.a(1111550335);
        }
    }

    private void m1616h() {
        TracerDetour.a("HiPri-Completed-Setup", -2107714174);
        try {
            ((AppInitLock) this.f824e.get()).m2275a();
        } finally {
            TracerDetour.a(-1385956923);
        }
    }

    private boolean m1617i() {
        int b = this.f835p.m1903b();
        if (b == -1 || b <= 1) {
            return false;
        }
        return true;
    }

    public static void m1618j(FbAppInitializerInternal fbAppInitializerInternal) {
        if (((GatekeeperStoreImpl) fbAppInitializerInternal.f843x.get()).m2189a(890, false)) {
            ((FbSharedPreferencesWriteLatch) fbAppInitializerInternal.f837r.get()).init();
            return;
        }
        MessageQueue myQueue = Looper.myQueue();
        Preconditions.checkNotNull(myQueue);
        TracerDetour.a("LowPriUIThread-Setup", 2110238743);
        try {
            INeedInitIterator iNeedInitIterator = (INeedInitIterator) fbAppInitializerInternal.f829j.get();
            myQueue.addIdleHandler(new 5(fbAppInitializerInternal, iNeedInitIterator));
        } finally {
            myQueue = 2089823690;
            TracerDetour.a(2089823690);
        }
    }

    public static void m1601a(FbAppInitializerInternal fbAppInitializerInternal, Throwable th) {
        HandlerDetour.b(new Handler(Looper.getMainLooper()), new 6(fbAppInitializerInternal, th), -2135807134);
    }

    private void m1604a(final Iterator<INeedInit> it) {
        Futures.m2458a(this.f822c.m1634a("FbAppInitializer-LowPriWorkerThread:", new Runnable(this) {
            final /* synthetic */ FbAppInitializerInternal f1271b;

            public void run() {
                FbAppInitializerInternal.m1609b(this.f1271b, it);
            }
        }, AppChoreographer$Priority.APPLICATION_LOADED_HIGH_PRIORITY, AppChoreographer$ThreadType.BACKGROUND), this.f826g, this.f825f);
    }

    public static void m1609b(FbAppInitializerInternal fbAppInitializerInternal, Iterator it) {
        if (((GatekeeperStoreImpl) fbAppInitializerInternal.f843x.get()).m2189a(890, false)) {
            ((FbSharedPreferencesWriteLatch) fbAppInitializerInternal.f837r.get()).init();
        } else {
            long now = fbAppInitializerInternal.f833n.now();
            while (it.hasNext()) {
                INeedInit iNeedInit = (INeedInit) it.next();
                TracerDetour.a(iNeedInit.getClass().getName(), -159225128);
                LoomLogger.a(LoomLoggerDetour.a(1705011359), "INeedInit", iNeedInit.getClass().getName());
                try {
                    iNeedInit.init();
                    if (fbAppInitializerInternal.f833n.now() - now > 5) {
                        fbAppInitializerInternal.m1604a(it);
                        return;
                    }
                } finally {
                    TracerDetour.a(-1918044075);
                }
            }
        }
        ((FbAppInitializer) fbAppInitializerInternal.f821b.get()).m1598b();
        fbAppInitializerInternal.f821b = null;
    }

    public final void m1620a(INeedInit iNeedInit, String str) {
        String simpleName = iNeedInit.getClass().getSimpleName();
        if (StringUtil.m3589a((CharSequence) simpleName)) {
            simpleName = iNeedInit.getClass().getName();
        }
        long now = this.f833n.now();
        TracerDetour.a("#%s", simpleName, -1981402236);
        LoomLogger.a(LoomLoggerDetour.a(124789188), "INeedInit", simpleName);
        try {
            iNeedInit.init();
            synchronized (this.f839t) {
                this.f839t.put(str + "." + simpleName, Long.toString(this.f833n.now() - now));
            }
        } finally {
            TracerDetour.a(2128248394);
        }
    }

    private void m1603a(Class<?> cls) {
        if (BuildConstants.e()) {
            List<Entry> a;
            synchronized (this.f839t) {
                a = Lists.m1298a(this.f839t.entrySet());
            }
            Collections.sort(a, this.f838s);
            int i = 0;
            for (Entry entry : a) {
                entry.getValue();
                entry.getKey();
                i = Integer.parseInt((String) entry.getValue()) + i;
            }
            Integer.valueOf(i);
        }
    }
}
