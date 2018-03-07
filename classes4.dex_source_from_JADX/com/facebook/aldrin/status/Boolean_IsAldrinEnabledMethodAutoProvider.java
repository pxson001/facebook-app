package com.facebook.aldrin.status;

import com.facebook.aldrin.status.gk.AldrinFeatureKillSwitch;
import com.facebook.inject.AbstractProvider;

/* compiled from: voicemail_duration */
public class Boolean_IsAldrinEnabledMethodAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return AldrinStatusModule.a(AldrinFeatureKillSwitch.a(this));
    }
}
