package com.facebook.push.mqtt;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: spherical */
public class Boolean_IsHappyEyeballsEnabledGatekeeperAutoProvider extends AbstractProvider<Boolean> {
    private static Boolean m6352b(InjectorLike injectorLike) {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(injectorLike).a(370, false));
    }

    public Object get() {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(this).a(370, false));
    }
}
