package com.facebook.video.server;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.DataUsageCounters;
import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.BaseBackgroundWorkLogger;
import com.facebook.common.executors.ExecutorService_VideoServerHttpServiceExecutorMethodAutoProvider;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.video.exoserviceclient.ExoServiceClientMethodAutoProvider;

/* compiled from: isTrustedExternalContentProvider */
public class VideoServerMethodAutoProvider extends AbstractProvider<VideoServer> {
    private static volatile VideoServer f19325a;

    public static com.facebook.video.server.VideoServer m26993a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f19325a;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.video.server.VideoServerMethodAutoProvider.class;
        monitor-enter(r1);
        r0 = f19325a;	 Catch:{ all -> 0x003a }
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
        r0 = m26994b(r0);	 Catch:{ all -> 0x0035 }
        f19325a = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f19325a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.video.server.VideoServerMethodAutoProvider.a(com.facebook.inject.InjectorLike):com.facebook.video.server.VideoServer");
    }

    private static VideoServer m26994b(InjectorLike injectorLike) {
        return VideoServerModule.m13960a(AwakeTimeSinceBootClockMethodAutoProvider.m1697a(injectorLike), FbNetworkManager.m3811a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 3645), DataUsageCounters.m2584a(injectorLike), GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike), FbErrorReporterImpl.m2317a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike), BaseBackgroundWorkLogger.m1660a(injectorLike), LoggedInUserSessionManager.m2511a(injectorLike), ExecutorService_VideoServerHttpServiceExecutorMethodAutoProvider.m26995a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 3694), AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike), TimeoutStreamHelper.m16713a(injectorLike), ExoServiceClientMethodAutoProvider.m14000a(injectorLike));
    }

    public Object get() {
        return VideoServerModule.m13960a(AwakeTimeSinceBootClockMethodAutoProvider.m1697a(this), FbNetworkManager.m3811a((InjectorLike) this), IdBasedSingletonScopeProvider.m1810b(this, 3645), DataUsageCounters.m2584a(this), GatekeeperStoreImplMethodAutoProvider.m2131a(this), FbErrorReporterImpl.m2317a((InjectorLike) this), QeInternalImplMethodAutoProvider.m3744a(this), BaseBackgroundWorkLogger.m1660a((InjectorLike) this), LoggedInUserSessionManager.m2511a((InjectorLike) this), ExecutorService_VideoServerHttpServiceExecutorMethodAutoProvider.m26995a(this), IdBasedSingletonScopeProvider.m1810b(this, 3694), AnalyticsLoggerMethodAutoProvider.m3509a(this), TimeoutStreamHelper.m16713a((InjectorLike) this), ExoServiceClientMethodAutoProvider.m14000a(this));
    }
}
