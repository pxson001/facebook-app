package com.facebook.messaging.media.upload;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.media.attachments.MediaResource;
import com.google.common.base.Stopwatch;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: login_latitude */
public class TwoPhaseSendAnalyticsLogger {
    private static volatile TwoPhaseSendAnalyticsLogger f8847c;
    private final AnalyticsLogger f8848a;
    private final Cache<MediaResource, Stopwatch> f8849b = CacheBuilder.newBuilder().a(2073600000, TimeUnit.MILLISECONDS).q();

    public static com.facebook.messaging.media.upload.TwoPhaseSendAnalyticsLogger m9205a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8847c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.media.upload.TwoPhaseSendAnalyticsLogger.class;
        monitor-enter(r1);
        r0 = f8847c;	 Catch:{ all -> 0x003a }
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
        r0 = m9206b(r0);	 Catch:{ all -> 0x0035 }
        f8847c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8847c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.media.upload.TwoPhaseSendAnalyticsLogger.a(com.facebook.inject.InjectorLike):com.facebook.messaging.media.upload.TwoPhaseSendAnalyticsLogger");
    }

    private static TwoPhaseSendAnalyticsLogger m9206b(InjectorLike injectorLike) {
        return new TwoPhaseSendAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public TwoPhaseSendAnalyticsLogger(AnalyticsLogger analyticsLogger) {
        this.f8848a = analyticsLogger;
    }

    public final void m9208a(MediaResource mediaResource) {
        this.f8849b.a(mediaResource, Stopwatch.createStarted());
        HoneyClientEvent a = m9203a("messenger_media_upload_phase_two_start", mediaResource);
        a.a("file_size_bytes", mediaResource.p);
        a.a("width", mediaResource.j);
        a.a("height", mediaResource.k);
        this.f8848a.a(a);
    }

    public final void m9213b(MediaResource mediaResource) {
        HoneyClientEvent a = m9203a("messenger_media_upload_phase_two_succeeded", mediaResource);
        a.a("elapsed_time", m9207c(mediaResource));
        this.f8848a.a(a);
    }

    public final void m9209a(MediaResource mediaResource, Throwable th) {
        HoneyClientEvent a = m9203a("messenger_media_upload_phase_two_failed", mediaResource);
        a.a("elapsed_time", m9207c(mediaResource));
        if (th != null) {
            a.a("exception", th);
        }
        this.f8848a.a(a);
    }

    public final void m9210a(String str, String str2) {
        this.f8848a.a(m9204a("messenger_update_message_phase_two_start", str, str2));
    }

    public final void m9211a(String str, String str2, int i) {
        HoneyClientEvent a = m9204a("messenger_update_message_phase_two_succeeded", str, str2);
        a.a("retry_count", i);
        this.f8848a.a(a);
    }

    public final void m9212a(String str, String str2, int i, Exception exception) {
        HoneyClientEvent a = m9204a("messenger_update_message_phase_two_failed", str, str2);
        a.a("retry_count", i);
        if (exception != null) {
            a.a("exception", exception);
        }
        this.f8848a.a(a);
    }

    private static HoneyClientEvent m9203a(String str, MediaResource mediaResource) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(str);
        honeyClientEvent.c = "two_phase_send";
        honeyClientEvent.b("offline_threading_id", mediaResource.m);
        honeyClientEvent.a("media_type", mediaResource.d);
        honeyClientEvent.b("attachment_id", mediaResource.c.getLastPathSegment());
        return honeyClientEvent;
    }

    private static HoneyClientEvent m9204a(String str, String str2, String str3) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(str);
        honeyClientEvent.c = "two_phase_send";
        honeyClientEvent.b("offline_threading_id", str2);
        honeyClientEvent.b("message_id", str3);
        return honeyClientEvent;
    }

    private long m9207c(MediaResource mediaResource) {
        Stopwatch stopwatch = (Stopwatch) this.f8849b.a(mediaResource);
        if (stopwatch == null) {
            return 0;
        }
        stopwatch.stop();
        this.f8849b.b(mediaResource);
        return stopwatch.elapsed(TimeUnit.MILLISECONDS);
    }
}
