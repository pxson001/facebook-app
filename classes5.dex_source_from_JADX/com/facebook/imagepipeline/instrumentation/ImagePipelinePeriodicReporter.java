package com.facebook.imagepipeline.instrumentation;

import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.analytics.logger.IAnalyticsPeriodicEventReporter;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: TRAFFIC_SCHOOL */
public class ImagePipelinePeriodicReporter implements IAnalyticsPeriodicEventReporter {
    private static volatile ImagePipelinePeriodicReporter f13704e;
    private final DefaultImageCacheStatsTracker f13705a;
    private final Provider<FbPoolStatsTracker> f13706b;
    private final Provider<FbPoolStatsTracker> f13707c;
    private final Provider<FbPoolStatsTracker> f13708d;

    public static com.facebook.imagepipeline.instrumentation.ImagePipelinePeriodicReporter m23044a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f13704e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.imagepipeline.instrumentation.ImagePipelinePeriodicReporter.class;
        monitor-enter(r1);
        r0 = f13704e;	 Catch:{ all -> 0x003a }
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
        r0 = m23045b(r0);	 Catch:{ all -> 0x0035 }
        f13704e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f13704e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.instrumentation.ImagePipelinePeriodicReporter.a(com.facebook.inject.InjectorLike):com.facebook.imagepipeline.instrumentation.ImagePipelinePeriodicReporter");
    }

    private static ImagePipelinePeriodicReporter m23045b(InjectorLike injectorLike) {
        return new ImagePipelinePeriodicReporter(DefaultImageCacheStatsTracker.a(injectorLike), IdBasedSingletonScopeProvider.a(injectorLike, 2315), IdBasedSingletonScopeProvider.a(injectorLike, 2316), IdBasedSingletonScopeProvider.a(injectorLike, 2314));
    }

    @Inject
    public ImagePipelinePeriodicReporter(DefaultImageCacheStatsTracker defaultImageCacheStatsTracker, Provider<FbPoolStatsTracker> provider, Provider<FbPoolStatsTracker> provider2, Provider<FbPoolStatsTracker> provider3) {
        this.f13705a = defaultImageCacheStatsTracker;
        this.f13706b = provider;
        this.f13707c = provider2;
        this.f13708d = provider3;
    }

    public final synchronized HoneyAnalyticsEvent m23046a(long j, String str) {
        HoneyClientEvent honeyClientEvent;
        honeyClientEvent = new HoneyClientEvent("image_pipeline_counters");
        this.f13705a.a(honeyClientEvent);
        ((FbPoolStatsTracker) this.f13706b.get()).a(honeyClientEvent);
        ((FbPoolStatsTracker) this.f13707c.get()).a(honeyClientEvent);
        ((FbPoolStatsTracker) this.f13708d.get()).a(honeyClientEvent);
        honeyClientEvent.g("image_pipeline");
        return honeyClientEvent;
    }
}
