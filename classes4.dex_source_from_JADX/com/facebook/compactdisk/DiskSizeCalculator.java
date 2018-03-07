package com.facebook.compactdisk;

import android.os.Looper;
import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.soloader.SoLoader;

/* compiled from: media_mime_type */
public class DiskSizeCalculator {
    @DoNotStrip
    private final HybridData mHybridData;

    private static native HybridData initHybrid(DiskSizeCalculatorHolder diskSizeCalculatorHolder);

    private native void startNativeDiskSizeCalculation();

    private native void startNativeRandomDiskSizeCalculation();

    public native void addDirectory(String str, long j);

    public native long fetchDirectorySize(String str);

    public native void setAnalytics(boolean z);

    static {
        SoLoader.a("compactdisk-jni");
    }

    public DiskSizeCalculator(DiskSizeCalculatorHolder diskSizeCalculatorHolder) {
        this.mHybridData = initHybrid(diskSizeCalculatorHolder);
    }

    public final void m8451a(String str) {
        addDirectory(str, 604800);
    }

    public final void m8450a() {
        m8449b();
        startNativeRandomDiskSizeCalculation();
    }

    private static void m8449b() {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            throw new IllegalStateException("On UI thread");
        }
    }
}
