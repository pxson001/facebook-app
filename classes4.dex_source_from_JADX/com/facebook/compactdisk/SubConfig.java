package com.facebook.compactdisk;

import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.soloader.SoLoader;

@DoNotStrip
/* compiled from: media */
public class SubConfig {
    @DoNotStrip
    private final HybridData mHybridData;

    static {
        SoLoader.a("compactdisk-jni");
    }

    protected SubConfig(HybridData hybridData) {
        this.mHybridData = hybridData;
    }
}
