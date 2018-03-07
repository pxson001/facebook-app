package com.facebook.messaging.audio.record;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;

/* compiled from: operationParams.getBundle() is null */
public class Boolean_IsAudioRecorderEnabledGkGatekeeperAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(this).a(917, false));
    }
}
