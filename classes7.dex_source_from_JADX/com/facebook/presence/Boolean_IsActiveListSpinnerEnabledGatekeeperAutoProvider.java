package com.facebook.presence;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: in_live_experience */
public class Boolean_IsActiveListSpinnerEnabledGatekeeperAutoProvider extends AbstractProvider<Boolean> {
    private static Boolean m13075b(InjectorLike injectorLike) {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(injectorLike).a(153, false));
    }

    public Object get() {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(this).a(153, false));
    }
}
