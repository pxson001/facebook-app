package com.facebook.stickers.service;

import com.facebook.xconfig.core.XConfig;
import com.facebook.xconfig.core.XConfigName;
import com.facebook.xconfig.core.XConfigSetting;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;

/* compiled from: starting_location */
public class DownloadPreviewStickerPacksXConfig extends XConfig {
    public static final XConfigSetting f1888c;
    private static final XConfigName f1889d = new XConfigName("android_messenger_sticker_tray_downloadable_packs");
    private static final ImmutableSet<XConfigSetting> f1890e;

    static {
        XConfigSetting xConfigSetting = new XConfigSetting(f1889d, "pack_ids");
        f1888c = xConfigSetting;
        f1890e = ImmutableSet.of(xConfigSetting);
    }

    @Inject
    public DownloadPreviewStickerPacksXConfig() {
        super(f1889d, f1890e);
    }
}
