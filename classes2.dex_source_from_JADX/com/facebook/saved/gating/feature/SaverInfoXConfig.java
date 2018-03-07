package com.facebook.saved.gating.feature;

import com.facebook.xconfig.core.XConfig;
import com.facebook.xconfig.core.XConfigName;
import com.facebook.xconfig.core.XConfigSetting;
import com.google.common.collect.ImmutableSet;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: marketplace_notifications */
public class SaverInfoXConfig extends XConfig {
    public static final XConfigSetting f14995c = new XConfigSetting(f14999g, "mobile_bookmark_nux_state");
    public static final XConfigSetting f14996d = new XConfigSetting(f14999g, "only_me_sharer_nux_state");
    public static final XConfigSetting f14997e = new XConfigSetting(f14999g, "recent_save_info_unread_count");
    public static final XConfigSetting f14998f = new XConfigSetting(f14999g, "recent_save_info_timeframe");
    private static final XConfigName f14999g = new XConfigName("saver_info");

    /* compiled from: marketplace_notifications */
    public enum SaveBookmarkNuxState {
        INELIGIBLE,
        ELIGIBLE,
        FORCE;

        public static SaveBookmarkNuxState convertString(@Nullable String str) {
            if (str == null) {
                return INELIGIBLE;
            }
            try {
                return valueOf(str);
            } catch (IllegalArgumentException e) {
                return INELIGIBLE;
            }
        }
    }

    @Inject
    public SaverInfoXConfig() {
        super(f14999g, ImmutableSet.of(f14995c, f14996d, f14997e, f14998f));
    }
}
