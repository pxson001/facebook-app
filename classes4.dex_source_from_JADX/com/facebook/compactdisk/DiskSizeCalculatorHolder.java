package com.facebook.compactdisk;

import com.facebook.common.jniexecutors.AndroidAsyncExecutorFactory;
import com.facebook.common.time.MonotonicClock;
import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.soloader.SoLoader;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: media_resize */
public class DiskSizeCalculatorHolder {
    @DoNotStrip
    private final HybridData mHybridData;

    private static native HybridData initHybrid(FileUtilsHolder fileUtilsHolder, AttributeStoreHolder attributeStoreHolder, AnalyticsEventReporterHolder analyticsEventReporterHolder, AndroidAsyncExecutorFactory androidAsyncExecutorFactory);

    static {
        SoLoader.a("compactdisk-jni");
    }

    public DiskSizeCalculatorHolder(FileUtilsHolder fileUtilsHolder, AttributeStoreHolder attributeStoreHolder, AnalyticsEventReporterHolder analyticsEventReporterHolder, ScheduledExecutorService scheduledExecutorService, MonotonicClock monotonicClock) {
        this.mHybridData = initHybrid(fileUtilsHolder, attributeStoreHolder, analyticsEventReporterHolder, new AndroidAsyncExecutorFactory(scheduledExecutorService));
    }
}
