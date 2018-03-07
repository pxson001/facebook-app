package com.facebook.messaging.cache;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.messaging.cache.ThreadsCache.CacheType;
import com.facebook.messaging.model.messages.MessageUtil;

/* compiled from: is_istl */
public class ThreadsCacheProvider extends AbstractAssistedProvider<ThreadsCache> {
    public final ThreadsCache m10386a(CacheType cacheType) {
        return new ThreadsCache(cacheType, IdBasedSingletonScopeProvider.b(this, 7973), IdBasedLazy.a(this, 7708), MessageUtil.a(this), IdBasedProvider.a(this, 3595), IdBasedProvider.a(this, 4075), IdBasedLazy.a(this, 7700), GatekeeperStoreImplMethodAutoProvider.a(this), IdBasedLazy.a(this, 2569));
    }
}
