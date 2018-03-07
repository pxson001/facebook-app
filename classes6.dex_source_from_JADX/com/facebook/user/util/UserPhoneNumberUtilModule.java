package com.facebook.user.util;

import android.telephony.TelephonyManager;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;

@InjectorModule
/* compiled from: context_token */
public class UserPhoneNumberUtilModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @LoggedInUserPhoneNumber
    static String m27095a(TelephonyManager telephonyManager) {
        return telephonyManager.getLine1Number();
    }
}
