package com.facebook.bookmark.iface;

import com.facebook.bookmark.client.BookmarkClient;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.inject.ProviderLazy;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: webrtc */
public final class STATICDI_MULTIBIND_PROVIDER$BookmarkSyncListener implements MultiBindIndexedProvider<BookmarkSyncListener>, Provider<Set<BookmarkSyncListener>> {
    private final InjectorLike f8569a;

    public STATICDI_MULTIBIND_PROVIDER$BookmarkSyncListener(InjectorLike injectorLike) {
        this.f8569a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f8569a.getScopeAwareInjector(), this);
    }

    public static Lazy<Set<BookmarkSyncListener>> m13132a(InjectorLike injectorLike) {
        return ProviderLazy.m1699a(new STATICDI_MULTIBIND_PROVIDER$BookmarkSyncListener(injectorLike.getScopeAwareInjector()), injectorLike.getScopeAwareInjector());
    }

    public final int size() {
        return 1;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return BookmarkClient.a(injector);
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
