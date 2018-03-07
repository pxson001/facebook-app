package com.facebook.messaging.business.commerceui.config;

import com.facebook.inject.InjectorLike;
import com.facebook.xconfig.core.XConfig;
import com.facebook.xconfig.core.XConfigName;
import com.facebook.xconfig.core.XConfigSetting;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;

/* compiled from: step_detector */
public class WifiNotificationXConfig extends XConfig {
    public static final XConfigSetting f1798c = new XConfigSetting(f1802g, "walmart_wifi_bssid_list");
    public static final XConfigSetting f1799d = new XConfigSetting(f1802g, "wifi_signal_level_threshold");
    public static final XConfigSetting f1800e = new XConfigSetting(f1802g, "wifi_in_range_duration");
    public static final XConfigSetting f1801f = new XConfigSetting(f1802g, "walmart_wifi_notification_info");
    private static final XConfigName f1802g = new XConfigName("messenger_business_wifi_notifications_config");
    private static final ImmutableSet<XConfigSetting> f1803h = ImmutableSet.of(f1798c, f1799d, f1800e, f1801f);

    public static WifiNotificationXConfig m1944a(InjectorLike injectorLike) {
        return new WifiNotificationXConfig();
    }

    @Inject
    public WifiNotificationXConfig() {
        super(f1802g, f1803h);
    }
}
