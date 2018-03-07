package com.facebook.messaging.quickcam;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;

/* compiled from: dequeueOutputBuffer failed */
public class Boolean_IsQuickCamVideoEnabledGkGatekeeperAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(this).a(960, false));
    }
}
