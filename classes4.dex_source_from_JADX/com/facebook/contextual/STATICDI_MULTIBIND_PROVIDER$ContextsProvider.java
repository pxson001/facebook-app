package com.facebook.contextual;

import com.facebook.contextual.network.NetworkQualityContextsProviderMethodAutoProvider;
import com.facebook.contextual.validation.BooleanContextMethodAutoProvider;
import com.facebook.contextual.validation.FloatContextMethodAutoProvider;
import com.facebook.contextual.validation.IntegerContextMethodAutoProvider;
import com.facebook.contextual.validation.StringContextMethodAutoProvider;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: updateDeviceSyncOlderPhotosOnServer */
public final class STATICDI_MULTIBIND_PROVIDER$ContextsProvider implements MultiBindIndexedProvider<ContextsProvider>, Provider<Set<ContextsProvider>> {
    private final InjectorLike f1911a;

    private STATICDI_MULTIBIND_PROVIDER$ContextsProvider(InjectorLike injectorLike) {
        this.f1911a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f1911a.getScopeAwareInjector(), this);
    }

    public static Set<ContextsProvider> m1959a(InjectorLike injectorLike) {
        return new MultiBinderSet(injectorLike.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$ContextsProvider(injectorLike));
    }

    public final int size() {
        return 5;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return NetworkQualityContextsProviderMethodAutoProvider.m1967a(injector);
            case 1:
                return BooleanContextMethodAutoProvider.m1982a(injector);
            case 2:
                return FloatContextMethodAutoProvider.m1985a(injector);
            case 3:
                return IntegerContextMethodAutoProvider.m1988a(injector);
            case 4:
                return StringContextMethodAutoProvider.m1991a(injector);
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
