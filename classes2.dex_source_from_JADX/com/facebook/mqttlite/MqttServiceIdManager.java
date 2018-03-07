package com.facebook.mqttlite;

import com.facebook.config.application.FbAppType;
import com.facebook.device_id.UniqueIdForDeviceHolderImpl;
import com.facebook.device_id.UniqueIdForDeviceHolderMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.app.module.common.String_AppNameInUserAgentMethodAutoProvider;
import com.facebook.rti.mqtt.credentials.MqttDeviceIdAndSecret;
import com.facebook.rti.mqtt.manager.MqttIdManager;
import javax.inject.Inject;

/* compiled from: fps_guessed */
public class MqttServiceIdManager implements MqttIdManager {
    private final FbAppType f23379a;
    private final UniqueIdForDeviceHolderImpl f23380b;
    private final String f23381c;

    private static MqttServiceIdManager m31653b(InjectorLike injectorLike) {
        return new MqttServiceIdManager((FbAppType) injectorLike.getInstance(FbAppType.class), UniqueIdForDeviceHolderMethodAutoProvider.m4339b(injectorLike), String_AppNameInUserAgentMethodAutoProvider.m9472a(injectorLike));
    }

    @Inject
    MqttServiceIdManager(FbAppType fbAppType, UniqueIdForDeviceHolderImpl uniqueIdForDeviceHolderImpl, String str) {
        this.f23379a = fbAppType;
        this.f23380b = uniqueIdForDeviceHolderImpl;
        this.f23381c = str;
    }

    public final String m31654a() {
        return this.f23379a.c();
    }

    public final String m31656b() {
        return this.f23381c;
    }

    public final String m31657c() {
        return this.f23380b.m4346a();
    }

    public final String m31658d() {
        return null;
    }

    public static MqttServiceIdManager m31652a(InjectorLike injectorLike) {
        return m31653b(injectorLike);
    }

    public final boolean m31655a(MqttDeviceIdAndSecret mqttDeviceIdAndSecret) {
        return false;
    }

    public final void m31659e() {
    }
}
