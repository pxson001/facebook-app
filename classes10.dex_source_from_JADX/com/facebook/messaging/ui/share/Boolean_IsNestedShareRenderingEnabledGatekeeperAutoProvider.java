package com.facebook.messaging.ui.share;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: place_id_state */
public class Boolean_IsNestedShareRenderingEnabledGatekeeperAutoProvider extends AbstractProvider<Boolean> {
    private static Boolean m4398b(InjectorLike injectorLike) {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(injectorLike).a(315, false));
    }

    public Object get() {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(this).a(315, false));
    }
}
