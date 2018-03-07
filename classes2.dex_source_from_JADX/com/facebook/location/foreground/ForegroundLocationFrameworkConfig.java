package com.facebook.location.foreground;

import com.facebook.common.util.StringLocaleUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.xconfig.core.XConfigReader;
import com.facebook.xconfig.core.XConfigSetting;
import com.google.common.annotations.VisibleForTesting;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: mInnerView= */
public class ForegroundLocationFrameworkConfig {
    private static volatile ForegroundLocationFrameworkConfig f15543c;
    private final QeAccessor f15544a;
    private final XConfigReader f15545b;

    public static com.facebook.location.foreground.ForegroundLocationFrameworkConfig m22169a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f15543c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.location.foreground.ForegroundLocationFrameworkConfig.class;
        monitor-enter(r1);
        r0 = f15543c;	 Catch:{ all -> 0x003a }
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
        r0 = m22172b(r0);	 Catch:{ all -> 0x0035 }
        f15543c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f15543c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.location.foreground.ForegroundLocationFrameworkConfig.a(com.facebook.inject.InjectorLike):com.facebook.location.foreground.ForegroundLocationFrameworkConfig");
    }

    private static ForegroundLocationFrameworkConfig m22172b(InjectorLike injectorLike) {
        return new ForegroundLocationFrameworkConfig(QeInternalImplMethodAutoProvider.m3744a(injectorLike), XConfigReader.m2681a(injectorLike));
    }

    @Inject
    public ForegroundLocationFrameworkConfig(QeAccessor qeAccessor, XConfigReader xConfigReader) {
        this.f15544a = qeAccessor;
        this.f15545b = xConfigReader;
    }

    public final long m22173a() {
        return m22168a(ExperimentsForForegroundLocationModule.f15225d, ForegroundLocationFrameworkXConfig.f15620d, 5000);
    }

    public final long m22174b() {
        return m22168a(ExperimentsForForegroundLocationModule.f15223b, ForegroundLocationFrameworkXConfig.f15621e, 5000);
    }

    public final float m22175c() {
        return m22166a(ExperimentsForForegroundLocationModule.f15222a, ForegroundLocationFrameworkXConfig.f15622f, 50);
    }

    public final long m22176d() {
        return m22168a(ExperimentsForForegroundLocationModule.f15226e, ForegroundLocationFrameworkXConfig.f15619c, 300000);
    }

    public final long m22177e() {
        return m22168a(ExperimentsForForegroundLocationModule.f15227f, ForegroundLocationFrameworkXConfig.f15623g, 5000);
    }

    public final int m22178f() {
        return m22167a(ExperimentsForForegroundLocationModule.f15234m, ForegroundLocationFrameworkXConfig.f15624h, -100);
    }

    public final int m22179g() {
        return m22167a(ExperimentsForForegroundLocationModule.f15233l, ForegroundLocationFrameworkXConfig.f15625i, 30);
    }

    public final boolean m22180h() {
        return m22171a(ExperimentsForForegroundLocationModule.f15232k, ForegroundLocationFrameworkXConfig.f15626j, false);
    }

    public final ForegroundLocationFrameworkSignalScenario m22181i() {
        return m22170a(ExperimentsForForegroundLocationModule.f15228g, ForegroundLocationFrameworkXConfig.f15627k, ForegroundLocationFrameworkSignalScenario.MEDIUM_POWER);
    }

    public final ForegroundLocationFrameworkSignalScenario m22182j() {
        return m22170a(ExperimentsForForegroundLocationModule.f15231j, ForegroundLocationFrameworkXConfig.f15628l, ForegroundLocationFrameworkSignalScenario.MEDIUM_POWER);
    }

    public final ForegroundLocationFrameworkSignalScenario m22183k() {
        return m22170a(ExperimentsForForegroundLocationModule.f15229h, ForegroundLocationFrameworkXConfig.f15629m, ForegroundLocationFrameworkSignalScenario.MEDIUM_POWER);
    }

    public final ForegroundLocationFrameworkSignalScenario m22184l() {
        return m22170a(ExperimentsForForegroundLocationModule.f15230i, ForegroundLocationFrameworkXConfig.f15630n, ForegroundLocationFrameworkSignalScenario.MEDIUM_POWER);
    }

    @VisibleForTesting
    private int m22167a(int i, XConfigSetting xConfigSetting, int i2) {
        return this.f15544a.mo572a(i, this.f15545b.m2683a(xConfigSetting, i2));
    }

    @VisibleForTesting
    private long m22168a(long j, XConfigSetting xConfigSetting, long j2) {
        return this.f15544a.mo575a(j, this.f15545b.m2684a(xConfigSetting, j2));
    }

    @VisibleForTesting
    private float m22166a(float f, XConfigSetting xConfigSetting, int i) {
        return this.f15544a.mo571a(f, (float) this.f15545b.m2683a(xConfigSetting, i));
    }

    @VisibleForTesting
    private boolean m22171a(short s, XConfigSetting xConfigSetting, boolean z) {
        return this.f15544a.mo596a(s, this.f15545b.m2686a(xConfigSetting, z));
    }

    @VisibleForTesting
    private ForegroundLocationFrameworkSignalScenario m22170a(char c, XConfigSetting xConfigSetting, ForegroundLocationFrameworkSignalScenario foregroundLocationFrameworkSignalScenario) {
        String a = this.f15544a.mo581a(c, null);
        if (a == null) {
            a = this.f15545b.m2685a(xConfigSetting, null);
        }
        if (a != null) {
            try {
                foregroundLocationFrameworkSignalScenario = ForegroundLocationFrameworkSignalScenario.valueOf(StringLocaleUtil.m21641b(a));
            } catch (IllegalArgumentException e) {
            }
        }
        return foregroundLocationFrameworkSignalScenario;
    }
}
