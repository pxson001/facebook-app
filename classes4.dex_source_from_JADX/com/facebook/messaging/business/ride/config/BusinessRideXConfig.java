package com.facebook.messaging.business.ride.config;

import com.facebook.common.json.FbObjectMapper;
import com.facebook.xconfig.core.XConfig;
import com.facebook.xconfig.core.XConfigName;
import com.facebook.xconfig.core.XConfigSetting;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import java.io.IOException;
import javax.inject.Inject;

/* compiled from: static_uri */
public class BusinessRideXConfig extends XConfig {
    public static final XConfigSetting f1807c;
    private static final XConfigName f1808d = new XConfigName("android_messenger_rideshare");
    private static final ImmutableSet<XConfigSetting> f1809e;

    static {
        XConfigSetting xConfigSetting = new XConfigSetting(f1808d, "trigger_keywords");
        f1807c = xConfigSetting;
        f1809e = ImmutableSet.of(xConfigSetting);
    }

    @Inject
    public BusinessRideXConfig() {
        super(f1808d, f1809e);
    }

    public static ImmutableMap<String, String> m1945a(String str) {
        try {
            return (ImmutableMap) FbObjectMapper.i().a(str, new 1());
        } catch (IOException e) {
            return ImmutableBiMap.a();
        }
    }
}
