package com.facebook.timeline.prefs;

import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;

/* compiled from: fav_photos_edit_cancel_click */
public class TimelinePreferencesKeys {
    public static final PrefKey f14693a;
    public static final PrefKey f14694b = ((PrefKey) f14702j.a("show_tooltips"));
    public static final PrefKey f14695c = ((PrefKey) f14702j.a("show_debug_overlay"));
    public static final PrefKey f14696d = ((PrefKey) f14702j.a("is_flat_buffer_corrupt"));
    public static final PrefKey f14697e = ((PrefKey) f14702j.a("intro_cards_suggested_photos_nux_dismissed"));
    public static final PrefKey f14698f = ((PrefKey) f14702j.a("intro_cards_suggested_bio_nux_dismissed"));
    public static final PrefKey f14699g = ((PrefKey) f14702j.a("intro_cards_bio_post_to_feed_nux_dismissed"));
    public static final PrefKey f14700h = ((PrefKey) f14702j.a("intro_cards_fav_photos_post_to_feed_dismissed"));
    public static final PrefKey f14701i = ((PrefKey) f14702j.a("featured_header_nux_dismissed"));
    private static final PrefKey f14702j;

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.a.a("timeline/");
        f14702j = prefKey;
        f14693a = (PrefKey) prefKey.a("pause_updates");
    }
}
