package com.facebook.video.settings;

import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import javax.annotation.Nullable;

/* compiled from: is_imported */
public class VideoPrefs {
    public static final PrefKey f19177a;
    public static final PrefKey f19178b;
    public static final PrefKey f19179c = ((PrefKey) f19177a.m2011a("fullscreen_userpaused"));
    public static final PrefKey f19180d = ((PrefKey) SharedPrefKeys.f989c.m2011a("autoplay_all_connections_option"));
    public static final PrefKey f19181e = ((PrefKey) SharedPrefKeys.f989c.m2011a("autoplay_wifi_only_option"));
    public static final PrefKey f19182f = ((PrefKey) SharedPrefKeys.f989c.m2011a("autoplay_no_autoplay_option"));
    public static final PrefKey f19183g = ((PrefKey) SharedPrefKeys.f989c.m2011a("autoplay_eligibility"));
    public static final PrefKey f19184h = ((PrefKey) SharedPrefKeys.f989c.m2011a("previous_autoplay_eligibility"));
    public static final PrefKey f19185i = ((PrefKey) SharedPrefKeys.f989c.m2011a("autoplay_has_user_touched_setting"));
    public static final PrefKey f19186j = ((PrefKey) SharedPrefKeys.f989c.m2011a("autoplay_policy_version_updated"));
    public static final PrefKey f19187k = ((PrefKey) SharedPrefKeys.f989c.m2011a("subtitle_preferred_locale"));

    /* compiled from: is_imported */
    public enum AutoPlaySettingValue {
        ON(0),
        OFF(1),
        WIFI_ONLY(2),
        DEFAULT(3);
        
        public final int value;

        private AutoPlaySettingValue(int i) {
            this.value = i;
        }

        public final boolean isAutoPlayOn() {
            return this == ON;
        }

        public final boolean isWifiOnly() {
            return this == WIFI_ONLY;
        }

        public final boolean isAutoPlayOff() {
            return this == OFF;
        }

        public final boolean isDefaultAutoPlay() {
            return this == DEFAULT;
        }

        public static AutoPlaySettingValue lookupInstanceByValue(String str) {
            return lookupInstanceByValue(str, null);
        }

        public static AutoPlaySettingValue lookupInstanceByValue(String str, @Nullable AutoPlaySettingValue autoPlaySettingValue) {
            try {
                int parseInt = Integer.parseInt(str);
                for (AutoPlaySettingValue autoPlaySettingValue2 : values()) {
                    if (autoPlaySettingValue2.value == parseInt) {
                        return autoPlaySettingValue2;
                    }
                }
                return autoPlaySettingValue;
            } catch (NumberFormatException e) {
                return autoPlaySettingValue;
            }
        }
    }

    static {
        PrefKey prefKey = (PrefKey) SharedPrefKeys.f987a.m2011a("video/");
        f19177a = prefKey;
        f19178b = (PrefKey) prefKey.m2011a("fullscreen_seek");
    }
}
