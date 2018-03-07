package com.facebook.zero.iptest;

import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.zero.iptest.annotations.IsZeroIPTestsEnabled;

@InjectorModule
/* compiled from: fetch_interstitials */
public class ZeroIPTestModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @IsZeroIPTestsEnabled
    public static Boolean m12190a(GatekeeperStoreImpl gatekeeperStoreImpl) {
        return Boolean.valueOf(gatekeeperStoreImpl.a(67, false));
    }
}
