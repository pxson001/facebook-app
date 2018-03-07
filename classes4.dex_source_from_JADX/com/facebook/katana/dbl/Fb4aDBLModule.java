package com.facebook.katana.dbl;

import com.facebook.common.util.TriState;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.katana.annotations.DeviceBasedLoginKillSwitch;

@InjectorModule
/* compiled from: total_batch_count */
public class Fb4aDBLModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @DeviceBasedLoginKillSwitch
    public static TriState m1232a(GatekeeperStoreImpl gatekeeperStoreImpl) {
        return gatekeeperStoreImpl.a(4);
    }
}
