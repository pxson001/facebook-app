package com.facebook.feed.environment;

import com.facebook.feed.rows.core.persistence.ContextStateKey;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.multirow.api.AnyEnvironment;

/* compiled from: newsfeed_story_notify_me */
public interface HasPersistentState extends AnyEnvironment {
    @Deprecated
    <K, T> T mo2424a(ContextStateKey<K, T> contextStateKey);

    <K, T> T mo2425a(ContextStateKey<K, T> contextStateKey, CacheableEntity cacheableEntity);

    <K, T> boolean mo2439a(ContextStateKey<K, T> contextStateKey, T t);
}
