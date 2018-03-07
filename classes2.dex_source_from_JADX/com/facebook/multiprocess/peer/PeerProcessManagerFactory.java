package com.facebook.multiprocess.peer;

import android.os.HandlerThread;
import com.facebook.auth.event.AuthEventBus;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.HandlerThreadMethodAutoProvider;
import com.facebook.common.process.DefaultProcessUtil;
import com.facebook.common.process.ProcessUtil;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: time_range.timezone */
public class PeerProcessManagerFactory {
    private static volatile PeerProcessManagerFactory f2828g;
    private final Provider<Integer> f2829a;
    private final DefaultProcessUtil f2830b;
    private final AbstractFbErrorReporter f2831c;
    private final HandlerThread f2832d;
    private final Provider<String> f2833e;
    private final AuthEventBus f2834f;

    public static com.facebook.multiprocess.peer.PeerProcessManagerFactory m4834a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f2828g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.multiprocess.peer.PeerProcessManagerFactory.class;
        monitor-enter(r1);
        r0 = f2828g;	 Catch:{ all -> 0x003a }
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
        r0 = m4835b(r0);	 Catch:{ all -> 0x0035 }
        f2828g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2828g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.multiprocess.peer.PeerProcessManagerFactory.a(com.facebook.inject.InjectorLike):com.facebook.multiprocess.peer.PeerProcessManagerFactory");
    }

    private static PeerProcessManagerFactory m4835b(InjectorLike injectorLike) {
        return new PeerProcessManagerFactory(IdBasedProvider.m1811a(injectorLike, 4413), DefaultProcessUtil.m2387a(injectorLike), FbErrorReporterImpl.m2317a(injectorLike), HandlerThreadMethodAutoProvider.m3573a(injectorLike), IdBasedProvider.m1811a(injectorLike, 4442), AuthEventBus.m4563a(injectorLike));
    }

    @Inject
    public PeerProcessManagerFactory(Provider<Integer> provider, ProcessUtil processUtil, FbErrorReporter fbErrorReporter, HandlerThread handlerThread, Provider<String> provider2, AuthEventBus authEventBus) {
        this.f2829a = provider;
        this.f2830b = processUtil;
        this.f2831c = fbErrorReporter;
        this.f2832d = handlerThread;
        this.f2833e = provider2;
        this.f2834f = authEventBus;
    }

    public final PeerProcessManager m4836a(String str, BaseFbBroadcastManager baseFbBroadcastManager, boolean z) {
        return new PeerProcessManagerImpl(str, baseFbBroadcastManager, this.f2829a, this.f2830b, this.f2831c, this.f2834f, this.f2832d, this.f2833e, z);
    }
}
