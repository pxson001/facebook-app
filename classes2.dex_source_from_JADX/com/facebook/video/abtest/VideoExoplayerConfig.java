package com.facebook.video.abtest;

import android.os.Build.VERSION;
import com.facebook.common.util.TriState;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: response_server_quality */
public class VideoExoplayerConfig {
    public static final List<Integer> f6900a = ImmutableList.of(Integer.valueOf(50), Integer.valueOf(100), Integer.valueOf(200));
    public final boolean f6901A;
    public final boolean f6902B;
    public final int f6903C;
    public final boolean f6904D;
    public final boolean f6905E;
    public final boolean f6906F;
    public final boolean f6907G;
    public final boolean f6908H;
    public final boolean f6909I;
    public final boolean f6910J;
    public final boolean f6911K;
    public final int f6912L;
    private final GatekeeperStoreImpl f6913M;
    private final QeAccessor f6914N;
    public final SourceType f6915b;
    public final int f6916c;
    public int f6917d;
    public boolean f6918e;
    public boolean f6919f;
    public boolean f6920g;
    public boolean f6921h;
    public boolean f6922i;
    public boolean f6923j;
    public final int f6924k;
    public final int f6925l;
    public final int f6926m;
    public final int f6927n;
    public final int f6928o;
    public final int f6929p;
    public boolean f6930q;
    public final int f6931r;
    public boolean f6932s;
    public final boolean f6933t;
    public final boolean f6934u;
    public final boolean f6935v;
    public final boolean f6936w;
    public final boolean f6937x;
    public final int f6938y;
    public final int f6939z;

    public static VideoExoplayerConfig m11519b(InjectorLike injectorLike) {
        return new VideoExoplayerConfig(QeInternalImplMethodAutoProvider.m3744a(injectorLike), GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike));
    }

    public static VideoExoplayerConfig m11518a(InjectorLike injectorLike) {
        return m11519b(injectorLike);
    }

    @Inject
    public VideoExoplayerConfig(QeAccessor qeAccessor, GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f6913M = gatekeeperStoreImpl;
        this.f6914N = qeAccessor;
        this.f6915b = SourceType.of(qeAccessor.mo581a(ExperimentsForVideoAbTestModule.dx, (gatekeeperStoreImpl.m2189a(490, false) ? SourceType.HTTP_1RT_INTERCEPTING : SourceType.HTTP).toString()));
        this.f6917d = qeAccessor.mo572a(ExperimentsForVideoAbTestModule.di, 0);
        this.f6916c = qeAccessor.mo572a(ExperimentsForVideoAbTestModule.dI, 500);
        this.f6918e = qeAccessor.mo596a(ExperimentsForVideoAbTestModule.dd, true);
        this.f6919f = qeAccessor.mo596a(ExperimentsForVideoAbTestModule.dc, true);
        this.f6920g = qeAccessor.mo596a(ExperimentsForVideoAbTestModule.dH, false);
        this.f6921h = qeAccessor.mo596a(ExperimentsForVideoAbTestModule.dR, true);
        this.f6922i = qeAccessor.mo596a(ExperimentsForVideoAbTestModule.dQ, true);
        this.f6923j = qeAccessor.mo596a(ExperimentsForVideoAbTestModule.df, true);
        this.f6924k = qeAccessor.mo572a(ExperimentsForVideoAbTestModule.dy, 262144);
        this.f6925l = qeAccessor.mo572a(ExperimentsForVideoAbTestModule.dz, 64);
        this.f6926m = qeAccessor.mo572a(ExperimentsForVideoAbTestModule.dj, 65536);
        this.f6927n = qeAccessor.mo572a(ExperimentsForVideoAbTestModule.dk, 32);
        this.f6928o = qeAccessor.mo572a(ExperimentsForVideoAbTestModule.dB, 250);
        this.f6929p = qeAccessor.mo572a(ExperimentsForVideoAbTestModule.dC, 2000);
        this.f6930q = qeAccessor.mo596a(ExperimentsForVideoAbTestModule.dS, false);
        this.f6931r = qeAccessor.mo572a(ExperimentsForVideoAbTestModule.dO, 20480);
        this.f6932s = qeAccessor.mo596a(ExperimentsForVideoAbTestModule.dm, true);
        this.f6933t = qeAccessor.mo596a(ExperimentsForVideoAbTestModule.dt, true);
        this.f6934u = qeAccessor.mo596a(ExperimentsForVideoAbTestModule.ds, false);
        this.f6935v = qeAccessor.mo596a(ExperimentsForVideoAbTestModule.dp, false);
        this.f6936w = qeAccessor.mo596a(ExperimentsForVideoAbTestModule.du, true);
        this.f6937x = qeAccessor.mo596a(ExperimentsForVideoAbTestModule.dw, true);
        this.f6938y = qeAccessor.mo572a(ExperimentsForVideoAbTestModule.dG, 1);
        this.f6939z = qeAccessor.mo572a(ExperimentsForVideoAbTestModule.dE, 1);
        this.f6901A = qeAccessor.mo596a(ExperimentsForVideoAbTestModule.dA, true);
        this.f6902B = qeAccessor.mo596a(ExperimentsForVideoAbTestModule.dK, true);
        this.f6903C = qeAccessor.mo572a(ExperimentsForVideoAbTestModule.dJ, 1);
        this.f6904D = qeAccessor.mo596a(ExperimentsForVideoAbTestModule.dL, true);
        this.f6905E = qeAccessor.mo596a(ExperimentsForVideoAbTestModule.dr, false);
        this.f6906F = qeAccessor.mo596a(ExperimentsForVideoAbTestModule.dq, false);
        this.f6907G = qeAccessor.mo596a(ExperimentsForVideoAbTestModule.dh, true);
        this.f6908H = qeAccessor.mo596a(ExperimentsForVideoAbTestModule.de, false);
        this.f6909I = qeAccessor.mo596a(ExperimentsForVideoAbTestModule.dT, false);
        this.f6910J = qeAccessor.mo596a(ExperimentsForVideoAbTestModule.dl, true);
        this.f6911K = qeAccessor.mo596a(ExperimentsForVideoAbTestModule.dv, true);
        this.f6912L = qeAccessor.mo572a(ExperimentsForVideoAbTestModule.dg, 60000);
    }

    public final boolean m11520a() {
        boolean z;
        if (!this.f6914N.mo596a(ExperimentsForVideoAbTestModule.dW, this.f6913M.m2185a(854) == TriState.YES)) {
            QeAccessor qeAccessor = this.f6914N;
            short s = ExperimentsForVideoAbTestModule.dV;
            if (this.f6913M.m2185a(846) == TriState.YES) {
                z = true;
            } else {
                z = false;
            }
            if (!qeAccessor.mo596a(s, z)) {
                z = false;
                if (VERSION.SDK_INT >= 16 || !r0) {
                    return false;
                }
                return true;
            }
        }
        z = true;
        if (VERSION.SDK_INT >= 16) {
        }
        return false;
    }

    public final boolean m11521b() {
        boolean z;
        QeAccessor qeAccessor = this.f6914N;
        short s = ExperimentsForVideoAbTestModule.dW;
        if (this.f6913M.m2185a(854) == TriState.YES) {
            z = true;
        } else {
            z = false;
        }
        return m11520a() && qeAccessor.mo596a(s, z);
    }

    public final boolean m11522c() {
        return this.f6913M.m2189a(481, false);
    }

    public static int m11517a(int i) {
        if (i <= f6900a.size()) {
            return ((Integer) f6900a.get(i - 1)).intValue();
        }
        return 100;
    }
}
