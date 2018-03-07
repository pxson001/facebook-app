package com.facebook.gk.internal;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperWriter;
import com.facebook.inject.AbstractProvider;

/* compiled from: zero_rating_shown */
public class RemoveGatekeepersFbSharedPrefsUpgradeStepMethodAutoProvider extends AbstractProvider<RemoveGatekeepersFbSharedPrefsUpgradeStep> {
    public Object get() {
        return GkInternalModule.m34b((GatekeeperWriter) GatekeeperStoreImplMethodAutoProvider.a(this), GatekeeperStoreImplMethodAutoProvider.a(this));
    }
}
