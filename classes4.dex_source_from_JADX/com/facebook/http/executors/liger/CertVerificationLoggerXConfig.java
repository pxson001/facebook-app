package com.facebook.http.executors.liger;

import com.facebook.xconfig.core.XConfig;
import com.facebook.xconfig.core.XConfigName;
import com.facebook.xconfig.core.XConfigSetting;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;

/* compiled from: sticker_asserts as animated_assets  */
public class CertVerificationLoggerXConfig extends XConfig {
    public static final XConfigName f1773c = new XConfigName("cert_verification");
    public static final XConfigSetting f1774d = new XConfigSetting(f1773c, "verification_logging_pool_size");
    public static final XConfigSetting f1775e = new XConfigSetting(f1773c, "verification_logging_enabled");
    private static final ImmutableSet<XConfigSetting> f1776f = ImmutableSet.of(f1774d, f1775e);

    @Inject
    public CertVerificationLoggerXConfig() {
        super(f1773c, f1776f);
    }
}
