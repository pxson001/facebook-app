package com.facebook.ui.browser;

import com.facebook.common.util.TriState;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: topScrollEndDrag */
public class TriState_IsNavigationTrackingEnabledGatekeeperAutoProvider extends AbstractProvider<TriState> {
    private static TriState m1593b(InjectorLike injectorLike) {
        return GatekeeperStoreImplMethodAutoProvider.a(injectorLike).a(127);
    }

    public Object get() {
        return GatekeeperStoreImplMethodAutoProvider.a(this).a(127);
    }
}
