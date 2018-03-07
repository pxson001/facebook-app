package com.facebook.analytics.service;

import com.facebook.analytics.AnalyticsEvent;
import com.facebook.analytics.AnalyticsRunnable;
import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.db.AnalyticsDbProperties;
import com.facebook.analytics.db.AnalyticsPropertyUtil;
import com.facebook.analytics.db.AnalyticsSessionManager;
import com.facebook.analytics.db.AnalyticsStorage;
import com.facebook.common.diagnostics.VMMemoryInfo;
import com.facebook.common.diagnostics.VMMemoryInfoMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.errorreporting.SoftErrorBuilder;
import com.facebook.common.executors.ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.NamedRunnable;
import com.facebook.common.idleexecutor.IdleExecutor_DefaultIdleExecutorMethodAutoProvider;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProviderLazy;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Lists;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: thread_key=? */
public class AnalyticsEventsDataStore {
    public static final Class<?> f1147b = AnalyticsEventsDataStore.class;
    private static volatile AnalyticsEventsDataStore f1148p;
    @VisibleForTesting
    AnalyticsSessionManager f1149a;
    private final Clock f1150c;
    public final AnalyticsPropertyUtil f1151d;
    private final AnalyticsStorage f1152e;
    private final Executor f1153f;
    private final LinkedBlockingQueue<AnalyticsEvent> f1154g;
    private final Object f1155h = new Object();
    private final AnalyticsRunnable f1156i;
    private final Lazy<Set<AnalyticsEventsDataStoreListener>> f1157j;
    private final AbstractFbErrorReporter f1158k;
    private int f1159l = 0;
    public long f1160m = -1;
    private long f1161n = -1;
    @GuardedBy("mIdleSync")
    private volatile boolean f1162o = true;

    /* compiled from: thread_key=? */
    final class StoreEventsRunnable extends NamedRunnable {
        final /* synthetic */ AnalyticsEventsDataStore f1188c;

        public StoreEventsRunnable(AnalyticsEventsDataStore analyticsEventsDataStore) {
            this.f1188c = analyticsEventsDataStore;
            super(AnalyticsEventsDataStore.f1147b, "StoreEvents");
        }

        public final void run() {
            AnalyticsEventsDataStore.m1414b(this.f1188c);
        }
    }

    public static com.facebook.analytics.service.AnalyticsEventsDataStore m1410a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1148p;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.analytics.service.AnalyticsEventsDataStore.class;
        monitor-enter(r1);
        r0 = f1148p;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m1412b(r0);	 Catch:{ all -> 0x0035 }
        f1148p = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1148p;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.analytics.service.AnalyticsEventsDataStore.a(com.facebook.inject.InjectorLike):com.facebook.analytics.service.AnalyticsEventsDataStore");
    }

    private static AnalyticsEventsDataStore m1412b(InjectorLike injectorLike) {
        return new AnalyticsEventsDataStore(AnalyticsPropertyUtil.m1290b(injectorLike), AnalyticsStorage.m1421a(injectorLike), AnalyticsSessionManager.m1434a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), (Executor) IdleExecutor_DefaultIdleExecutorMethodAutoProvider.a(injectorLike), (ExecutorService) ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider.a(injectorLike), VMMemoryInfoMethodAutoProvider.a(injectorLike), ProviderLazy.a(new C0072x552d0095(injectorLike.getScopeAwareInjector()), injectorLike.getScopeAwareInjector()), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), IdBasedProvider.a(injectorLike, 3882));
    }

    @Inject
    public AnalyticsEventsDataStore(AnalyticsPropertyUtil analyticsPropertyUtil, AnalyticsStorage analyticsStorage, AnalyticsSessionManager analyticsSessionManager, Clock clock, Executor executor, ExecutorService executorService, VMMemoryInfo vMMemoryInfo, Lazy<Set<AnalyticsEventsDataStoreListener>> lazy, FbErrorReporter fbErrorReporter, Provider<Boolean> provider) {
        this.f1150c = clock;
        this.f1151d = analyticsPropertyUtil;
        this.f1152e = analyticsStorage;
        this.f1149a = analyticsSessionManager;
        this.f1153f = executor;
        this.f1157j = lazy;
        this.f1158k = fbErrorReporter;
        this.f1154g = new LinkedBlockingQueue();
        this.f1156i = new AnalyticsRunnable(vMMemoryInfo, provider, executorService, new StoreEventsRunnable(this));
    }

    public final void m1419a(List<? extends AnalyticsEvent> list) {
        synchronized (this.f1155h) {
            this.f1154g.addAll(list);
            if (this.f1162o) {
                this.f1162o = false;
                ExecutorDetour.a(this.f1153f, this.f1156i, -583013423);
            }
            this.f1156i.m810a(this.f1154g.size());
        }
    }

    public static void m1414b(AnalyticsEventsDataStore analyticsEventsDataStore) {
        analyticsEventsDataStore.m1417d();
        boolean z;
        do {
            List a = Lists.a();
            while (!analyticsEventsDataStore.f1154g.isEmpty()) {
                HoneyAnalyticsEvent honeyAnalyticsEvent = (HoneyAnalyticsEvent) analyticsEventsDataStore.f1154g.remove();
                analyticsEventsDataStore.f1149a.m1442a(honeyAnalyticsEvent);
                analyticsEventsDataStore.m1411a(honeyAnalyticsEvent);
                analyticsEventsDataStore.f1159l++;
                a.add(honeyAnalyticsEvent);
            }
            if (!a.isEmpty()) {
                analyticsEventsDataStore.f1152e.m1430a(a);
                analyticsEventsDataStore.f1161n = analyticsEventsDataStore.f1150c.a();
                analyticsEventsDataStore.m1415b(a);
            }
            z = false;
            synchronized (analyticsEventsDataStore.f1155h) {
                if (analyticsEventsDataStore.f1154g.isEmpty()) {
                    z = true;
                    analyticsEventsDataStore.f1162o = true;
                }
            }
        } while (!z);
        analyticsEventsDataStore.m1416c();
    }

    private void m1411a(HoneyAnalyticsEvent honeyAnalyticsEvent) {
        honeyAnalyticsEvent.h = this.f1149a.m1441a();
    }

    private void m1415b(List<AnalyticsEvent> list) {
        for (AnalyticsEventUploader a : (Set) this.f1157j.get()) {
            a.m1285a((List) list);
        }
    }

    private void m1416c() {
        for (AnalyticsEventUploader a : (Set) this.f1157j.get()) {
            a.m1282a();
        }
    }

    private void m1417d() {
        long a = this.f1150c.a();
        if (this.f1160m == -1) {
            this.f1160m = this.f1151d.m8550a(AnalyticsDbProperties.f1041k, 0);
        }
        long j = a - this.f1160m;
        if ((j > 86400000 || j < 0) && this.f1152e.m1425a() > 8000) {
            int a2 = this.f1152e.m1426a(this.f1150c.a());
            this.f1160m = a;
            this.f1151d.m8557b(AnalyticsDbProperties.f1041k, a);
            if (a2 > 0) {
                SoftErrorBuilder a3 = SoftError.m4758a("marauder:data_loss:delete_stale_event", Integer.toString(a2));
                a3.f4228e = 1;
                this.f1158k.a(a3.m4765g());
            }
        }
    }

    public final void m1418a(PrintWriter printWriter) {
        printWriter.println("AnalyticsEventDataStore: ");
        synchronized (this.f1155h) {
            printWriter.println(" mIdle: " + this.f1162o);
        }
        printWriter.println(" pending in-memory events: " + this.f1154g.size());
        printWriter.println(" total events logged since start: " + this.f1159l);
        printWriter.println(StringFormatUtil.formatStrLocaleSafe(" last event written: %s ago", m1413b(this.f1150c.a() - this.f1161n)));
    }

    private static String m1413b(long j) {
        return StringFormatUtil.formatStrLocaleSafe("%02d:%02d.%03d", Long.valueOf(j / 60000), Long.valueOf((j / 1000) % 60), Long.valueOf(j % 1000));
    }
}
