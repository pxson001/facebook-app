package com.facebook.video.exoserviceclient;

import android.content.Context;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.time.RealtimeSinceBootClockMethodAutoProvider;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.video.abtest.VideoDashConfig;
import com.facebook.video.abtest.VideoExoplayerConfig;
import com.facebook.video.abtest.VideoLivePlaybackConfig;

/* compiled from: presence_unit */
public class ExoServiceClientMethodAutoProvider extends AbstractProvider<ExoServiceClient> {
    private static volatile ExoServiceClient f9096a;

    public static com.facebook.video.exoserviceclient.ExoServiceClient m14000a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9096a;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.video.exoserviceclient.ExoServiceClientMethodAutoProvider.class;
        monitor-enter(r1);
        r0 = f9096a;	 Catch:{ all -> 0x003a }
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
        r0 = m14001b(r0);	 Catch:{ all -> 0x0035 }
        f9096a = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9096a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.video.exoserviceclient.ExoServiceClientMethodAutoProvider.a(com.facebook.inject.InjectorLike):com.facebook.video.exoserviceclient.ExoServiceClient");
    }

    private static ExoServiceClient m14001b(InjectorLike injectorLike) {
        return ExoServiceClientModule.m14008a((Context) injectorLike.getInstance(Context.class), VideoDashConfig.m11509a(injectorLike), VideoExoplayerConfig.m11519b(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike), RealtimeSinceBootClockMethodAutoProvider.m6582a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 494), VideoLivePlaybackConfig.m14002a(injectorLike), LocalFbBroadcastManager.m2946a(injectorLike), FbNetworkManager.m3811a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 584));
    }

    public Object get() {
        return ExoServiceClientModule.m14008a((Context) getInstance(Context.class), VideoDashConfig.m11509a((InjectorLike) this), VideoExoplayerConfig.m11519b(this), QeInternalImplMethodAutoProvider.m3744a(this), RealtimeSinceBootClockMethodAutoProvider.m6582a(this), IdBasedSingletonScopeProvider.m1810b(this, 494), VideoLivePlaybackConfig.m14002a(this), LocalFbBroadcastManager.m2946a((InjectorLike) this), FbNetworkManager.m3811a((InjectorLike) this), IdBasedSingletonScopeProvider.m1810b(this, 584));
    }
}
