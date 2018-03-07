package com.facebook.messaging.intents;

import android.content.Intent;
import android.os.Parcelable;

/* compiled from: tosPrivacyUrl */
public class MessagingIntents {
    public static boolean m1695a(Intent intent, String str, boolean z) {
        if (intent == null || !intent.hasExtra(str)) {
            return z;
        }
        z = intent.getBooleanExtra(str, z);
        intent.removeExtra(str);
        return z;
    }

    public static String m1694a(Intent intent, String str) {
        if (intent == null || !intent.hasExtra(str)) {
            return null;
        }
        String stringExtra = intent.getStringExtra(str);
        intent.removeExtra(str);
        return stringExtra;
    }

    public static <T extends Parcelable> T m1696b(Intent intent, String str) {
        if (intent == null || !intent.hasExtra(str)) {
            return null;
        }
        T parcelableExtra = intent.getParcelableExtra(str);
        intent.removeExtra(str);
        return parcelableExtra;
    }
}
