package com.facebook.feed.goodfriends.nux;

import com.facebook.goodfriends.analytics.GoodFriendsAnalyticsLogger;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import javax.inject.Inject;

/* compiled from: TYPES_ONLY */
public class GoodFriendsNuxController {
    public static final PrefKey f24486a = ((PrefKey) SharedPrefKeys.a.a("goodfriends_show_tooltip"));
    public FbSharedPreferences f24487b;
    public GoodFriendsAnalyticsLogger f24488c;

    public static GoodFriendsNuxController m26386b(InjectorLike injectorLike) {
        return new GoodFriendsNuxController((FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), GoodFriendsAnalyticsLogger.a(injectorLike));
    }

    @Inject
    public GoodFriendsNuxController(FbSharedPreferences fbSharedPreferences, GoodFriendsAnalyticsLogger goodFriendsAnalyticsLogger) {
        this.f24487b = fbSharedPreferences;
        this.f24488c = goodFriendsAnalyticsLogger;
    }
}
