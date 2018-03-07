package com.facebook.user.util;

import com.facebook.common.android.TelephonyManagerMethodAutoProvider;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: context_types */
public class String_LoggedInUserPhoneNumberMethodAutoProvider extends AbstractProvider<String> {
    private static String m27090b(InjectorLike injectorLike) {
        return UserPhoneNumberUtilModule.m27095a(TelephonyManagerMethodAutoProvider.b(injectorLike));
    }

    public Object get() {
        return UserPhoneNumberUtilModule.m27095a(TelephonyManagerMethodAutoProvider.b(this));
    }
}
