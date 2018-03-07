package com.facebook.push.externalcloud;

import com.facebook.common.util.TriState;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.push.externalcloud.annotations.IsPreRegPushTokenRegistrationEnabled;
import javax.inject.Singleton;

@InjectorModule
/* compiled from: ignore_duplicate */
public class ExternalCloudPushModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @Singleton
    @IsPreRegPushTokenRegistrationEnabled
    static TriState m11056a(GatekeeperStoreImpl gatekeeperStoreImpl) {
        return gatekeeperStoreImpl.a(31);
    }
}
