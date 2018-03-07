package com.facebook.messaging.cache;

import android.annotation.SuppressLint;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.config.application.Product;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.messaging.annotations.IsMessengerSyncEnabled;
import com.facebook.messaging.cache.ThreadsCache.CacheType;

@InjectorModule
/* compiled from: is_initial_reg */
public class MessagingCacheModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @IsMessengerSyncEnabled
    public static Boolean m10388a(Product product) {
        return Boolean.valueOf(product != Product.FB4A);
    }

    @ProviderMethod
    @SuppressLint({"ProviderUsage"})
    @UserScoped
    @FacebookMessages
    static ThreadsCache m10387a(ThreadsCacheProvider threadsCacheProvider) {
        return threadsCacheProvider.m10386a(CacheType.FACEBOOK);
    }

    @ProviderMethod
    @SuppressLint({"ProviderUsage"})
    @SmsMessages
    @UserScoped
    static ThreadsCache m10389b(ThreadsCacheProvider threadsCacheProvider) {
        return threadsCacheProvider.m10386a(CacheType.SMS);
    }

    @ProviderMethod
    @TincanMessages
    @SuppressLint({"ProviderUsage"})
    @UserScoped
    static ThreadsCache m10390c(ThreadsCacheProvider threadsCacheProvider) {
        return threadsCacheProvider.m10386a(CacheType.TINCAN);
    }
}
