package com.facebook.gk.internal;

import com.facebook.gk.sessionless.GatekeeperStoreImpl_SessionlessMethodAutoProvider;
import com.facebook.gk.store.GatekeeperWriter;
import com.facebook.inject.AbstractProvider;

/* compiled from: |tw= */
public class C0001x2a39be7c extends AbstractProvider<RemoveGatekeepersFbSharedPrefsUpgradeStep> {
    public Object get() {
        return GkInternalModule.m31a((GatekeeperWriter) GatekeeperStoreImpl_SessionlessMethodAutoProvider.a(this), GatekeeperStoreImpl_SessionlessMethodAutoProvider.a(this));
    }
}
