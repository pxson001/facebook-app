package com.facebook.privacy.checkup.photofeed;

import com.facebook.xconfig.core.XConfig;
import com.facebook.xconfig.core.XConfigName;
import com.facebook.xconfig.core.XConfigSetting;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;

/* compiled from: starve_smoothing */
public class PhotoPrivacyFeedXConfig extends XConfig {
    public static final XConfigSetting f1863c = new XConfigSetting(f1865e, "consecutive_edits_before_bulk_edit");
    public static final XConfigSetting f1864d = new XConfigSetting(f1865e, "min_photos_to_allow_bulk_edit");
    private static final XConfigName f1865e = new XConfigName("fb4a_profile_photo_checkup");
    private static final ImmutableSet<XConfigSetting> f1866f = ImmutableSet.of(f1863c, f1864d);

    @Inject
    public PhotoPrivacyFeedXConfig() {
        super(f1865e, f1866f);
    }
}
