package com.facebook.orca.notify;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: home_location_prediction */
public class Boolean_IsMessengerAppIconBadgingGkEnabledGatekeeperAutoProvider extends AbstractProvider<Boolean> {
    public static Boolean m11189b(InjectorLike injectorLike) {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(injectorLike).a(156, false));
    }

    public Object get() {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(this).a(156, false));
    }
}
