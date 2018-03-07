package com.facebook.placetips.bootstrap;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;

/* compiled from: search_sent */
public class Boolean_IsUserPlaceTipsDebugEmployeeGatekeeperAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(this).a(862, false));
    }
}
