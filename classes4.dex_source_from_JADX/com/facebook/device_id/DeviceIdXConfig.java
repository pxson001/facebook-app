package com.facebook.device_id;

import com.facebook.xconfig.core.XConfig;
import com.facebook.xconfig.core.XConfigName;
import com.facebook.xconfig.core.XConfigSetting;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;

/* compiled from: total_sd */
public class DeviceIdXConfig extends XConfig {
    public static final XConfigName f861c = new XConfigName("android_deviceid");
    public static final XConfigSetting f862d = new XConfigSetting(f861c, "valid_packages");
    public static final XConfigSetting f863e = new XConfigSetting(f861c, "sync_interval");
    public static final XConfigSetting f864f = new XConfigSetting(f861c, "enable_phoneid_sync");
    public static final XConfigSetting f865g = new XConfigSetting(f861c, "phoneid_sync_interval");
    static final ImmutableSet<XConfigSetting> f866h = ImmutableSet.of(f862d, f863e, f864f, f865g);

    @Inject
    public DeviceIdXConfig() {
        super(f861c, f866h);
    }
}
