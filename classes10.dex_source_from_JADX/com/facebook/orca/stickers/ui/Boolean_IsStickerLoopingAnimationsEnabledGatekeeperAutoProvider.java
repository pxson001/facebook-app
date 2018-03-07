package com.facebook.orca.stickers.ui;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;

/* compiled from: nearby_friends_now_nux_turn_on */
public class Boolean_IsStickerLoopingAnimationsEnabledGatekeeperAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(this).a(1029, false));
    }
}
