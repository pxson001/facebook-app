package com.facebook.orca.notify;

import com.facebook.messaging.model.threads.NotificationSetting;
import java.util.Date;

/* compiled from: nmvap */
class MuteNotificationHelper$MuteOption {
    public final String f6260a;
    public final String f6261b;
    public final NotificationSetting f6262c;

    public MuteNotificationHelper$MuteOption(String str, String str2, Date date) {
        this(str, str2, NotificationSetting.a(date.getTime() / 1000));
    }

    public MuteNotificationHelper$MuteOption(String str, String str2, NotificationSetting notificationSetting) {
        this.f6260a = str;
        this.f6261b = str2;
        this.f6262c = notificationSetting;
    }
}
