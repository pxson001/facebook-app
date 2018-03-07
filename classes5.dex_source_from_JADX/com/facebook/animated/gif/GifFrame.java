package com.facebook.animated.gif;

import android.graphics.Bitmap;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.imagepipeline.animated.base.AnimatedImageFrame;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: audio */
public class GifFrame implements AnimatedImageFrame {
    @DoNotStrip
    private long mNativeContext;

    private native void nativeDispose();

    private native void nativeFinalize();

    private native int nativeGetDisposalMode();

    private native int nativeGetDurationMs();

    private native int nativeGetHeight();

    private native int nativeGetWidth();

    private native int nativeGetXOffset();

    private native int nativeGetYOffset();

    private native boolean nativeHasTransparency();

    private native void nativeRenderFrame(int i, int i2, Bitmap bitmap);

    @DoNotStrip
    GifFrame(long j) {
        this.mNativeContext = j;
    }

    protected void finalize() {
        nativeFinalize();
    }

    public final void mo1087a() {
        nativeDispose();
    }

    public final void mo1088a(int i, int i2, Bitmap bitmap) {
        nativeRenderFrame(i, i2, bitmap);
    }

    public final int mo1089b() {
        return nativeGetWidth();
    }

    public final int mo1090c() {
        return nativeGetHeight();
    }

    public final int mo1091d() {
        return nativeGetXOffset();
    }

    public final int mo1092e() {
        return nativeGetYOffset();
    }

    public final int m14632f() {
        return nativeGetDisposalMode();
    }
}
