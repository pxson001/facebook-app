package com.facebook.composer.minutiae.ridge.config;

import com.facebook.xconfig.core.XConfig;
import com.facebook.xconfig.core.XConfigName;
import com.facebook.xconfig.core.XConfigSetting;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;

/* compiled from: sticker_results */
public class RidgeXConfig extends XConfig {
    public static final XConfigSetting f1719c = new XConfigSetting(f1722f, "help_url");
    public static final XConfigSetting f1720d = new XConfigSetting(f1722f, "tooltip_nux_max_imp");
    public static final XConfigSetting f1721e = new XConfigSetting(f1722f, "tooltip_nux_categories");
    private static final XConfigName f1722f = new XConfigName("ridge_android_xconfig");
    private static final ImmutableSet<XConfigSetting> f1723g = ImmutableSet.of(f1719c, f1720d, f1721e);

    @Inject
    public RidgeXConfig() {
        super(f1722f, f1723g);
    }
}
