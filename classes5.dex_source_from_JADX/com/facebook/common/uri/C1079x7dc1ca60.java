package com.facebook.common.uri;

import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.pages.deeplinking.uri.PagesManagerRedirectUriIntentBuilder;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: transaction_status_display */
public final class C1079x7dc1ca60 implements MultiBindIndexedProvider<UriIntentBuilder>, Provider<Set<UriIntentBuilder>> {
    private final InjectorLike f11184a;

    private C1079x7dc1ca60(InjectorLike injectorLike) {
        this.f11184a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f11184a.getScopeAwareInjector(), this);
    }

    public static Provider<Set<UriIntentBuilder>> m19137a(InjectorLike injectorLike) {
        return new C1079x7dc1ca60(injectorLike.getScopeAwareInjector());
    }

    public final int size() {
        return 1;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return PagesManagerRedirectUriIntentBuilder.a(injector);
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
