package com.facebook.messaging.analytics.base;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: onTouchMove */
public class Boolean_IsAnalyticsEnabledGkGatekeeperAutoProvider extends AbstractProvider<Boolean> {
    public static Boolean m9413b(InjectorLike injectorLike) {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(injectorLike).a(925, false));
    }

    public Object get() {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(this).a(925, false));
    }
}
