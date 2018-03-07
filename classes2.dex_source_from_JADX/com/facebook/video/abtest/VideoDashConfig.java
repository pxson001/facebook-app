package com.facebook.video.abtest;

import com.facebook.device.DeviceConditionHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.xconfig.core.XConfigReader;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: restartLoader in  */
public class VideoDashConfig {
    private static volatile VideoDashConfig f6855S;
    public final int f6856A;
    public final int f6857B;
    public final boolean f6858C;
    public final int f6859D;
    public final int f6860E;
    public final boolean f6861F;
    public final boolean f6862G;
    public final boolean f6863H;
    public final boolean f6864I;
    public final boolean f6865J;
    public final int f6866K;
    public final int f6867L;
    public final float f6868M;
    public final float f6869N;
    public final boolean f6870O;
    public final long f6871P;
    public final boolean f6872Q;
    public final DashNetworkApi f6873R;
    public final String f6874a;
    public final boolean f6875b;
    public final boolean f6876c;
    public final boolean f6877d;
    public final int f6878e;
    public final int f6879f;
    public final int f6880g;
    public final boolean f6881h;
    public final boolean f6882i;
    public final boolean f6883j;
    public final boolean f6884k;
    public final DashAbrPolicy f6885l;
    public final int f6886m;
    public final int f6887n;
    public final int f6888o;
    public final int f6889p;
    public final int f6890q;
    public final int f6891r;
    public final int f6892s;
    public final int f6893t;
    public final int f6894u;
    public final int f6895v;
    public final float f6896w;
    public final boolean f6897x;
    public final boolean f6898y;
    public final int f6899z;

    /* compiled from: restartLoader in  */
    public enum DashAbrPolicy {
        MANUAL,
        CUSTOM_ABR,
        RANDOM_ABR;

        public static DashAbrPolicy of(String str) {
            try {
                return valueOf(str);
            } catch (Throwable th) {
                return MANUAL;
            }
        }
    }

    /* compiled from: restartLoader in  */
    public enum DashNetworkApi {
        BANDWIDTH_METER,
        DATA_CONNECTION_MANAGER,
        NETWORK_INFO;

        public static DashNetworkApi of(String str) {
            try {
                return valueOf(str);
            } catch (Throwable th) {
                return BANDWIDTH_METER;
            }
        }
    }

    public static com.facebook.video.abtest.VideoDashConfig m11509a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f6855S;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.video.abtest.VideoDashConfig.class;
        monitor-enter(r1);
        r0 = f6855S;	 Catch:{ all -> 0x003a }
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
        r0 = m11510b(r0);	 Catch:{ all -> 0x0035 }
        f6855S = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f6855S;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.video.abtest.VideoDashConfig.a(com.facebook.inject.InjectorLike):com.facebook.video.abtest.VideoDashConfig");
    }

    private static VideoDashConfig m11510b(InjectorLike injectorLike) {
        return new VideoDashConfig(QeInternalImplMethodAutoProvider.m3744a(injectorLike), VideoExoplayerConfig.m11519b(injectorLike), XConfigReader.m2681a(injectorLike));
    }

    @Inject
    public VideoDashConfig(QeAccessor qeAccessor, VideoExoplayerConfig videoExoplayerConfig, XConfigReader xConfigReader) {
        boolean z;
        boolean a = videoExoplayerConfig.m11520a();
        this.f6874a = qeAccessor.mo581a(ExperimentsForVideoAbTestModule.aZ, a ? "MPEG_DASH" : "NONE");
        this.f6878e = qeAccessor.mo572a(ExperimentsForVideoAbTestModule.aN, 131072);
        this.f6879f = qeAccessor.mo572a(ExperimentsForVideoAbTestModule.aO, 65536);
        this.f6880g = qeAccessor.mo572a(ExperimentsForVideoAbTestModule.aY, 0);
        if (m11512a() || m11515c()) {
            z = true;
        } else {
            z = false;
        }
        this.f6875b = z;
        this.f6876c = qeAccessor.mo596a(ExperimentsForVideoAbTestModule.av, true);
        this.f6877d = qeAccessor.mo596a(ExperimentsForVideoAbTestModule.aA, "MPEG_DASH".equalsIgnoreCase(this.f6874a));
        this.f6881h = qeAccessor.mo596a(ExperimentsForVideoAbTestModule.aw, true);
        this.f6882i = qeAccessor.mo596a(ExperimentsForVideoAbTestModule.az, a);
        this.f6883j = qeAccessor.mo596a(ExperimentsForVideoAbTestModule.ay, a);
        this.f6884k = qeAccessor.mo596a(ExperimentsForVideoAbTestModule.aG, true);
        this.f6885l = DashAbrPolicy.of(qeAccessor.mo581a(ExperimentsForVideoAbTestModule.au, DashAbrPolicy.CUSTOM_ABR.toString()));
        this.f6886m = qeAccessor.mo572a(ExperimentsForVideoAbTestModule.an, xConfigReader.m2683a(VideoDashXConfig.f6975c, 0));
        this.f6888o = qeAccessor.mo572a(ExperimentsForVideoAbTestModule.ao, this.f6886m);
        this.f6887n = qeAccessor.mo572a(ExperimentsForVideoAbTestModule.ap, xConfigReader.m2683a(VideoDashXConfig.f6976d, 0));
        this.f6889p = qeAccessor.mo572a(ExperimentsForVideoAbTestModule.aq, this.f6887n);
        this.f6890q = qeAccessor.mo572a(ExperimentsForVideoAbTestModule.am, xConfigReader.m2683a(VideoDashXConfig.f6978f, 640));
        this.f6891r = qeAccessor.mo572a(ExperimentsForVideoAbTestModule.al, xConfigReader.m2683a(VideoDashXConfig.f6977e, 426));
        this.f6892s = qeAccessor.mo572a(ExperimentsForVideoAbTestModule.aQ, 50000);
        this.f6893t = qeAccessor.mo572a(ExperimentsForVideoAbTestModule.aU, 10000);
        this.f6894u = qeAccessor.mo572a(ExperimentsForVideoAbTestModule.aP, 25000);
        this.f6895v = qeAccessor.mo572a(ExperimentsForVideoAbTestModule.aV, 25000);
        this.f6896w = qeAccessor.mo571a(ExperimentsForVideoAbTestModule.as, 0.75f);
        this.f6897x = qeAccessor.mo596a(ExperimentsForVideoAbTestModule.ba, false);
        this.f6898y = qeAccessor.mo596a(ExperimentsForVideoAbTestModule.aH, true);
        this.f6899z = qeAccessor.mo572a(ExperimentsForVideoAbTestModule.bb, 200);
        this.f6856A = qeAccessor.mo572a(ExperimentsForVideoAbTestModule.ar, 60);
        this.f6857B = qeAccessor.mo572a(ExperimentsForVideoAbTestModule.at, 65536);
        this.f6858C = qeAccessor.mo596a(ExperimentsForVideoAbTestModule.aK, this.f6885l != DashAbrPolicy.MANUAL);
        this.f6859D = qeAccessor.mo572a(ExperimentsForVideoAbTestModule.aR, 0);
        this.f6860E = qeAccessor.mo572a(ExperimentsForVideoAbTestModule.aS, 0);
        this.f6861F = qeAccessor.mo596a(ExperimentsForVideoAbTestModule.aF, false);
        this.f6862G = qeAccessor.mo596a(ExperimentsForVideoAbTestModule.aD, true);
        this.f6863H = qeAccessor.mo596a(ExperimentsForVideoAbTestModule.aC, true);
        this.f6864I = qeAccessor.mo596a(ExperimentsForVideoAbTestModule.aX, true);
        this.f6865J = qeAccessor.mo596a(ExperimentsForVideoAbTestModule.ax, false);
        this.f6866K = qeAccessor.mo572a(ExperimentsForVideoAbTestModule.aM, 15000);
        this.f6867L = qeAccessor.mo572a(ExperimentsForVideoAbTestModule.aJ, 30000);
        this.f6868M = qeAccessor.mo571a(ExperimentsForVideoAbTestModule.aL, 0.2f);
        this.f6869N = qeAccessor.mo571a(ExperimentsForVideoAbTestModule.aI, 0.8f);
        this.f6870O = qeAccessor.mo596a(ExperimentsForVideoAbTestModule.aB, false);
        this.f6871P = qeAccessor.mo575a(ExperimentsForVideoAbTestModule.aT, 0);
        this.f6872Q = qeAccessor.mo596a(ExperimentsForVideoAbTestModule.aE, qeAccessor.mo596a(ExperimentsForVideoAbTestModule.bW, false));
        this.f6873R = DashNetworkApi.of(qeAccessor.mo581a(ExperimentsForVideoAbTestModule.aW, DashNetworkApi.BANDWIDTH_METER.toString()));
    }

    public final boolean m11512a() {
        return this.f6874a.equals("MPEG_DASH");
    }

    public final boolean m11514b() {
        return m11512a() && this.f6884k;
    }

    public final boolean m11515c() {
        return this.f6874a.equals("WEBM_DASH");
    }

    public final boolean m11513a(DeviceConditionHelper deviceConditionHelper) {
        if (!this.f6883j && !this.f6882i) {
            return false;
        }
        boolean b = deviceConditionHelper.m5534b();
        if ((!b || !this.f6882i) && (b || !this.f6883j)) {
            return false;
        }
        return true;
    }

    public final int m11511a(DeviceConditionHelper deviceConditionHelper, boolean z) {
        return z ? deviceConditionHelper.m5534b() ? this.f6888o : this.f6889p : deviceConditionHelper.m5534b() ? this.f6886m : this.f6887n;
    }

    public final boolean m11516d() {
        return this.f6885l != DashAbrPolicy.MANUAL;
    }
}
