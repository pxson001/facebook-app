package com.facebook.video.abtest;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.http.observer.ConnectionQuality;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.video.videohome.abtest.ExperimentsForVideoHomeAbTestModule;
import com.facebook.video.videohome.abtest.VideoHomeConfig;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: presence */
public class VideoLivePlaybackConfig {
    private static volatile VideoLivePlaybackConfig ae;
    public final int f9097A;
    public final int f9098B;
    public final int f9099C;
    public final boolean f9100D;
    public final boolean f9101E;
    public final boolean f9102F;
    public final boolean f9103G;
    public final boolean f9104H;
    public final boolean f9105I;
    public final int f9106J;
    public final int f9107K;
    public final int f9108L;
    public final int f9109M;
    public final boolean f9110N;
    public final boolean f9111O;
    public final boolean f9112P;
    public final boolean f9113Q;
    public final boolean f9114R;
    public final long f9115S;
    public final int f9116T;
    public final boolean f9117U;
    public final boolean f9118V;
    public final int f9119W;
    public final int f9120X;
    public final boolean f9121Y;
    public final long f9122Z;
    public final boolean f9123a;
    public final boolean aa;
    public final int ab;
    public final int ac;
    public final boolean ad;
    public final boolean f9124b;
    public final boolean f9125c;
    public final boolean f9126d;
    public final boolean f9127e;
    public final boolean f9128f;
    public final boolean f9129g;
    public final int f9130h;
    public final ConnectionQuality f9131i;
    public final ConnectionQuality f9132j;
    public final boolean f9133k;
    public final boolean f9134l;
    public final boolean f9135m;
    public final boolean f9136n;
    public final boolean f9137o;
    public final boolean f9138p;
    public final boolean f9139q;
    public final boolean f9140r;
    public final boolean f9141s;
    public final int f9142t;
    public final int f9143u;
    public final boolean f9144v;
    public final boolean f9145w;
    public final boolean f9146x;
    public final boolean f9147y;
    public final int f9148z;

    public static com.facebook.video.abtest.VideoLivePlaybackConfig m14002a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = ae;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.video.abtest.VideoLivePlaybackConfig.class;
        monitor-enter(r1);
        r0 = ae;	 Catch:{ all -> 0x003a }
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
        r0 = m14004b(r0);	 Catch:{ all -> 0x0035 }
        ae = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = ae;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.video.abtest.VideoLivePlaybackConfig.a(com.facebook.inject.InjectorLike):com.facebook.video.abtest.VideoLivePlaybackConfig");
    }

    private static VideoLivePlaybackConfig m14004b(InjectorLike injectorLike) {
        return new VideoLivePlaybackConfig(QeInternalImplMethodAutoProvider.m3744a(injectorLike), GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike), VideoHomeConfig.m14005a(injectorLike));
    }

    @Inject
    public VideoLivePlaybackConfig(QeAccessor qeAccessor, GatekeeperStoreImpl gatekeeperStoreImpl, VideoHomeConfig videoHomeConfig) {
        boolean z;
        int i;
        this.f9103G = gatekeeperStoreImpl.m2189a(486, false);
        boolean a = gatekeeperStoreImpl.m2189a(485, false);
        boolean a2 = gatekeeperStoreImpl.m2189a(483, false);
        boolean z2 = qeAccessor.mo596a(ExperimentsForVideoHomeAbTestModule.f7002p, false) && qeAccessor.mo596a(ExperimentsForVideoAbTestModule.bq, true);
        boolean a3 = qeAccessor.mo596a(ExperimentsForVideoHomeAbTestModule.f6982B, false);
        this.f9123a = qeAccessor.mo596a(ExperimentsForVideoAbTestModule.cs, false);
        if (a3 || !(z2 || qeAccessor.mo596a(ExperimentsForVideoAbTestModule.cm, a))) {
            z = false;
        } else {
            z = true;
        }
        this.f9125c = z;
        if (a3 || !(z2 || qeAccessor.mo596a(ExperimentsForVideoAbTestModule.cq, a))) {
            z = false;
        } else {
            z = true;
        }
        this.f9126d = z;
        if (z2 || qeAccessor.mo596a(ExperimentsForVideoAbTestModule.cn, a)) {
            z = true;
        } else {
            z = false;
        }
        this.f9127e = z;
        if (a3 || qeAccessor.mo596a(ExperimentsForVideoAbTestModule.bW, a2)) {
            z = true;
        } else {
            z = false;
        }
        this.f9128f = z;
        if (z2 || qeAccessor.mo596a(ExperimentsForVideoAbTestModule.bL, a)) {
            z = true;
        } else {
            z = false;
        }
        this.f9129g = z;
        this.f9114R = qeAccessor.mo596a(ExperimentsForVideoAbTestModule.bJ, true);
        this.aa = qeAccessor.mo596a(ExperimentsForVideoAbTestModule.bG, false);
        if (z2 || qeAccessor.mo596a(ExperimentsForVideoAbTestModule.bK, a)) {
            z = true;
        } else {
            z = false;
        }
        this.f9141s = z;
        this.f9130h = qeAccessor.mo572a(ExperimentsForVideoAbTestModule.bu, 6000);
        String a4 = qeAccessor.mo581a(ExperimentsForVideoAbTestModule.bP, ConnectionQuality.GOOD.toString());
        this.f9131i = (ConnectionQuality) m14003a(ConnectionQuality.class, a4, ConnectionQuality.MODERATE);
        this.f9132j = (ConnectionQuality) m14003a(ConnectionQuality.class, qeAccessor.mo581a(ExperimentsForVideoHomeAbTestModule.f6983C, a4), this.f9131i);
        this.f9136n = qeAccessor.mo596a(ExperimentsForVideoAbTestModule.cj, false);
        if (this.f9128f) {
            this.f9133k = qeAccessor.mo596a(ExperimentsForVideoAbTestModule.bz, true);
        } else {
            this.f9133k = false;
        }
        this.f9134l = qeAccessor.mo596a(ExperimentsForVideoAbTestModule.bB, false);
        this.f9135m = qeAccessor.mo596a(ExperimentsForVideoAbTestModule.by, false);
        this.f9138p = qeAccessor.mo596a(ExperimentsForVideoAbTestModule.bo, false);
        if (a3 || qeAccessor.mo596a(ExperimentsForVideoAbTestModule.bA, a2)) {
            z = true;
        } else {
            z = false;
        }
        this.f9139q = z;
        this.f9140r = qeAccessor.mo596a(ExperimentsForVideoAbTestModule.bI, false);
        this.f9142t = qeAccessor.mo572a(ExperimentsForVideoAbTestModule.ci, 20);
        this.f9143u = qeAccessor.mo572a(ExperimentsForVideoAbTestModule.br, this.f9128f ? 5000 : -1);
        a2 = gatekeeperStoreImpl.m2189a(487, false);
        this.f9144v = qeAccessor.mo596a(ExperimentsForVideoAbTestModule.cr, a2);
        this.f9137o = qeAccessor.mo596a(ExperimentsForVideoAbTestModule.bM, false);
        this.f9145w = qeAccessor.mo596a(ExperimentsForVideoAbTestModule.cg, true);
        this.f9146x = qeAccessor.mo596a(ExperimentsForVideoAbTestModule.bY, false);
        this.f9124b = qeAccessor.mo596a(ExperimentsForVideoAbTestModule.bw, !this.f9144v);
        if (z2 || qeAccessor.mo596a(ExperimentsForVideoAbTestModule.cp, a)) {
            z = true;
        } else {
            z = false;
        }
        this.f9147y = z;
        this.f9148z = z2 ? 2000 : qeAccessor.mo572a(ExperimentsForVideoAbTestModule.cc, 2000);
        if (z2) {
            i = 200;
        } else {
            i = qeAccessor.mo572a(ExperimentsForVideoAbTestModule.cd, 200);
        }
        this.f9097A = i;
        this.f9098B = qeAccessor.mo572a(ExperimentsForVideoAbTestModule.ce, 2);
        this.f9099C = qeAccessor.mo572a(ExperimentsForVideoAbTestModule.cf, 15000);
        this.f9100D = qeAccessor.mo596a(ExperimentsForVideoAbTestModule.bF, a2);
        this.f9101E = qeAccessor.mo596a(ExperimentsForVideoAbTestModule.cl, true);
        z = videoHomeConfig.f9157h || qeAccessor.mo596a(ExperimentsForVideoAbTestModule.co, false);
        this.f9102F = z;
        this.f9104H = qeAccessor.mo596a(ExperimentsForVideoAbTestModule.bX, true);
        this.f9105I = qeAccessor.mo596a(ExperimentsForVideoAbTestModule.bp, false);
        this.f9106J = qeAccessor.mo572a(ExperimentsForVideoAbTestModule.bv, 0);
        this.f9107K = qeAccessor.mo572a(ExperimentsForVideoAbTestModule.bt, 30000);
        this.f9108L = qeAccessor.mo572a(ExperimentsForVideoAbTestModule.bS, 0);
        this.f9109M = qeAccessor.mo572a(ExperimentsForVideoAbTestModule.bT, 500);
        this.f9110N = gatekeeperStoreImpl.m2189a(484, false);
        this.f9111O = qeAccessor.mo596a(ExperimentsForVideoAbTestModule.bV, true);
        this.f9112P = qeAccessor.mo596a(ExperimentsForVideoAbTestModule.bx, true);
        this.f9113Q = qeAccessor.mo596a(ExperimentsForVideoAbTestModule.bH, true);
        this.f9115S = (long) qeAccessor.mo572a(ExperimentsForVideoAbTestModule.bs, 0);
        this.f9116T = qeAccessor.mo572a(ExperimentsForVideoAbTestModule.bO, 2);
        this.f9117U = qeAccessor.mo596a(ExperimentsForVideoAbTestModule.ck, false);
        this.f9118V = qeAccessor.mo596a(ExperimentsForVideoAbTestModule.bD, false);
        this.f9119W = qeAccessor.mo572a(ExperimentsForVideoAbTestModule.bU, 1);
        this.f9120X = qeAccessor.mo572a(ExperimentsForVideoAbTestModule.cb, 0);
        this.f9121Y = qeAccessor.mo596a(ExperimentsForVideoAbTestModule.bC, false);
        this.f9122Z = qeAccessor.mo575a(ExperimentsForVideoAbTestModule.bZ, Long.MAX_VALUE);
        this.ab = qeAccessor.mo572a(ExperimentsForVideoAbTestModule.bR, 0);
        this.ac = qeAccessor.mo572a(ExperimentsForVideoAbTestModule.bQ, 6);
        this.ad = qeAccessor.mo596a(ExperimentsForVideoAbTestModule.bN, false);
    }

    private static <T extends Enum<T>> T m14003a(Class<T> cls, String str, T t) {
        if (str != null) {
            try {
                t = Enum.valueOf(cls, str);
            } catch (IllegalArgumentException e) {
            }
        }
        return t;
    }
}
