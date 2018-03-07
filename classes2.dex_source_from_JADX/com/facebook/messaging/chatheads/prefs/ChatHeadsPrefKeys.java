package com.facebook.messaging.chatheads.prefs;

import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;

/* compiled from: title_bar_background_color_id */
public class ChatHeadsPrefKeys {
    public static final PrefKey f2589a = ((PrefKey) SharedPrefKeys.f987a.m2011a("messages/"));
    public static final PrefKey f2590b;
    public static final PrefKey f2591c;
    public static final PrefKey f2592d;
    public static final PrefKey f2593e = ((PrefKey) f2591c.m2011a("primary_chat_heads_enabled"));
    public static final PrefKey f2594f;
    public static final PrefKey f2595g;
    public static final PrefKey f2596h = ((PrefKey) f2594f.m2011a("/dock_y_percentage"));
    public static final PrefKey f2597i = ((PrefKey) f2594f.m2011a("/has_chat_head_settings_been_reported"));
    public static final PrefKey f2598j = ((PrefKey) f2594f.m2011a("/should_present_accessibility_hint"));
    public static final PrefKey f2599k = ((PrefKey) f2594f.m2011a("/debug_shading_enabled"));

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.f989c.m2011a("messages/");
        f2590b = prefKey;
        prefKey = (PrefKey) prefKey.m2011a("notifications/");
        f2591c = prefKey;
        f2592d = (PrefKey) prefKey.m2011a("chat_heads_enabled");
        prefKey = (PrefKey) f2589a.m2011a("notifications/chat_heads");
        f2594f = prefKey;
        f2595g = (PrefKey) prefKey.m2011a("/dock_x_percentage");
    }
}
