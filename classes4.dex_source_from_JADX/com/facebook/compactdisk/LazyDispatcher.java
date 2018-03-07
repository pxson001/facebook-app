package com.facebook.compactdisk;

import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.soloader.SoLoader;

@DoNotStrip
/* compiled from: media_dedupe */
public class LazyDispatcher {
    @DoNotStrip
    private final HybridData mHybridData;

    private native HybridData initHybrid(TaskQueueFactoryHolder taskQueueFactoryHolder);

    public native void dispatchNow();

    static {
        SoLoader.a("compactdisk-jni");
    }

    public LazyDispatcher(TaskQueueFactoryHolder taskQueueFactoryHolder) {
        this.mHybridData = initHybrid(taskQueueFactoryHolder);
    }
}
