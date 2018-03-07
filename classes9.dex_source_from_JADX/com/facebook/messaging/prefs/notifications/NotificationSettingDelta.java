package com.facebook.messaging.prefs.notifications;

import com.facebook.messaging.model.threads.NotificationSetting;

/* compiled from: device_got_hot */
class NotificationSettingDelta {
    public final NotificationSetting f16353a;
    public final NotificationSetting f16354b;

    NotificationSettingDelta(NotificationSetting notificationSetting, NotificationSetting notificationSetting2) {
        this.f16353a = notificationSetting;
        this.f16354b = notificationSetting2;
    }

    public final boolean m16422a() {
        if (this.f16353a == null || this.f16354b == null || this.f16353a.a() == this.f16354b.a()) {
            return false;
        }
        return true;
    }
}
