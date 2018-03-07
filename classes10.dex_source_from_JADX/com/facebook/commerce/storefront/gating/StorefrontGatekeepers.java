package com.facebook.commerce.storefront.gating;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: cover_image_landscape_size */
public class StorefrontGatekeepers {
    private final GatekeeperStoreImpl f15747a;

    public static StorefrontGatekeepers m16206b(InjectorLike injectorLike) {
        return new StorefrontGatekeepers(GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public StorefrontGatekeepers(GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f15747a = gatekeeperStoreImpl;
    }

    public final boolean m16207a() {
        return this.f15747a.a(39, false);
    }
}
