package com.facebook.ssl.reporter;

import com.facebook.xconfig.core.XConfig;
import com.facebook.xconfig.core.XConfigName;
import com.facebook.xconfig.core.XConfigSetting;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;

/* compiled from: startup_retry */
public class RootCAReporterXConfig extends XConfig {
    public static final XConfigName f1882c = new XConfigName("rootca_sampling");
    public static final XConfigSetting f1883d = new XConfigSetting(f1882c, "cert_pool_size");
    public static final XConfigSetting f1884e = new XConfigSetting(f1882c, "logging_pool_size");
    public static final XConfigSetting f1885f = new XConfigSetting(f1882c, "cert_enabled");
    public static final XConfigSetting f1886g = new XConfigSetting(f1882c, "logging_enabled");
    private static final ImmutableSet<XConfigSetting> f1887h = ImmutableSet.of(f1883d, f1884e, f1885f, f1886g);

    @Inject
    public RootCAReporterXConfig() {
        super(f1882c, f1887h);
    }
}
