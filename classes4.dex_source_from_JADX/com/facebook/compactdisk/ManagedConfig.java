package com.facebook.compactdisk;

import com.facebook.common.jniexecutors.AndroidAsyncExecutorFactory;
import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.soloader.SoLoader;

@DoNotStrip
/* compiled from: mediaResource */
public class ManagedConfig extends SubConfig {
    private native void eventListenerPairNative(DiskCacheEventListener diskCacheEventListener, AndroidAsyncExecutorFactory androidAsyncExecutorFactory);

    private native void evictionNative(EvictionConfig evictionConfig);

    private static native HybridData initHybrid();

    private native void inlineDataNative(boolean z);

    private native void stalePruningNative(StalePruningConfig stalePruningConfig);

    static {
        SoLoader.a("compactdisk-jni");
    }

    public ManagedConfig() {
        super(initHybrid());
    }
}
