package com.facebook.backstage.abtest;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: segment_partition_status */
public class BackstageGatekeepers {
    public final GatekeeperStoreImpl f4264a;

    public static BackstageGatekeepers m4256b(InjectorLike injectorLike) {
        return new BackstageGatekeepers(GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public BackstageGatekeepers(GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f4264a = gatekeeperStoreImpl;
    }

    public final boolean m4257a() {
        return this.f4264a.a(16, false);
    }

    public final boolean m4258b() {
        return this.f4264a.a(15, false);
    }
}
