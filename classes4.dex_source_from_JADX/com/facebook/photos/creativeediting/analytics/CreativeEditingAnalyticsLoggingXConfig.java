package com.facebook.photos.creativeediting.analytics;

import com.facebook.xconfig.core.XConfig;
import com.facebook.xconfig.core.XConfigName;
import com.facebook.xconfig.core.XConfigSetting;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;

/* compiled from: state_now */
public class CreativeEditingAnalyticsLoggingXConfig extends XConfig {
    public static final XConfigSetting f1848c;
    private static final XConfigName f1849d = new XConfigName("creative_editing_sampling_rate");
    private static final ImmutableSet<XConfigSetting> f1850e;

    static {
        XConfigSetting xConfigSetting = new XConfigSetting(f1849d, "logging_sampling_rate");
        f1848c = xConfigSetting;
        f1850e = ImmutableSet.of(xConfigSetting);
    }

    @Inject
    public CreativeEditingAnalyticsLoggingXConfig() {
        super(f1849d, f1850e);
    }
}
