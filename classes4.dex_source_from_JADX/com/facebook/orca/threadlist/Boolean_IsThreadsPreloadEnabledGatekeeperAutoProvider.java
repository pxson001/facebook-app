package com.facebook.orca.threadlist;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;

/* compiled from: getGlobalKillSwitchForContactsUpload */
public class Boolean_IsThreadsPreloadEnabledGatekeeperAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(this).a(292, false));
    }
}
