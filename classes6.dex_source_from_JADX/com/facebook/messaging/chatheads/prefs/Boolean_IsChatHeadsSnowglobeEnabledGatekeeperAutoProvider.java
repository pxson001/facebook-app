package com.facebook.messaging.chatheads.prefs;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: is_supported_carrier */
public class Boolean_IsChatHeadsSnowglobeEnabledGatekeeperAutoProvider extends AbstractProvider<Boolean> {
    private static Boolean m18907b(InjectorLike injectorLike) {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(injectorLike).a(530, false));
    }

    public Object get() {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(this).a(530, false));
    }
}
