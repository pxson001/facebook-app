package com.facebook.common.jniexecutors;

import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.soloader.SoLoader;
import java.util.concurrent.ScheduledExecutorService;

@DoNotStrip
/* compiled from: mds_cache */
public final class AndroidAsyncExecutorFactory {
    @DoNotStrip
    private final HybridData mHybridData;

    private native HybridData initHybrid(ScheduledExecutorService scheduledExecutorService);

    static {
        SoLoader.a("jniexecutors");
    }

    public AndroidAsyncExecutorFactory(ScheduledExecutorService scheduledExecutorService) {
        this.mHybridData = initHybrid(scheduledExecutorService);
    }
}
