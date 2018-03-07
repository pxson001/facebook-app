package com.facebook.stickers.analytics;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: end_offset */
public class StickerSearchAnalyticsLogger {
    private static volatile StickerSearchAnalyticsLogger f16423c;
    private final AnalyticsLogger f16424a;
    private final Clock f16425b;

    /* compiled from: end_offset */
    public enum OperationStatus {
        STARTED,
        COMPLETED,
        CANCELLED,
        FAILED
    }

    public static com.facebook.stickers.analytics.StickerSearchAnalyticsLogger m23901a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f16423c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.stickers.analytics.StickerSearchAnalyticsLogger.class;
        monitor-enter(r1);
        r0 = f16423c;	 Catch:{ all -> 0x003a }
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
        r0 = m23902b(r0);	 Catch:{ all -> 0x0035 }
        f16423c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f16423c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.stickers.analytics.StickerSearchAnalyticsLogger.a(com.facebook.inject.InjectorLike):com.facebook.stickers.analytics.StickerSearchAnalyticsLogger");
    }

    private static StickerSearchAnalyticsLogger m23902b(InjectorLike injectorLike) {
        return new StickerSearchAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public StickerSearchAnalyticsLogger(AnalyticsLogger analyticsLogger, Clock clock) {
        this.f16424a = analyticsLogger;
        this.f16425b = clock;
    }

    public final void m23904a(String str) {
        HoneyClientEvent e = m23903e("featured_tag_selected");
        e.b("tag_id", str);
        this.f16424a.a(e);
    }

    public final void m23907b(String str) {
        HoneyClientEvent e = m23903e("search");
        e.b("search_query", str);
        e.a("operation_status", OperationStatus.STARTED);
        this.f16424a.a(e);
    }

    public final void m23905a(String str, int i, int i2) {
        HoneyClientEvent e = m23903e("search");
        e.b("search_query", str);
        e.a("operation_status", OperationStatus.COMPLETED);
        e.a("tray_sticker_matches_shown", i);
        e.a("store_sticker_matches_shown", i2);
        this.f16424a.a(e);
    }

    public final void m23908c(String str) {
        HoneyClientEvent e = m23903e("search");
        e.b("search_query", str);
        e.a("operation_status", OperationStatus.CANCELLED);
        this.f16424a.a(e);
    }

    public final void m23909d(String str) {
        HoneyClientEvent e = m23903e("search");
        e.b("search_query", str);
        e.a("operation_status", OperationStatus.FAILED);
        this.f16424a.a(e);
    }

    public final void m23906a(String str, boolean z, boolean z2) {
        HoneyClientEvent e = m23903e("sticker_sent");
        e.b("sticker_id", str);
        e.a("is_in_tray", z);
        e.a("is_from_featured_tag", z2);
        this.f16424a.a(e);
    }

    private HoneyClientEvent m23903e(String str) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("sticker_search");
        honeyClientEvent.b("event_type", str);
        honeyClientEvent.a("timestamp", this.f16425b.a());
        return honeyClientEvent;
    }
}
