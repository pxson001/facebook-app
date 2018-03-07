package com.facebook.common.uri;

import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: transaction_status_display */
public final class C1078x465e9c87 implements MultiBindIndexedProvider<UriIntentBuilder>, Provider<Set<UriIntentBuilder>> {
    private final InjectorLike f11183a;

    private C1078x465e9c87(InjectorLike injectorLike) {
        this.f11183a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f11183a.getScopeAwareInjector(), this);
    }

    public static Provider<Set<UriIntentBuilder>> m19136a(InjectorLike injectorLike) {
        return new C1078x465e9c87(injectorLike.getScopeAwareInjector());
    }

    public final int size() {
        return 0;
    }

    public final Object provide(Injector injector, int i) {
        throw new IllegalArgumentException("Invalid binding index");
    }
}
