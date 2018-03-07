package com.facebook.common.appstate.configs;

import com.facebook.xconfig.core.XConfig;
import com.facebook.xconfig.core.XConfigName;
import com.facebook.xconfig.core.XConfigSetting;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;

/* compiled from: sticker_tags */
public class FloatingWindowTimeoutXConfig extends XConfig {
    public static final XConfigName f1712c = new XConfigName("android_messenger_floating_window_timeout");
    public static final XConfigSetting f1713d = new XConfigSetting(f1712c, "floating_window_timeout_length_seconds");
    public static final XConfigSetting f1714e = new XConfigSetting(f1712c, "floating_window_timeout_disabled");
    private static final ImmutableSet<XConfigSetting> f1715f = ImmutableSet.of(f1713d, f1714e);

    @Inject
    public FloatingWindowTimeoutXConfig() {
        super(f1712c, f1715f);
    }
}
