package com.facebook.push.mqtt;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: speedTestTimeoutSeconds */
public class Boolean_IsMqttPublishArriveFastPathEnabledGatekeeperAutoProvider extends AbstractProvider<Boolean> {
    private static Boolean m6355b(InjectorLike injectorLike) {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(injectorLike).a(361, false));
    }

    public Object get() {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(this).a(361, false));
    }
}
