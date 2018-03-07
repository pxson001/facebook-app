package com.facebook.registration.common;

import com.facebook.device_id.UniqueIdForDeviceHolderImpl;
import com.facebook.device_id.UniqueIdForDeviceHolderMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.registration.prefs.RegistrationPrefKeys;
import javax.inject.Inject;

/* compiled from: extra_result */
public class RegInstanceHelper {
    public FbSharedPreferences f12441a;
    public UniqueIdForDeviceHolderImpl f12442b;

    public static RegInstanceHelper m13184b(InjectorLike injectorLike) {
        return new RegInstanceHelper((FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), UniqueIdForDeviceHolderMethodAutoProvider.b(injectorLike));
    }

    @Inject
    public RegInstanceHelper(FbSharedPreferences fbSharedPreferences, UniqueIdForDeviceHolderImpl uniqueIdForDeviceHolderImpl) {
        this.f12441a = fbSharedPreferences;
        this.f12442b = uniqueIdForDeviceHolderImpl;
    }

    public final void m13185a(String str) {
        this.f12441a.edit().a(RegistrationPrefKeys.f12444b, str).commit();
    }
}
