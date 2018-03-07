package com.facebook.compactdisk;

import android.content.Context;
import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.soloader.SoLoader;

@DoNotStrip
/* compiled from: media_fbid_first_returned */
public class ExperimentManager {
    @DoNotStrip
    private final HybridData mHybridData;

    private native HybridData initHybrid(String str, FileUtilsHolder fileUtilsHolder);

    public native void onExperimentsUpdated(Experiment[] experimentArr);

    static {
        SoLoader.a("compactdisk-jni");
    }

    public ExperimentManager(Context context, FileUtilsHolder fileUtilsHolder) {
        this.mHybridData = initHybrid(context.getApplicationContext().getFilesDir().getPath(), fileUtilsHolder);
    }
}
