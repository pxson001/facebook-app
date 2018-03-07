package com.facebook.orca.notify;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: notificationSettingsDialog */
public class Boolean_IsBadgeTrayNotificationsGkEnabledGatekeeperAutoProvider extends AbstractProvider<Boolean> {
    public static Boolean m5915b(InjectorLike injectorLike) {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(injectorLike).a(918, false));
    }

    public Object get() {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(this).a(918, false));
    }
}
