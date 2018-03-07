package com.facebook.richdocument.config;

import com.facebook.xconfig.core.XConfig;
import com.facebook.xconfig.core.XConfigName;
import com.facebook.xconfig.core.XConfigSetting;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;

/* compiled from: starve_out_audio_window_ms */
public class InstantArticlesXConfig extends XConfig {
    public static final XConfigSetting f1873c = new XConfigSetting(f1875e, "share_menu_packages");
    public static final XConfigSetting f1874d = new XConfigSetting(f1875e, "hosts_that_shouldnt_be_wrapped_in_iframes");
    private static final XConfigName f1875e = new XConfigName("android_instant_articles");

    @Inject
    public InstantArticlesXConfig() {
        super(f1875e, ImmutableSet.of(f1873c, f1874d));
    }
}
