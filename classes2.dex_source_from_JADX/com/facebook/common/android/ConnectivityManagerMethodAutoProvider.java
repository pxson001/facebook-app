package com.facebook.common.android;

import android.content.Context;
import android.net.ConnectivityManager;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: unparsed_data */
public class ConnectivityManagerMethodAutoProvider extends AbstractProvider<ConnectivityManager> {
    public static ConnectivityManager m3847b(InjectorLike injectorLike) {
        return AndroidModule.m2415l((Context) injectorLike.getInstance(Context.class));
    }

    public Object get() {
        return AndroidModule.m2415l((Context) getInstance(Context.class));
    }

    public static ConnectivityManager m3846a(InjectorLike injectorLike) {
        return m3847b(injectorLike);
    }
}
