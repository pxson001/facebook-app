package com.facebook.compactdisk;

import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.soloader.SoLoader;

@DoNotStrip
/* compiled from: mediaupload/ */
public class Configuration {
    @DoNotStrip
    private final HybridData mHybridData = initHybrid();

    private native HybridData initHybrid();

    static {
        SoLoader.a("compactdisk-jni");
    }
}
