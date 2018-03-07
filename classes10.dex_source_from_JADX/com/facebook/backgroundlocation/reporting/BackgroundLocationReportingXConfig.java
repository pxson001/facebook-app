package com.facebook.backgroundlocation.reporting;

import com.facebook.inject.InjectorLike;
import com.facebook.xconfig.core.XConfig;
import com.facebook.xconfig.core.XConfigName;
import com.facebook.xconfig.core.XConfigSetting;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;

/* compiled from: diode_screen */
public class BackgroundLocationReportingXConfig extends XConfig {
    static final XConfigSetting f14905c = new XConfigSetting(f14908f, "desired_time_between_updates_ms");
    static final XConfigSetting f14906d = new XConfigSetting(f14908f, "min_time_between_updates_ms");
    static final XConfigSetting f14907e = new XConfigSetting(f14908f, "time_between_waking_network_ms");
    private static final XConfigName f14908f = new XConfigName("android_background_location_config");
    private static final ImmutableSet<XConfigSetting> f14909g = ImmutableSet.of(f14905c, f14906d, f14907e);

    public static BackgroundLocationReportingXConfig m15361a(InjectorLike injectorLike) {
        return new BackgroundLocationReportingXConfig();
    }

    @Inject
    public BackgroundLocationReportingXConfig() {
        super(f14908f, f14909g);
    }
}
