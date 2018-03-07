package com.facebook.feed.xconfig;

import com.facebook.xconfig.core.XConfig;
import com.facebook.xconfig.core.XConfigName;
import com.facebook.xconfig.core.XConfigSetting;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;

/* compiled from: sticker_asset_cleanup */
public class FeedUnitInvalidateTimeXConfig extends XConfig {
    public static final XConfigSetting f1761c;
    public static final ImmutableSet<XConfigSetting> f1762d;
    private static final XConfigName f1763e = new XConfigName("news_feed_unit_invalidate_time");

    static {
        XConfigSetting xConfigSetting = new XConfigSetting(f1763e, "nearby_friends_unit_invalidate_time");
        f1761c = xConfigSetting;
        f1762d = ImmutableSet.of(xConfigSetting);
    }

    @Inject
    public FeedUnitInvalidateTimeXConfig() {
        super(f1763e, f1762d);
    }
}
