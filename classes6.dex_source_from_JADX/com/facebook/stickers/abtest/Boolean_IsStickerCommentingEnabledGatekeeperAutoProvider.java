package com.facebook.stickers.abtest;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: entities_named */
public class Boolean_IsStickerCommentingEnabledGatekeeperAutoProvider extends AbstractProvider<Boolean> {
    private static Boolean m23886b(InjectorLike injectorLike) {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(injectorLike).a(37, false));
    }

    public Object get() {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(this).a(37, false));
    }
}
