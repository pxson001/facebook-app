package com.facebook.messaging.media.upload;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.media.upload.util.MediaHashCache;
import com.facebook.ui.media.attachments.MediaResource;
import com.google.common.base.Throwables;
import com.google.common.collect.Iterables;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: mEId */
public class MediaGetFbidAnalyticsLogger {
    private static volatile MediaGetFbidAnalyticsLogger f8718c;
    private final AnalyticsLogger f8719a;
    private final MediaHashCache f8720b;

    public static com.facebook.messaging.media.upload.MediaGetFbidAnalyticsLogger m9001a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8718c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.media.upload.MediaGetFbidAnalyticsLogger.class;
        monitor-enter(r1);
        r0 = f8718c;	 Catch:{ all -> 0x003a }
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
        r0 = m9003b(r0);	 Catch:{ all -> 0x0035 }
        f8718c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8718c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.media.upload.MediaGetFbidAnalyticsLogger.a(com.facebook.inject.InjectorLike):com.facebook.messaging.media.upload.MediaGetFbidAnalyticsLogger");
    }

    private static MediaGetFbidAnalyticsLogger m9003b(InjectorLike injectorLike) {
        return new MediaGetFbidAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike), MediaHashCache.m8888a(injectorLike));
    }

    @Inject
    public MediaGetFbidAnalyticsLogger(AnalyticsLogger analyticsLogger, MediaHashCache mediaHashCache) {
        this.f8719a = analyticsLogger;
        this.f8720b = mediaHashCache;
    }

    public final void m9005a(MediaResource mediaResource) {
        m9002a("messenger_get_media_fbid_started", m9004b(mediaResource));
    }

    public final void m9007a(MediaResource mediaResource, String str, long j, @Nullable Throwable th) {
        Map b = m9004b(mediaResource);
        b.put("get_fbid_status", str);
        b.put("elapsed_time", Long.toString(j));
        if (th != null) {
            Throwable th2 = (Throwable) Iterables.g(Throwables.getCausalChain(th));
            Writer stringWriter = new StringWriter();
            th2.printStackTrace(new PrintWriter(stringWriter));
            b.put("error_code", stringWriter.toString());
        }
        m9002a("messenger_get_media_fbid_failed", b);
    }

    public final void m9006a(MediaResource mediaResource, long j, String str, long j2) {
        Map b = m9004b(mediaResource);
        b.put("media_fbid", String.valueOf(j));
        b.put("get_fbid_status", str);
        b.put("elapsed_time", String.valueOf(j2));
        m9002a("messenger_get_media_fbid_finished", b);
    }

    public final void m9008a(MediaResource mediaResource, String str, String str2, String str3) {
        Map b = m9004b(mediaResource);
        b.put("media_fbid_first_returned", str);
        b.put("media_fbid_second_returned", str2);
        b.put("second_fbid_creation_path", str3);
        m9002a("messenger_dup_media_fbid_returned", b);
    }

    private Map<String, String> m9004b(MediaResource mediaResource) {
        Map<String, String> hashMap = new HashMap();
        hashMap.put("offline_threading_id", mediaResource.m);
        hashMap.put("media_source", mediaResource.e.toString());
        hashMap.put("media_type", mediaResource.d.toString());
        hashMap.put("original_sha256", this.f8720b.m8892a(mediaResource));
        return hashMap;
    }

    private void m9002a(String str, Map<String, String> map) {
        this.f8719a.a(str, map);
    }
}
