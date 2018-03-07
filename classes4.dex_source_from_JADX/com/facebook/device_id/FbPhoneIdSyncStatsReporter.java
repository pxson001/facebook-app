package com.facebook.device_id;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.executors.ScheduledExecutorService_BackgroundExecutorServiceMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.phoneid.Response;
import java.util.ArrayList;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: total_pd */
public class FbPhoneIdSyncStatsReporter {
    private static final String f877a = FbPhoneIdSyncStatsReporter.class.getSimpleName();
    private static volatile FbPhoneIdSyncStatsReporter f878f;
    private final ScheduledExecutorService f879b;
    private final AnalyticsLogger f880c;
    @GuardedBy("this")
    private ArrayList<Response> f881d = new ArrayList();
    @GuardedBy("this")
    private boolean f882e = false;

    /* compiled from: total_pd */
    class StatsReportingRunnable implements Runnable {
        final /* synthetic */ FbPhoneIdSyncStatsReporter f922a;

        public StatsReportingRunnable(FbPhoneIdSyncStatsReporter fbPhoneIdSyncStatsReporter) {
            this.f922a = fbPhoneIdSyncStatsReporter;
        }

        public void run() {
            FbPhoneIdSyncStatsReporter.m1213a(this.f922a);
        }
    }

    public static com.facebook.device_id.FbPhoneIdSyncStatsReporter m1212a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f878f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.device_id.FbPhoneIdSyncStatsReporter.class;
        monitor-enter(r1);
        r0 = f878f;	 Catch:{ all -> 0x003a }
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
        r0 = m1214b(r0);	 Catch:{ all -> 0x0035 }
        f878f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f878f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.device_id.FbPhoneIdSyncStatsReporter.a(com.facebook.inject.InjectorLike):com.facebook.device_id.FbPhoneIdSyncStatsReporter");
    }

    private static FbPhoneIdSyncStatsReporter m1214b(InjectorLike injectorLike) {
        return new FbPhoneIdSyncStatsReporter(ScheduledExecutorService_BackgroundExecutorServiceMethodAutoProvider.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public FbPhoneIdSyncStatsReporter(ScheduledExecutorService scheduledExecutorService, AnalyticsLogger analyticsLogger) {
        this.f879b = scheduledExecutorService;
        this.f880c = analyticsLogger;
    }

    public final synchronized void m1216a(Response response) {
        this.f881d.add(response);
        if (!this.f882e) {
            this.f879b.schedule(new StatsReportingRunnable(this), 10, TimeUnit.SECONDS);
            this.f882e = true;
        }
    }

    public static void m1213a(FbPhoneIdSyncStatsReporter fbPhoneIdSyncStatsReporter) {
        ArrayList arrayList;
        synchronized (fbPhoneIdSyncStatsReporter) {
            arrayList = fbPhoneIdSyncStatsReporter.f881d;
            fbPhoneIdSyncStatsReporter.f881d = new ArrayList();
            fbPhoneIdSyncStatsReporter.f882e = false;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            fbPhoneIdSyncStatsReporter.m1215b((Response) arrayList.get(i));
        }
    }

    private void m1215b(Response response) {
        HoneyClientEventFast a = this.f880c.a("phoneid_sync_stats", true);
        if (a.a()) {
            a.a("phone_id", response.f891b).a("src_pkg", response.f890a).a("status", response.m1224d()).a("duration", response.m1225e()).a("prev_phone_id", response.f892c).b();
            response.toString();
        }
    }
}
