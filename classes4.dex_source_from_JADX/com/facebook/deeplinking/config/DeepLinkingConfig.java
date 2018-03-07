package com.facebook.deeplinking.config;

import com.facebook.xconfig.core.XConfig;
import com.facebook.xconfig.core.XConfigName;
import com.facebook.xconfig.core.XConfigSetting;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;

/* compiled from: sticker_id */
public class DeepLinkingConfig extends XConfig {
    public static final XConfigSetting f1740c = new XConfigSetting(f1741d, "blacklisted_paths");
    private static final XConfigName f1741d = new XConfigName("android_deep_linking");

    @Inject
    public DeepLinkingConfig() {
        super(f1741d, ImmutableSet.of(f1740c));
    }
}
