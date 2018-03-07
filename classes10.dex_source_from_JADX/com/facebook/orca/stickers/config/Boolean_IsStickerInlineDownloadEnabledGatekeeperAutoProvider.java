package com.facebook.orca.stickers.config;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;

/* compiled from: nearby_friends_self_view_fetch_location_fail */
public class Boolean_IsStickerInlineDownloadEnabledGatekeeperAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(this).a(973, false));
    }
}
