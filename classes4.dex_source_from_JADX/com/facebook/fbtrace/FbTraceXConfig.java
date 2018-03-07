package com.facebook.fbtrace;

import com.facebook.xconfig.core.XConfig;
import com.facebook.xconfig.core.XConfigName;
import com.facebook.xconfig.core.XConfigSetting;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;

/* compiled from: sticker_background_fetch */
public class FbTraceXConfig extends XConfig {
    public static final XConfigName f1751c = new XConfigName("mobile_fbtrace_config");
    public static final XConfigSetting f1752d = new XConfigSetting(f1751c, "sampling_rate");
    public static final XConfigSetting f1753e = new XConfigSetting(f1751c, "voip_sampling_rate");
    private static final ImmutableSet<XConfigSetting> f1754f = ImmutableSet.of(f1752d, f1753e);

    @Inject
    public FbTraceXConfig() {
        super(f1751c, f1754f);
    }
}
