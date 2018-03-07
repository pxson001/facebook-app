package com.facebook.appinvites.module;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;

/* compiled from: ed5444dfb603eaa85b2068cac948b7a8 */
public class Boolean_ArePeerPressureAppInvitesEnabledGatekeeperAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(this).a(841, false));
    }
}
