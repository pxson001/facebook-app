package com.facebook.photos.gating;

import com.facebook.common.util.TriState;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: hide_attribution */
public class TriState_IsSnowflakeBillingEnabledGatekeeperAutoProvider extends AbstractProvider<TriState> {
    private static TriState m20370b(InjectorLike injectorLike) {
        return GatekeeperStoreImplMethodAutoProvider.a(injectorLike).a(816);
    }

    public Object get() {
        return GatekeeperStoreImplMethodAutoProvider.a(this).a(816);
    }
}
