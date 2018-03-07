package com.facebook.messaging.business.promotion.gating;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: msgType */
public class BusinessPromotionGatekeepers {
    private final GatekeeperStoreImpl f9048a;

    public static BusinessPromotionGatekeepers m9358b(InjectorLike injectorLike) {
        return new BusinessPromotionGatekeepers(GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public BusinessPromotionGatekeepers(GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f9048a = gatekeeperStoreImpl;
    }

    public final boolean m9359a() {
        return this.f9048a.a(173, false);
    }

    public final boolean m9360b() {
        return this.f9048a.a(261, false);
    }

    public static BusinessPromotionGatekeepers m9357a(InjectorLike injectorLike) {
        return m9358b(injectorLike);
    }
}
