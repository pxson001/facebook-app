package com.facebook.facecast.abtest;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: suggest_friends */
public class FacecastBroadcasterCommercialBreakConfig {
    private static volatile FacecastBroadcasterCommercialBreakConfig f2798h;
    public final boolean f2799a;
    public final int f2800b;
    public final int f2801c;
    public final int f2802d;
    public final int f2803e;
    public final boolean f2804f;
    public final boolean f2805g;

    public static com.facebook.facecast.abtest.FacecastBroadcasterCommercialBreakConfig m3058a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f2798h;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.facecast.abtest.FacecastBroadcasterCommercialBreakConfig.class;
        monitor-enter(r1);
        r0 = f2798h;	 Catch:{ all -> 0x003a }
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
        r0 = m3059b(r0);	 Catch:{ all -> 0x0035 }
        f2798h = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2798h;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.facecast.abtest.FacecastBroadcasterCommercialBreakConfig.a(com.facebook.inject.InjectorLike):com.facebook.facecast.abtest.FacecastBroadcasterCommercialBreakConfig");
    }

    private static FacecastBroadcasterCommercialBreakConfig m3059b(InjectorLike injectorLike) {
        return new FacecastBroadcasterCommercialBreakConfig((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public FacecastBroadcasterCommercialBreakConfig(QeAccessor qeAccessor, GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f2799a = qeAccessor.a(ExperimentsForFacecastAbtestModule.f2781b, false);
        this.f2800b = qeAccessor.a(ExperimentsForFacecastAbtestModule.f2782c, 7);
        this.f2801c = qeAccessor.a(ExperimentsForFacecastAbtestModule.f2784e, 7);
        this.f2802d = qeAccessor.a(ExperimentsForFacecastAbtestModule.f2783d, 10);
        this.f2803e = qeAccessor.a(ExperimentsForFacecastAbtestModule.f2780a, 19000);
        this.f2804f = gatekeeperStoreImpl.a(752, false);
        this.f2805g = gatekeeperStoreImpl.a(758, false);
    }
}
