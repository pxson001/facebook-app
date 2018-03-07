package com.facebook.photos.upload.module;

import com.facebook.xconfig.core.XConfig;
import com.facebook.xconfig.core.XConfigName;
import com.facebook.xconfig.core.XConfigSetting;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;

/* compiled from: state_idle */
public class UploadQualityXConfig extends XConfig {
    public static final XConfigName f1851c = new XConfigName("fb4a_upload_quality");
    public static final XConfigSetting f1852d;
    private static final ImmutableSet<XConfigSetting> f1853e;

    static {
        XConfigSetting xConfigSetting = new XConfigSetting(f1851c, "QValue");
        f1852d = xConfigSetting;
        f1853e = ImmutableSet.of(xConfigSetting);
    }

    @Inject
    public UploadQualityXConfig() {
        super(f1851c, f1853e);
    }
}
