package com.facebook.location.foreground;

import com.facebook.xconfig.core.XConfig;
import com.facebook.xconfig.core.XConfigName;
import com.facebook.xconfig.core.XConfigSetting;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;

/* compiled from: stickerPack */
public class GeoPixelXConfig extends XConfig {
    public static final XConfigSetting f1787c = new XConfigSetting(f1788d, "pop_servers");
    private static final XConfigName f1788d = new XConfigName("geopixel_config");

    @Inject
    public GeoPixelXConfig() {
        super(f1788d, ImmutableSet.of(f1787c));
    }
}
