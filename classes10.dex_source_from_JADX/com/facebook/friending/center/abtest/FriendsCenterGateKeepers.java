package com.facebook.friending.center.abtest;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.ultralight.Inject;

/* compiled from: all_qrcodes */
public class FriendsCenterGateKeepers {
    public final GatekeeperStoreImpl f19952a;

    public static FriendsCenterGateKeepers m20124b(InjectorLike injectorLike) {
        return new FriendsCenterGateKeepers(GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    private FriendsCenterGateKeepers(GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f19952a = gatekeeperStoreImpl;
    }

    public final boolean m20125b() {
        return this.f19952a.a(669, false);
    }
}
