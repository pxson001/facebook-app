package com.facebook.crowdsourcing.module;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;

/* compiled from: com.facebook.messenger.intents.SecureIntentHandlerActivity */
public class Boolean_IsPendingEditsViewEnabledGatekeeperAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(this).a(404, false));
    }
}
