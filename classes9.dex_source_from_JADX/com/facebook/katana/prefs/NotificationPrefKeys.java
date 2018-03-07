package com.facebook.katana.prefs;

import com.facebook.prefs.shared.IHavePrivacyCriticalKeysToClear;
import com.facebook.prefs.shared.PrefKey;
import com.google.common.collect.ImmutableSet;

/* compiled from: p2p_mobile_browser_risk_confirm */
public class NotificationPrefKeys implements IHavePrivacyCriticalKeysToClear {
    public static final PrefKey f7570a;
    public static final PrefKey f7571b;
    public static final PrefKey f7572c = ((PrefKey) f7570a.a("last_notification_update_time"));
    public static final PrefKey f7573d = ((PrefKey) f7570a.a("sticky_sys_tray_notifications"));
    public static final PrefKey f7574e = ((PrefKey) f7570a.a("notifications_survey_shown"));

    static {
        PrefKey prefKey = (PrefKey) FbandroidPrefKeys.a.a("notifications/");
        f7570a = prefKey;
        f7571b = (PrefKey) prefKey.a("polling_marker");
    }

    public final ImmutableSet<PrefKey> m7870b() {
        return ImmutableSet.of(f7570a);
    }
}
