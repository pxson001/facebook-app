package com.facebook.orca.threadview;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;

/* compiled from: mqtt_send_attempt */
public class Boolean_IsInviteToMessengerPromoEnabledGkGatekeeperAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(this).a(949, false));
    }
}
