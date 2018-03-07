package com.facebook.ui.browser;

import com.facebook.common.util.TriState;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: today_unit_settings */
public class TriState_IsSavePocketEnabledGatekeeperAutoProvider extends AbstractProvider<TriState> {
    private static TriState m1598b(InjectorLike injectorLike) {
        return GatekeeperStoreImplMethodAutoProvider.a(injectorLike).a(130);
    }

    public Object get() {
        return GatekeeperStoreImplMethodAutoProvider.a(this).a(130);
    }
}
