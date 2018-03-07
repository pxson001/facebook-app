package com.facebook.presence.configs;

import com.facebook.xconfig.core.XConfig;
import com.facebook.xconfig.core.XConfigName;
import com.facebook.xconfig.core.XConfigSetting;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;

/* compiled from: mqtt_config */
public class PresenceLruCacheXConfig extends XConfig {
    public static final XConfigName f7485c = new XConfigName("android_messenger_presence_lru_cache");
    public static final XConfigSetting f7486d = new XConfigSetting(f7485c, "presence_lru_cache_recent_threads_size");
    public static final XConfigSetting f7487e = new XConfigSetting(f7485c, "presence_lru_cache_inbox_threads_size");
    private static final ImmutableSet<XConfigSetting> f7488f = ImmutableSet.of(f7486d, f7487e);

    @Inject
    public PresenceLruCacheXConfig() {
        super(f7485c, f7488f);
    }
}
