package com.facebook.dialtone.switcher;

import com.facebook.inject.InjectorLike;
import com.facebook.xconfig.core.XConfig;
import com.facebook.xconfig.core.XConfigName;
import com.facebook.xconfig.core.XConfigSetting;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;

/* compiled from: skip_sample_entities_fields */
public final class DialtoneManualSwitcherXConfig extends XConfig {
    public static final XConfigSetting f4693c = new XConfigSetting(f4696f, "info_banner_impression_cap");
    public static final XConfigSetting f4694d = new XConfigSetting(f4696f, "zero_balance_tooltip_impression_cap");
    public static final XConfigSetting f4695e = new XConfigSetting(f4696f, "show_optout_tooltip_period");
    private static final XConfigName f4696f = new XConfigName("dialtone_manual_switcher");
    private static final ImmutableSet<XConfigSetting> f4697g = ImmutableSet.of(f4693c, f4694d, f4695e);

    private static DialtoneManualSwitcherXConfig m8479a() {
        return new DialtoneManualSwitcherXConfig();
    }

    @Inject
    public DialtoneManualSwitcherXConfig() {
        super(f4696f, f4697g);
    }

    public static DialtoneManualSwitcherXConfig m8480a(InjectorLike injectorLike) {
        return m8479a();
    }
}
