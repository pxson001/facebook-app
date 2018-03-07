package com.facebook.contextual.validation;

import com.facebook.auth.userscope.UserScoped;
import com.facebook.contextual.ContextualResolverImpl;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import javax.inject.Singleton;

@InjectorModule
/* compiled from: sticker_pack_id */
public class ContextualConfigValidationModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @UserScoped
    static ContextualConfigValidationXConfig m1932a() {
        return new ContextualConfigValidationXConfig();
    }

    @ProviderMethod
    @UserScoped
    static ContextualConfigValidation m1931a(ContextualResolverImpl contextualResolverImpl) {
        return new ContextualConfigValidation(contextualResolverImpl);
    }

    @ProviderMethod
    @Singleton
    static BooleanContext m1933b() {
        return new BooleanContext();
    }

    @ProviderMethod
    @Singleton
    static IntegerContext m1934c() {
        return new IntegerContext();
    }

    @ProviderMethod
    @Singleton
    static FloatContext m1935d() {
        return new FloatContext();
    }

    @ProviderMethod
    @Singleton
    static StringContext m1936e() {
        return new StringContext();
    }
}
