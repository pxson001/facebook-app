package com.facebook.photos.prefetch;

import com.facebook.feed.photos.FeedImagesCacheStateMapper;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: webrtc */
public final class STATICDI_MULTIBIND_PROVIDER$PrefetchListener implements MultiBindIndexedProvider<PrefetchListener>, Provider<Set<PrefetchListener>> {
    private final InjectorLike f11079a;

    private STATICDI_MULTIBIND_PROVIDER$PrefetchListener(InjectorLike injectorLike) {
        this.f11079a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f11079a.getScopeAwareInjector(), this);
    }

    public static Set<PrefetchListener> m16437a(InjectorLike injectorLike) {
        return new MultiBinderSet(injectorLike.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$PrefetchListener(injectorLike));
    }

    public final int size() {
        return 1;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return FeedImagesCacheStateMapper.m14216a(injector);
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
