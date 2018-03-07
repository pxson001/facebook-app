package com.facebook.compactdisk;

import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.soloader.SoLoader;

@DoNotStrip
/* compiled from: me/stickerpacks */
public class StalePruningConfig {
    @DoNotStrip
    private final HybridData mHybridData = initHybrid();

    private native HybridData initHybrid();

    private native void staleAgeNative(long j);

    static {
        SoLoader.a("compactdisk-jni");
    }
}
