package com.facebook.messaging.attachments;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;

/* compiled from: p2p_confirm_send */
public class Boolean_IsPopOutVideoPlayerSupportedGkGatekeeperAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(this).a(248, false));
    }
}
