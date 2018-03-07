package com.facebook.messaging.cache;

import com.facebook.auth.module.ViewerContextManagerProvider;
import com.facebook.graphql.executor.cache.GraphQLCacheManager;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.media.upload.MediaUploadCache;
import com.facebook.messaging.model.messages.MessageUtil;
import com.facebook.messaging.sharedimage.gqlrequest.SharedMediaHistoryRequestFactory;
import com.facebook.presence.DefaultPresenceManager;
import com.facebook.user.cache.UserCache;

/* compiled from: minCropHeight */
public class CacheInsertThreadsHandlerProvider extends AbstractAssistedProvider<CacheInsertThreadsHandler> {
    public final CacheInsertThreadsHandler m9941a(ThreadsCache threadsCache) {
        return new CacheInsertThreadsHandler(threadsCache, ThreadDisplayCache.m10136a((InjectorLike) this), DefaultPresenceManager.a(this), ThreadParticipantUtils.m10155a((InjectorLike) this), ViewerContextManagerProvider.b(this), GraphQLCacheManager.a(this), SharedMediaHistoryRequestFactory.m17194b(this), MessagesBroadcaster.a(this), MessageUtil.a(this), MediaUploadCache.a(this), IdBasedSingletonScopeProvider.a(this, 3749), UserCache.a(this));
    }
}
