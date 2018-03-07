package com.facebook.rtc;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;

/* compiled from: b62773fab0651951e92ad5bbe079af1a */
public class Boolean_IsVoipVideoCameraFacingEnabledGatekeeperAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(this).a(1104, false));
    }
}
