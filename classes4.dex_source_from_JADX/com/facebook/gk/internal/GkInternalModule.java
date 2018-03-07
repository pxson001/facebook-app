package com.facebook.gk.internal;

import com.facebook.device_id.UniqueIdForDeviceHolderImpl;
import com.facebook.gk.sessionless.Sessionless;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.gk.store.GatekeeperWriter;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
@InjectorModule
/* compiled from: |th= */
public class GkInternalModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @DeviceIdForGKs
    @ProviderMethod
    public static String m33a(UniqueIdForDeviceHolderImpl uniqueIdForDeviceHolderImpl) {
        return uniqueIdForDeviceHolderImpl.a();
    }

    @ProviderMethod
    @Sessionless
    public static RemoveGatekeepersFbSharedPrefsUpgradeStep m31a(GatekeeperWriter gatekeeperWriter, GatekeeperStoreImpl gatekeeperStoreImpl) {
        return new RemoveGatekeepersFbSharedPrefsUpgradeStep(gatekeeperWriter, gatekeeperStoreImpl, SessionlessGkPrefKeys.f46d, 0);
    }

    @ProviderMethod
    @GkConfigurationFetchPeriodMillis
    public static Long m32a() {
        return Long.valueOf(7200000);
    }

    @ProviderMethod
    public static RemoveGatekeepersFbSharedPrefsUpgradeStep m34b(GatekeeperWriter gatekeeperWriter, GatekeeperStoreImpl gatekeeperStoreImpl) {
        return new RemoveGatekeepersFbSharedPrefsUpgradeStep(gatekeeperWriter, gatekeeperStoreImpl, GkPrefKeys.b, 1);
    }

    @DoNotStrip
    public static GkSessionlessFetcher getInstanceForTest_GkSessionlessFetcher(FbInjector fbInjector) {
        return GkSessionlessFetcher.m1311a((InjectorLike) fbInjector);
    }
}
