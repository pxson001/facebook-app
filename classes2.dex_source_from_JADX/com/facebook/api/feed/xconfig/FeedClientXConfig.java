package com.facebook.api.feed.xconfig;

import com.facebook.xconfig.core.XConfig;
import com.facebook.xconfig.core.XConfigName;
import com.facebook.xconfig.core.XConfigSetting;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.Builder;
import javax.inject.Inject;

/* compiled from: session_request_count */
public class FeedClientXConfig extends XConfig {
    public static final XConfigName f5467c = new XConfigName("feed_client");
    public static final XConfigSetting f5468d;
    public static final ImmutableSet<XConfigSetting> f5469e;
    private static final ImmutableSet<XConfigSetting> f5470f = new Builder().m4809b(f5469e).m4812b();

    static {
        XConfigSetting xConfigSetting = new XConfigSetting(f5467c, "ranking_config");
        f5468d = xConfigSetting;
        f5469e = ImmutableSet.of(xConfigSetting);
    }

    @Inject
    public FeedClientXConfig() {
        super(f5467c, f5470f);
    }
}
