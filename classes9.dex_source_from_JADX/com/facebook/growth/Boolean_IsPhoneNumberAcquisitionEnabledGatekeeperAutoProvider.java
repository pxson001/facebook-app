package com.facebook.growth;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: payment_awareness_mode */
public class Boolean_IsPhoneNumberAcquisitionEnabledGatekeeperAutoProvider extends AbstractProvider<Boolean> {
    public static Boolean m7331a(InjectorLike injectorLike) {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(injectorLike).a(406, false));
    }

    public Object get() {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(this).a(406, false));
    }
}
