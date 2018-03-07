package com.facebook.compactdisk;

import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.soloader.SoLoader;

/* compiled from: me/message_forced_fetch */
public class UnmanagedStore {
    @DoNotStrip
    private final HybridData mHybridData;

    public native String getDirectoryPath();

    public native long getMaxSize();

    static {
        SoLoader.a("compactdisk-jni");
    }

    @DoNotStrip
    private UnmanagedStore(HybridData hybridData) {
        this.mHybridData = hybridData;
    }
}
