package com.facebook.orca.contacts;

import com.facebook.common.util.TriState;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: onion_orbot_available */
public class TriState_IsNewUserNotificationsAvailableGatekeeperAutoProvider extends AbstractProvider<TriState> {
    private static TriState m5477b(InjectorLike injectorLike) {
        return GatekeeperStoreImplMethodAutoProvider.a(injectorLike).a(954);
    }

    public Object get() {
        return GatekeeperStoreImplMethodAutoProvider.a(this).a(954);
    }
}
