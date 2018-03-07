package com.facebook.api.ufiservices.config;

import com.facebook.xconfig.core.XConfig;
import com.facebook.xconfig.core.XConfigName;
import com.facebook.xconfig.core.XConfigSetting;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;

/* compiled from: group_threads/ */
public class FeedbackPrefetchPolicyXConfig extends XConfig {
    public static final XConfigSetting f21641c = new XConfigSetting(f21652n, "fetch_disk_and_network_in_parallel");
    public static final XConfigSetting f21642d = new XConfigSetting(f21652n, "always_fetch_more_recent_from_network");
    public static final XConfigSetting f21643e = new XConfigSetting(f21652n, "prefetch_staleness_time");
    public static final XConfigSetting f21644f = new XConfigSetting(f21652n, "prefetch_in_excellent_connectivity");
    public static final XConfigSetting f21645g = new XConfigSetting(f21652n, "prefetch_low_priority_feedback");
    public static final XConfigSetting f21646h = new XConfigSetting(f21652n, "comments_fetch_limit");
    public static final XConfigSetting f21647i = new XConfigSetting(f21652n, "likers_fetch_limit");
    public static final XConfigSetting f21648j = new XConfigSetting(f21652n, "max_batch_size");
    public static final XConfigSetting f21649k = new XConfigSetting(f21652n, "max_cache_age");
    public static final XConfigSetting f21650l = new XConfigSetting(f21652n, "bg_prefetch_in_excellent_connectivity");
    public static final XConfigSetting f21651m = new XConfigSetting(f21652n, "bg_prefetch_low_priority_feedback");
    private static final XConfigName f21652n = new XConfigName("fb4a_feedback_prefetch_policy");
    private static final ImmutableSet<XConfigSetting> f21653o = ImmutableSet.of(f21641c, f21642d, f21643e, f21644f, f21645g, f21646h, f21647i, f21648j, f21649k, f21650l, f21651m);

    @Inject
    public FeedbackPrefetchPolicyXConfig() {
        super(f21652n, f21653o);
    }
}
