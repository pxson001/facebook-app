package com.facebook.stickers.analytics;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: push_unreg_status */
public class StickersAutodownloadAnalyticsLogger {
    private static volatile StickersAutodownloadAnalyticsLogger f12247d;
    private final AnalyticsLogger f12248a;
    private final Clock f12249b;
    private final FbNetworkManager f12250c;

    /* compiled from: push_unreg_status */
    public enum OperationStatus {
        STARTED,
        COMPLETED
    }

    public static com.facebook.stickers.analytics.StickersAutodownloadAnalyticsLogger m12915a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12247d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.stickers.analytics.StickersAutodownloadAnalyticsLogger.class;
        monitor-enter(r1);
        r0 = f12247d;	 Catch:{ all -> 0x003a }
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
        r0 = m12916b(r0);	 Catch:{ all -> 0x0035 }
        f12247d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12247d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.stickers.analytics.StickersAutodownloadAnalyticsLogger.a(com.facebook.inject.InjectorLike):com.facebook.stickers.analytics.StickersAutodownloadAnalyticsLogger");
    }

    private static StickersAutodownloadAnalyticsLogger m12916b(InjectorLike injectorLike) {
        return new StickersAutodownloadAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), FbNetworkManager.a(injectorLike));
    }

    @Inject
    public StickersAutodownloadAnalyticsLogger(AnalyticsLogger analyticsLogger, Clock clock, FbNetworkManager fbNetworkManager) {
        this.f12248a = analyticsLogger;
        this.f12249b = clock;
        this.f12250c = fbNetworkManager;
    }

    public final void m12917a() {
        this.f12248a.a(m12914a("task_triggered"));
    }

    public final void m12920b() {
        this.f12248a.a(m12914a("no_fetch_needed"));
    }

    public final void m12922c() {
        this.f12248a.a(m12914a("metadata_not_ready"));
    }

    public final void m12918a(OperationStatus operationStatus) {
        HoneyClientEvent a = m12914a("metadata");
        a.b("operation_status", operationStatus.name());
        this.f12248a.a(a);
    }

    public final void m12919a(String str, OperationStatus operationStatus) {
        HoneyClientEvent a = m12914a("add_to_tray");
        a.b("pack_id", str);
        a.b("operation_status", operationStatus.name());
        this.f12248a.a(a);
    }

    public final void m12921b(String str, OperationStatus operationStatus) {
        HoneyClientEvent a = m12914a("download_asset");
        a.b("pack_id", str);
        a.b("operation_status", operationStatus.name());
        this.f12248a.a(a);
    }

    private HoneyClientEvent m12914a(String str) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("sticker_autodownload");
        honeyClientEvent.b("event_type", str);
        honeyClientEvent.a("timestamp", this.f12249b.a());
        honeyClientEvent.a("appears_to_be_connected_on_wifi", this.f12250c.v());
        return honeyClientEvent;
    }
}
