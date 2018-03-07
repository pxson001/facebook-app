package com.facebook.sync.analytics;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.debug.debugoverlay.DebugOverlayController;
import com.facebook.inject.InjectorLike;
import com.facebook.sync.model.IrisQueueTypes;
import com.facebook.sync.prefs.SyncDebugOverlaySettingsTags;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: feedback_stop_typing */
public class SyncAnalyticsLogger {
    private static volatile SyncAnalyticsLogger f14435d;
    public final AnalyticsLogger f14436a;
    private final Clock f14437b;
    private final DebugOverlayController f14438c;

    public static com.facebook.sync.analytics.SyncAnalyticsLogger m18336a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f14435d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.sync.analytics.SyncAnalyticsLogger.class;
        monitor-enter(r1);
        r0 = f14435d;	 Catch:{ all -> 0x003a }
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
        r0 = m18337b(r0);	 Catch:{ all -> 0x0035 }
        f14435d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f14435d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.sync.analytics.SyncAnalyticsLogger.a(com.facebook.inject.InjectorLike):com.facebook.sync.analytics.SyncAnalyticsLogger");
    }

    private static SyncAnalyticsLogger m18337b(InjectorLike injectorLike) {
        return new SyncAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), DebugOverlayController.a(injectorLike));
    }

    @Inject
    public SyncAnalyticsLogger(AnalyticsLogger analyticsLogger, Clock clock, DebugOverlayController debugOverlayController) {
        this.f14436a = analyticsLogger;
        this.f14437b = clock;
        this.f14438c = debugOverlayController;
    }

    public final void m18340a(IrisQueueTypes irisQueueTypes, FullRefreshReason fullRefreshReason) {
        this.f14438c.a(SyncDebugOverlaySettingsTags.f14550c, "full_refresh (" + irisQueueTypes.apiString + "): " + fullRefreshReason);
        HoneyClientEvent b = new HoneyClientEvent("sync_full_refresh").b("queue_type", irisQueueTypes.apiString).b("reason_type", fullRefreshReason.f14432h.name()).b("reason_msg", fullRefreshReason.f14433i);
        b.c = "android_sync";
        this.f14436a.c(b);
    }

    public final void m18339a(IrisQueueTypes irisQueueTypes, long j, int i, boolean z) {
        HoneyClientEvent b = new HoneyClientEvent("handle_deltas_perf").a("is_success", z).b("deltas_count", Integer.toString(i)).b("total_time", Long.toString(this.f14437b.a() - j));
        b.a("queue_type", irisQueueTypes).c = "android_sync";
        this.f14436a.c(b);
    }

    public final void m18338a(HoneyClientEvent honeyClientEvent, IrisQueueTypes irisQueueTypes) {
        honeyClientEvent.a("queue_type", irisQueueTypes).c = "android_sync";
        this.f14436a.a(honeyClientEvent);
    }
}
