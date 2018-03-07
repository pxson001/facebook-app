package com.facebook.feed.ui.chaining;

import com.facebook.feedplugins.articlechaining.controllers.ArticleChainingViewController;
import com.facebook.feedplugins.eventschaining.controllers.EventJoinChainingViewController;
import com.facebook.feedplugins.photochaining.controllers.PhotoChainingViewController;
import com.facebook.feedplugins.pyml.controllers.PymlChainingViewController;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: ्औ */
public final class STATICDI_MULTIBIND_PROVIDER$HScrollChainingViewController implements MultiBindIndexedProvider<HScrollChainingViewController>, Provider<Set<HScrollChainingViewController>> {
    private final InjectorLike f21863a;

    public STATICDI_MULTIBIND_PROVIDER$HScrollChainingViewController(InjectorLike injectorLike) {
        this.f21863a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f21863a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 4;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return ArticleChainingViewController.m25226a((InjectorLike) injector);
            case 1:
                return EventJoinChainingViewController.a(injector);
            case 2:
                return PhotoChainingViewController.a(injector);
            case 3:
                return PymlChainingViewController.a(injector);
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
