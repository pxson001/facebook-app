package com.facebook.messaging.sync;

import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.messaging.sync.annotations.MessagesSyncApiVersion;
import com.facebook.messaging.sync.annotations.RtcCallInfoDataEnabled;

@InjectorModule
/* compiled from: provided dataItem is null */
public class MessagesSyncModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @MessagesSyncApiVersion
    public static Integer m3896a(GatekeeperStoreImpl gatekeeperStoreImpl) {
        if (gatekeeperStoreImpl.a(263, false)) {
            return Integer.valueOf(9);
        }
        if (gatekeeperStoreImpl.a(262, false)) {
            return Integer.valueOf(8);
        }
        if (gatekeeperStoreImpl.a(950, false)) {
            return Integer.valueOf(7);
        }
        return Integer.valueOf(5);
    }

    @ProviderMethod
    @RtcCallInfoDataEnabled
    public static Boolean m3897b(GatekeeperStoreImpl gatekeeperStoreImpl) {
        boolean z = false;
        if (m3896a(gatekeeperStoreImpl).intValue() >= 9 && gatekeeperStoreImpl.a(1091, false)) {
            z = true;
        }
        return Boolean.valueOf(z);
    }
}
