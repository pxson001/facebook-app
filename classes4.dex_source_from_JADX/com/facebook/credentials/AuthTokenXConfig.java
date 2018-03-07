package com.facebook.credentials;

import com.facebook.xconfig.core.XConfig;
import com.facebook.xconfig.core.XConfigName;
import com.facebook.xconfig.core.XConfigSetting;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;

/* compiled from: sticker_id_list */
public class AuthTokenXConfig extends XConfig {
    public static final XConfigName f1734c = new XConfigName("auth_token_debug_logger");
    public static final XConfigSetting f1735d = new XConfigSetting(f1734c, "initial_count");
    public static final XConfigSetting f1736e = new XConfigSetting(f1734c, "total_count");
    public static final XConfigSetting f1737f = new XConfigSetting(f1734c, "token_pool_size");
    public static final XConfigSetting f1738g = new XConfigSetting(f1734c, "token_store_enabled");
    static final ImmutableSet<XConfigSetting> f1739h = ImmutableSet.of(f1735d, f1736e, f1737f, f1738g);

    @Inject
    public AuthTokenXConfig() {
        super(f1734c, f1739h);
    }
}
