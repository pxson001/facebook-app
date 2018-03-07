package com.facebook.common.hardware;

import com.facebook.common.android.TelephonyManagerMethodAutoProvider;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: remove_montage_viewer */
public class String_PhoneIsoCountryCodeMethodAutoProvider extends AbstractProvider<String> {
    public static String m12185b(InjectorLike injectorLike) {
        return PhoneIsoCountryCodeProvider.m12186a(TelephonyManagerMethodAutoProvider.m3851b(injectorLike), IdBasedProvider.m1811a(injectorLike, 4483));
    }

    public Object get() {
        return PhoneIsoCountryCodeProvider.m12186a(TelephonyManagerMethodAutoProvider.m3851b(this), IdBasedProvider.m1811a(this, 4483));
    }
}
