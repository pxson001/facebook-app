package com.facebook.contacts.omnistore;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: inline_notification_id */
public class Boolean_IsOmnistoreContactsEnabledGatekeeperAutoProvider extends AbstractProvider<Boolean> {
    public static Boolean m10851b(InjectorLike injectorLike) {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(injectorLike).a(273, false));
    }

    public Object get() {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(this).a(273, false));
    }
}
