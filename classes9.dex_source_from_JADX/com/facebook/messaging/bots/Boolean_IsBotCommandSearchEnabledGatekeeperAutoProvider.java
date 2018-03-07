package com.facebook.messaging.bots;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: off_incall_duration */
public class Boolean_IsBotCommandSearchEnabledGatekeeperAutoProvider extends AbstractProvider<Boolean> {
    public static Boolean m8575b(InjectorLike injectorLike) {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(injectorLike).a(191, false));
    }

    public Object get() {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(this).a(191, false));
    }

    public static Boolean m8574a(InjectorLike injectorLike) {
        return m8575b(injectorLike);
    }
}
