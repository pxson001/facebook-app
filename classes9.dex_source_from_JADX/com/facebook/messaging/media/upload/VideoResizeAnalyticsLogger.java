package com.facebook.messaging.media.upload;

import android.net.NetworkInfo;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ui.media.attachments.MediaResourceHelper;
import com.google.common.base.Throwables;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: later_source */
public class VideoResizeAnalyticsLogger {
    private static volatile VideoResizeAnalyticsLogger f12071c;
    private final AnalyticsLogger f12072a;
    public final FbNetworkManager f12073b;

    public static com.facebook.messaging.media.upload.VideoResizeAnalyticsLogger m12585a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12071c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.media.upload.VideoResizeAnalyticsLogger.class;
        monitor-enter(r1);
        r0 = f12071c;	 Catch:{ all -> 0x003a }
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
        r0 = m12587b(r0);	 Catch:{ all -> 0x0035 }
        f12071c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12071c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.media.upload.VideoResizeAnalyticsLogger.a(com.facebook.inject.InjectorLike):com.facebook.messaging.media.upload.VideoResizeAnalyticsLogger");
    }

    private static VideoResizeAnalyticsLogger m12587b(InjectorLike injectorLike) {
        return new VideoResizeAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike), FbNetworkManager.a(injectorLike));
    }

    @Inject
    public VideoResizeAnalyticsLogger(AnalyticsLogger analyticsLogger, FbNetworkManager fbNetworkManager) {
        this.f12072a = analyticsLogger;
        this.f12073b = fbNetworkManager;
    }

    public final void m12589a(MediaResource mediaResource) {
        m12586a("messenger_transcode_started", m12588b(mediaResource));
    }

    public final void m12591a(MediaResource mediaResource, @Nullable String str, long j, int i, @Nullable String str2) {
        Map b = m12588b(mediaResource);
        b.put("elapsed_time", Long.toString(j));
        b.put("resize_strategy", str);
        b.put("original_sha256", str2);
        b.put("transcode_attempt", String.valueOf(i));
        b.put("is_video_trimmed_or_cropped", String.valueOf(MediaResourceHelper.c(mediaResource)));
        m12586a("messenger_transcode_canceled", b);
    }

    public final void m12592a(MediaResource mediaResource, @Nullable String str, long j, @Nullable Throwable th, int i, @Nullable String str2) {
        Map b = m12588b(mediaResource);
        b.put("elapsed_time", Long.toString(j));
        b.put("resize_strategy", str);
        b.put("transcode_attempt", String.valueOf(i));
        b.put("original_sha256", str2);
        b.put("is_video_trimmed_or_cropped", String.valueOf(MediaResourceHelper.c(mediaResource)));
        if (th != null) {
            Throwable th2 = (Throwable) Iterables.g(Throwables.getCausalChain(th));
            Writer stringWriter = new StringWriter();
            th2.printStackTrace(new PrintWriter(stringWriter));
            b.put("error_code", stringWriter.toString());
        }
        m12586a("messenger_transcode_failed", b);
    }

    public final void m12590a(MediaResource mediaResource, long j, int i, @Nullable String str, @Nullable String str2, long j2, int i2, @Nullable String str3) {
        Map b = m12588b(mediaResource);
        b.put("elapsed_time", Long.toString(j2));
        b.put("new_size", String.valueOf(j));
        b.put("transcode_attempt", String.valueOf(i2));
        b.put("original_sha256", str3);
        if (i != 0) {
            b.put("estimated_size", String.valueOf(i));
        }
        b.put("resize_strategy", str);
        b.put("resize_status", str2);
        b.put("is_video_trimmed_or_cropped", String.valueOf(MediaResourceHelper.c(mediaResource)));
        m12586a("messenger_transcode_finished", b);
    }

    private Map<String, String> m12588b(MediaResource mediaResource) {
        Map<String, String> c = Maps.c();
        NetworkInfo i = this.f12073b.i();
        c.put("connection_type", i != null ? i.getTypeName() : null);
        c.put("connection_wifi_rssi", Integer.toString(this.f12073b.r()));
        c.put("is_connected", Boolean.toString(this.f12073b.d()));
        c.put("is_network_metered", Boolean.toString(this.f12073b.h()));
        c.put("video_duration_millis", String.valueOf(mediaResource.i));
        c.put("video_size", String.valueOf(mediaResource.p));
        c.put("offline_threading_id", mediaResource.m);
        c.put("video_attachment_type", mediaResource.e.toString());
        c.put("original_height", String.valueOf(mediaResource.k));
        c.put("original_width", String.valueOf(mediaResource.j));
        return c;
    }

    private void m12586a(String str, Map<String, String> map) {
        this.f12072a.a(str, map);
    }
}
