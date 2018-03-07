package com.facebook.stickers.client;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: endDate */
public class Boolean_IsStickerStoreNewBadgeEnabledGkGatekeeperAutoProvider extends AbstractProvider<Boolean> {
    private static Boolean m23910b(InjectorLike injectorLike) {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(injectorLike).a(976, false));
    }

    public Object get() {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(this).a(976, false));
    }
}
