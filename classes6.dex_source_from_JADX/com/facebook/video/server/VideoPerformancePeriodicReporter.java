package com.facebook.video.server;

import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.analytics.logger.IAnalyticsPeriodicEventReporter;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.video.analytics.VideoPerformanceTracking;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: comment_id */
public class VideoPerformancePeriodicReporter implements IAnalyticsPeriodicEventReporter {
    private static volatile VideoPerformancePeriodicReporter f19548b;
    private final Lazy<VideoPerformanceTracking> f19549a;

    public static com.facebook.video.server.VideoPerformancePeriodicReporter m28268a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f19548b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.video.server.VideoPerformancePeriodicReporter.class;
        monitor-enter(r1);
        r0 = f19548b;	 Catch:{ all -> 0x003a }
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
        r0 = m28269b(r0);	 Catch:{ all -> 0x0035 }
        f19548b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f19548b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.video.server.VideoPerformancePeriodicReporter.a(com.facebook.inject.InjectorLike):com.facebook.video.server.VideoPerformancePeriodicReporter");
    }

    private static VideoPerformancePeriodicReporter m28269b(InjectorLike injectorLike) {
        return new VideoPerformancePeriodicReporter(IdBasedSingletonScopeProvider.b(injectorLike, 3645));
    }

    @Inject
    public VideoPerformancePeriodicReporter(Lazy<VideoPerformanceTracking> lazy) {
        this.f19549a = lazy;
    }

    public final HoneyAnalyticsEvent m28270a(long j, String str) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("video_daily_data_usage");
        honeyClientEvent.e = j;
        honeyClientEvent.f = str;
        ((VideoPerformanceTracking) this.f19549a.get()).a(honeyClientEvent);
        return honeyClientEvent;
    }
}
