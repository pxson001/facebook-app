package com.facebook.orca.stickers.config;

import com.facebook.common.util.TriState;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: nearby_friends_region */
public class TriState_IsAnimatedStickerPreviewsEnabledGatekeeperAutoProvider extends AbstractProvider<TriState> {
    private static TriState m6088b(InjectorLike injectorLike) {
        return GatekeeperStoreImplMethodAutoProvider.a(injectorLike).a(914);
    }

    public Object get() {
        return GatekeeperStoreImplMethodAutoProvider.a(this).a(914);
    }
}
