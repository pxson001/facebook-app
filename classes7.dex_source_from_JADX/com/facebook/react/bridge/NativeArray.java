package com.facebook.react.bridge;

import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.soloader.SoLoader;

@DoNotStrip
/* compiled from: group_event_create */
public abstract class NativeArray {
    @DoNotStrip
    private HybridData mHybridData;

    public native String toString();

    static {
        SoLoader.a("reactnativejni");
    }

    protected NativeArray(HybridData hybridData) {
        this.mHybridData = hybridData;
    }
}
