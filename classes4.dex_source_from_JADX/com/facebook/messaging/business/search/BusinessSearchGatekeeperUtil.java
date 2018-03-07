package com.facebook.messaging.business.search;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: fa_isc_jb_ext_ms */
public class BusinessSearchGatekeeperUtil {
    GatekeeperStoreImpl f12407a;

    public static BusinessSearchGatekeeperUtil m13108b(InjectorLike injectorLike) {
        return new BusinessSearchGatekeeperUtil(GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public BusinessSearchGatekeeperUtil(GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f12407a = gatekeeperStoreImpl;
    }

    public final boolean m13109a() {
        return this.f12407a.a(293, false);
    }

    public final boolean m13110b() {
        return this.f12407a.a(307, false);
    }
}
