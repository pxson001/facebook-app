package com.facebook.messaging.business.promotion.config;

import com.facebook.xconfig.core.XConfig;
import com.facebook.xconfig.core.XConfigName;
import com.facebook.xconfig.core.XConfigSetting;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;

/* compiled from: step_counter */
public class AdsImpressionLoggingXConfig extends XConfig {
    public static final XConfigSetting f1804c;
    private static final XConfigName f1805d = new XConfigName("messenger_ads_impression_logging_config");
    private static final ImmutableSet<XConfigSetting> f1806e;

    static {
        XConfigSetting xConfigSetting = new XConfigSetting(f1805d, "impression_logging_threshold");
        f1804c = xConfigSetting;
        f1806e = ImmutableSet.of(xConfigSetting);
    }

    @Inject
    public AdsImpressionLoggingXConfig() {
        super(f1805d, f1806e);
    }
}
