package com.facebook.auth.login;

import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import com.facebook.common.locale.Locales;
import com.facebook.config.application.FbAppType;
import com.facebook.debug.log.BLog;

/* compiled from: system */
public class FacebookRegistrationIntentProvider {
    private static final Class<?> f2291a = FacebookRegistrationIntentProvider.class;

    public static Intent m3184a(Locales locales, FbAppType fbAppType) {
        Builder buildUpon = Uri.parse("https://m.facebook.com/r.php").buildUpon();
        BLog.a(f2291a, "Signing up user with locale: %s", new Object[]{locales.d()});
        buildUpon.appendQueryParameter("locale", r1);
        buildUpon.appendQueryParameter("cid", fbAppType.c());
        return new Intent("android.intent.action.VIEW", buildUpon.build());
    }
}
