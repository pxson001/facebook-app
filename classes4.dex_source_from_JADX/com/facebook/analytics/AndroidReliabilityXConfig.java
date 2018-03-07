package com.facebook.analytics;

import com.facebook.xconfig.core.XConfig;
import com.facebook.xconfig.core.XConfigName;
import com.facebook.xconfig.core.XConfigSetting;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;

/* compiled from: streamable_json_response */
public class AndroidReliabilityXConfig extends XConfig {
    public static final XConfigName f1648c = new XConfigName("android_reliability");
    public static final XConfigSetting f1649d;
    public static final ImmutableSet<XConfigSetting> f1650e;

    static {
        XConfigSetting xConfigSetting = new XConfigSetting(f1648c, "anr_delay");
        f1649d = xConfigSetting;
        f1650e = ImmutableSet.of(xConfigSetting);
    }

    @Inject
    public AndroidReliabilityXConfig() {
        super(f1648c, f1650e);
    }
}
