package com.facebook.messaging.composershortcuts;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: messenger_composer */
public class Boolean_IsSendEventMessageEnabledGatekeeperAutoProvider extends AbstractProvider<Boolean> {
    private static Boolean m10487b(InjectorLike injectorLike) {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(injectorLike).a(309, false));
    }

    public Object get() {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(this).a(309, false));
    }
}
