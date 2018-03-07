package com.facebook.compactdisk;

import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.soloader.SoLoader;

@DoNotStrip
/* compiled from: medium_speed_animation */
public class AnalyticsEventReporterHolder {
    @DoNotStrip
    private final HybridData mHybridData;

    private native HybridData initHybrid(XAnalyticsLogger xAnalyticsLogger);

    static {
        SoLoader.a("compactdisk-jni");
    }

    public AnalyticsEventReporterHolder(XAnalyticsLogger xAnalyticsLogger) {
        this.mHybridData = initHybrid(xAnalyticsLogger);
    }
}
