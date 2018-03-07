package com.facebook.api.feed.module;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: sPreloadedDrawables */
public class Boolean_IsTagMemoizingEnabledGatekeeperAutoProvider extends AbstractProvider<Boolean> {
    public static Boolean m10689b(InjectorLike injectorLike) {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike).m2189a(77, false));
    }

    public Object get() {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.m2131a(this).m2189a(77, false));
    }
}
