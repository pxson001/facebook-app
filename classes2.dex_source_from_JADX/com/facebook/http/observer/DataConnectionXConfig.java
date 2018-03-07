package com.facebook.http.observer;

import com.facebook.xconfig.core.XConfig;
import com.facebook.xconfig.core.XConfigName;
import com.facebook.xconfig.core.XConfigSetting;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;

/* compiled from: maps.googleapis.com */
public class DataConnectionXConfig extends XConfig {
    public static final XConfigName f15121c = new XConfigName("data_connection_xconfig");
    public static final XConfigSetting f15122d = new XConfigSetting(f15121c, "time_to_quality_change_ms");
    public static final XConfigSetting f15123e = new XConfigSetting(f15121c, "time_to_connection_quality_reset");
    public static final XConfigSetting f15124f = new XConfigSetting(f15121c, "geometric_samples_till_change");
    public static final XConfigSetting f15125g = new XConfigSetting(f15121c, "samples_to_latency_change");
    public static final XConfigSetting f15126h = new XConfigSetting(f15121c, "geometric_decay_constant");
    public static final XConfigSetting f15127i = new XConfigSetting(f15121c, "rtt_decay_constant");
    public static final XConfigSetting f15128j = new XConfigSetting(f15121c, "bandwidth_poor");
    public static final XConfigSetting f15129k = new XConfigSetting(f15121c, "bandwidth_moderate");
    public static final XConfigSetting f15130l = new XConfigSetting(f15121c, "bandwidth_good");
    public static final XConfigSetting f15131m = new XConfigSetting(f15121c, "rtt_poor");
    public static final XConfigSetting f15132n = new XConfigSetting(f15121c, "rtt_moderate");
    public static final XConfigSetting f15133o = new XConfigSetting(f15121c, "rtt_good");
    public static final XConfigSetting f15134p = new XConfigSetting(f15121c, "hysteresis_percent");
    public static final ImmutableSet<XConfigSetting> f15135q = ImmutableSet.of(f15122d, f15123e, f15124f, f15125g, f15126h, f15127i, f15128j, f15129k, f15130l, f15131m, f15132n, f15133o, f15134p);

    @Inject
    public DataConnectionXConfig() {
        super(f15121c, f15135q);
    }
}
