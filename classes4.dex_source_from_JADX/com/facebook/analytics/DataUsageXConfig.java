package com.facebook.analytics;

import com.facebook.xconfig.core.XConfig;
import com.facebook.xconfig.core.XConfigName;
import com.facebook.xconfig.core.XConfigSetting;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;

/* compiled from: sticky_guardrail_manager_deserialize_error */
public class DataUsageXConfig extends XConfig {
    public static final XConfigName f1662c = new XConfigName("fb4a_mobile_data_usage");
    public static final XConfigSetting f1663d;
    public static final ImmutableSet<XConfigSetting> f1664e;

    static {
        XConfigSetting xConfigSetting = new XConfigSetting(f1662c, "data_usage_per_user");
        f1663d = xConfigSetting;
        f1664e = ImmutableSet.of(xConfigSetting);
    }

    @Inject
    public DataUsageXConfig() {
        super(f1662c, f1664e);
    }
}
