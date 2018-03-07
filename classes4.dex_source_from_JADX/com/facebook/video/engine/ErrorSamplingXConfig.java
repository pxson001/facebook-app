package com.facebook.video.engine;

import com.facebook.xconfig.core.XConfig;
import com.facebook.xconfig.core.XConfigName;
import com.facebook.xconfig.core.XConfigSetting;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;

/* compiled from: specifiedContacts */
public class ErrorSamplingXConfig extends XConfig {
    public static final XConfigSetting f1954c;
    private static final XConfigName f1955d = new XConfigName("video_error_sampling");
    private static final ImmutableSet<XConfigSetting> f1956e;

    static {
        XConfigSetting xConfigSetting = new XConfigSetting(f1955d, "video_error_sampling");
        f1954c = xConfigSetting;
        f1956e = ImmutableSet.of(xConfigSetting);
    }

    @Inject
    public ErrorSamplingXConfig() {
        super(f1955d, f1956e);
    }
}
