package com.facebook.webrtc;

import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;

/* compiled from: location_opt_in_intro_learn_more_tapped */
public class TurnAllocatorCallback {
    @DoNotStrip
    private final HybridData mHybridData;

    @DoNotStrip
    public native void turnAllocationFailure();

    @DoNotStrip
    public native void turnAllocationSuccess(String str);

    @DoNotStrip
    private TurnAllocatorCallback(HybridData hybridData) {
        this.mHybridData = hybridData;
    }
}
