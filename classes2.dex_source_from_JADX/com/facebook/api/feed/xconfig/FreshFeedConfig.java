package com.facebook.api.feed.xconfig;

import com.facebook.xconfig.core.XConfig;
import com.facebook.xconfig.core.XConfigName;
import com.facebook.xconfig.core.XConfigSetting;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.Builder;
import javax.inject.Inject;

/* compiled from: set_payment_pin */
public class FreshFeedConfig extends XConfig {
    public static final XConfigName f5201c = new XConfigName("fb4a_fresh_feed");
    public static final XConfigSetting f5202d = new XConfigSetting(f5201c, "max_story_freshness_delta_minutes");
    public static final XConfigSetting f5203e = new XConfigSetting(f5201c, "min_ad_freshness_delta_minutes");
    public static final XConfigSetting f5204f = new XConfigSetting(f5201c, "ranking_config");
    public static final XConfigSetting f5205g = new XConfigSetting(f5201c, "more_story_pill_timeout_to_show_secs");
    public static final XConfigSetting f5206h = new XConfigSetting(f5201c, "reset_feed_view_time_minutes");
    public static final XConfigSetting f5207i = new XConfigSetting(f5201c, "reranking_timeout_seconds");
    public static final XConfigSetting f5208j = new XConfigSetting(f5201c, "num_stories_to_prepare_for_scroll");
    public static final XConfigSetting f5209k = new XConfigSetting(f5201c, "num_ads_to_prepare_for_scroll");
    public static final XConfigSetting f5210l = new XConfigSetting(f5201c, "num_stories_to_return_for_scroll_event");
    public static final XConfigSetting f5211m = new XConfigSetting(f5201c, "min_stories_in_feed_unit_collection");
    public static final XConfigSetting f5212n = new XConfigSetting(f5201c, "min_num_fresh_stories_before_tail_fetch");
    public static final XConfigSetting f5213o = new XConfigSetting(f5201c, "min_auto_refresh_period_sec");
    public static final XConfigSetting f5214p = new XConfigSetting(f5201c, "auto_refresh_after_snap_shot_hit_delay_sec");
    public static final XConfigSetting f5215q = new XConfigSetting(f5201c, "fresh_definition");
    public static final XConfigSetting f5216r = new XConfigSetting(f5201c, "more_stories_pill_enabled");
    public static final XConfigSetting f5217s = new XConfigSetting(f5201c, "auto_refresh_enabled");
    public static final XConfigSetting f5218t = new XConfigSetting(f5201c, "use_snap_shot_aware_auto_refresh");
    public static final XConfigSetting f5219u = new XConfigSetting(f5201c, "stories_order");
    public static final ImmutableSet<XConfigSetting> f5220v = ImmutableSet.of(f5202d, f5203e, f5205g, f5206h, f5207i, f5208j, f5209k, f5210l, f5211m, f5212n, f5213o, f5214p, f5215q);
    public static final ImmutableSet<XConfigSetting> f5221w = ImmutableSet.of(f5216r, f5217s, f5218t);
    public static final ImmutableSet<XConfigSetting> f5222x = ImmutableSet.of(f5204f);
    public static final ImmutableSet<XConfigSetting> f5223y = ImmutableSet.of(f5219u);
    private static final ImmutableSet<XConfigSetting> f5224z = new Builder().m4809b(f5220v).m4809b(f5222x).m4809b(f5221w).m4809b(f5223y).m4812b();

    @Inject
    public FreshFeedConfig() {
        super(f5201c, f5224z);
    }
}
