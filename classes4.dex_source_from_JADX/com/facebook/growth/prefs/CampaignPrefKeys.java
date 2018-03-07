package com.facebook.growth.prefs;

import com.facebook.prefs.shared.PrefKey;

/* compiled from: total_count */
public class CampaignPrefKeys {
    public static final PrefKey f900a;
    public static final PrefKey f901b;

    static {
        PrefKey prefKey = (PrefKey) GrowthPrefKeys.f902a.a("ad_campaign/");
        f900a = prefKey;
        f901b = (PrefKey) prefKey.a("is_app_new_install_reported/");
    }
}
