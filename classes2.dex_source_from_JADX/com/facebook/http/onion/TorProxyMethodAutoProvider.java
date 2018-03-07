package com.facebook.http.onion;

import com.facebook.inject.AbstractProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: unknown reason */
public class TorProxyMethodAutoProvider extends AbstractProvider<TorProxy> {
    public static TorProxy m3888b(InjectorLike injectorLike) {
        return OnionModule.m3889a(IdBasedSingletonScopeProvider.m1810b(injectorLike, 7190), IdBasedSingletonScopeProvider.m1810b(injectorLike, 2269));
    }

    public Object get() {
        return OnionModule.m3889a(IdBasedSingletonScopeProvider.m1810b(this, 7190), IdBasedSingletonScopeProvider.m1810b(this, 2269));
    }

    public static TorProxy m3887a(InjectorLike injectorLike) {
        return m3888b(injectorLike);
    }
}
