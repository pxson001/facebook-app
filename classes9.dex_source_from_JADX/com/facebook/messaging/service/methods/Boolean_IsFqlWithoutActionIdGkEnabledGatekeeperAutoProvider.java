package com.facebook.messaging.service.methods;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: db_size_info */
public class Boolean_IsFqlWithoutActionIdGkEnabledGatekeeperAutoProvider extends AbstractProvider<Boolean> {
    public static Boolean m16864b(InjectorLike injectorLike) {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(injectorLike).a(940, false));
    }

    public Object get() {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(this).a(940, false));
    }
}
