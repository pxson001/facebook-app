package com.facebook.privacy.checkup.abtest;

import com.facebook.xconfig.core.XConfig;
import com.facebook.xconfig.core.XConfigName;
import com.facebook.xconfig.core.XConfigSetting;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;

/* compiled from: state_before */
public class PrivacyCheckupMobileXConfig extends XConfig {
    public static final XConfigSetting f1857c = new XConfigSetting(f1861g, "batching_threshold");
    public static final XConfigSetting f1858d = new XConfigSetting(f1861g, "max_num_mutation_retries");
    public static final XConfigSetting f1859e = new XConfigSetting(f1861g, "network_timeout_ms_for_blocking_requests");
    public static final XConfigSetting f1860f = new XConfigSetting(f1861g, "num_failures_to_declare_review_doesnt_work");
    private static final XConfigName f1861g = new XConfigName("privacy_checkup_mobile");
    private static final ImmutableSet<XConfigSetting> f1862h = ImmutableSet.of(f1857c, f1858d, f1859e, f1860f);

    @Inject
    public PrivacyCheckupMobileXConfig() {
        super(f1861g, f1862h);
    }
}
