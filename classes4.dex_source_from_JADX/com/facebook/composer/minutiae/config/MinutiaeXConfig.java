package com.facebook.composer.minutiae.config;

import com.facebook.xconfig.core.XConfig;
import com.facebook.xconfig.core.XConfigName;
import com.facebook.xconfig.core.XConfigSetting;
import com.google.common.collect.ImmutableSet;

/* compiled from: sticker_storage_download */
public class MinutiaeXConfig extends XConfig {
    public static final XConfigName f1716c = new XConfigName("minutiae_android_xconfig");
    public static final XConfigSetting f1717d;
    public static final ImmutableSet<XConfigSetting> f1718e;

    static {
        XConfigSetting xConfigSetting = new XConfigSetting(f1716c, "verbs_config_version");
        f1717d = xConfigSetting;
        f1718e = ImmutableSet.of(xConfigSetting);
    }

    public MinutiaeXConfig() {
        super(f1716c, f1718e);
    }
}
