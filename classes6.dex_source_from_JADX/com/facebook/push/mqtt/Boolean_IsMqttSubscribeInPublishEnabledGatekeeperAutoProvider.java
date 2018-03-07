package com.facebook.push.mqtt;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: southern latitude exceeds northern latitude (%s > %s) */
public class Boolean_IsMqttSubscribeInPublishEnabledGatekeeperAutoProvider extends AbstractProvider<Boolean> {
    private static Boolean m6358b(InjectorLike injectorLike) {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(injectorLike).a(371, false));
    }

    public Object get() {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(this).a(371, false));
    }
}
