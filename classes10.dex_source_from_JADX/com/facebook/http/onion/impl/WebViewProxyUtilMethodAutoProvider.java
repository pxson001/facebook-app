package com.facebook.http.onion.impl;

import android.content.Context;
import com.facebook.inject.AbstractProvider;
import com.facebook.webview.proxy.WebViewProxyUtil;

/* compiled from: StoryAttachment */
public class WebViewProxyUtilMethodAutoProvider extends AbstractProvider<WebViewProxyUtil> {
    public Object get() {
        return OnionImplModule.m24683a((Context) getInstance(Context.class));
    }
}
