package com.facebook.messaging.smsbridge.abtest;

import android.os.Build.VERSION;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;

@InjectorModule
/* compiled from: download_time_ms */
public class SmsBridgeAbTestModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @IsSmsBridgeEnabled
    static Boolean m14452a(GatekeeperStoreImpl gatekeeperStoreImpl) {
        boolean z = false;
        if (VERSION.SDK_INT >= 19 && gatekeeperStoreImpl.a(323, false)) {
            z = true;
        }
        return Boolean.valueOf(z);
    }
}
