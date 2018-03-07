package com.facebook.rtc;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;

/* compiled from: b294fb3f157946eb2c8b5e857ad27c0b */
public class Boolean_VoipAudioModeInCallGatekeeperAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(this).a(1172, false));
    }
}
