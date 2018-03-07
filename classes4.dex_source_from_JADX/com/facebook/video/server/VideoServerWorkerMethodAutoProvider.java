package com.facebook.video.server;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.DataUsageCounters;
import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.ScheduledExecutorService_BackgroundExecutorServiceMethodAutoProvider;
import com.facebook.common.file.StatFsHelperMethodAutoProvider;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.network.FbDataConnectionManager;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.http.common.FbHttpRequestProcessor;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.video.abtest.VideoExoplayerConfig;
import com.fasterxml.jackson.databind.ObjectMapper;

/* compiled from: page_tag */
public class VideoServerWorkerMethodAutoProvider extends AbstractProvider<VideoServer$VideoServerWorker> {
    private static volatile VideoServer$VideoServerWorker f5397a;

    public static com.facebook.video.server.VideoServer$VideoServerWorker m5871a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f5397a;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.video.server.VideoServerWorkerMethodAutoProvider.class;
        monitor-enter(r1);
        r0 = f5397a;	 Catch:{ all -> 0x003a }
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
        r0 = m5872b(r0);	 Catch:{ all -> 0x0035 }
        f5397a = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f5397a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.video.server.VideoServerWorkerMethodAutoProvider.a(com.facebook.inject.InjectorLike):com.facebook.video.server.VideoServer$VideoServerWorker");
    }

    public /* synthetic */ Object get() {
        return m5870a();
    }

    private VideoServer$VideoServerWorker m5870a() {
        return VideoServerModule.a((MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(this), FbNetworkManager.a(this), IdBasedSingletonScopeProvider.b(this, 3645), DataUsageCounters.a(this), PartialFileStorage_VideoCacheMethodAutoProvider.a(this), DefaultAndroidThreadUtil.a(this), ScheduledExecutorService_BackgroundExecutorServiceMethodAutoProvider.a(this), (AbstractFbErrorReporter) FbErrorReporterImpl.a(this), (QeAccessor) QeInternalImplMethodAutoProvider.a(this), FbHttpRequestProcessor.a(this), ThrottlingPolicyFactory.m5874a(this), VideoPlayerSessionManagerMethodAutoProvider.a(this), FbDataConnectionManager.a(this), VideoKeyCreatorMethodAutoProvider.a(this), IdBasedSingletonScopeProvider.b(this, 3698), IdBasedSingletonScopeProvider.a(this, 3635), VideoExoplayerConfig.a(this), StatFsHelperMethodAutoProvider.a(this), AnalyticsLoggerMethodAutoProvider.a(this), LoggedInUserSessionManager.a(this), (ObjectMapper) FbObjectMapperMethodAutoProvider.a(this), TimeoutStreamHelper.a(this));
    }

    private static VideoServer$VideoServerWorker m5872b(InjectorLike injectorLike) {
        return VideoServerModule.a((MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), FbNetworkManager.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 3645), DataUsageCounters.a(injectorLike), PartialFileStorage_VideoCacheMethodAutoProvider.a(injectorLike), DefaultAndroidThreadUtil.a(injectorLike), ScheduledExecutorService_BackgroundExecutorServiceMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), FbHttpRequestProcessor.a(injectorLike), ThrottlingPolicyFactory.m5874a(injectorLike), VideoPlayerSessionManagerMethodAutoProvider.a(injectorLike), FbDataConnectionManager.a(injectorLike), VideoKeyCreatorMethodAutoProvider.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 3698), IdBasedSingletonScopeProvider.a(injectorLike, 3635), VideoExoplayerConfig.a(injectorLike), StatFsHelperMethodAutoProvider.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), LoggedInUserSessionManager.a(injectorLike), (ObjectMapper) FbObjectMapperMethodAutoProvider.a(injectorLike), TimeoutStreamHelper.a(injectorLike));
    }
}
