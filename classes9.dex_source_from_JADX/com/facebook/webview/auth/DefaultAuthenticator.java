package com.facebook.webview.auth;

import android.content.Context;
import com.facebook.inject.InjectorLike;

/* compiled from: shipping_address_id */
public class DefaultAuthenticator implements Authenticator {
    public static DefaultAuthenticator m3337a(InjectorLike injectorLike) {
        return new DefaultAuthenticator();
    }

    public final void mo96a(Context context, AuthCallback authCallback) {
        if (authCallback != null) {
            authCallback.m3334b();
        }
    }
}
