package com.facebook.katana.login;

import android.content.ComponentName;
import android.content.Context;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;

@InjectorModule
/* compiled from: shortcut_notif_enabled */
public class Fb4aLoginModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @LoginActivityComponent
    static ComponentName m8839a(Context context) {
        return new ComponentName(context, "com.facebook.katana.FacebookLoginActivity");
    }

    @ProviderMethod
    @LogoutActivityComponent
    static ComponentName m8840b(Context context) {
        return new ComponentName(context, "com.facebook.katana.LogoutActivity");
    }

    @ProviderMethod
    @UseAuthLogin
    static Boolean m8841b() {
        return Boolean.valueOf(false);
    }
}
