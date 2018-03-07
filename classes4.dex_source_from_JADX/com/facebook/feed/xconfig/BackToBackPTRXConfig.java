package com.facebook.feed.xconfig;

import com.facebook.xconfig.core.XConfig;
import com.facebook.xconfig.core.XConfigName;
import com.facebook.xconfig.core.XConfigSetting;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;

/* compiled from: sticker_auto_fetch */
public class BackToBackPTRXConfig extends XConfig {
    public static final XConfigSetting f1758c;
    private static final XConfigName f1759d = new XConfigName("BACK_TO_BACK_PTR");
    private static final ImmutableSet<XConfigSetting> f1760e;

    static {
        XConfigSetting xConfigSetting = new XConfigSetting(f1759d, "time_threshold");
        f1758c = xConfigSetting;
        f1760e = ImmutableSet.of(xConfigSetting);
    }

    @Inject
    public BackToBackPTRXConfig() {
        super(f1759d, f1760e);
    }
}
