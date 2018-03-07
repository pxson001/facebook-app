package com.facebook.video.abtest;

import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.qe.api.QeAccessor;

/* compiled from: pending_app_calls. */
public class DirectPlayConfig {
    public final boolean f5257a;
    public final boolean f5258b;
    public final int f5259c;
    public final long f5260d;
    public final int f5261e;
    public final int f5262f;
    public final boolean f5263g;
    public final boolean f5264h;
    public final boolean f5265i;
    public final boolean f5266j;
    public final boolean f5267k;
    public final boolean f5268l;

    public DirectPlayConfig(QeAccessor qeAccessor, GatekeeperStoreImpl gatekeeperStoreImpl) {
        boolean a = gatekeeperStoreImpl.a(488, false);
        boolean a2 = gatekeeperStoreImpl.a(504, false);
        this.f5257a = qeAccessor.a(ExperimentsForVideoAbTestModule.bc, a);
        this.f5258b = qeAccessor.a(ExperimentsForVideoAbTestModule.bd, false);
        this.f5259c = qeAccessor.a(ExperimentsForVideoAbTestModule.bh, 1000);
        this.f5260d = qeAccessor.a(ExperimentsForVideoAbTestModule.bf, 600000);
        this.f5261e = qeAccessor.a(ExperimentsForVideoAbTestModule.bg, 5);
        this.f5262f = qeAccessor.a(ExperimentsForVideoAbTestModule.be, 1048576);
        this.f5263g = qeAccessor.a(ExperimentsForVideoAbTestModule.bl, true);
        this.f5264h = qeAccessor.a(ExperimentsForVideoAbTestModule.bj, false);
        this.f5265i = qeAccessor.a(ExperimentsForVideoAbTestModule.bk, a2);
        this.f5266j = qeAccessor.a(ExperimentsForVideoAbTestModule.bi, true);
        this.f5267k = qeAccessor.a(ExperimentsForVideoAbTestModule.bm, false);
        this.f5268l = qeAccessor.a(ExperimentsForVideoAbTestModule.bn, false);
    }
}
