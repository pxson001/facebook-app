package com.facebook.messaging.particles;

import com.facebook.xconfig.core.XConfig;
import com.facebook.xconfig.core.XConfigName;
import com.facebook.xconfig.core.XConfigSetting;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;

/* compiled from: static_asset */
public class FloatingHeartStickersXConfig extends XConfig {
    public static final XConfigSetting f1825c;
    private static final XConfigName f1826d = new XConfigName("messenger_floating_heart_sticker_ids");
    private static final ImmutableSet<XConfigSetting> f1827e;

    static {
        XConfigSetting xConfigSetting = new XConfigSetting(f1826d, "sticker_ids");
        f1825c = xConfigSetting;
        f1827e = ImmutableSet.of(xConfigSetting);
    }

    @Inject
    public FloatingHeartStickersXConfig() {
        super(f1826d, f1827e);
    }
}
