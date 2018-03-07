package com.facebook.api.feedcache.omnistore;

import com.facebook.auth.userscope.UserScoped;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.omnistore.CollectionName;
import com.facebook.omnistore.Omnistore;

@InjectorModule
/* compiled from: la_authenticate_approve */
public class OmnistoreUpdateModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @PrivacyUpdateCollection
    @ProviderMethod
    @UserScoped
    static CollectionName m10105a(Omnistore omnistore, String str) {
        return omnistore.createCollectionNameBuilder("fb4a_feed_updates").addSegment(str).addDeviceId().build();
    }

    @ProviderMethod
    @VpvUpdateCollection
    @UserScoped
    static CollectionName m10106b(Omnistore omnistore, String str) {
        return omnistore.createCollectionNameBuilder("fb4a_feed_vpv_updates").addSegment(str).addDeviceId().build();
    }
}
