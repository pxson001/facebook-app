package com.facebook.messaging.business.airline.utils;

import android.content.Context;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: thread_key_for_settings */
public final class AirlineColorUtil {
    public final Context f1538a;

    @Inject
    public AirlineColorUtil(Context context) {
        this.f1538a = context;
    }

    public static String m1546b(String str) {
        return str.codePointAt(0) == 35 ? str : "#" + str;
    }
}
