package com.facebook.xanalytics;

import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
/* compiled from: mAnchor */
public abstract class XAnalyticsHolder {
    @DoNotStrip
    protected final HybridData mHybridData;

    protected XAnalyticsHolder(HybridData hybridData) {
        this.mHybridData = hybridData;
    }
}
