package com.facebook.auth.login;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import com.facebook.auth.annotations.AuthTokenString;
import com.facebook.auth.annotations.ShouldRequestSessionCookiesWithAuth;
import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.auth.event.AuthEventBus;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.common.android.FbLocalBroadcastManager;
import com.facebook.common.build.BuildConstants;
import com.facebook.common.locale.Locales;
import com.facebook.fblibraries.fblogin.SsoLoginUtil;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import java.util.Arrays;
import javax.inject.Singleton;

@InjectorModule
/* compiled from: shared/ */
public class LoginModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @ShouldRequestSessionCookiesWithAuth
    public static Boolean m8888a() {
        return Boolean.valueOf(true);
    }

    @ProviderMethod
    @Singleton
    static AuthStateMachineMonitor m8886a(FbLocalBroadcastManager fbLocalBroadcastManager, AuthEventBus authEventBus) {
        return new AuthStateMachineMonitor(fbLocalBroadcastManager, authEventBus);
    }

    @ProviderMethod
    @AuthTokenString
    public static String m8889a(LoggedInUserSessionManager loggedInUserSessionManager) {
        ViewerContext a = loggedInUserSessionManager.m2517a();
        return a != null ? a.mAuthToken : null;
    }

    @ProviderMethod
    @ForWebPasswordRecovery
    static Intent m8885a(Locales locales) {
        Builder buildUpon = Uri.parse("https://m.facebook.com/recover/initiate").buildUpon();
        buildUpon.appendQueryParameter("locale", locales.m2614d());
        return new Intent("android.intent.action.VIEW", buildUpon.build());
    }

    @ProviderMethod
    @Singleton
    static SsoLoginUtil m8887a(ContentResolver contentResolver, Boolean bool) {
        if (bool.booleanValue()) {
            return new SsoLoginUtil(contentResolver, Arrays.asList(new String[]{BuildConstants.f}));
        }
        return new SsoLoginUtil(contentResolver, Arrays.asList(new String[]{BuildConstants.g, "com.facebook.lite"}));
    }
}
