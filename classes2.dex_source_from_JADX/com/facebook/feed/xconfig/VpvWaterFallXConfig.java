package com.facebook.feed.xconfig;

import com.facebook.xconfig.core.XConfig;
import com.facebook.xconfig.core.XConfigName;
import com.facebook.xconfig.core.XConfigSetting;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;

/* compiled from: iorg_background_external_url_prompt */
public final class VpvWaterFallXConfig extends XConfig {
    public static final XConfigSetting f19490c = new XConfigSetting(f19492e, "BATCH_SIZE");
    public static final XConfigSetting f19491d = new XConfigSetting(f19492e, "SEND_INTERVAL");
    private static final XConfigName f19492e = new XConfigName("android_vpv_waterfall_param");
    private static final ImmutableSet<XConfigSetting> f19493f = ImmutableSet.of(f19490c, f19491d);

    @Inject
    public VpvWaterFallXConfig() {
        super(f19492e, f19493f);
    }
}
