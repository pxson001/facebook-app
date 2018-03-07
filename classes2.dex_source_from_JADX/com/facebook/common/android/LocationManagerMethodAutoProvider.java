package com.facebook.common.android;

import android.content.Context;
import android.location.LocationManager;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: sms_offline_swallow_network_exception */
public class LocationManagerMethodAutoProvider extends AbstractProvider<LocationManager> {
    public static LocationManager m8262b(InjectorLike injectorLike) {
        return AndroidModule.m2399a((Context) injectorLike.getInstance(Context.class));
    }

    public Object get() {
        return AndroidModule.m2399a((Context) getInstance(Context.class));
    }

    public static LocationManager m8261a(InjectorLike injectorLike) {
        return m8262b(injectorLike);
    }
}
