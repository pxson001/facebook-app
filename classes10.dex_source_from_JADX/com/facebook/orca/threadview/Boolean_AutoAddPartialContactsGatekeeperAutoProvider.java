package com.facebook.orca.threadview;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;

/* compiled from: msg_count DESC LIMIT 20 */
public class Boolean_AutoAddPartialContactsGatekeeperAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(this).a(162, false));
    }
}
