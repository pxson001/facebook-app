package com.facebook.api.feed.module;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: aspect_ratio */
public class Boolean_IsFeedFileStorageEnabledGatekeeperAutoProvider extends AbstractProvider<Boolean> {
    private static Boolean m14677b(InjectorLike injectorLike) {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(injectorLike).a(826, false));
    }

    public Object get() {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(this).a(826, false));
    }
}
