package com.facebook.common.appstate;

import com.facebook.http.common.RequestProcessorSnapshotLogger;

/* compiled from: receiver_mqtt_client */
class ForegroundPeriodicTask {
    private final double f7915a;
    private final RequestProcessorSnapshotLogger f7916b;

    public ForegroundPeriodicTask(RequestProcessorSnapshotLogger requestProcessorSnapshotLogger, double d) {
        this.f7915a = d;
        this.f7916b = requestProcessorSnapshotLogger;
    }

    public final double m12498a() {
        return this.f7915a;
    }

    public final RequestProcessorSnapshotLogger m12499b() {
        return this.f7916b;
    }
}
