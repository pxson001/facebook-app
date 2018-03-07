package com.facebook.attribution;

import com.facebook.xconfig.core.XConfig;
import com.facebook.xconfig.core.XConfigName;
import com.facebook.xconfig.core.XConfigSetting;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;

/* compiled from: markerEnd */
public final class AttributionIdXConfig extends XConfig {
    public static final XConfigSetting f15036c;
    private static final XConfigName f15037d = new XConfigName("attribution_id_rotation_xconfig");
    private static final ImmutableSet<XConfigSetting> f15038e;

    static {
        XConfigSetting xConfigSetting = new XConfigSetting(f15037d, "sync_interval");
        f15036c = xConfigSetting;
        f15038e = ImmutableSet.of(xConfigSetting);
    }

    @Inject
    public AttributionIdXConfig() {
        super(f15037d, f15038e);
    }
}
