package com.facebook.messaging.tincan.gatekeepers;

import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: total_mqtt_bytes_sent_foreground */
public class TincanGatekeepers {
    public final GatekeeperStoreImpl f2334a;
    private final Product f2335b;
    private final Boolean f2336c;

    public static TincanGatekeepers m4518b(InjectorLike injectorLike) {
        return new TincanGatekeepers(GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike), ProductMethodAutoProvider.m4524b(injectorLike), Boolean_IsWorkBuildMethodAutoProvider.m4525a(injectorLike));
    }

    @Inject
    public TincanGatekeepers(GatekeeperStoreImpl gatekeeperStoreImpl, Product product, Boolean bool) {
        this.f2334a = gatekeeperStoreImpl;
        this.f2335b = product;
        this.f2336c = bool;
    }

    public final boolean m4519a() {
        return this.f2335b == Product.MESSENGER && !this.f2336c.booleanValue() && this.f2334a.m2189a(339, false);
    }

    public static TincanGatekeepers m4517a(InjectorLike injectorLike) {
        return m4518b(injectorLike);
    }

    public final boolean m4520c() {
        return m4519a() && this.f2334a.m2189a(300, false);
    }

    public final boolean m4521d() {
        return m4519a() && this.f2334a.m2189a(219, false);
    }

    public final boolean m4522e() {
        return m4519a() && this.f2334a.m2189a(340, false);
    }
}
