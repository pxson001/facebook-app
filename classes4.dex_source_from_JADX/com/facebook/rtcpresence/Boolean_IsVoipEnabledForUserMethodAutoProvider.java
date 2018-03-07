package com.facebook.rtcpresence;

import com.facebook.config.application.FbAppType;
import com.facebook.inject.AbstractProvider;

/* compiled from: graphApiWriteId */
public class Boolean_IsVoipEnabledForUserMethodAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return RtcPresenceModule.a(Boolean_IsVoipEnabledConstsMethodAutoProvider.a(this), TriState_MessengerVoipAndroidGatekeeperAutoProvider.b(this), (FbAppType) getInstance(FbAppType.class));
    }
}
