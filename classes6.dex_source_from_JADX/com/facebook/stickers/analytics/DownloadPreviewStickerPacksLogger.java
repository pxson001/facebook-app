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
/* compiled from: ensureUploadAlive */
public class DownloadPreviewStickerPacksLogger {
    private static volatile DownloadPreviewStickerPacksLogger f16418c;
    private final AnalyticsLogger f16419a;
    private final Clock f16420b;

    public static com.facebook.stickers.analytics.DownloadPreviewStickerPacksLogger m23891a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f16418c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.stickers.analytics.DownloadPreviewStickerPacksLogger.class;
        monitor-enter(r1);
        r0 = f16418c;	 Catch:{ all -> 0x003a }
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
        r0 = m23892b(r0);	 Catch:{ all -> 0x0035 }
        f16418c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f16418c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.stickers.analytics.DownloadPreviewStickerPacksLogger.a(com.facebook.inject.InjectorLike):com.facebook.stickers.analytics.DownloadPreviewStickerPacksLogger");
    }

    private static DownloadPreviewStickerPacksLogger m23892b(InjectorLike injectorLike) {
        return new DownloadPreviewStickerPacksLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public DownloadPreviewStickerPacksLogger(AnalyticsLogger analyticsLogger, Clock clock) {
        this.f16419a = analyticsLogger;
        this.f16420b = clock;
    }

    public final void m23894a(String str) {
        HoneyClientEvent d = m23893d("download_button_pressed");
        d.b("pack_id", str);
        this.f16419a.a(d);
    }

    public final void m23895b(String str) {
        HoneyClientEvent d = m23893d("cancel_button_pressed");
        d.b("pack_id", str);
        this.f16419a.a(d);
    }

    public final void m23896c(String str) {
        HoneyClientEvent d = m23893d("download_preview_tab_viewed");
        d.b("pack_id", str);
        this.f16419a.a(d);
    }

    private HoneyClientEvent m23893d(String str) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("download_preview");
        honeyClientEvent.b("event_type", str);
        honeyClientEvent.a("timestamp", this.f16420b.a());
        return honeyClientEvent;
    }
}
