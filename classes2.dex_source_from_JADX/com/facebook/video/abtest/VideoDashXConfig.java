package com.facebook.video.abtest;

import com.facebook.xconfig.core.XConfig;
import com.facebook.xconfig.core.XConfigName;
import com.facebook.xconfig.core.XConfigSetting;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;

/* compiled from: response_body_size */
public class VideoDashXConfig extends XConfig {
    public static final XConfigSetting f6975c = new XConfigSetting(f6979g, "abr_max_width_to_prefetch");
    public static final XConfigSetting f6976d = new XConfigSetting(f6979g, "abr_max_width_to_prefetch_cell");
    public static final XConfigSetting f6977e = new XConfigSetting(f6979g, "abr_max_width_cell");
    public static final XConfigSetting f6978f = new XConfigSetting(f6979g, "abr_max_width_inline_player");
    private static final XConfigName f6979g = new XConfigName("android_video_dash");
    private static final ImmutableSet<XConfigSetting> f6980h = ImmutableSet.of(f6975c, f6976d, f6977e, f6978f);

    @Inject
    public VideoDashXConfig() {
        super(f6979g, f6980h);
    }
}
