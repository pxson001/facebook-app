package com.facebook.common.android;

import android.content.Context;
import android.net.wifi.WifiManager;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: unknown_story */
public class WifiManagerMethodAutoProvider extends AbstractProvider<WifiManager> {
    public static WifiManager m3852b(InjectorLike injectorLike) {
        return AndroidModule.m2416m((Context) injectorLike.getInstance(Context.class));
    }

    public Object get() {
        return AndroidModule.m2416m((Context) getInstance(Context.class));
    }
}
