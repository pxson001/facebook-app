package com.facebook.rtc;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;

/* compiled from: b6d2bfbd07916d278d7a66ac432f641f */
public class Boolean_IsVoipAudioSpeakerEnabledGatekeeperAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(this).a(1174, false));
    }
}
