package com.facebook.push.mqtt;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: source_width */
public class Boolean_MqttCombineConnectSubGatekeeperGatekeeperAutoProvider extends AbstractProvider<Boolean> {
    private static Boolean m6359b(InjectorLike injectorLike) {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(injectorLike).a(352, false));
    }

    public Object get() {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(this).a(352, false));
    }
}
