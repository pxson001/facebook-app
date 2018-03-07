package com.facebook.messaging.chatheads.prefs;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: is_user_subscribed_to_merchant */
public class Boolean_IsChatHeadsDefaultShowOnFullscreenGatekeeperAutoProvider extends AbstractProvider<Boolean> {
    private static Boolean m18905b(InjectorLike injectorLike) {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(injectorLike).a(924, false));
    }

    public Object get() {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(this).a(924, false));
    }
}
