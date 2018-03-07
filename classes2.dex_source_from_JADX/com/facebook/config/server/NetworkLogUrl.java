package com.facebook.config.server;

import android.content.Context;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.http.prefs.InternalHttpPrefKeys;
import com.facebook.inject.FbInjector;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;

/* compiled from: renderAsSticker */
public class NetworkLogUrl {
    public static String m12161a(Context context, String str) {
        String a;
        FbSharedPreferences a2 = FbSharedPreferencesImpl.m1826a(FbInjector.get(context));
        if (a2.mo284a()) {
            a = a2.mo278a(InternalHttpPrefKeys.f2523r, "facebook.com");
        } else {
            a = "facebook.com";
        }
        return StringFormatUtil.a(str, new Object[]{a});
    }
}
