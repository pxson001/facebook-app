package com.facebook.ui.browser;

import com.facebook.common.util.TriState;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: tooltip_should_be_shown */
public class TriState_IsSaveForLaterEnabledGatekeeperAutoProvider extends AbstractProvider<TriState> {
    private static TriState m1597b(InjectorLike injectorLike) {
        return GatekeeperStoreImplMethodAutoProvider.a(injectorLike).a(1110);
    }

    public Object get() {
        return GatekeeperStoreImplMethodAutoProvider.a(this).a(1110);
    }
}
