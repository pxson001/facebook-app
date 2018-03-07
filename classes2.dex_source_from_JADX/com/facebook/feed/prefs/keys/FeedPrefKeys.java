package com.facebook.feed.prefs.keys;

import com.facebook.prefs.shared.IHaveNonCriticalKeysToClear;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.google.common.collect.ImmutableSet;

/* compiled from: selfupdate_back_button */
public class FeedPrefKeys implements IHaveNonCriticalKeysToClear {
    public static final PrefKey f5737a;
    public static final PrefKey f5738b;
    public static final PrefKey f5739c = ((PrefKey) f5737a.m2011a("story_ranking_time"));
    public static final PrefKey f5740d = ((PrefKey) f5737a.m2011a("last_hit_previously_ranked_stories_time"));
    public static final PrefKey f5741e = ((PrefKey) f5737a.m2011a("last_head_fetch_time"));
    public static final PrefKey f5742f = ((PrefKey) f5737a.m2011a("clear_stories_cache"));
    public static final PrefKey f5743g = ((PrefKey) f5737a.m2011a("always_do_fresh_fetch_on_cold_start"));
    public static final PrefKey f5744h = ((PrefKey) f5737a.m2011a("topics_prediction_visual_feedback_enabled"));
    public static final PrefKey f5745i = ((PrefKey) f5737a.m2011a("vpvd_visual_feedback_enabled"));
    public static final PrefKey f5746j = ((PrefKey) f5737a.m2011a("spam_reporting"));
    public static final PrefKey f5747k = ((PrefKey) f5737a.m2011a("enable_place_save_nux_history"));
    public static final PrefKey f5748l = ((PrefKey) f5737a.m2011a("follow_videos_nux_history"));
    public static final PrefKey f5749m = ((PrefKey) f5737a.m2011a("page_story_admin_attr_nux_history"));
    public static final PrefKey f5750n = ((PrefKey) f5737a.m2011a("privacy_editing"));
    public static final PrefKey f5751o = ((PrefKey) f5737a.m2011a("demo_ad_invalidation"));
    public static final PrefKey f5752p;
    public static final PrefKey f5753q;
    public static final PrefKey f5754r = ((PrefKey) f5737a.m2011a("music_preview_nux_history"));
    public static final PrefKey f5755s = ((PrefKey) f5737a.m2011a("debug_enabled"));
    public static final PrefKey f5756t = ((PrefKey) f5737a.m2011a("impression_logging_visual_feedback_enabled"));
    public static final PrefKey f5757u = ((PrefKey) f5737a.m2011a("time_since_last_photo_uploaded"));
    public static final PrefKey f5758v = ((PrefKey) f5737a.m2011a("is_flat_buffer_corrupt"));
    public static final PrefKey f5759w = ((PrefKey) f5737a.m2011a("time_last_adchaining_shown"));
    public static final PrefKey f5760x = ((PrefKey) f5737a.m2011a("client_ranking_indicator"));
    public static final PrefKey f5761y = ((PrefKey) f5737a.m2011a("show_comment_cache_state"));
    public static final PrefKey f5762z = ((PrefKey) f5737a.m2011a("inline_feed_survey_enabled"));

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.f987a.m2011a("feed/");
        f5737a = prefKey;
        f5738b = (PrefKey) prefKey.m2011a("permalink_pref");
        prefKey = (PrefKey) f5737a.m2011a("bookmarks/");
        f5752p = prefKey;
        f5753q = (PrefKey) prefKey.m2011a("newsfeed_filter_type_key");
    }

    public final ImmutableSet<PrefKey> mo1206a() {
        return ImmutableSet.of(f5747k, f5749m, f5754r);
    }
}
