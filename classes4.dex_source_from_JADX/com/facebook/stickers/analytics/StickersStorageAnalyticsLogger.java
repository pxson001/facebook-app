package com.facebook.stickers.analytics;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.stickers.model.StickerAssetType;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: fa_suppression_off_pl_trigger */
public class StickersStorageAnalyticsLogger {
    private static volatile StickersStorageAnalyticsLogger f12378e;
    private final AnalyticsLogger f12379a;
    public final Clock f12380b;
    private final MonotonicClock f12381c;
    private final FbNetworkManager f12382d;

    public static com.facebook.stickers.analytics.StickersStorageAnalyticsLogger m13077a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12378e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.stickers.analytics.StickersStorageAnalyticsLogger.class;
        monitor-enter(r1);
        r0 = f12378e;	 Catch:{ all -> 0x003a }
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
        r0 = m13079b(r0);	 Catch:{ all -> 0x0035 }
        f12378e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12378e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.stickers.analytics.StickersStorageAnalyticsLogger.a(com.facebook.inject.InjectorLike):com.facebook.stickers.analytics.StickersStorageAnalyticsLogger");
    }

    private static StickersStorageAnalyticsLogger m13079b(InjectorLike injectorLike) {
        return new StickersStorageAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), FbNetworkManager.a(injectorLike));
    }

    @Inject
    public StickersStorageAnalyticsLogger(AnalyticsLogger analyticsLogger, Clock clock, MonotonicClock monotonicClock, FbNetworkManager fbNetworkManager) {
        this.f12379a = analyticsLogger;
        this.f12380b = clock;
        this.f12381c = monotonicClock;
        this.f12382d = fbNetworkManager;
    }

    public final void m13084a(String str, StickerAssetType stickerAssetType, long j) {
        HoneyClientEvent b = m13078b(str, stickerAssetType, j);
        b.b("download_status", "success");
        this.f12379a.c(b);
    }

    public final void m13085a(String str, StickerAssetType stickerAssetType, Exception exception, long j) {
        HoneyClientEvent b = m13078b(str, stickerAssetType, j);
        b.b("download_status", "failure");
        b.b("exception_type", exception.getClass().getName());
        this.f12379a.c(b);
    }

    public final void m13081a() {
        HoneyClientEvent c = m13080c();
        c.b("status", "started");
        this.f12379a.a(c);
    }

    public final void m13086b() {
        HoneyClientEvent c = m13080c();
        c.b("status", "ended");
        this.f12379a.a(c);
    }

    public final void m13088b(String str) {
        HoneyClientEvent c = m13080c();
        c.b("error", str);
        this.f12379a.a(c);
    }

    public final void m13082a(ImmutableList<String> immutableList) {
        HoneyClientEvent c = m13080c();
        c.b("event_source", "xconfig");
        c.b("sticker_ids", immutableList.toString());
        this.f12379a.a(c);
    }

    public final void m13087b(ImmutableList<String> immutableList) {
        HoneyClientEvent c = m13080c();
        c.b("event_source", "updated_packs");
        c.b("sticker_ids", immutableList.toString());
        this.f12379a.a(c);
    }

    private HoneyClientEvent m13078b(String str, StickerAssetType stickerAssetType, long j) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("sticker_asset");
        honeyClientEvent.b("event_type", "download");
        honeyClientEvent.b("sticker_id", str);
        honeyClientEvent.b("asset_type", stickerAssetType.getDbName());
        honeyClientEvent.a("timestamp", this.f12380b.a());
        honeyClientEvent.a("download_time_ms", this.f12381c.now() - j);
        honeyClientEvent.a("appears_to_be_connected_on_wifi", this.f12382d.v());
        honeyClientEvent.b("asset_type", stickerAssetType.getDbName());
        return honeyClientEvent;
    }

    public final void m13083a(String str) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("sticker_asset");
        honeyClientEvent.b("event_type", "cleanup");
        honeyClientEvent.b("pack_id", str);
        honeyClientEvent.a("timestamp", this.f12380b.a());
        HoneyClientEvent honeyClientEvent2 = honeyClientEvent;
        honeyClientEvent2.b("pack_id", str);
        this.f12379a.c(honeyClientEvent2);
    }

    private HoneyClientEvent m13080c() {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("sticker_asset");
        honeyClientEvent.b("event_type", "flush");
        honeyClientEvent.a("timestamp", this.f12380b.a());
        return honeyClientEvent;
    }
}
