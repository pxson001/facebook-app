package com.facebook.katana.app.module;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: VIDEOS_HEADER */
public class Boolean_IsJewelDivebarPromotionEnabledGatekeeperAutoProvider extends AbstractProvider<Boolean> {
    private static Boolean m10794b(InjectorLike injectorLike) {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(injectorLike).a(63, false));
    }

    public Object get() {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(this).a(63, false));
    }
}
