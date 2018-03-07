package com.facebook.messaging.composer.triggers;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: messenger_montage_inbox_composer */
public class Boolean_IsContentSearchEnabledGatekeeperAutoProvider extends AbstractProvider<Boolean> {
    public static Boolean m10362a(InjectorLike injectorLike) {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(injectorLike).a(1027, false));
    }

    public Object get() {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(this).a(1027, false));
    }
}
