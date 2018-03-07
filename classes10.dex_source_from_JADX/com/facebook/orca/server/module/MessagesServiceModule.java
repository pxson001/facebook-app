package com.facebook.orca.server.module;

import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.executors.ThreadPriority;
import com.facebook.config.application.Product;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.FilterChainLink;
import com.facebook.fbservice.service.TerminatingHandler;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.messaging.cache.CacheServiceHandler;
import com.facebook.messaging.database.handlers.DbServiceHandler;
import com.facebook.messaging.protocol.WebServiceHandler;
import com.facebook.messaging.sms.SmsServiceHandler;
import com.facebook.messaging.tincan.messenger.annotations.TincanCachingServiceChain;

@InjectorModule
/* compiled from: nearby_places_entry_point */
public class MessagesServiceModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @LowPriorityThreadsQueue
    @UserScoped
    static BlueServiceHandler m6033a(MultiCacheServiceHandler multiCacheServiceHandler) {
        return new FilterChainLink(multiCacheServiceHandler, new TerminatingHandler());
    }

    @ProviderMethod
    @PushQueue
    @UserScoped
    static BlueServiceHandler m6034b(MultiCacheServiceHandler multiCacheServiceHandler) {
        return new FilterChainLink(multiCacheServiceHandler, new TerminatingHandler());
    }

    @ProviderMethod
    @MultiCacheThreadsQueue
    public static ThreadPriority m6029a(Product product) {
        if (product == Product.MESSENGER) {
            return ThreadPriority.URGENT;
        }
        return ThreadPriority.FOREGROUND;
    }

    @ProviderMethod
    @MultiCacheThreadsQueue
    @UserScoped
    static BlueServiceHandler m6035c(MultiCacheServiceHandler multiCacheServiceHandler) {
        return new FilterChainLink(multiCacheServiceHandler, new TerminatingHandler());
    }

    @ProviderMethod
    @FacebookCachingServiceChain
    @UserScoped
    static BlueServiceHandler m6031a(CacheServiceHandler cacheServiceHandler, DbServiceHandler dbServiceHandler, WebServiceHandler webServiceHandler) {
        return new FilterChainLink(cacheServiceHandler, new FilterChainLink(dbServiceHandler, new FilterChainLink(webServiceHandler, new TerminatingHandler())));
    }

    @ProviderMethod
    @UserScoped
    @SmsCachingServiceChain
    static BlueServiceHandler m6032a(CacheServiceHandler cacheServiceHandler, SmsServiceHandler smsServiceHandler) {
        return new FilterChainLink(cacheServiceHandler, new FilterChainLink(smsServiceHandler, new TerminatingHandler()));
    }

    @ProviderMethod
    @UserScoped
    @TincanCachingServiceChain
    static BlueServiceHandler m6030a() {
        return new TerminatingHandler();
    }
}
