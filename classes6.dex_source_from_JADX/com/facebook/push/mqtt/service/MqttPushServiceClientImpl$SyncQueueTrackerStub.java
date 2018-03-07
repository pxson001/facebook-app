package com.facebook.push.mqtt.service;

import com.facebook.push.mqtt.ipc.SyncQueueTracker.Stub;
import com.facebook.sync.connection.SyncQueueTrackerImpl;
import java.util.List;

/* compiled from: sms_default_application */
class MqttPushServiceClientImpl$SyncQueueTrackerStub extends Stub {
    private final SyncQueueTrackerImpl f4302a;

    public MqttPushServiceClientImpl$SyncQueueTrackerStub(SyncQueueTrackerImpl syncQueueTrackerImpl) {
        this.f4302a = syncQueueTrackerImpl;
    }

    public final List mo300a() {
        return this.f4302a.a();
    }

    public final void mo301b() {
        this.f4302a.b();
    }
}
