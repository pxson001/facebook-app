package com.facebook.katana.webview;

import android.content.Context;
import com.facebook.inject.FbInjector;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;

/* compiled from: timeline_message_button */
public class MFacewebVersion {
    public static final PrefKey f1305a = ((PrefKey) SharedPrefKeys.d.a("mfacewebversion"));

    public static String m1348a(Context context) {
        return ((FbSharedPreferences) FbSharedPreferencesImpl.a(FbInjector.get(context))).a(f1305a, null);
    }

    public static void m1349a(Context context, String str) {
        ((FbSharedPreferences) FbSharedPreferencesImpl.a(FbInjector.get(context))).edit().a(f1305a, str).commit();
    }
}
