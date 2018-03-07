package com.facebook.compactdisk;

import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.soloader.SoLoader;
import com.google.common.util.concurrent.SettableFuture;

/* compiled from: me/traces */
public class PersistentKeyValueStore {
    @DoNotStrip
    protected final HybridData mHybridData;

    private native void fetchManualNative(String str, ManualRead manualRead, SettableFuture<byte[]> settableFuture);

    private native void fetchNative(String str, SettableFuture<byte[]> settableFuture);

    private native void storeManualNative(String str, ManualWrite manualWrite, SettableFuture<Void> settableFuture);

    private native void storeNative(String str, byte[] bArr, SettableFuture<Void> settableFuture);

    public native String fetchPath(String str);

    static {
        SoLoader.a("compactdisk-jni");
    }

    @DoNotStrip
    protected PersistentKeyValueStore(HybridData hybridData) {
        this.mHybridData = hybridData;
    }
}
