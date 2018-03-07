package com.facebook.feed.xconfig;

import com.facebook.xconfig.core.XConfig;
import com.facebook.xconfig.core.XConfigName;
import com.facebook.xconfig.core.XConfigSetting;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;

/* compiled from: sticker_asset */
public final class VpvStrippedTrackingDataXConfig extends XConfig {
    public static final XConfigSetting f1764c;
    private static final XConfigName f1765d = new XConfigName("android_vpv_stripped_tracking_data_param");
    private static final ImmutableSet<XConfigSetting> f1766e;

    static {
        XConfigSetting xConfigSetting = new XConfigSetting(f1765d, "BLACKLISTED_FIELDS");
        f1764c = xConfigSetting;
        f1766e = ImmutableSet.of(xConfigSetting);
    }

    @Inject
    public VpvStrippedTrackingDataXConfig() {
        super(f1765d, f1766e);
    }
}
