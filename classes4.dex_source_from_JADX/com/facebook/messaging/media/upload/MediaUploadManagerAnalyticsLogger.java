package com.facebook.messaging.media.upload;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.media.attachments.MediaResource;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: mColdStartTraceControl */
public class MediaUploadManagerAnalyticsLogger {
    private static volatile MediaUploadManagerAnalyticsLogger f8721b;
    private final AnalyticsLogger f8722a;

    public static com.facebook.messaging.media.upload.MediaUploadManagerAnalyticsLogger m9009a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8721b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.media.upload.MediaUploadManagerAnalyticsLogger.class;
        monitor-enter(r1);
        r0 = f8721b;	 Catch:{ all -> 0x003a }
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
        r0 = m9011b(r0);	 Catch:{ all -> 0x0035 }
        f8721b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8721b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.media.upload.MediaUploadManagerAnalyticsLogger.a(com.facebook.inject.InjectorLike):com.facebook.messaging.media.upload.MediaUploadManagerAnalyticsLogger");
    }

    private static MediaUploadManagerAnalyticsLogger m9011b(InjectorLike injectorLike) {
        return new MediaUploadManagerAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public MediaUploadManagerAnalyticsLogger(AnalyticsLogger analyticsLogger) {
        this.f8722a = analyticsLogger;
    }

    public final void m9013a(MediaResource mediaResource) {
        Map b = m9012b(mediaResource);
        b.put("media_source", mediaResource.e.toString());
        b.put("media_mime_type", mediaResource.o);
        m9010a("messenger_media_upload_request_started", m9012b(mediaResource));
    }

    public final void m9014a(MediaResource mediaResource, String str) {
        Map b = m9012b(mediaResource);
        b.put("result_path", str);
        m9010a("messenger_media_upload_request_finished", b);
    }

    public final void m9015a(MediaResource mediaResource, String str, String str2) {
        Map b = m9012b(mediaResource);
        b.put("result_path", str);
        b.put("canceled_stage", str2);
        m9010a("messenger_media_upload_request_canceled", b);
    }

    public final void m9016b(MediaResource mediaResource, String str, String str2) {
        Map b = m9012b(mediaResource);
        b.put("result_path", str);
        b.put("failed_stage", str2);
        m9010a("messenger_media_upload_request_failed", b);
    }

    public final void m9017c(MediaResource mediaResource, String str, String str2) {
        Map b = m9012b(mediaResource);
        b.put("result_path", str);
        b.put("progress_stage", str2);
        m9010a("messenger_media_upload_request_in_progress", b);
    }

    private static Map<String, String> m9012b(MediaResource mediaResource) {
        Map<String, String> hashMap = new HashMap();
        hashMap.put("offline_threading_id", mediaResource.m);
        hashMap.put("media_type", mediaResource.d.toString());
        return hashMap;
    }

    private void m9010a(String str, Map<String, String> map) {
        this.f8722a.a(str, map);
    }
}
