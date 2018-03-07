package com.facebook.compactdisk;

import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.soloader.SoLoader;

@DoNotStrip
/* compiled from: medium */
public class AttributeStoreHolder {
    @DoNotStrip
    private final HybridData mHybridData;

    private native HybridData initHybrid(FileUtilsHolder fileUtilsHolder);

    static {
        SoLoader.a("compactdisk-jni");
    }

    public AttributeStoreHolder(FileUtilsHolder fileUtilsHolder) {
        this.mHybridData = initHybrid(fileUtilsHolder);
    }
}
