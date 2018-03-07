package com.facebook.push.mqtt;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: spherical_projection_type */
public class Boolean_IsDeltaSentMessageEnabledGatekeeperAutoProvider extends AbstractProvider<Boolean> {
    private static Boolean m6351b(InjectorLike injectorLike) {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(injectorLike).a(136, false));
    }

    public Object get() {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(this).a(136, false));
    }
}
