package com.facebook.common.android;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: unlike_link */
public class TelephonyManagerMethodAutoProvider extends AbstractProvider<TelephonyManager> {
    public static TelephonyManager m3851b(InjectorLike injectorLike) {
        return AndroidModule.m2420q((Context) injectorLike.getInstance(Context.class));
    }

    public Object get() {
        return AndroidModule.m2420q((Context) getInstance(Context.class));
    }

    public static TelephonyManager m3850a(InjectorLike injectorLike) {
        return m3851b(injectorLike);
    }
}
