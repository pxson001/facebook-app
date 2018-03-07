package com.facebook.video.videohome.abtest;

import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: prepay_fund */
public class VideoHomeConfig {
    private static volatile VideoHomeConfig f9149p;
    public final boolean f9150a;
    public final boolean f9151b;
    public final boolean f9152c;
    public final boolean f9153d;
    public final int f9154e;
    public final boolean f9155f;
    public final boolean f9156g;
    public final boolean f9157h;
    public final long f9158i;
    public final long f9159j;
    public final boolean f9160k;
    public final long f9161l;
    public final String f9162m;
    public final boolean f9163n;
    public final boolean f9164o;

    public static com.facebook.video.videohome.abtest.VideoHomeConfig m14005a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9149p;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.video.videohome.abtest.VideoHomeConfig.class;
        monitor-enter(r1);
        r0 = f9149p;	 Catch:{ all -> 0x003a }
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
        r0 = m14006b(r0);	 Catch:{ all -> 0x0035 }
        f9149p = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9149p;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.video.videohome.abtest.VideoHomeConfig.a(com.facebook.inject.InjectorLike):com.facebook.video.videohome.abtest.VideoHomeConfig");
    }

    private static VideoHomeConfig m14006b(InjectorLike injectorLike) {
        return new VideoHomeConfig(QeInternalImplMethodAutoProvider.m3744a(injectorLike));
    }

    @Inject
    public VideoHomeConfig(QeAccessor qeAccessor) {
        this.f9150a = qeAccessor.mo596a(ExperimentsForVideoHomeAbTestModule.f6985E, false);
        this.f9151b = qeAccessor.mo596a(ExperimentsForVideoHomeAbTestModule.f6991e, false);
        this.f9152c = qeAccessor.mo596a(ExperimentsForVideoHomeAbTestModule.f7010x, false);
        this.f9153d = qeAccessor.mo596a(ExperimentsForVideoHomeAbTestModule.f6990d, false);
        this.f9154e = qeAccessor.mo572a(ExperimentsForVideoHomeAbTestModule.f7005s, 10);
        this.f9155f = qeAccessor.mo596a(ExperimentsForVideoHomeAbTestModule.f6989c, false);
        this.f9156g = qeAccessor.mo596a(ExperimentsForVideoHomeAbTestModule.f7004r, false);
        this.f9157h = qeAccessor.mo596a(ExperimentsForVideoHomeAbTestModule.f6995i, false);
        this.f9158i = qeAccessor.mo575a(ExperimentsForVideoHomeAbTestModule.f7006t, Long.MAX_VALUE);
        this.f9159j = qeAccessor.mo575a(ExperimentsForVideoHomeAbTestModule.f6986F, Long.MAX_VALUE);
        this.f9160k = qeAccessor.mo596a(ExperimentsForVideoHomeAbTestModule.f6993g, false);
        this.f9161l = qeAccessor.mo575a(ExperimentsForVideoHomeAbTestModule.f6988b, 2000);
        this.f9162m = qeAccessor.mo581a(ExperimentsForVideoHomeAbTestModule.f6987a, "badge_enabled");
        this.f9163n = qeAccessor.mo596a(ExperimentsForVideoHomeAbTestModule.f6997k, true);
        this.f9164o = qeAccessor.mo596a(ExperimentsForVideoHomeAbTestModule.f6994h, false);
    }

    public final boolean m14007a() {
        return "badge_enabled".equals(this.f9162m);
    }
}
