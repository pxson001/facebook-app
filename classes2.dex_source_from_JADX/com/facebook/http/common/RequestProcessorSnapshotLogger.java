package com.facebook.http.common;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.appstate.PeriodicForegroundScheduler;
import com.facebook.common.network.FbDataConnectionManager;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: recent_ping_sent_count */
public class RequestProcessorSnapshotLogger {
    private static final Class<?> f7885a = RequestProcessorSnapshotLogger.class;
    private static volatile RequestProcessorSnapshotLogger f7886g;
    private final AnalyticsLogger f7887b;
    private final PeriodicForegroundScheduler f7888c;
    private final Provider<FbHttpRequestProcessor> f7889d;
    private final FbNetworkManager f7890e;
    private final FbDataConnectionManager f7891f;

    public static com.facebook.http.common.RequestProcessorSnapshotLogger m12483a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f7886g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.http.common.RequestProcessorSnapshotLogger.class;
        monitor-enter(r1);
        r0 = f7886g;	 Catch:{ all -> 0x003a }
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
        r0 = m12485b(r0);	 Catch:{ all -> 0x0035 }
        f7886g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f7886g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.http.common.RequestProcessorSnapshotLogger.a(com.facebook.inject.InjectorLike):com.facebook.http.common.RequestProcessorSnapshotLogger");
    }

    private static RequestProcessorSnapshotLogger m12485b(InjectorLike injectorLike) {
        return new RequestProcessorSnapshotLogger(AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike), PeriodicForegroundScheduler.m12490a(injectorLike), IdBasedSingletonScopeProvider.m1809a(injectorLike, 2217), FbNetworkManager.m3811a(injectorLike), FbDataConnectionManager.m3787a(injectorLike));
    }

    public final void m12486a() {
        m12484a(true);
    }

    @Inject
    public RequestProcessorSnapshotLogger(AnalyticsLogger analyticsLogger, PeriodicForegroundScheduler periodicForegroundScheduler, Provider<FbHttpRequestProcessor> provider, FbNetworkManager fbNetworkManager, FbDataConnectionManager fbDataConnectionManager) {
        this.f7888c = periodicForegroundScheduler;
        this.f7887b = analyticsLogger;
        this.f7889d = provider;
        this.f7888c.m12495a(this, 1.0E-4d);
        this.f7890e = fbNetworkManager;
        this.f7891f = fbDataConnectionManager;
    }

    private void m12484a(boolean z) {
        if (z || Math.random() < 0.002d) {
            TracerDetour.a("RequestProcessorSnapshotLogger.reportSnapshot", 1068891476);
            try {
                RequestProcessorSnapshot a = ((FbHttpRequestProcessor) this.f7889d.get()).m12266a();
                String immutableList = FbHttpUtils.a(a.a()).toString();
                this.f7887b.mo526a(new HoneyClientEvent("network_prioritization_snapshot").m5090b("periodic", String.valueOf(z)).m5090b("requests_in_flight_snapshot", immutableList).m5090b("requests_in_queue_snapshot", FbHttpUtils.a(a.b()).toString()).m5090b("connection_type", this.f7890e.m3835k()).m5090b("network_subtype", this.f7890e.m3836l()).m5090b("connection_class", this.f7891f.m3801c().name()));
            } finally {
                TracerDetour.a(-1188399286);
            }
        }
    }
}
