package com.facebook.messaging.analytics.reliability;

import com.facebook.xconfig.core.XConfig;
import com.facebook.xconfig.core.XConfigName;
import com.facebook.xconfig.core.XConfigSetting;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;

/* compiled from: step_name */
public final class AggregatedReliabilityLoggerXConfig extends XConfig {
    public static final XConfigSetting f1793c = new XConfigSetting(f1796f, "MAX_ENTRIES_TO_KEEP");
    public static final XConfigSetting f1794d = new XConfigSetting(f1796f, "MIN_TIME_TO_KEEP_ENTRIES_SECONDS");
    public static final XConfigSetting f1795e = new XConfigSetting(f1796f, "MAX_TIME_TO_KEEP_ENTRIES_SECONDS");
    private static final XConfigName f1796f = new XConfigName("android_messenger_aggr_reliability");
    private static final ImmutableSet<XConfigSetting> f1797g = ImmutableSet.of(f1793c, f1794d, f1795e);

    @Inject
    public AggregatedReliabilityLoggerXConfig() {
        super(f1796f, f1797g);
    }
}
