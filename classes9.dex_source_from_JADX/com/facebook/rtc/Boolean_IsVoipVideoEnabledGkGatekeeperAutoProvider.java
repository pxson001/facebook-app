package com.facebook.rtc;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: b4cea841b9c5e30ab60e13237a3aeaf8 */
public class Boolean_IsVoipVideoEnabledGkGatekeeperAutoProvider extends AbstractProvider<Boolean> {
    public static Boolean m19083b(InjectorLike injectorLike) {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(injectorLike).a(1177, false));
    }

    public Object get() {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(this).a(1177, false));
    }
}
