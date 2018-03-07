package com.facebook.backgroundworklog.performanceobserver;

import com.facebook.xconfig.core.XConfig;
import com.facebook.xconfig.core.XConfigName;
import com.facebook.xconfig.core.XConfigSetting;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;

/* compiled from: stickers_db */
public class BackgroundWorkObserverXConfig extends XConfig {
    public static final XConfigSetting f1674c = new XConfigSetting(f1676e, "perf_log_threshold_ms");
    public static final XConfigSetting f1675d = new XConfigSetting(f1676e, "perf_sample_rate");
    private static final XConfigName f1676e = new XConfigName("android_background_work_observer");

    @Inject
    public BackgroundWorkObserverXConfig() {
        super(f1676e, ImmutableSet.of(f1674c, f1675d));
    }
}
