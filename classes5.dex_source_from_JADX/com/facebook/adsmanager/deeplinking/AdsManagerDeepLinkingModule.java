package com.facebook.adsmanager.deeplinking;

import com.facebook.adsmanager.deeplinking.uri.AdsManagerRedirect;
import com.facebook.common.uri.DefaultUriIntentMapper;
import com.facebook.common.uri.UriIntentBuilder;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import java.util.Set;
import javax.inject.Provider;
import javax.inject.Singleton;

@InjectorModule
/* compiled from: base */
public class AdsManagerDeepLinkingModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @AdsManagerRedirect
    @Singleton
    static DefaultUriIntentMapper m14180a(Provider<Set<UriIntentBuilder>> provider) {
        return new DefaultUriIntentMapper(provider);
    }
}
