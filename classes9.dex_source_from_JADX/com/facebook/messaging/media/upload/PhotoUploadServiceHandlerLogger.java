package com.facebook.messaging.media.upload;

import android.graphics.BitmapFactory.Options;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.bitmaps.FbBitmapFactory;
import com.facebook.bitmaps.ImageResizingMode;
import com.facebook.bitmaps.ImageScaleParam;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.file.StatFsHelperMethodAutoProvider;
import com.facebook.common.network.FbDataConnectionManager;
import com.facebook.common.statfs.StatFsHelper;
import com.facebook.common.statfs.StatFsHelper.StorageType;
import com.facebook.http.protocol.ApiErrorResult;
import com.facebook.http.protocol.ApiException;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.messaging.media.bandwidth.MediaBandwidthManager;
import com.facebook.messaging.media.bandwidth.MediaBandwidthManager$ConnectionQualityMeasurement;
import com.facebook.ui.media.attachments.MediaResource;
import com.google.common.base.Stopwatch;
import com.google.common.base.Throwables;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import java.io.File;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: like_attachment_count */
public class PhotoUploadServiceHandlerLogger {
    private static volatile PhotoUploadServiceHandlerLogger f11999i;
    private final AnalyticsLogger f12000a;
    private final AbstractFbErrorReporter f12001b;
    private final Provider<ImageResizingMode> f12002c;
    private final Stopwatch f12003d;
    private final Lazy<FbDataConnectionManager> f12004e;
    private final MediaBandwidthManager f12005f;
    private final StatFsHelper f12006g;
    private final Cache<MediaResource, Stopwatch> f12007h = CacheBuilder.newBuilder().a(2073600000, TimeUnit.MILLISECONDS).q();

    public static com.facebook.messaging.media.upload.PhotoUploadServiceHandlerLogger m12545a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f11999i;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.media.upload.PhotoUploadServiceHandlerLogger.class;
        monitor-enter(r1);
        r0 = f11999i;	 Catch:{ all -> 0x003a }
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
        r0 = m12549b(r0);	 Catch:{ all -> 0x0035 }
        f11999i = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f11999i;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.media.upload.PhotoUploadServiceHandlerLogger.a(com.facebook.inject.InjectorLike):com.facebook.messaging.media.upload.PhotoUploadServiceHandlerLogger");
    }

    private static PhotoUploadServiceHandlerLogger m12549b(InjectorLike injectorLike) {
        return new PhotoUploadServiceHandlerLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), IdBasedProvider.a(injectorLike, 4976), Stopwatch.createUnstarted(), IdBasedSingletonScopeProvider.b(injectorLike, 584), MediaBandwidthManager.a(injectorLike), StatFsHelperMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public PhotoUploadServiceHandlerLogger(AnalyticsLogger analyticsLogger, FbErrorReporter fbErrorReporter, Provider<ImageResizingMode> provider, Stopwatch stopwatch, Lazy<FbDataConnectionManager> lazy, MediaBandwidthManager mediaBandwidthManager, StatFsHelper statFsHelper) {
        this.f12000a = analyticsLogger;
        this.f12001b = fbErrorReporter;
        this.f12002c = provider;
        this.f12003d = stopwatch;
        this.f12004e = lazy;
        this.f12005f = mediaBandwidthManager;
        this.f12006g = statFsHelper;
    }

    public final void m12556a(MediaResource mediaResource, boolean z, boolean z2) {
        this.f12007h.a(mediaResource, Stopwatch.createStarted());
        HoneyClientEvent a = m12544a("media_upload_unpublished_start", mediaResource);
        m12547a(a, mediaResource, null, z, z2);
        this.f12000a.a(a);
    }

    public final void m12555a(MediaResource mediaResource, String str, int i, Map<String, String> map, boolean z, boolean z2) {
        HoneyClientEvent a = m12544a("media_upload_unpublished_end", mediaResource);
        m12547a(a, mediaResource, (Map) map, z, z2);
        a.a("elapsed_time", m12543a(mediaResource));
        a.b("unpublished_fbid", str);
        a.a("retry_count", i);
        this.f12000a.a(a);
    }

    public final void m12554a(MediaResource mediaResource, Exception exception, int i, Map<String, String> map, boolean z, boolean z2) {
        HoneyClientEvent a = m12544a("media_upload_unpublished_failure", mediaResource);
        m12547a(a, mediaResource, (Map) map, z, z2);
        a.a("elapsed_time", m12543a(mediaResource));
        a.a("retry_count", i);
        a.b("exception_info", exception.toString());
        a.a("available_internal_storage", this.f12006g.a(StorageType.INTERNAL));
        a.a("available_external_storage", this.f12006g.a(StorageType.EXTERNAL));
        this.f12000a.a(a);
        a.a("is_transient_api_error", m12548a(exception));
    }

    private static boolean m12548a(Exception exception) {
        for (Throwable th : Throwables.getCausalChain(exception)) {
            if (th instanceof ApiException) {
                ApiErrorResult b = ((ApiException) th).b();
                if (b != null) {
                    return b.mIsTransient;
                }
            }
        }
        return false;
    }

    public final void m12552a(MediaResource mediaResource, int i, Map<String, String> map, boolean z, boolean z2) {
        HoneyClientEvent a = m12544a("media_upload_unpublished_canceled", mediaResource);
        m12547a(a, mediaResource, (Map) map, z, z2);
        a.a("elapsed_time", m12543a(mediaResource));
        a.a("retry_count", i);
        this.f12000a.a(a);
    }

    private long m12543a(MediaResource mediaResource) {
        Stopwatch stopwatch = (Stopwatch) this.f12007h.a(mediaResource);
        if (stopwatch == null) {
            return 0;
        }
        stopwatch.stop();
        this.f12007h.b(mediaResource);
        return stopwatch.elapsed(TimeUnit.MILLISECONDS);
    }

    private void m12547a(HoneyClientEvent honeyClientEvent, MediaResource mediaResource, Map<String, String> map, boolean z, boolean z2) {
        honeyClientEvent.a("current_rtt", ((FbDataConnectionManager) this.f12004e.get()).f());
        honeyClientEvent.a("current_bandwidth", ((FbDataConnectionManager) this.f12004e.get()).e());
        honeyClientEvent.a("upload_size", mediaResource.p);
        MediaBandwidthManager$ConnectionQualityMeasurement b = this.f12005f.b();
        honeyClientEvent.b("upload_conn_quality", b.f11504a.name());
        honeyClientEvent.b("upload_conn_quality_confidence", b.f11505b.name());
        honeyClientEvent.a("upload_full_quality_photo", z);
        honeyClientEvent.a("parallel_upload", z2);
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                honeyClientEvent.b((String) entry.getKey(), (String) entry.getValue());
            }
        }
    }

    public final void m12550a(MediaResource mediaResource, int i) {
        Stopwatch stopwatch = this.f12003d;
        stopwatch.elapsedNanos = 0;
        stopwatch.isRunning = false;
        stopwatch.start();
        HoneyClientEvent a = m12544a("media_upload_resize_start", mediaResource);
        a.a("phase", i);
        this.f12000a.a(a);
    }

    public final void m12553a(MediaResource mediaResource, ImageScaleParam imageScaleParam, File file, int i) {
        this.f12003d.stop();
        File file2 = new File(mediaResource.c.getPath());
        Options options = new Options();
        options.inJustDecodeBounds = true;
        FbBitmapFactory.a(mediaResource.c.getPath(), options);
        HoneyClientEvent a = m12544a("media_upload_resize_end", mediaResource);
        a.a("phase", i);
        a.a("original_size", file2.length());
        a.a("resized_size", file.length());
        a.a("requested_width", imageScaleParam.a);
        a.a("requested_height", imageScaleParam.b);
        a.a("original_width", options.outWidth);
        a.a("original_height", options.outHeight);
        FbBitmapFactory.a(file.getPath(), options);
        a.a("resized_width", options.outWidth);
        a.a("resized_height", options.outHeight);
        a.a("resized_quality", imageScaleParam.c);
        a.a("elapsed_time", this.f12003d.elapsed(TimeUnit.MILLISECONDS));
        m12546a(a);
        this.f12000a.a(a);
    }

    public final void m12551a(MediaResource mediaResource, int i, Throwable th) {
        this.f12003d.stop();
        HoneyClientEvent a = m12544a("media_upload_resize_end", mediaResource);
        a.a("phase", i);
        a.a("elapsed_time", this.f12003d.elapsed(TimeUnit.MILLISECONDS));
        if (th instanceof Error) {
            a.b("exception_info", ((Error) th).toString());
        } else {
            a.b("exception_info", ((Exception) th).toString());
        }
        m12546a(a);
        this.f12000a.a(a);
        this.f12001b.a("orca_upload_resize_failure", th);
    }

    private static HoneyClientEvent m12544a(String str, MediaResource mediaResource) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(str);
        honeyClientEvent.c = "compose";
        honeyClientEvent.b("uuid", mediaResource.m);
        honeyClientEvent.b("offline_threading_id", mediaResource.m);
        honeyClientEvent.b("attachment_id", mediaResource.c.getLastPathSegment());
        honeyClientEvent.a("attachment_type", mediaResource.d);
        honeyClientEvent.b("media_source", mediaResource.e.toString());
        return honeyClientEvent;
    }

    private void m12546a(HoneyClientEvent honeyClientEvent) {
        honeyClientEvent.b("native_resizer", ((ImageResizingMode) this.f12002c.get()).toString());
    }
}
