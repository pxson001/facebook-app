package com.facebook.feed.environment.impl;

import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.core.persistence.ContextStateKey;
import com.facebook.feed.rows.core.persistence.ContextStateMap;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: new_timeline */
public class HasPersistentStateImpl implements HasPersistentState {
    private final ContextStateMap f12298a;

    public static HasPersistentStateImpl m18341b(InjectorLike injectorLike) {
        return new HasPersistentStateImpl(ContextStateMap.m14935a(injectorLike));
    }

    @Inject
    public HasPersistentStateImpl(ContextStateMap contextStateMap) {
        this.f12298a = contextStateMap;
    }

    @Deprecated
    public final <K, T> T mo2424a(ContextStateKey<K, T> contextStateKey) {
        return this.f12298a.m14939a((ContextStateKey) contextStateKey);
    }

    public final <K, T> T mo2425a(ContextStateKey<K, T> contextStateKey, CacheableEntity cacheableEntity) {
        return this.f12298a.m14940a((ContextStateKey) contextStateKey, cacheableEntity);
    }

    public final <K, T> boolean mo2439a(ContextStateKey<K, T> contextStateKey, T t) {
        return this.f12298a.m14943a((ContextStateKey) contextStateKey, (Object) t);
    }

    public static HasPersistentStateImpl m18340a(InjectorLike injectorLike) {
        return m18341b(injectorLike);
    }
}
