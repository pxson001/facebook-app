package com.facebook.push.mqtt.service;

import android.content.Intent;
import com.facebook.base.service.FbIntentService;
import com.facebook.common.init.AppInitLock;
import com.facebook.inject.FbInjector;

/* compiled from: sms_send_failed */
public class MqttPushHelperService extends FbIntentService {
    private static final Class<?> f4296a = MqttPushHelperService.class;

    public MqttPushHelperService() {
        super(f4296a.getSimpleName());
    }

    protected final void m6398a(Intent intent) {
        FbInjector a = a();
        AppInitLock.a(a).b();
        MqttPushServiceManager.a(a).init();
    }
}
