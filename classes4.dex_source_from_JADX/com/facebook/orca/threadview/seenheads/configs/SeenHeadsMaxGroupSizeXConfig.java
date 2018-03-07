package com.facebook.orca.threadview.seenheads.configs;

import com.facebook.xconfig.core.XConfig;
import com.facebook.xconfig.core.XConfigName;
import com.facebook.xconfig.core.XConfigSetting;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;

/* compiled from: state_paused */
public class SeenHeadsMaxGroupSizeXConfig extends XConfig {
    public static final XConfigName f1845c = new XConfigName("messenger_seen_heads_max_group_size");
    public static final XConfigSetting f1846d;
    private static final ImmutableSet<XConfigSetting> f1847e;

    static {
        XConfigSetting xConfigSetting = new XConfigSetting(f1845c, "max_group_size");
        f1846d = xConfigSetting;
        f1847e = ImmutableSet.of(xConfigSetting);
    }

    @Inject
    public SeenHeadsMaxGroupSizeXConfig() {
        super(f1845c, f1847e);
    }
}
