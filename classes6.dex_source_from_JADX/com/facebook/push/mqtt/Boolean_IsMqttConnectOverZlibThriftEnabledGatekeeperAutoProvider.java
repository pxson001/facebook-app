package com.facebook.push.mqtt;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: speed_test_ui_timeout */
public class Boolean_IsMqttConnectOverZlibThriftEnabledGatekeeperAutoProvider extends AbstractProvider<Boolean> {
    private static Boolean m6353b(InjectorLike injectorLike) {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(injectorLike).a(353, false));
    }

    public Object get() {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(this).a(353, false));
    }
}
