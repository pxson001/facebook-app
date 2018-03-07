package com.facebook.messaging.cache;

import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.user.cache.UserCache;

/* compiled from: min_num_threads_to_show */
public class CacheFetchThreadsHandlerProvider extends AbstractAssistedProvider<CacheFetchThreadsHandler> {
    public final CacheFetchThreadsHandler m9909a(ThreadsCache threadsCache) {
        return new CacheFetchThreadsHandler(threadsCache, ThreadsCacheUpdateRateLimiter.m10190a((InjectorLike) this), UserCache.a(this));
    }
}
