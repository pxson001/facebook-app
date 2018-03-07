package com.facebook.compactdisk;

import android.content.Context;
import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.soloader.SoLoader;

@DoNotStrip
/* compiled from: me/message_media_quality */
public class TrashCollector {
    @DoNotStrip
    private final HybridData mHybridData;

    private native HybridData initHybrid(String str, FileUtilsHolder fileUtilsHolder, AnalyticsEventReporterHolder analyticsEventReporterHolder, TaskQueueFactoryHolder taskQueueFactoryHolder);

    static {
        SoLoader.a("compactdisk-jni");
    }

    public TrashCollector(Context context, FileUtilsHolder fileUtilsHolder, AnalyticsEventReporterHolder analyticsEventReporterHolder, TaskQueueFactoryHolder taskQueueFactoryHolder) {
        this.mHybridData = initHybrid(context.getApplicationContext().getCacheDir().getPath() + "/trash_collector", fileUtilsHolder, analyticsEventReporterHolder, taskQueueFactoryHolder);
    }
}
