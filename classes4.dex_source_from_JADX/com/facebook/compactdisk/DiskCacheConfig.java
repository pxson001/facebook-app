package com.facebook.compactdisk;

import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.soloader.SoLoader;

@DoNotStrip
/* compiled from: media_source */
public class DiskCacheConfig {
    @DoNotStrip
    private final HybridData mHybridData = initHybrid();

    private native void diskAreaNative(int i);

    private native HybridData initHybrid();

    private native void localeSensitiveNative(boolean z);

    private native void maxCapacityNative(Long l);

    private native void nameNative(String str);

    private native void sessionScopedNative(boolean z);

    private native void subConfigNative(SubConfig subConfig);

    private native void versionNative(Long l);

    public native String getName();

    static {
        SoLoader.a("compactdisk-jni");
    }

    public final DiskCacheConfig m8447a(String str) {
        nameNative(str);
        return this;
    }

    public final DiskCacheConfig m8448a(boolean z) {
        sessionScopedNative(z);
        return this;
    }

    public final DiskCacheConfig m8445a(DiskArea diskArea) {
        diskAreaNative(diskArea.ordinal());
        return this;
    }

    public final DiskCacheConfig m8446a(SubConfig subConfig) {
        subConfigNative(subConfig);
        return this;
    }
}
