package com.facebook.messaging.composershortcuts;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;

/* compiled from: messenger_composer_order */
public class Boolean_IsPlatformSampleContentEnabledGatekeeperAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(this).a(289, false));
    }
}
