package com.facebook.feed.platformads;

import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;

/* compiled from: admin_click_insights_graph_weekly_post_reach */
public class PlatformAdPrefKeys {
    public static final PrefKey f19817a;
    public static final PrefKey f19818b;
    public static final PrefKey f19819c = ((PrefKey) f19817a.a("tracked_packages_v2/"));

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.e.a("platformads/");
        f19817a = prefKey;
        f19818b = (PrefKey) prefKey.a("tracked_packages/");
    }
}
