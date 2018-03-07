package com.facebook.messaging.composershortcuts;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;

/* compiled from: messenger_conversation_starter_item */
public class Boolean_IsBadgeOverflowTabEnabledGatekeeperAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(this).a(1026, false));
    }
}
