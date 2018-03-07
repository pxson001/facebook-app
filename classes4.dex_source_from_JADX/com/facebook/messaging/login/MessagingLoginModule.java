package com.facebook.messaging.login;

import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.messaging.login.annotations.IsLoggedOutRemotely;
import com.facebook.prefs.shared.FbSharedPreferences;

@InjectorModule
/* compiled from: enable_delta_frame */
public class MessagingLoginModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @IsLoggedOutRemotely
    public static Boolean m13927a(FbSharedPreferences fbSharedPreferences) {
        return Boolean.valueOf(fbSharedPreferences.a(LoginPrefKeys.f13108b, false));
    }
}
