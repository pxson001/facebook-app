package com.facebook.rtc.fbwebrtc;

import com.facebook.inject.InjectorLike;
import com.facebook.push.mqtt.service.IMqttClientActiveCallback;

/* compiled from: has_seen_contacts_upload_dialog */
public class WebrtcMqttClientActiveCallback implements IMqttClientActiveCallback {
    public boolean f10831a;

    public static WebrtcMqttClientActiveCallback m11281a(InjectorLike injectorLike) {
        return new WebrtcMqttClientActiveCallback();
    }

    final void m11282a(boolean z) {
        this.f10831a = z;
    }

    public final boolean mo826a() {
        return this.f10831a;
    }
}
