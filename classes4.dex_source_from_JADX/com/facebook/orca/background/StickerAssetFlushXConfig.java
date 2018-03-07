package com.facebook.orca.background;

import com.facebook.xconfig.core.XConfig;
import com.facebook.xconfig.core.XConfigName;
import com.facebook.xconfig.core.XConfigSetting;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;

/* compiled from: state_playback_completed */
public class StickerAssetFlushXConfig extends XConfig {
    public static final XConfigName f1841c = new XConfigName("android_messenger_sticker_asset_flush_list");
    public static final XConfigSetting f1842d = new XConfigSetting(f1841c, "sticker_ids");
    public static final XConfigSetting f1843e = new XConfigSetting(f1841c, "config_version");
    static final ImmutableSet<XConfigSetting> f1844f = ImmutableSet.of(f1842d, f1843e);

    @Inject
    public StickerAssetFlushXConfig() {
        super(f1841c, f1844f);
    }
}
