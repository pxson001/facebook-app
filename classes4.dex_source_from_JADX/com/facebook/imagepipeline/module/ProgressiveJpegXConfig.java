package com.facebook.imagepipeline.module;

import com.facebook.xconfig.core.XConfig;
import com.facebook.xconfig.core.XConfigName;
import com.facebook.xconfig.core.XConfigSetting;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;

/* compiled from: stickerPacks */
public class ProgressiveJpegXConfig extends XConfig {
    public static final XConfigSetting f1784c;
    private static final XConfigName f1785d = new XConfigName("progressive_jpeg_properties");
    private static final ImmutableSet<XConfigSetting> f1786e;

    static {
        XConfigSetting xConfigSetting = new XConfigSetting(f1785d, "good_enough_scan");
        f1784c = xConfigSetting;
        f1786e = ImmutableSet.of(xConfigSetting);
    }

    @Inject
    public ProgressiveJpegXConfig() {
        super(f1785d, f1786e);
    }
}
