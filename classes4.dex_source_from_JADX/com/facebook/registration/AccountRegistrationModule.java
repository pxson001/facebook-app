package com.facebook.registration;

import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.registration.annotations.RegInstance;
import com.facebook.registration.common.RegInstanceHelper;
import com.facebook.registration.prefs.RegistrationPrefKeys;
import javax.inject.Singleton;

@InjectorModule
/* compiled from: extra_ref_module */
public class AccountRegistrationModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @RegInstance
    @Singleton
    static String m13186a(RegInstanceHelper regInstanceHelper) {
        String a = regInstanceHelper.f12441a.a(RegistrationPrefKeys.f12444b, "");
        if (a.isEmpty()) {
            a = regInstanceHelper.f12442b.a();
            regInstanceHelper.m13185a(a);
        }
        return a;
    }
}
