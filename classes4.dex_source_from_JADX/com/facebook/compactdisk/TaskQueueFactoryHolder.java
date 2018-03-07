package com.facebook.compactdisk;

import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.soloader.SoLoader;
import java.util.concurrent.ScheduledExecutorService;

@DoNotStrip
/* compiled from: me/notification_seen_states */
public class TaskQueueFactoryHolder {
    @DoNotStrip
    private final HybridData mHybridData;

    private native HybridData initHybrid(ScheduledExecutorService scheduledExecutorService);

    static {
        SoLoader.a("compactdisk-jni");
    }

    public TaskQueueFactoryHolder(ScheduledExecutorService scheduledExecutorService) {
        this.mHybridData = initHybrid(scheduledExecutorService);
    }
}
