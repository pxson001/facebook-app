package com.facebook.work.diode;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: exclude_ids */
public class Boolean_IsInstallInternalWorkChatEnabledGatekeeperAutoProvider extends AbstractProvider<Boolean> {
    private static Boolean m13101b(InjectorLike injectorLike) {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(injectorLike).a(1185, false));
    }

    public Object get() {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(this).a(1185, false));
    }
}
