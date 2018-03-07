package com.facebook.messaging.particles;

import com.facebook.xconfig.core.XConfig;
import com.facebook.xconfig.core.XConfigName;
import com.facebook.xconfig.core.XConfigSetting;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;

/* compiled from: static */
public class SnowFallStickersXConfig extends XConfig {
    public static final XConfigSetting f1828c;
    private static final XConfigName f1829d = new XConfigName("messenger_thread_view_snow_fall");
    private static final ImmutableSet<XConfigSetting> f1830e;

    static {
        XConfigSetting xConfigSetting = new XConfigSetting(f1829d, "sticker_ids");
        f1828c = xConfigSetting;
        f1830e = ImmutableSet.of(xConfigSetting);
    }

    @Inject
    public SnowFallStickersXConfig() {
        super(f1829d, f1830e);
    }
}
