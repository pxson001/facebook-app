package com.facebook.selfupdate;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;

/* compiled from: voicemail_error */
public class Boolean_IsOxygenBasedSelfUpdateEnabledGkGatekeeperAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(this).a(398, false));
    }
}
