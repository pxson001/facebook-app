package com.facebook.video.abtest;

import com.facebook.feed.abtest.ExperimentsForNewsFeedAbTestModule;
import com.facebook.http.observer.ConnectionQuality;
import com.facebook.qe.api.QeAccessor;

/* compiled from: pageInfo */
public class ThrottlingConfig {
    public final boolean f5505a;
    public final int f5506b;
    public final String f5507c;
    public final int f5508d;
    public final int f5509e;
    public final int f5510f;
    public final int f5511g;
    public final int f5512h;
    public final int f5513i;
    public final float f5514j;
    public final boolean f5515k;
    public final boolean f5516l;
    public final boolean f5517m;
    public final int f5518n;
    public final boolean f5519o;
    public final boolean f5520p;
    public final boolean f5521q;
    public final long f5522r;
    public final long f5523s;
    public final ConnectionQuality f5524t;
    public final boolean f5525u;
    public final boolean f5526v;

    public ThrottlingConfig(QeAccessor qeAccessor) {
        this.f5505a = qeAccessor.a(ExperimentsForVideoAbTestModule.o, false);
        this.f5506b = qeAccessor.a(ExperimentsForVideoAbTestModule.y, 512000);
        this.f5507c = qeAccessor.a(ExperimentsForVideoAbTestModule.D, "bandwidth");
        this.f5508d = qeAccessor.a(ExperimentsForVideoAbTestModule.B, 262144);
        this.f5509e = qeAccessor.a(ExperimentsForVideoAbTestModule.x, 262144);
        this.f5510f = qeAccessor.a(ExperimentsForVideoAbTestModule.z, 1048576);
        this.f5511g = qeAccessor.a(ExperimentsForVideoAbTestModule.v, 10);
        this.f5512h = qeAccessor.a(ExperimentsForVideoAbTestModule.w, 2);
        this.f5513i = qeAccessor.a(ExperimentsForVideoAbTestModule.E, 8);
        this.f5514j = qeAccessor.a(ExperimentsForVideoAbTestModule.m, 2.0f);
        this.f5515k = qeAccessor.a(ExperimentsForVideoAbTestModule.t, false);
        this.f5516l = qeAccessor.a(ExperimentsForVideoAbTestModule.s, false);
        this.f5517m = qeAccessor.a(ExperimentsForVideoAbTestModule.q, true);
        this.f5518n = qeAccessor.a(ExperimentsForVideoAbTestModule.F, 15);
        this.f5519o = qeAccessor.a(ExperimentsForVideoAbTestModule.p, false);
        this.f5520p = qeAccessor.a(ExperimentsForVideoAbTestModule.l, true);
        this.f5521q = qeAccessor.a(ExperimentsForVideoAbTestModule.u, false);
        this.f5522r = qeAccessor.a(ExperimentsForVideoAbTestModule.A, 5000);
        this.f5523s = qeAccessor.a(ExperimentsForVideoAbTestModule.n, 4096);
        this.f5524t = (ConnectionQuality) m5956a(ConnectionQuality.class, qeAccessor.a(ExperimentsForVideoAbTestModule.C, "GOOD"), ConnectionQuality.GOOD);
        this.f5525u = qeAccessor.a(ExperimentsForVideoAbTestModule.r, false);
        this.f5526v = qeAccessor.a(ExperimentsForNewsFeedAbTestModule.k, false);
    }

    private static <T extends Enum<T>> T m5956a(Class<T> cls, String str, T t) {
        try {
            t = Enum.valueOf(cls, str);
        } catch (IllegalArgumentException e) {
        }
        return t;
    }
}
