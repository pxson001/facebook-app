package com.facebook.location.foreground;

import com.facebook.xconfig.core.XConfig;
import com.facebook.xconfig.core.XConfigName;
import com.facebook.xconfig.core.XConfigSetting;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;

/* compiled from: mFeatureAnimations */
public class ForegroundLocationFrameworkXConfig extends XConfig {
    public static final XConfigSetting f15619c = new XConfigSetting(f15631o, "medium_power_scan_interval_ms");
    public static final XConfigSetting f15620d = new XConfigSetting(f15631o, "max_age_ms");
    public static final XConfigSetting f15621e = new XConfigSetting(f15631o, "desired_age_ms");
    public static final XConfigSetting f15622f = new XConfigSetting(f15631o, "desired_accuracy_meters");
    public static final XConfigSetting f15623g = new XConfigSetting(f15631o, "timeout_ms");
    public static final XConfigSetting f15624h = new XConfigSetting(f15631o, "wifi_scan_min_rssi");
    public static final XConfigSetting f15625i = new XConfigSetting(f15631o, "wifi_scan_max_results");
    public static final XConfigSetting f15626j = new XConfigSetting(f15631o, "wifi_scan_include_frequency");
    public static final XConfigSetting f15627k = new XConfigSetting(f15631o, "use_signal_balanced_location_manager");
    public static final XConfigSetting f15628l = new XConfigSetting(f15631o, "use_signal_wifi_scan");
    public static final XConfigSetting f15629m = new XConfigSetting(f15631o, "use_signal_connected_wifi");
    public static final XConfigSetting f15630n = new XConfigSetting(f15631o, "use_signal_neighbor_cell");
    private static final XConfigName f15631o = new XConfigName("foreground_location_config");
    private static final ImmutableSet<XConfigSetting> f15632p = ImmutableSet.of(f15619c, f15620d, f15621e, f15622f, f15623g, f15627k, f15628l, f15629m, f15630n);

    @Inject
    public ForegroundLocationFrameworkXConfig() {
        super(f15631o, f15632p);
    }
}
