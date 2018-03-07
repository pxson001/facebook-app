package com.facebook.graphql.executor;

import com.facebook.graphql.executor.cache.ConsistencyConfig;
import com.facebook.graphql.executor.cache.ConsistencyConfigImpl;
import com.facebook.graphql.executor.cache.ConsistencyConfigImpl.LazyHolder;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: messenger_hot_emojilikes */
public class ConsistencyConfigMethodAutoProvider extends AbstractProvider<ConsistencyConfig> {
    public Object get() {
        return LazyHolder.f12473a;
    }

    public static ConsistencyConfigImpl m20299a(InjectorLike injectorLike) {
        return LazyHolder.f12473a;
    }
}
