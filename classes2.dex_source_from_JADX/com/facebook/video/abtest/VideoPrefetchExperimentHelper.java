package com.facebook.video.abtest;

import android.net.NetworkInfo;
import com.facebook.common.util.TriState;
import com.facebook.device.DeviceConditionHelper;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: offline_mode_operation_dropped_new_app_version_detected */
public class VideoPrefetchExperimentHelper {
    private static volatile VideoPrefetchExperimentHelper f11399n;
    public final boolean f11400a = this.f11406g.mo594a(Liveness.Cached, ExperimentsForVideoAbTestModule.cM, ((TriState) this.f11409j.get()).asBoolean(false));
    public final int f11401b = m16702f();
    public final int f11402c = m16703g();
    public final boolean f11403d = m16706n();
    public final boolean f11404e = m16700c();
    public final boolean f11405f;
    public final QeAccessor f11406g;
    public final VideoExoplayerConfig f11407h;
    public final VideoDashConfig f11408i;
    public final Provider<TriState> f11409j;
    private final DeviceConditionHelper f11410k;
    private Set<String> f11411l = m16701d();
    private final GatekeeperStoreImpl f11412m;

    public static com.facebook.video.abtest.VideoPrefetchExperimentHelper m16698a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f11399n;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.video.abtest.VideoPrefetchExperimentHelper.class;
        monitor-enter(r1);
        r0 = f11399n;	 Catch:{ all -> 0x003a }
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
        r0 = m16699b(r0);	 Catch:{ all -> 0x0035 }
        f11399n = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f11399n;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.video.abtest.VideoPrefetchExperimentHelper.a(com.facebook.inject.InjectorLike):com.facebook.video.abtest.VideoPrefetchExperimentHelper");
    }

    private static VideoPrefetchExperimentHelper m16699b(InjectorLike injectorLike) {
        return new VideoPrefetchExperimentHelper(QeInternalImplMethodAutoProvider.m3744a(injectorLike), IdBasedProvider.m1811a(injectorLike, 808), VideoExoplayerConfig.m11519b(injectorLike), DeviceConditionHelper.m5526a(injectorLike), GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike), VideoDashConfig.m11509a(injectorLike));
    }

    @Inject
    public VideoPrefetchExperimentHelper(QeAccessor qeAccessor, Provider<TriState> provider, VideoExoplayerConfig videoExoplayerConfig, DeviceConditionHelper deviceConditionHelper, GatekeeperStore gatekeeperStore, VideoDashConfig videoDashConfig) {
        this.f11406g = qeAccessor;
        this.f11407h = videoExoplayerConfig;
        this.f11408i = videoDashConfig;
        this.f11409j = provider;
        this.f11410k = deviceConditionHelper;
        this.f11412m = gatekeeperStore;
        this.f11405f = qeAccessor.mo596a(ExperimentsForVideoAbTestModule.cU, false);
    }

    public final boolean m16708a() {
        return m16704l() || m16705m();
    }

    private boolean m16700c() {
        return this.f11406g.mo596a(ExperimentsForVideoAbTestModule.cH, false);
    }

    private Set<String> m16701d() {
        Set<String> hashSet = new HashSet();
        for (String toLowerCase : this.f11406g.mo581a(ExperimentsForVideoAbTestModule.cG, "").split(",")) {
            hashSet.add(toLowerCase.toLowerCase());
        }
        return hashSet;
    }

    private int m16702f() {
        return Math.min(Math.max(this.f11406g.mo573a(Liveness.Cached, ExperimentsForVideoAbTestModule.cT, 1), 1), 8);
    }

    private int m16703g() {
        int a = this.f11406g.mo572a(ExperimentsForVideoAbTestModule.cD, 1000);
        if (this.f11407h.m11520a()) {
            return this.f11406g.mo572a(ExperimentsForVideoAbTestModule.cE, a);
        }
        return a;
    }

    public final BytesToPrefetch m16707a(boolean z, boolean z2) {
        int i;
        int a;
        int i2;
        boolean z3;
        boolean z4 = false;
        if (z2) {
            int a2;
            i = this.f11408i.f6880g;
            a = this.f11406g.mo572a(ExperimentsForVideoAbTestModule.cS, 0);
            if (z) {
                a2 = this.f11406g.mo572a(ExperimentsForVideoAbTestModule.cN, this.f11408i.f6878e);
            } else {
                a2 = this.f11406g.mo572a(ExperimentsForVideoAbTestModule.cO, this.f11408i.f6878e);
            }
            i2 = a2;
            z3 = z;
        } else {
            boolean z5;
            boolean a3;
            if (z) {
                a3 = this.f11406g.mo596a(ExperimentsForVideoAbTestModule.cB, false);
                if (this.f11407h.m11520a()) {
                    a3 = this.f11406g.mo596a(ExperimentsForVideoAbTestModule.cC, a3);
                }
                z5 = a3;
            } else {
                a3 = this.f11406g.mo596a(ExperimentsForVideoAbTestModule.cz, true);
                if (this.f11407h.m11520a()) {
                    a3 = this.f11406g.mo596a(ExperimentsForVideoAbTestModule.cA, a3);
                }
                z5 = a3;
            }
            i = m16703g();
            a = this.f11406g.mo572a(ExperimentsForVideoAbTestModule.cR, 0);
            i2 = z ? this.f11406g.mo572a(ExperimentsForVideoAbTestModule.cQ, 500000) : this.f11406g.mo572a(ExperimentsForVideoAbTestModule.cP, 256000);
            if (z) {
                z4 = m16705m();
                z3 = z5;
            } else {
                z4 = m16704l();
                z3 = z5;
            }
        }
        return new BytesToPrefetch(a, i2, z3, i, z4);
    }

    private boolean m16704l() {
        boolean a = this.f11406g.mo594a(Liveness.Cached, ExperimentsForVideoAbTestModule.cI, false);
        if (this.f11407h.m11520a()) {
            return this.f11406g.mo594a(Liveness.Cached, ExperimentsForVideoAbTestModule.cJ, a);
        }
        return a;
    }

    private boolean m16705m() {
        boolean a = this.f11406g.mo594a(Liveness.Cached, ExperimentsForVideoAbTestModule.cK, false);
        if (this.f11407h.m11520a()) {
            return this.f11406g.mo594a(Liveness.Cached, ExperimentsForVideoAbTestModule.cL, a);
        }
        return a;
    }

    public final boolean m16709b() {
        if (this.f11410k.m5534b()) {
            return true;
        }
        if (!this.f11412m.m2185a(842).asBoolean(false)) {
            return false;
        }
        NetworkInfo c = this.f11410k.m5535c();
        if (c == null || !this.f11411l.contains(c.getSubtypeName().toLowerCase())) {
            return false;
        }
        return true;
    }

    private boolean m16706n() {
        return this.f11406g.mo596a(ExperimentsForVideoAbTestModule.cF, false);
    }
}
