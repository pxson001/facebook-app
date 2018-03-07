package com.facebook.zero;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: com.facebook.platform.extra.PERMISSIONS */
public class Boolean_IsInZeroWifiGatekeeperGatekeeperAutoProvider extends AbstractProvider<Boolean> {
    private static Boolean m28826b(InjectorLike injectorLike) {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(injectorLike).a(1190, false));
    }

    public Object get() {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(this).a(1190, false));
    }
}
