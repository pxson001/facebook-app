package com.facebook.messaging.chatheads.prefs;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;

/* compiled from: is_ticket_sold_out */
public class Boolean_IsChatHeadsPermittedGkGatekeeperAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(this).a(923, false));
    }
}
