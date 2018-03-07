package com.facebook.messaging.cache;

import android.annotation.SuppressLint;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProviderMethod;

@InjectorModule
/* compiled from: method/friendFinder.mobilecalllogsync */
public class MessagingCacheHandlersModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @SuppressLint({"ProviderUsage"})
    @UserScoped
    @FacebookMessages
    static CacheServiceHandler m10109a(CacheServiceHandlerProvider cacheServiceHandlerProvider, ThreadsCache threadsCache, CacheFetchThreadsHandler cacheFetchThreadsHandler, Lazy<CacheInsertThreadsHandler> lazy) {
        return cacheServiceHandlerProvider.m10069a("FacebookCacheServiceHandler", threadsCache, cacheFetchThreadsHandler, lazy);
    }

    @ProviderMethod
    @SuppressLint({"ProviderUsage"})
    @UserScoped
    @FacebookMessages
    static CacheFetchThreadsHandler m10107a(CacheFetchThreadsHandlerProvider cacheFetchThreadsHandlerProvider, ThreadsCache threadsCache) {
        return cacheFetchThreadsHandlerProvider.m9909a(threadsCache);
    }

    @ProviderMethod
    @SuppressLint({"ProviderUsage"})
    @UserScoped
    @FacebookMessages
    static CacheInsertThreadsHandler m10108a(CacheInsertThreadsHandlerProvider cacheInsertThreadsHandlerProvider, ThreadsCache threadsCache) {
        return cacheInsertThreadsHandlerProvider.m9941a(threadsCache);
    }

    @ProviderMethod
    @SuppressLint({"ProviderUsage"})
    @SmsMessages
    @UserScoped
    static CacheServiceHandler m10112b(CacheServiceHandlerProvider cacheServiceHandlerProvider, ThreadsCache threadsCache, CacheFetchThreadsHandler cacheFetchThreadsHandler, Lazy<CacheInsertThreadsHandler> lazy) {
        return cacheServiceHandlerProvider.m10069a("SmsCacheServiceHandler", threadsCache, cacheFetchThreadsHandler, lazy);
    }

    @ProviderMethod
    @SuppressLint({"ProviderUsage"})
    @SmsMessages
    @UserScoped
    static CacheFetchThreadsHandler m10110b(CacheFetchThreadsHandlerProvider cacheFetchThreadsHandlerProvider, ThreadsCache threadsCache) {
        return cacheFetchThreadsHandlerProvider.m9909a(threadsCache);
    }

    @ProviderMethod
    @SuppressLint({"ProviderUsage"})
    @SmsMessages
    @UserScoped
    static CacheInsertThreadsHandler m10111b(CacheInsertThreadsHandlerProvider cacheInsertThreadsHandlerProvider, ThreadsCache threadsCache) {
        return cacheInsertThreadsHandlerProvider.m9941a(threadsCache);
    }

    @ProviderMethod
    @TincanMessages
    @SuppressLint({"ProviderUsage"})
    @UserScoped
    static CacheServiceHandler m10115c(CacheServiceHandlerProvider cacheServiceHandlerProvider, ThreadsCache threadsCache, CacheFetchThreadsHandler cacheFetchThreadsHandler, Lazy<CacheInsertThreadsHandler> lazy) {
        return cacheServiceHandlerProvider.m10069a("TincanCacheServiceHandler", threadsCache, cacheFetchThreadsHandler, lazy);
    }

    @ProviderMethod
    @TincanMessages
    @SuppressLint({"ProviderUsage"})
    @UserScoped
    static CacheFetchThreadsHandler m10113c(CacheFetchThreadsHandlerProvider cacheFetchThreadsHandlerProvider, ThreadsCache threadsCache) {
        return cacheFetchThreadsHandlerProvider.m9909a(threadsCache);
    }

    @ProviderMethod
    @TincanMessages
    @SuppressLint({"ProviderUsage"})
    @UserScoped
    static CacheInsertThreadsHandler m10114c(CacheInsertThreadsHandlerProvider cacheInsertThreadsHandlerProvider, ThreadsCache threadsCache) {
        return cacheInsertThreadsHandlerProvider.m9941a(threadsCache);
    }
}
