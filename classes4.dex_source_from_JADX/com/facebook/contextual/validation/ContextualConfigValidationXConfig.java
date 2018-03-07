package com.facebook.contextual.validation;

import com.facebook.xconfig.core.XConfig;
import com.facebook.xconfig.core.XConfigName;
import com.facebook.xconfig.core.XConfigSetting;
import com.google.common.collect.ImmutableSet;

/* compiled from: sticker_ids */
public class ContextualConfigValidationXConfig extends XConfig {
    public static final XConfigSetting f1729c = new XConfigSetting(f1732f, "alpha");
    public static final XConfigSetting f1730d = new XConfigSetting(f1732f, "beta");
    public static final XConfigSetting f1731e = new XConfigSetting(f1732f, "multi");
    private static final XConfigName f1732f = new XConfigName("contextual_config_test");
    private static final ImmutableSet<XConfigSetting> f1733g = ImmutableSet.of(f1729c, f1730d, f1731e);

    public ContextualConfigValidationXConfig() {
        super(f1732f, f1733g);
    }
}
