package com.facebook.groups.feed.ui;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: TimelineFragment.onFragmentCreate.setupEventHandlers */
public class Boolean_IsViewPhotosInMoreMenuEnabledGatekeeperAutoProvider extends AbstractProvider<Boolean> {
    private static Boolean m23144b(InjectorLike injectorLike) {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(injectorLike).a(873, false));
    }

    public Object get() {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(this).a(873, false));
    }
}
