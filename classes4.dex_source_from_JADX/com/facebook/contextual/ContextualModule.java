package com.facebook.contextual;

import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.api.manager.QeManager;
import com.facebook.xconfig.core.XConfigReader;
import java.util.Set;
import javax.inject.Singleton;

@InjectorModule
/* compiled from: startTime */
public class ContextualModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @Singleton
    static ContextsProviderRegistry m1960a(Set<ContextsProvider> set) {
        return new ContextsProviderRegistryImpl(set);
    }

    @ProviderMethod
    @Singleton
    static ContextualConfigLogger m1962a(AnalyticsLogger analyticsLogger) {
        return new ContextualConfigAnalyticsLogger(analyticsLogger);
    }

    @ProviderMethod
    @UserScoped
    static ContextualConfigFactoryImpl m1961a(ContextsProviderRegistryImpl contextsProviderRegistryImpl, ContextualConfigLogger contextualConfigLogger) {
        return new ContextualConfigFactoryImpl(new BucketMatcherFactoryImpl(), contextsProviderRegistryImpl, contextualConfigLogger);
    }

    @ProviderMethod
    @UserScoped
    static ContextualResolverImpl m1963a(DefaultRawContextualConfigSourceImpl defaultRawContextualConfigSourceImpl, ContextualConfigFactoryImpl contextualConfigFactoryImpl, ContextualConfigLogger contextualConfigLogger) {
        return new ContextualResolverImpl(defaultRawContextualConfigSourceImpl, contextualConfigFactoryImpl, contextualConfigLogger);
    }

    @ProviderMethod
    @UserScoped
    static DefaultRawContextualConfigSourceImpl m1964a(QeAccessor qeAccessor, QeManager qeManager, XConfigReader xConfigReader) {
        return new DefaultRawContextualConfigSourceImpl(qeAccessor, qeManager, xConfigReader);
    }
}
