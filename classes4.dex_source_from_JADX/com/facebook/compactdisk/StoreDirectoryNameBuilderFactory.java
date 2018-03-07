package com.facebook.compactdisk;

import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.soloader.SoLoader;

@DoNotStrip
/* compiled from: me/sticker_tray_packs */
public class StoreDirectoryNameBuilderFactory {
    @DoNotStrip
    private final HybridData mHybridData;

    private native HybridData initHybrid(String str, String str2, String str3);

    static {
        SoLoader.a("compactdisk-jni");
    }

    public StoreDirectoryNameBuilderFactory(String str, String str2) {
        this.mHybridData = initHybrid("ijxLJi1yGs1JpL-X1SExmchvork", str, str2);
    }
}
