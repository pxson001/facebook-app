package com.facebook.messaging.sms.defaultapp.config;

import com.facebook.xconfig.core.XConfig;
import com.facebook.xconfig.core.XConfigName;
import com.facebook.xconfig.core.XConfigSetting;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;

/* compiled from: state_playing */
public class CarrierXConfig extends XConfig {
    public static final XConfigSetting f1838c;
    private static final XConfigName f1839d = new XConfigName("sms_takeover_carrier_config");
    private static final ImmutableSet<XConfigSetting> f1840e;

    static {
        XConfigSetting xConfigSetting = new XConfigSetting(f1839d, "max_message_size");
        f1838c = xConfigSetting;
        f1840e = ImmutableSet.of(xConfigSetting);
    }

    @Inject
    public CarrierXConfig() {
        super(f1839d, f1840e);
    }
}
