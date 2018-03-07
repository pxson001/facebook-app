package com.facebook.checkin.abtest;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: s_sum */
public class CheckinAbTestGatekeepers {
    public final GatekeeperStoreImpl f6337a;

    public static CheckinAbTestGatekeepers m10687b(InjectorLike injectorLike) {
        return new CheckinAbTestGatekeepers(GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike));
    }

    @Inject
    public CheckinAbTestGatekeepers(GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f6337a = gatekeeperStoreImpl;
    }

    public final boolean m10688a() {
        return this.f6337a.m2189a(30, false);
    }
}
