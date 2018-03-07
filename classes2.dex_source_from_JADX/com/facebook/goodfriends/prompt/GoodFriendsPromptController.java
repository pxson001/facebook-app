package com.facebook.goodfriends.prompt;

import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import javax.inject.Inject;

/* compiled from: mqtt_client_log */
public class GoodFriendsPromptController {
    public static final PrefKey f13268a = ((PrefKey) SharedPrefKeys.f987a.m2011a("goodfriends_first_post_prompt"));
    public FbSharedPreferences f13269b;

    @Inject
    public GoodFriendsPromptController(FbSharedPreferences fbSharedPreferences) {
        this.f13269b = fbSharedPreferences;
    }

    public final boolean m19528a() {
        return this.f13269b.mo286a(f13268a, true);
    }
}
