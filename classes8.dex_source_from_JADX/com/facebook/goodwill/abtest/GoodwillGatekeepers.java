package com.facebook.goodwill.abtest;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: fetch_intermediate_image */
public class GoodwillGatekeepers {
    private final GatekeeperStoreImpl f13433a;

    private static GoodwillGatekeepers m15052b(InjectorLike injectorLike) {
        return new GoodwillGatekeepers(GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public GoodwillGatekeepers(GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f13433a = gatekeeperStoreImpl;
    }
}
