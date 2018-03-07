package com.facebook.messaging.attachments;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;

/* compiled from: p2p_confirm_remove_card */
public class Boolean_IsShowVideoAttachmentSizeEnabledGatekeeperAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(this).a(317, false));
    }
}
