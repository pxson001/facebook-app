package com.facebook.composer.prefs;

import com.facebook.prefs.shared.IHavePrivacyCriticalKeysToClear;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.google.common.collect.ImmutableSet;

/* compiled from: timing_advance */
public class ComposerPrefKeys implements IHavePrivacyCriticalKeysToClear {
    public static final PrefKey f2658a;
    public static final PrefKey f2659b;
    @Deprecated
    public static final PrefKey f2660c = ((PrefKey) f2658a.m2011a("breakfast_club_share_composer_nux_v2"));
    public static final PrefKey f2661d = ((PrefKey) f2658a.m2011a("breakfast_club_tag_expansion_tip"));
    public static final PrefKey f2662e = ((PrefKey) f2658a.m2011a("draft_exists"));
    public static final PrefKey f2663f = ((PrefKey) f2658a.m2011a("has_pending_stories"));
    public static final PrefKey f2664g = ((PrefKey) f2658a.m2011a("publish_mode_selector_nux_seen"));
    public static final PrefKey f2665h = ((PrefKey) f2658a.m2011a("publish_mode_selector_nux"));
    public static final PrefKey f2666i = ((PrefKey) f2658a.m2011a("linear_composer_next_button_nux"));
    public static final PrefKey f2667j = ((PrefKey) f2658a.m2011a("auto_enhance_photos"));
    public static final PrefKey f2668k = ((PrefKey) f2658a.m2011a("check_in_nux_for_photo_nux"));
    public static final PrefKey f2669l = ((PrefKey) f2658a.m2011a("creative_editing_stickers_nux"));
    public static final PrefKey f2670m = ((PrefKey) f2658a.m2011a("creative_editing_frames_nux"));
    public static final PrefKey f2671n = ((PrefKey) f2658a.m2011a("creative_editing_filter_nux"));
    public static final PrefKey f2672o = ((PrefKey) f2658a.m2011a("sticker_post_sticker_icon_nux"));
    public static final PrefKey f2673p = ((PrefKey) f2658a.m2011a("last_published_post_time"));
    public static final PrefKey f2674q = ((PrefKey) f2658a.m2011a("sprouts_music_nux_tapped"));
    public static final PrefKey f2675r = ((PrefKey) f2658a.m2011a("facecast_icon_nux_seen"));
    public static final PrefKey f2676s = ((PrefKey) f2658a.m2011a("facecast_sprouts_nux_seen"));
    public static final PrefKey f2677t = ((PrefKey) f2658a.m2011a("last_published_mmp_time"));
    public static final PrefKey f2678u = ((PrefKey) f2658a.m2011a("topic_composer_nux"));
    public static final PrefKey f2679v = ((PrefKey) f2658a.m2011a("live_topic_composer_nux"));
    public static final PrefKey f2680w = ((PrefKey) f2658a.m2011a("composer_feed_only_post_nux"));

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.f987a.m2011a("composer/");
        f2658a = prefKey;
        f2659b = (PrefKey) prefKey.m2011a("photo_review_nux_seen");
    }

    public final ImmutableSet<PrefKey> mo671b() {
        return ImmutableSet.of(f2659b, f2660c, f2661d, f2673p);
    }
}
