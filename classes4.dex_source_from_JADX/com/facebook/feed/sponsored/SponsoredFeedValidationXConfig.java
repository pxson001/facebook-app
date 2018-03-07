package com.facebook.feed.sponsored;

import com.facebook.xconfig.core.XConfig;
import com.facebook.xconfig.core.XConfigName;
import com.facebook.xconfig.core.XConfigSetting;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;

/* compiled from: sticker_autodownload */
public class SponsoredFeedValidationXConfig extends XConfig {
    public static final XConfigSetting f1755c;
    public static final ImmutableSet<XConfigSetting> f1756d;
    private static final XConfigName f1757e = new XConfigName("fb4a_sponsored_feed_validation");

    static {
        XConfigSetting xConfigSetting = new XConfigSetting(f1757e, "sponsored_feed_unit_cache_size");
        f1755c = xConfigSetting;
        f1756d = ImmutableSet.of(xConfigSetting);
    }

    @Inject
    public SponsoredFeedValidationXConfig() {
        super(f1757e, f1756d);
    }
}
