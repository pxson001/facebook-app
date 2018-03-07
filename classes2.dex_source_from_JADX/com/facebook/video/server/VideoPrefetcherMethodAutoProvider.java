package com.facebook.video.server;

import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.BaseBackgroundWorkLogger;
import com.facebook.common.executors.C0055x2995691a;
import com.facebook.common.executors.ConstrainedExecutorsStatusController;
import com.facebook.common.executors.Handler_ForNonUiThreadMethodAutoProvider;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.device.DeviceConditionHelper;
import com.facebook.http.common.FbHttpRequestProcessor;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.sequencelogger.SequenceLoggerImpl;
import com.facebook.video.abtest.VideoPrefetchExperimentHelper;
import com.facebook.video.exoserviceclient.ExoServiceClientMethodAutoProvider;
import com.facebook.video.server.prefetcher.VideoPrefetcher;
import com.facebook.zero.FbZeroFeatureVisibilityHelper;

/* compiled from: offline_mode_queue_processing_finished */
public class VideoPrefetcherMethodAutoProvider extends AbstractProvider<VideoPrefetcher> {
    private static volatile VideoPrefetcher f11380a;

    public static com.facebook.video.server.prefetcher.VideoPrefetcher m16673a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f11380a;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.video.server.VideoPrefetcherMethodAutoProvider.class;
        monitor-enter(r1);
        r0 = f11380a;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m16674b(r0);	 Catch:{ all -> 0x0035 }
        f11380a = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f11380a;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.video.server.VideoPrefetcherMethodAutoProvider.a(com.facebook.inject.InjectorLike):com.facebook.video.server.prefetcher.VideoPrefetcher");
    }

    public /* synthetic */ Object get() {
        return m16672a();
    }

    private VideoPrefetcher m16672a() {
        return VideoServerModule.m13965a(PartialFileStorage_VideoCacheMethodAutoProvider.m16675a(this), VideoPrefetchModelMethodAutoProvider.m14810a(this), C0055x2995691a.m1881a(this), FbErrorReporterImpl.m2317a((InjectorLike) this), DeviceConditionHelper.m5526a((InjectorLike) this), VideoPrefetchExperimentHelper.m16698a(this), IdBasedProvider.m1811a(this, 3959), FbZeroFeatureVisibilityHelper.m7916a((InjectorLike) this), FbHttpRequestProcessor.m12260a((InjectorLike) this), Handler_ForNonUiThreadMethodAutoProvider.m5522a(this), VideoKeyCreatorMethodAutoProvider.m16710a(this), BaseBackgroundWorkLogger.m1660a((InjectorLike) this), IdBasedSingletonScopeProvider.m1810b(this, 3645), SequenceLoggerImpl.m3464a((InjectorLike) this), AwakeTimeSinceBootClockMethodAutoProvider.m1697a(this), ConstrainedExecutorsStatusController.m1909a(this), LoggedInUserSessionManager.m2511a((InjectorLike) this), FbObjectMapperMethodAutoProvider.m6609a(this), ExoServiceClientMethodAutoProvider.m14000a(this), TimeoutStreamHelper.m16713a((InjectorLike) this));
    }

    private static VideoPrefetcher m16674b(InjectorLike injectorLike) {
        return VideoServerModule.m13965a(PartialFileStorage_VideoCacheMethodAutoProvider.m16675a(injectorLike), VideoPrefetchModelMethodAutoProvider.m14810a(injectorLike), C0055x2995691a.m1881a(injectorLike), FbErrorReporterImpl.m2317a(injectorLike), DeviceConditionHelper.m5526a(injectorLike), VideoPrefetchExperimentHelper.m16698a(injectorLike), IdBasedProvider.m1811a(injectorLike, 3959), FbZeroFeatureVisibilityHelper.m7916a(injectorLike), FbHttpRequestProcessor.m12260a(injectorLike), Handler_ForNonUiThreadMethodAutoProvider.m5522a(injectorLike), VideoKeyCreatorMethodAutoProvider.m16710a(injectorLike), BaseBackgroundWorkLogger.m1660a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 3645), SequenceLoggerImpl.m3464a(injectorLike), AwakeTimeSinceBootClockMethodAutoProvider.m1697a(injectorLike), ConstrainedExecutorsStatusController.m1909a(injectorLike), LoggedInUserSessionManager.m2511a(injectorLike), FbObjectMapperMethodAutoProvider.m6609a(injectorLike), ExoServiceClientMethodAutoProvider.m14000a(injectorLike), TimeoutStreamHelper.m16713a(injectorLike));
    }
}
