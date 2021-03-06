package com.facebook.stickers.data;

import android.net.Uri;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.file.FileUtils;
import com.facebook.common.tempfile.TempFileManager;
import com.facebook.common.tempfile.TempFileManager.Privacy;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.config.application.PlatformAppConfig;
import com.facebook.debug.log.BLog;
import com.facebook.http.common.FbHttpRequestCancelTrigger;
import com.facebook.inject.InjectorLike;
import com.facebook.stickers.analytics.StickersStorageAnalyticsLogger;
import com.facebook.stickers.model.StickerAssetType;
import com.facebook.ui.images.fetch.ImageWriter;
import com.google.common.base.Throwables;
import java.io.File;
import java.io.IOException;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: pyml_page_like */
public class StickerAssetDownloader {
    private static final Class<?> f3968a = StickerAssetDownloader.class;
    private static volatile StickerAssetDownloader f3969i;
    private final TempFileManager f3970b;
    private final StickersFileUtil f3971c;
    public final ImageWriter f3972d;
    public final PlatformAppConfig f3973e;
    private final StickerMediaDownloader f3974f;
    private final StickersStorageAnalyticsLogger f3975g;
    private final MonotonicClock f3976h;

    public static com.facebook.stickers.data.StickerAssetDownloader m4462a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f3969i;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.stickers.data.StickerAssetDownloader.class;
        monitor-enter(r1);
        r0 = f3969i;	 Catch:{ all -> 0x003a }
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
        r0 = m4463b(r0);	 Catch:{ all -> 0x0035 }
        f3969i = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f3969i;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.stickers.data.StickerAssetDownloader.a(com.facebook.inject.InjectorLike):com.facebook.stickers.data.StickerAssetDownloader");
    }

    private static StickerAssetDownloader m4463b(InjectorLike injectorLike) {
        return new StickerAssetDownloader(TempFileManager.m8903a(injectorLike), StickersFileUtil.m13050a(injectorLike), ImageWriter.m13829b(injectorLike), (PlatformAppConfig) injectorLike.getInstance(PlatformAppConfig.class), StickerMediaDownloader.m4465a(injectorLike), StickersStorageAnalyticsLogger.m13077a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public StickerAssetDownloader(TempFileManager tempFileManager, StickersFileUtil stickersFileUtil, ImageWriter imageWriter, PlatformAppConfig platformAppConfig, StickerMediaDownloader stickerMediaDownloader, StickersStorageAnalyticsLogger stickersStorageAnalyticsLogger, MonotonicClock monotonicClock) {
        this.f3970b = tempFileManager;
        this.f3971c = stickersFileUtil;
        this.f3972d = imageWriter;
        this.f3973e = platformAppConfig;
        this.f3974f = stickerMediaDownloader;
        this.f3975g = stickersStorageAnalyticsLogger;
        this.f3976h = monotonicClock;
    }

    public final File m4464a(String str, String str2, StickerAssetType stickerAssetType, Uri uri, CallerContext callerContext) {
        CallerContext a = CallerContext.a(getClass(), "sticker_storage_download", callerContext != null ? callerContext.b() : null);
        long now = this.f3976h.now();
        File file = null;
        try {
            file = this.f3971c.m13055a(str, str2, uri, stickerAssetType, true);
            File a2 = this.f3970b.m8907a("sticker", ".tmp", Privacy.REQUIRE_SDCARD);
            if (file == null) {
                throw new RuntimeException("destFile cannot be created and is null.");
            }
            this.f3974f.mo304a(new 2(this, uri, new 1(this, a2), new FbHttpRequestCancelTrigger(), a));
            FileUtils.a(a2, file);
            this.f3975g.m13084a(str2, stickerAssetType, now);
            return file;
        } catch (Throwable e) {
            BLog.b(f3968a, e, "Failed to download sticker asset for sticker %s, asset type: %s.", new Object[]{str2, stickerAssetType});
            this.f3975g.m13085a(str2, stickerAssetType, e, now);
            if (file != null) {
                file.delete();
            }
            if (e instanceof IOException) {
                throw ((IOException) e);
            }
            throw Throwables.propagate(e);
        }
    }
}
