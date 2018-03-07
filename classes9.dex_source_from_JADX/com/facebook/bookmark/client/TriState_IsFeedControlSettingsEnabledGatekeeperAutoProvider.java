package com.facebook.bookmark.client;

import com.facebook.common.util.TriState;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: rel_pos */
public class TriState_IsFeedControlSettingsEnabledGatekeeperAutoProvider extends AbstractProvider<TriState> {
    private static TriState m5832b(InjectorLike injectorLike) {
        return GatekeeperStoreImplMethodAutoProvider.a(injectorLike).a(78);
    }

    public Object get() {
        return GatekeeperStoreImplMethodAutoProvider.a(this).a(78);
    }
}
