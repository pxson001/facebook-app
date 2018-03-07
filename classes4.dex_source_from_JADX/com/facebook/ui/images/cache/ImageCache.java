package com.facebook.ui.images.cache;

import android.app.ActivityManager;
import android.graphics.Bitmap;
import com.facebook.analytics.cache.CacheTracker.Factory;
import com.facebook.analytics.webrequest.WebRequestCounters;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.disk.DiskStorageCache;
import com.facebook.cache.disk.FileCache;
import com.facebook.common.android.ActivityManagerMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.memory.MemoryManager;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.process.ProcessNameMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.imagepipeline.module.FileCache_MainImageFileCacheMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.NeedsApplicationInjector;
import com.facebook.katana.app.module.MainProcessModule;
import com.facebook.ui.media.cache.DefaultCacheErrorLogger;
import com.facebook.ui.media.cache.MediaCache;
import com.facebook.ui.media.cache.MediaCacheParams;
import com.facebook.ui.media.cache.ObjectEncoder;
import com.google.common.annotations.VisibleForTesting;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Singleton;

@ThreadSafe
@Singleton
@Deprecated
/* compiled from: ephemeral_data */
public class ImageCache extends MediaCache<ImageCacheKey, CachedImage> {
    private static volatile ImageCache f12870a;

    public static com.facebook.ui.images.cache.ImageCache m13718a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12870a;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.ui.images.cache.ImageCache.class;
        monitor-enter(r1);
        r0 = f12870a;	 Catch:{ all -> 0x003a }
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
        r0 = m13720b(r0);	 Catch:{ all -> 0x0035 }
        f12870a = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12870a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ui.images.cache.ImageCache.a(com.facebook.inject.InjectorLike):com.facebook.ui.images.cache.ImageCache");
    }

    private static ImageCache m13720b(InjectorLike injectorLike) {
        return new ImageCache(ActivityManagerMethodAutoProvider.b(injectorLike.getApplicationInjector()), MainProcessModule.a(ProcessNameMethodAutoProvider.b(injectorLike)), (Clock) SystemClockMethodAutoProvider.a(injectorLike), Factory.a(injectorLike), WebRequestCounters.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (MemoryTrimmableRegistry) MemoryManager.a(injectorLike), FileCache_MainImageFileCacheMethodAutoProvider.m13755a(injectorLike), ImageEncoder.m13758b(injectorLike), (CacheErrorLogger) DefaultCacheErrorLogger.a(injectorLike));
    }

    protected final boolean mo930a(Object obj) {
        CachedImage cachedImage = (CachedImage) obj;
        if (!(cachedImage instanceof CachedBitmapImage)) {
            return true;
        }
        Bitmap a = cachedImage.mo941a();
        if (a == null || a.isRecycled()) {
            return false;
        }
        return true;
    }

    protected final int mo931b(Object obj) {
        return ((CachedImage) obj).mo946e();
    }

    @Inject
    public ImageCache(@NeedsApplicationInjector ActivityManager activityManager, String str, Clock clock, Factory factory, WebRequestCounters webRequestCounters, AbstractFbErrorReporter abstractFbErrorReporter, @Nullable MemoryTrimmableRegistry memoryTrimmableRegistry, DiskStorageCache diskStorageCache, ImageEncoder imageEncoder, CacheErrorLogger cacheErrorLogger) {
        this(clock, factory, webRequestCounters, abstractFbErrorReporter, m13719a("image", str + "_image", true, activityManager.getMemoryClass()), memoryTrimmableRegistry, diskStorageCache, imageEncoder, cacheErrorLogger);
    }

    @VisibleForTesting
    private ImageCache(Clock clock, Factory factory, WebRequestCounters webRequestCounters, FbErrorReporter fbErrorReporter, MediaCacheParams mediaCacheParams, @Nullable MemoryTrimmableRegistry memoryTrimmableRegistry, FileCache fileCache, ObjectEncoder<ImageCacheKey, CachedImage> objectEncoder, CacheErrorLogger cacheErrorLogger) {
        super(clock, factory, webRequestCounters, fbErrorReporter, mediaCacheParams, memoryTrimmableRegistry, fileCache, objectEncoder, cacheErrorLogger);
    }

    @VisibleForTesting
    private static MediaCacheParams m13719a(String str, String str2, boolean z, int i) {
        int i2 = i >= 64 ? ((i / 4) * 1024) * 1024 : i >= 32 ? 4194304 : 2097152;
        int i3 = i >= 32 ? i2 - 1048576 : i2 - 524288;
        i2 = (int) (((double) i2) * 1.0d);
        i3 = (int) (((double) i3) * 1.0d);
        MediaCacheParams mediaCacheParams = new MediaCacheParams();
        mediaCacheParams.f12904a = str;
        mediaCacheParams = mediaCacheParams;
        mediaCacheParams.f12905b = str2;
        mediaCacheParams = mediaCacheParams;
        mediaCacheParams.f12906c = z;
        mediaCacheParams = mediaCacheParams;
        mediaCacheParams.f12907d = i2;
        MediaCacheParams mediaCacheParams2 = mediaCacheParams;
        mediaCacheParams2.f12908e = i3;
        MediaCacheParams mediaCacheParams3 = mediaCacheParams2;
        mediaCacheParams3.f12909f = 100;
        mediaCacheParams3 = mediaCacheParams3;
        mediaCacheParams3.f12910g = 80;
        return mediaCacheParams3;
    }
}
