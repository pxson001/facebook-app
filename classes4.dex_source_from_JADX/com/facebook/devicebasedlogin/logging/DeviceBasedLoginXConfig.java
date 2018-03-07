package com.facebook.devicebasedlogin.logging;

import com.facebook.xconfig.core.XConfig;
import com.facebook.xconfig.core.XConfigName;
import com.facebook.xconfig.core.XConfigSetting;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;

/* compiled from: sticker_fetch_packs */
public class DeviceBasedLoginXConfig extends XConfig {
    public static final XConfigName f1742c = new XConfigName("device_based_login_logging_sampling_rate");
    public static final XConfigSetting f1743d;
    static final ImmutableSet<XConfigSetting> f1744e;

    static {
        XConfigSetting xConfigSetting = new XConfigSetting(f1742c, "logging_sampling_rate");
        f1743d = xConfigSetting;
        f1744e = ImmutableSet.of(xConfigSetting);
    }

    @Inject
    public DeviceBasedLoginXConfig() {
        super(f1742c, f1744e);
    }
}
