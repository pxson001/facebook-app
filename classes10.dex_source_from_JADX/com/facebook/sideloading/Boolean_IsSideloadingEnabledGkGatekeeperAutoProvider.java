package com.facebook.sideloading;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: has_clicked_on_location_picker */
public class Boolean_IsSideloadingEnabledGkGatekeeperAutoProvider extends AbstractProvider<Boolean> {
    private static Boolean m10111b(InjectorLike injectorLike) {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(injectorLike).a(72, false));
    }

    public Object get() {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(this).a(72, false));
    }
}
