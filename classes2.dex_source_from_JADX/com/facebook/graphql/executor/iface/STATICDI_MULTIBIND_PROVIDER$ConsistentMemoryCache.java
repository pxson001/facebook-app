package com.facebook.graphql.executor.iface;

import com.facebook.api.feedcache.memory.FeedUnitCache;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: webrtc */
public final class STATICDI_MULTIBIND_PROVIDER$ConsistentMemoryCache implements MultiBindIndexedProvider<ConsistentMemoryCache>, Provider<Set<ConsistentMemoryCache>> {
    private final InjectorLike f6186a;

    private STATICDI_MULTIBIND_PROVIDER$ConsistentMemoryCache(InjectorLike injectorLike) {
        this.f6186a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f6186a.getScopeAwareInjector(), this);
    }

    public static Set<ConsistentMemoryCache> m10387a(InjectorLike injectorLike) {
        return new MultiBinderSet(injectorLike.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$ConsistentMemoryCache(injectorLike));
    }

    public final int size() {
        return 1;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return FeedUnitCache.m10541a((InjectorLike) injector);
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
