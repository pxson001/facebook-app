package com.facebook.loom.module;

import com.facebook.xconfig.core.XConfig;
import com.facebook.xconfig.core.XConfigName;
import com.facebook.xconfig.core.XConfigSetting;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;

/* compiled from: get_app_name */
public class LoomXConfig extends XConfig {
    public static final XConfigName f11091c = new XConfigName("loom");
    public static final XConfigSetting f11092d = new XConfigSetting(f11091c, "config");

    @Inject
    public LoomXConfig() {
        super(f11091c, ImmutableSet.of(f11092d));
    }
}
