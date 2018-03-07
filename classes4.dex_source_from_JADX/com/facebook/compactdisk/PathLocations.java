package com.facebook.compactdisk;

import android.content.Context;
import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.soloader.SoLoader;

@DoNotStrip
/* compiled from: me/vaultdevices */
public class PathLocations {
    @DoNotStrip
    private final HybridData mHybridData;

    private native HybridData initHybrid(String str, String str2);

    static {
        SoLoader.a("compactdisk-jni");
    }

    PathLocations(Context context) {
        this.mHybridData = initHybrid(context.getApplicationContext().getCacheDir().getPath(), context.getApplicationContext().getFilesDir().getPath());
    }
}
