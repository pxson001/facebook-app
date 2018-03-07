package com.facebook.messaging.customthreads;

import com.facebook.xconfig.core.XConfig;
import com.facebook.xconfig.core.XConfigName;
import com.facebook.xconfig.core.XConfigSetting;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;

/* compiled from: static_base_url */
public class CustomThreadsXConfig extends XConfig {
    public static final XConfigSetting f1813c;
    private static final XConfigName f1814d = new XConfigName("messenger_thread_customizations");
    private static final ImmutableSet<XConfigSetting> f1815e;

    static {
        XConfigSetting xConfigSetting = new XConfigSetting(f1814d, "emoji_choices");
        f1813c = xConfigSetting;
        f1815e = ImmutableSet.of(xConfigSetting);
    }

    @Inject
    public CustomThreadsXConfig() {
        super(f1814d, f1815e);
    }
}
