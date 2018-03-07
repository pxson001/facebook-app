package com.facebook.analytics;

import com.facebook.analytics.logger.AnalyticsConfig;
import com.facebook.analytics.logger.IAnalyticsPeriodicEventReporter;
import com.facebook.analytics.prefs.AnalyticsPrefKeys;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.init.INeedInit;
import com.facebook.crudolib.prefs.LightSharedPreferences$Editor;
import com.facebook.crudolib.prefs.LightSharedPreferencesFactory;
import com.facebook.crudolib.prefs.LightSharedPreferencesImpl;
import com.facebook.debug.log.BLog;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.orca.FbAnalyticsConfig;
import com.facebook.prefs.light.LightSharedPreferencesFactoryMethodAutoProvider;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.Editor;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.google.common.annotations.VisibleForTesting;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: t_sm_rp */
public class ClientPeriodicEventReporterManager implements INeedInit {
    private static volatile ClientPeriodicEventReporterManager f3449j;
    private final FbSharedPreferences f3450a;
    private final LightSharedPreferencesFactory f3451b;
    private final AbstractFbErrorReporter f3452c;
    private final BaseAnalyticsConfig f3453d;
    private final Provider<String> f3454e;
    private final ClientPeriodicEventReporterHandler f3455f;
    private long f3456g;
    private volatile boolean f3457h = false;
    private LightSharedPreferencesImpl f3458i;

    public static com.facebook.analytics.ClientPeriodicEventReporterManager m5662a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f3449j;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.analytics.ClientPeriodicEventReporterManager.class;
        monitor-enter(r1);
        r0 = f3449j;	 Catch:{ all -> 0x003a }
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
        r0 = m5664b(r0);	 Catch:{ all -> 0x0035 }
        f3449j = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f3449j;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.analytics.ClientPeriodicEventReporterManager.a(com.facebook.inject.InjectorLike):com.facebook.analytics.ClientPeriodicEventReporterManager");
    }

    private static ClientPeriodicEventReporterManager m5664b(InjectorLike injectorLike) {
        return new ClientPeriodicEventReporterManager(FbSharedPreferencesImpl.m1826a(injectorLike), LightSharedPreferencesFactoryMethodAutoProvider.m2543a(injectorLike), FbErrorReporterImpl.m2317a(injectorLike), FbAnalyticsConfig.m3559a(injectorLike), IdBasedProvider.m1811a(injectorLike, 4442), ClientPeriodicEventReporterHandlerImpl.m5676a(injectorLike));
    }

    @Inject
    public ClientPeriodicEventReporterManager(FbSharedPreferences fbSharedPreferences, LightSharedPreferencesFactory lightSharedPreferencesFactory, FbErrorReporter fbErrorReporter, AnalyticsConfig analyticsConfig, Provider<String> provider, ClientPeriodicEventReporterHandler clientPeriodicEventReporterHandler) {
        this.f3450a = fbSharedPreferences;
        this.f3451b = lightSharedPreferencesFactory;
        this.f3452c = fbErrorReporter;
        this.f3453d = analyticsConfig;
        this.f3454e = provider;
        this.f3455f = clientPeriodicEventReporterHandler;
        this.f3456g = -1;
    }

    @Nullable
    public final List<HoneyAnalyticsEvent> m5672a(long j) {
        if (this.f3457h) {
            return m5663a(j, (String) this.f3454e.get());
        }
        return Collections.EMPTY_LIST;
    }

    public final void m5673a() {
        m5665b(-1);
    }

    final boolean m5674a(String str, boolean z) {
        return this.f3453d.m3564a(str, z);
    }

    @Nullable
    private List<HoneyAnalyticsEvent> m5663a(long j, String str) {
        if (m5668e() > j) {
            return null;
        }
        EventCollectionStatus eventCollectionStatus = new EventCollectionStatus(this);
        try {
            this.f3455f.mo754a(this, eventCollectionStatus, str, j);
            List<HoneyAnalyticsEvent> a = EventCollectionStatus.a(eventCollectionStatus);
            return a;
        } finally {
            EventCollectionStatus.b(eventCollectionStatus);
            m5665b(EventCollectionStatus.c(eventCollectionStatus));
        }
    }

    final long m5669a(String str, long j, long j2, boolean z, String str2) {
        long a = m5675b().m2642a(str, -1);
        return a == -1 ? j2 : a + m5670a(str2, j, z);
    }

    private void m5666c() {
        if (!this.f3450a.mo284a()) {
            BLog.a(getClass(), "Unexpected race with the shared preferences store!");
            while (true) {
                try {
                    this.f3450a.mo292c();
                    break;
                } catch (InterruptedException e) {
                }
            }
        }
    }

    final long m5670a(String str, long j, boolean z) {
        if (j < (z ? 3600000 : 900000)) {
            BLog.a(getClass(), "Requested time interval of %d ms should be increased to at least %d ms for %s", new Object[]{Long.valueOf(j), Long.valueOf(z ? 3600000 : 900000), str});
        }
        return j;
    }

    @Nullable
    final HoneyAnalyticsEvent m5671a(IAnalyticsPeriodicEventReporter iAnalyticsPeriodicEventReporter, long j, String str) {
        try {
            return iAnalyticsPeriodicEventReporter.a(j, str);
        } catch (Throwable th) {
            this.f3452c.m2343a("client_side_periodic_reporter_throw", iAnalyticsPeriodicEventReporter.getClass().toString(), th);
            return null;
        }
    }

    public void init() {
        this.f3457h = true;
    }

    @VisibleForTesting
    final synchronized LightSharedPreferencesImpl m5675b() {
        if (this.f3458i == null) {
            this.f3458i = this.f3451b.m2550a("analytics_periodic_events");
            if (!this.f3458i.m2647a("client_periodic_lightprefs_migration", false)) {
                m5666c();
                m5667d();
            }
        }
        return this.f3458i;
    }

    private void m5667d() {
        Set<PrefKey> d = this.f3450a.mo294d(AnalyticsPrefKeys.f4988j);
        LightSharedPreferences$Editor b = this.f3458i.m2648b();
        Editor edit = this.f3450a.edit();
        for (PrefKey prefKey : d) {
            b.mo3282a(prefKey.m2014b(AnalyticsPrefKeys.f4988j), this.f3450a.mo277a(prefKey, 0));
            edit.mo1271a(prefKey);
        }
        b.mo3285a("client_periodic_lightprefs_migration", true).mo3286b();
        edit.commit();
    }

    private synchronized void m5665b(long j) {
        this.f3456g = j;
    }

    private synchronized long m5668e() {
        return this.f3456g;
    }
}
