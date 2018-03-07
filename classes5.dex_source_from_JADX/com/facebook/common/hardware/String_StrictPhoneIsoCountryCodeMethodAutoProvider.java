package com.facebook.common.hardware;

import com.facebook.common.android.TelephonyManagerMethodAutoProvider;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: sphericalInlineAspectRatio */
public class String_StrictPhoneIsoCountryCodeMethodAutoProvider extends AbstractProvider<String> {
    public static String m3721b(InjectorLike injectorLike) {
        return StrictPhoneIsoCountryCodeProvider.m3720a(TelephonyManagerMethodAutoProvider.b(injectorLike));
    }

    public Object get() {
        return StrictPhoneIsoCountryCodeProvider.m3720a(TelephonyManagerMethodAutoProvider.b(this));
    }
}
