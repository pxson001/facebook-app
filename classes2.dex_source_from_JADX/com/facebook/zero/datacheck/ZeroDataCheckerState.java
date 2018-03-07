package com.facebook.zero.datacheck;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.executors.C0055x2995691a;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.config.application.FbAppType;
import com.facebook.config.application.Product;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.Futures;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: slideshow/entry_point */
public class ZeroDataCheckerState {
    public static PrefKey f4656a = ((PrefKey) SharedPrefKeys.f991e.m2011a("user_data_state"));
    public static PrefKey f4657b = ((PrefKey) SharedPrefKeys.f991e.m2011a("last_state_change_time"));
    public static final Class<?> f4658c = ZeroDataCheckerState.class;
    private static volatile ZeroDataCheckerState f4659x;
    private final int f4660d = 4;
    private final int f4661e = 3;
    private final int f4662f = 8;
    private final int f4663g = 4;
    private long f4664h = 0;
    private long f4665i = 0;
    private long f4666j = 0;
    private long f4667k = 0;
    private long f4668l = 0;
    private long f4669m = 0;
    private boolean f4670n = false;
    public final Set<Listener> f4671o = Sets.m1325b();
    private final Clock f4672p;
    public final ExecutorService f4673q;
    private Provider<Boolean> f4674r;
    private ZeroDataCheckerLogger f4675s;
    private FbSharedPreferences f4676t;
    private Lazy<FbErrorReporter> f4677u;
    private final FbAppType f4678v;
    public Lazy<ZeroDataCheckerRequestMaker> f4679w;

    /* compiled from: slideshow/entry_point */
    public interface Listener {
        void mo1249a(DataState dataState, DataState dataState2);
    }

    public static com.facebook.zero.datacheck.ZeroDataCheckerState m8439a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f4659x;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.zero.datacheck.ZeroDataCheckerState.class;
        monitor-enter(r1);
        r0 = f4659x;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m8444b(r0);	 Catch:{ all -> 0x0035 }
        f4659x = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4659x;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.zero.datacheck.ZeroDataCheckerState.a(com.facebook.inject.InjectorLike):com.facebook.zero.datacheck.ZeroDataCheckerState");
    }

    private static ZeroDataCheckerState m8444b(InjectorLike injectorLike) {
        return new ZeroDataCheckerState(C0055x2995691a.m1881a(injectorLike), IdBasedProvider.m1811a(injectorLike, 4392), new ZeroDataCheckerLogger(AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike), IdBasedProvider.m1811a(injectorLike, 3759), FbSharedPreferencesImpl.m1826a(injectorLike)), FbSharedPreferencesImpl.m1826a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 494), (FbAppType) injectorLike.getInstance(FbAppType.class), IdBasedSingletonScopeProvider.m1810b(injectorLike, 11805), SystemClockMethodAutoProvider.m1498a(injectorLike));
    }

    @Inject
    public ZeroDataCheckerState(ExecutorService executorService, Provider<Boolean> provider, ZeroDataCheckerLogger zeroDataCheckerLogger, FbSharedPreferences fbSharedPreferences, Lazy<FbErrorReporter> lazy, FbAppType fbAppType, Lazy<ZeroDataCheckerRequestMaker> lazy2, Clock clock) {
        this.f4673q = executorService;
        this.f4674r = provider;
        this.f4675s = zeroDataCheckerLogger;
        this.f4676t = fbSharedPreferences;
        this.f4677u = lazy;
        this.f4678v = fbAppType;
        this.f4679w = lazy2;
        this.f4672p = clock;
    }

    public final void m8461a(@Nullable Listener listener) {
        if (listener != null) {
            this.f4671o.add(listener);
        }
    }

    public final DataState m8459a() {
        if (this.f4676t.mo284a()) {
            return DataState.values()[this.f4676t.mo276a(f4656a, 0)];
        }
        return DataState.NOT_CONNECTED;
    }

    private void m8440a(DataState dataState) {
        if (this.f4676t.mo284a()) {
            this.f4676t.edit().mo1274a(f4656a, dataState.ordinal()).commit();
        }
    }

    private long m8446d() {
        if (!this.f4676t.mo284a()) {
            return 0;
        }
        long a = this.f4676t.mo277a(f4657b, 0);
        long a2 = this.f4672p.mo211a();
        this.f4676t.edit().mo1275a(f4657b, a2).commit();
        if (a > 0) {
            return a2 - a;
        }
        return 0;
    }

    private void m8441a(DataState dataState, int i, String str) {
        if (m8459a() != dataState && ((Boolean) this.f4674r.get()).booleanValue() && this.f4678v.h() == Product.FB4A) {
            DataState a = m8459a();
            this.f4675s.m8538a(a, dataState, i, str, this.f4664h, this.f4665i, m8446d());
            m8440a(dataState);
            for (Listener a2 : this.f4671o) {
                a2.mo1249a(a, dataState);
            }
        }
    }

    final synchronized void m8460a(int i, String str) {
        if (!this.f4670n) {
            if (m8443a(i)) {
                Integer.valueOf(i);
                this.f4665i = 0;
            } else {
                Integer.valueOf(i);
                this.f4665i++;
                if (m8448e()) {
                    m8440a(DataState.NOT_CONNECTED);
                }
            }
        }
    }

    final synchronized void m8463b(int i, String str) {
        if (!this.f4670n) {
            if (m8443a(i)) {
                m8441a(DataState.CONNECTED, i, str);
                this.f4664h = 0;
            } else {
                this.f4664h++;
                if (this.f4664h > 0 && this.f4664h % 4 == 0 && m8459a() != DataState.FREE_TIER_ONLY) {
                    m8450f();
                } else if (m8448e()) {
                    m8440a(DataState.NOT_CONNECTED);
                }
            }
        }
    }

    private boolean m8448e() {
        return this.f4665i >= 3 && this.f4664h >= 4;
    }

    final synchronized void m8462b() {
        ((AbstractFbErrorReporter) this.f4677u.get()).m2340a(f4658c.getSimpleName(), "NullUriResponse");
        this.f4664h++;
    }

    private static boolean m8443a(int i) {
        return (i >= 200 && i <= 305) || i >= 500;
    }

    private void m8450f() {
        m8442a("confirm_free_tier_initial_check");
        m8457l(this);
        this.f4670n = true;
        f4658c.getSimpleName();
        Futures.m2458a(((ZeroDataCheckerRequestMaker) this.f4679w.get()).b(), new 1(this), this.f4673q);
    }

    private void m8453h() {
        Futures.m2458a(((ZeroDataCheckerRequestMaker) this.f4679w.get()).b(), new 3(this), this.f4673q);
    }

    private void m8454i() {
        Futures.m2458a(((ZeroDataCheckerRequestMaker) this.f4679w.get()).a(), new 4(this), this.f4673q);
    }

    public static synchronized void m8455j(ZeroDataCheckerState zeroDataCheckerState) {
        int i = 0;
        synchronized (zeroDataCheckerState) {
            zeroDataCheckerState.m8442a("confirm_free_tier");
            zeroDataCheckerState.m8458m();
            for (int i2 = 0; i2 < 4; i2++) {
                zeroDataCheckerState.m8453h();
            }
            while (i < 8) {
                zeroDataCheckerState.m8454i();
                i++;
            }
        }
    }

    public static synchronized void m8456k(ZeroDataCheckerState zeroDataCheckerState) {
        synchronized (zeroDataCheckerState) {
            if (zeroDataCheckerState.f4666j < 1 || zeroDataCheckerState.f4669m < 8) {
                if (((zeroDataCheckerState.f4666j + zeroDataCheckerState.f4667k) + zeroDataCheckerState.f4669m) + zeroDataCheckerState.f4668l >= 12) {
                    zeroDataCheckerState.m8442a("confirm_free_tier_failure");
                    m8457l(zeroDataCheckerState);
                }
            } else if (zeroDataCheckerState.m8459a() != DataState.FREE_TIER_ONLY) {
                if (zeroDataCheckerState.f4666j < 1 || zeroDataCheckerState.f4669m < 8) {
                    zeroDataCheckerState.m8442a("confirm_free_tier_failure");
                } else {
                    zeroDataCheckerState.m8442a("confirm_free_tier_success");
                    zeroDataCheckerState.m8441a(DataState.FREE_TIER_ONLY, 0, null);
                }
                m8457l(zeroDataCheckerState);
            }
        }
    }

    private void m8442a(String str) {
        this.f4675s.m8539a(str, this.f4667k, this.f4666j, this.f4669m, this.f4668l);
    }

    public static synchronized void m8457l(ZeroDataCheckerState zeroDataCheckerState) {
        synchronized (zeroDataCheckerState) {
            zeroDataCheckerState.f4664h = 0;
            zeroDataCheckerState.f4665i = 0;
            zeroDataCheckerState.f4670n = false;
            zeroDataCheckerState.m8458m();
        }
    }

    private synchronized void m8458m() {
        this.f4667k = 0;
        this.f4666j = 0;
        this.f4669m = 0;
        this.f4668l = 0;
    }
}
