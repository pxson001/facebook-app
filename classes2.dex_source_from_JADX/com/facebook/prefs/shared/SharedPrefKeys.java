package com.facebook.prefs.shared;

import com.facebook.common.typedkey.TypedKey;

/* compiled from: vnd.android.cursor.item/vnd.facebook.events.event */
public class SharedPrefKeys {
    public static final PrefKey f987a;
    public static final PrefKey f988b;
    public static final PrefKey f989c = ((PrefKey) f987a.m2011a("settings/"));
    public static final PrefKey f990d = ((PrefKey) f987a.m2011a("config/"));
    public static final PrefKey f991e = ((PrefKey) f987a.m2011a("shared/"));
    public static final PrefKey f992f;
    public static final PrefKey f993g;
    public static final PrefKey f994h = ((PrefKey) f987a.m2011a("fb_android/"));

    static {
        TypedKey prefKey = new PrefKey("/");
        f987a = prefKey;
        f988b = (PrefKey) prefKey.m2011a("prefs/");
        PrefKey prefKey2 = (PrefKey) f987a.m2011a("dash/");
        f992f = prefKey2;
        f993g = (PrefKey) prefKey2.m2011a("enabled");
    }
}
