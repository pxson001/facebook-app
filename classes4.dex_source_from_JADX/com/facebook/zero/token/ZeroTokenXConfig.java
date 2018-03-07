package com.facebook.zero.token;

import com.facebook.xconfig.core.XConfig;
import com.facebook.xconfig.core.XConfigName;
import com.facebook.xconfig.core.XConfigSetting;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;

/* compiled from: speaker_on */
public class ZeroTokenXConfig extends XConfig {
    public static final XConfigSetting f1957c = new XConfigSetting(f1959e, "exponential_backoff_exponent");
    public static final XConfigSetting f1958d = new XConfigSetting(f1959e, "exponential_backoff_base");
    private static final XConfigName f1959e = new XConfigName("android_zero_token");
    private static final ImmutableSet<XConfigSetting> f1960f = ImmutableSet.of(f1957c, f1958d);

    @Inject
    public ZeroTokenXConfig() {
        super(f1959e, f1960f);
    }
}
