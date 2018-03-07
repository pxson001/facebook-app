package com.facebook.compactdisk;

import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.soloader.SoLoader;

@DoNotStrip
/* compiled from: turn_off_ccu_after_exception */
public class EvictionComparator {
    @DoNotStrip
    private final HybridData mHybridData;

    static {
        SoLoader.a("compactdisk-jni");
    }

    protected EvictionComparator(HybridData hybridData) {
        this.mHybridData = hybridData;
    }
}
