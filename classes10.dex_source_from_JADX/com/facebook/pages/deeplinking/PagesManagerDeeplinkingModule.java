package com.facebook.pages.deeplinking;

import com.facebook.common.uri.DefaultUriIntentMapper;
import com.facebook.common.uri.UriIntentBuilder;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.pages.deeplinking.uri.PagesManagerRedirect;
import java.util.Set;
import javax.inject.Provider;
import javax.inject.Singleton;

@InjectorModule
/* compiled from: mErrorMsg */
public class PagesManagerDeeplinkingModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @Singleton
    @PagesManagerRedirect
    static DefaultUriIntentMapper m8329a(Provider<Set<UriIntentBuilder>> provider) {
        return new DefaultUriIntentMapper(provider);
    }
}
