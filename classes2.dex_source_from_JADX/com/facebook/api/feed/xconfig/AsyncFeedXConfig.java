package com.facebook.api.feed.xconfig;

import com.facebook.xconfig.core.XConfig;
import com.facebook.xconfig.core.XConfigName;
import com.facebook.xconfig.core.XConfigSetting;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.Builder;
import javax.inject.Inject;

/* compiled from: session_scan_fail_count */
public class AsyncFeedXConfig extends XConfig {
    public static final XConfigSetting f5429A = new XConfigSetting(f5442c, "warm_start_reranking_enabled");
    public static final XConfigSetting f5430B = new XConfigSetting(f5442c, "predicted_prefetch_schedule");
    public static final XConfigSetting f5431C = new XConfigSetting(f5442c, "reranking_sortby");
    public static final XConfigSetting f5432D = new XConfigSetting(f5442c, "ranking_policy");
    public static final XConfigSetting f5433E = new XConfigSetting(f5442c, "cache_invalidation_interval");
    public static final XConfigSetting f5434F = new XConfigSetting(f5442c, "reranking_enabled_by_connection_class");
    public static final XConfigSetting f5435G = new XConfigSetting(f5442c, "avoid_nsp_at_top_after_head_fetch");
    public static final XConfigSetting f5436H = new XConfigSetting(f5442c, "background_newsfeed_prefetch_polling_interval_threshold_minutes");
    public static final ImmutableSet<XConfigSetting> f5437I = ImmutableSet.of(f5443d, f5444e, f5445f, f5446g, f5447h, f5448i, f5449j, f5450k, f5451l, f5452m, f5453n, f5459t, f5460u, f5461v, f5462w, f5433E, f5436H);
    public static final ImmutableSet<XConfigSetting> f5438J = ImmutableSet.of(f5463x, f5464y, f5465z, f5429A, f5454o, f5455p, f5456q, f5457r, f5435G, f5458s);
    public static final ImmutableSet<XConfigSetting> f5439K = ImmutableSet.of(f5430B, f5434F);
    public static final ImmutableSet<XConfigSetting> f5440L = ImmutableSet.of(f5431C, f5432D);
    private static final ImmutableSet<XConfigSetting> f5441M = new Builder().m4809b(f5437I).m4809b(f5438J).m4809b(f5439K).m4809b(f5440L).m4812b();
    public static final XConfigName f5442c = new XConfigName("fb4a_async_feed");
    public static final XConfigSetting f5443d = new XConfigSetting(f5442c, "background_newsfeed_prefetch_interval");
    public static final XConfigSetting f5444e = new XConfigSetting(f5442c, "background_newsfeed_prefetch_num_stories");
    public static final XConfigSetting f5445f = new XConfigSetting(f5442c, "ptr_client_reranking_timeout");
    public static final XConfigSetting f5446g = new XConfigSetting(f5442c, "max_age_for_reranking");
    public static final XConfigSetting f5447h = new XConfigSetting(f5442c, "cache_sync_min_battery");
    public static final XConfigSetting f5448i = new XConfigSetting(f5442c, "cache_sync_num_stories_to_sync");
    public static final XConfigSetting f5449j = new XConfigSetting(f5442c, "cache_sync_newest_fetch_time_threshold");
    public static final XConfigSetting f5450k = new XConfigSetting(f5442c, "cache_sync_after_cold_start_delay");
    public static final XConfigSetting f5451l = new XConfigSetting(f5442c, "cache_sync_normal_interval");
    public static final XConfigSetting f5452m = new XConfigSetting(f5442c, "cache_sync_max_interval");
    public static final XConfigSetting f5453n = new XConfigSetting(f5442c, "cache_sync_min_interval");
    public static final XConfigSetting f5454o = new XConfigSetting(f5442c, "cache_sync_feed_back_prefetch_enabled");
    public static final XConfigSetting f5455p = new XConfigSetting(f5442c, "cache_sync_image_cache_state_sync_enabled");
    public static final XConfigSetting f5456q = new XConfigSetting(f5442c, "cache_sync_rerank_stories_enabled");
    public static final XConfigSetting f5457r = new XConfigSetting(f5442c, "cache_sync_prefetch_images_enabled");
    public static final XConfigSetting f5458s = new XConfigSetting(f5442c, "cache_sync_prefetch_instant_articles_enabled");
    public static final XConfigSetting f5459t = new XConfigSetting(f5442c, "loading_indicator_allowed_delta_ms");
    public static final XConfigSetting f5460u = new XConfigSetting(f5442c, "minimum_time_between_warm_start_rerank_minutes");
    public static final XConfigSetting f5461v = new XConfigSetting(f5442c, "tail_fetch_timeout_seconds");
    public static final XConfigSetting f5462w = new XConfigSetting(f5442c, "staged_feed_num_units_to_prefetch");
    public static final XConfigSetting f5463x = new XConfigSetting(f5442c, "loading_indicator_logging_allowed");
    public static final XConfigSetting f5464y = new XConfigSetting(f5442c, "same_story_on_top_logging_allowed");
    public static final XConfigSetting f5465z = new XConfigSetting(f5442c, "is_sort_key_less_feed_unit_collection_enabled");

    @Inject
    public AsyncFeedXConfig() {
        super(f5442c, f5441M);
    }
}
