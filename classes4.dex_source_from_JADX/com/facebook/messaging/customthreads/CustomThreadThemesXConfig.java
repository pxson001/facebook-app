package com.facebook.messaging.customthreads;

import com.facebook.xconfig.core.XConfig;
import com.facebook.xconfig.core.XConfigName;
import com.facebook.xconfig.core.XConfigSetting;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;

/* compiled from: static_map_url */
public class CustomThreadThemesXConfig extends XConfig {
    public static final XConfigSetting f1810c;
    private static final XConfigName f1811d = new XConfigName("messenger_customthreads_color_themes");
    private static final ImmutableSet<XConfigSetting> f1812e;

    static {
        XConfigSetting xConfigSetting = new XConfigSetting(f1811d, "themes");
        f1810c = xConfigSetting;
        f1812e = ImmutableSet.of(xConfigSetting);
    }

    @Inject
    public CustomThreadThemesXConfig() {
        super(f1811d, f1812e);
    }
}
