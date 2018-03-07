package com.facebook.presence;

import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: download_sticker_pack_assets */
public class PayForPlayPresenceMethodAutoProvider extends AbstractProvider<PayForPlayPresence> {
    public Object get() {
        return PresenceModule.m14454a(DefaultPresenceManager.m7724a((InjectorLike) this));
    }
}
