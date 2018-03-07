package com.facebook.video.commercialbreak.abtest;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.ExposureLogging;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: prefetchAccessToken */
public class CommercialBreakConfig {
    private static volatile CommercialBreakConfig f4315l;
    public final boolean f4316a;
    public final int f4317b;
    public final int f4318c;
    public final long f4319d;
    public final long f4320e;
    public final long f4321f;
    public final long f4322g;
    public final long f4323h;
    public final boolean f4324i = this.f4326k.a(589, false);
    public final QeAccessor f4325j;
    private final GatekeeperStoreImpl f4326k;

    public static com.facebook.video.commercialbreak.abtest.CommercialBreakConfig m4866a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4315l;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.video.commercialbreak.abtest.CommercialBreakConfig.class;
        monitor-enter(r1);
        r0 = f4315l;	 Catch:{ all -> 0x003a }
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
        r0 = m4867b(r0);	 Catch:{ all -> 0x0035 }
        f4315l = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4315l;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.video.commercialbreak.abtest.CommercialBreakConfig.a(com.facebook.inject.InjectorLike):com.facebook.video.commercialbreak.abtest.CommercialBreakConfig");
    }

    private static CommercialBreakConfig m4867b(InjectorLike injectorLike) {
        return new CommercialBreakConfig((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public CommercialBreakConfig(QeAccessor qeAccessor, GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f4325j = qeAccessor;
        this.f4326k = gatekeeperStoreImpl;
        this.f4316a = qeAccessor.a(Liveness.Live, ExposureLogging.Off, ExperimentsForCommercialBreakAbTestModule.f4329c, false);
        this.f4317b = qeAccessor.a(Liveness.Live, ExposureLogging.Off, ExperimentsForCommercialBreakAbTestModule.f4327a, 200);
        this.f4318c = qeAccessor.a(Liveness.Live, ExposureLogging.Off, ExperimentsForCommercialBreakAbTestModule.f4334h, 10);
        this.f4319d = (long) qeAccessor.a(Liveness.Live, ExposureLogging.Off, ExperimentsForCommercialBreakAbTestModule.f4328b, 2000);
        this.f4320e = (long) qeAccessor.a(Liveness.Live, ExposureLogging.Off, ExperimentsForCommercialBreakAbTestModule.f4330d, 1500);
        this.f4321f = (long) qeAccessor.a(Liveness.Live, ExposureLogging.Off, ExperimentsForCommercialBreakAbTestModule.f4331e, 3000);
        this.f4322g = (long) qeAccessor.a(Liveness.Live, ExposureLogging.Off, ExperimentsForCommercialBreakAbTestModule.f4332f, 5000);
        this.f4323h = (long) qeAccessor.a(Liveness.Live, ExposureLogging.Off, ExperimentsForCommercialBreakAbTestModule.f4333g, 8000);
    }
}
