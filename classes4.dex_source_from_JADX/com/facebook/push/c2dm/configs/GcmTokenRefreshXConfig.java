package com.facebook.push.c2dm.configs;

import com.facebook.xconfig.core.XConfig;
import com.facebook.xconfig.core.XConfigName;
import com.facebook.xconfig.core.XConfigSetting;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;

/* compiled from: starve_out_window_ms */
public class GcmTokenRefreshXConfig extends XConfig {
    public static final XConfigSetting f1867c = new XConfigSetting(f1871g, "gcm_reg_frequency_s");
    public static final XConfigSetting f1868d = new XConfigSetting(f1871g, "min_push_intervals_s");
    public static final XConfigSetting f1869e = new XConfigSetting(f1871g, "gcm_reg_frequency_s_overrides");
    public static final XConfigSetting f1870f = new XConfigSetting(f1871g, "min_push_intervals_s_overrides");
    private static final XConfigName f1871g = new XConfigName("android_push_token_refresh");
    private static final ImmutableSet<XConfigSetting> f1872h = ImmutableSet.of(f1867c, f1868d, f1869e, f1870f);

    @Inject
    public GcmTokenRefreshXConfig() {
        super(f1871g, f1872h);
    }
}
