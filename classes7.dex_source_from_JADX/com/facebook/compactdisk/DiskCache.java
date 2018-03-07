package com.facebook.compactdisk;

import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.soloader.SoLoader;

@DoNotStrip
/* compiled from: typeWindowStateChanged */
public class DiskCache extends PersistentKeyValueStore {
    static {
        SoLoader.a("compactdisk-jni");
    }

    @DoNotStrip
    private DiskCache(HybridData hybridData) {
        super(hybridData);
    }
}
