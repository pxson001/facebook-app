package com.facebook.omnistore.module;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: lastUpdateTimestamp */
public class Boolean_OmnistoreDontDeleteDbOnOpenErrorGatekeeperAutoProvider extends AbstractProvider<Boolean> {
    public static Boolean m9995xcba8a628(InjectorLike injectorLike) {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(injectorLike).a(396, false));
    }

    public /* bridge */ /* synthetic */ Object get() {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(this).a(396, false));
    }
}
