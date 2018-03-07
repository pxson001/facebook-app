package com.facebook.mqttlite;

import com.facebook.debug.log.BLog;
import com.facebook.rti.mqtt.protocol.sync.SyncQueueTracker;
import com.google.common.base.Preconditions;
import java.util.List;

/* compiled from: time_to_load_bootstrap_from_search_button_clicked */
public class SyncQueueTrackerImpl implements SyncQueueTracker {
    private static final Class<?> f3009a = SyncQueueTrackerImpl.class;
    private final com.facebook.push.mqtt.ipc.SyncQueueTracker f3010b;

    SyncQueueTrackerImpl(com.facebook.push.mqtt.ipc.SyncQueueTracker syncQueueTracker) {
        this.f3010b = (com.facebook.push.mqtt.ipc.SyncQueueTracker) Preconditions.checkNotNull(syncQueueTracker);
    }

    public final List m4023a() {
        try {
            return this.f3010b.mo300a();
        } catch (Throwable e) {
            BLog.a(f3009a, e, "Failed to deliver getDiffsForConnect", new Object[0]);
            return null;
        }
    }

    public final void m4024b() {
        try {
            this.f3010b.mo301b();
        } catch (Throwable e) {
            BLog.a(f3009a, e, "Failed to deliver onConackReceived", new Object[0]);
        }
    }
}
