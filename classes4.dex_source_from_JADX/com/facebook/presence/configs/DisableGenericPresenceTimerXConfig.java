package com.facebook.presence.configs;

import com.facebook.xconfig.core.XConfig;
import com.facebook.xconfig.core.XConfigName;
import com.facebook.xconfig.core.XConfigSetting;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;

/* compiled from: state_error */
public class DisableGenericPresenceTimerXConfig extends XConfig {
    public static final XConfigName f1854c = new XConfigName("android_messenger_disable_generic_presence_timer");
    public static final XConfigSetting f1855d;
    private static final ImmutableSet<XConfigSetting> f1856e;

    static {
        XConfigSetting xConfigSetting = new XConfigSetting(f1854c, "scheduler_timer");
        f1855d = xConfigSetting;
        f1856e = ImmutableSet.of(xConfigSetting);
    }

    @Inject
    public DisableGenericPresenceTimerXConfig() {
        super(f1854c, f1856e);
    }
}
