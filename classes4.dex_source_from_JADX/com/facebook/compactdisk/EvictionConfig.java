package com.facebook.compactdisk;

import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.soloader.SoLoader;

@DoNotStrip
/* compiled from: media_fbid_second_returned */
public class EvictionConfig {
    @DoNotStrip
    private final HybridData mHybridData = initHybrid();

    private native void evictionComparatorNative(EvictionComparator evictionComparator);

    private native HybridData initHybrid();

    private native void lowSpaceMaxSizeNative(long j);

    private native void maxSizeNative(long j);

    static {
        SoLoader.a("compactdisk-jni");
    }
}
