package com.facebook.rtc;

import com.facebook.device.CpuCapabilities;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;

/* compiled from: b3d016417700d34ff25d68199eb30138 */
public class Boolean_IsVoipVideoEnabledMethodAutoProvider extends AbstractProvider<Boolean> {
    public static Boolean m19084b(InjectorLike injectorLike) {
        FbSharedPreferencesImpl.a(injectorLike);
        return RtcModule.m19086a(Boolean_IsVoipVideoEnabledGkGatekeeperAutoProvider.m19083b(injectorLike), CpuCapabilities.a(injectorLike));
    }

    public Object get() {
        FbSharedPreferencesImpl.a(this);
        return RtcModule.m19086a(Boolean_IsVoipVideoEnabledGkGatekeeperAutoProvider.m19083b(this), CpuCapabilities.a(this));
    }
}
