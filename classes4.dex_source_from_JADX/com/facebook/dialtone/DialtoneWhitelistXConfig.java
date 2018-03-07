package com.facebook.dialtone;

import com.facebook.xconfig.core.XConfig;
import com.facebook.xconfig.core.XConfigName;
import com.facebook.xconfig.core.XConfigSetting;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;

/* compiled from: sticker_featured */
public final class DialtoneWhitelistXConfig extends XConfig {
    public static final XConfigSetting f1745c = new XConfigSetting(f1749g, "whitelisted_photo_tag_regexes");
    public static final XConfigSetting f1746d = new XConfigSetting(f1749g, "whitelisted_uri_regexes");
    public static final XConfigSetting f1747e = new XConfigSetting(f1749g, "whitelisted_video_tag_regexes");
    public static final XConfigSetting f1748f = new XConfigSetting(f1749g, "whitelisted_faceweb_regexes");
    private static final XConfigName f1749g = new XConfigName("dialtone_whitelist");
    private static final ImmutableSet<XConfigSetting> f1750h = ImmutableSet.of(f1745c, f1746d, f1747e, f1748f);

    @Inject
    public DialtoneWhitelistXConfig() {
        super(f1749g, f1750h);
    }
}
