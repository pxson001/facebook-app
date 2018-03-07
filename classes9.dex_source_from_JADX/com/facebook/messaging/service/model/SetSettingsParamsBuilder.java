package com.facebook.messaging.service.model;

import com.facebook.messaging.model.threads.NotificationSetting;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* compiled from: connection_wifi_rssi */
public class SetSettingsParamsBuilder {
    public boolean f17329a;
    public NotificationSetting f17330b;

    public final SetSettingsParamsBuilder m17192a(boolean z) {
        this.f17329a = z;
        return this;
    }

    public final SetSettingsParamsBuilder m17191a(NotificationSetting notificationSetting) {
        this.f17330b = notificationSetting;
        return this;
    }

    public final SetSettingsParams m17193c() {
        return new SetSettingsParams(this);
    }
}
