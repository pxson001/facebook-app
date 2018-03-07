package com.facebook.compactdisk;

import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.soloader.SoLoader;

@DoNotStrip
/* compiled from: me_bubble_color */
public class ManualConfig extends SubConfig {
    private static native HybridData initHybrid();

    private native void lowSpaceMaxSizeNative(Long l);

    private native void maxSizeNative(Long l);

    static {
        SoLoader.a("compactdisk-jni");
    }

    public ManualConfig() {
        super(initHybrid());
    }
}
