package com.facebook.messaging.cache;

import com.facebook.debug.debugoverlay.DebugOverlayController;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.messaging.analytics.perf.MessagingPerformanceLogger;
import com.facebook.messaging.analytics.threads.FetchThreadLogger;
import com.facebook.messaging.analytics.threads.FetchThreadTracer;

/* compiled from: method/vault.androidBlacklistedSyncPaths */
public class CacheServiceHandlerProvider extends AbstractAssistedProvider<CacheServiceHandler> {
    public final CacheServiceHandler m10069a(String str, ThreadsCache threadsCache, CacheFetchThreadsHandler cacheFetchThreadsHandler, Lazy<CacheInsertThreadsHandler> lazy) {
        CacheServiceHandler cacheServiceHandler = new CacheServiceHandler(str, threadsCache, MessagesBroadcaster.a(this), cacheFetchThreadsHandler, lazy, GloballyDeletedMessagesPlaceholderCache.m10093a((InjectorLike) this), IdBasedProvider.a(this, 8006), FetchThreadTracer.m7979a((InjectorLike) this), MessagingPerformanceLogger.a(this), DebugOverlayController.a(this), FetchThreadLogger.m7977b(this), IdBasedProvider.a(this, 3595));
        cacheServiceHandler.m10047a(IdBasedSingletonScopeProvider.b(this, 339), IdBasedLazy.a(this, 11533), IdBasedLazy.a(this, 7821), IdBasedLazy.a(this, 2673));
        return cacheServiceHandler;
    }
}
