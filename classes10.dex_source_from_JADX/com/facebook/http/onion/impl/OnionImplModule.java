package com.facebook.http.onion.impl;

import android.app.Application;
import android.content.Context;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.webview.proxy.WebViewProxyUtil;

@InjectorModule
/* compiled from: Sync protocol disabled. Ignore operation %s */
public class OnionImplModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    public static WebViewProxyUtil m24683a(Context context) {
        return new WebViewProxyUtil(context, Application.class);
    }
}
