package com.facebook.rtc;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;

/* compiled from: b210863b0d702696f2bbdff270d0df60 */
public class Boolean_VoipAudioModeNormalGatekeeperAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(this).a(1173, false));
    }
}
