package com.facebook.omnistore.module;

import com.facebook.auth.userscope.UserScoped;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.omnistore.Omnistore;

@InjectorModule
/* compiled from: last_notifications_sync_new_time */
public class OmnistoreModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @UserScoped
    public static Omnistore provideOmnistore(OmnistoreComponentManager omnistoreComponentManager) {
        return omnistoreComponentManager.getOmnistoreInstanceForLegacyInjection();
    }
}
