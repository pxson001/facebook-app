package com.facebook.animated.gif;

import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.soloader.SoLoaderShim;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo.DisposalMethod;
import com.facebook.imagepipeline.animated.base.AnimatedImage;
import com.facebook.imagepipeline.animated.base.AnimatedImageFrame;
import com.facebook.imagepipeline.animated.factory.AnimatedImageDecoder;
import java.nio.ByteBuffer;
import javax.annotation.concurrent.ThreadSafe;

@DoNotStrip
@ThreadSafe
/* compiled from: p2p_android_send_theme */
public class GifImage implements AnimatedImage, AnimatedImageDecoder {
    private static volatile boolean f10634a;
    @DoNotStrip
    private long mNativeContext;

    private static native GifImage nativeCreateFromDirectByteBuffer(ByteBuffer byteBuffer);

    private static native GifImage nativeCreateFromNativeMemory(long j, int i);

    private native void nativeDispose();

    private native void nativeFinalize();

    private native int nativeGetDuration();

    private native GifFrame nativeGetFrame(int i);

    private native int nativeGetFrameCount();

    private native int[] nativeGetFrameDurations();

    private native int nativeGetHeight();

    private native int nativeGetLoopCount();

    private native int nativeGetSizeInBytes();

    private native int nativeGetWidth();

    public final /* synthetic */ AnimatedImageFrame mo2031a(int i) {
        return m15831c(i);
    }

    private static synchronized void m15833i() {
        synchronized (GifImage.class) {
            if (!f10634a) {
                f10634a = true;
                SoLoaderShim.a("gifimage");
            }
        }
    }

    public static GifImage m15829a(byte[] bArr) {
        m15833i();
        Preconditions.a(bArr);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(bArr.length);
        allocateDirect.put(bArr);
        allocateDirect.rewind();
        return nativeCreateFromDirectByteBuffer(allocateDirect);
    }

    private static GifImage m15830b(long j, int i) {
        m15833i();
        Preconditions.a(j != 0);
        return nativeCreateFromNativeMemory(j, i);
    }

    public final AnimatedImage mo2030a(long j, int i) {
        return m15830b(j, i);
    }

    @DoNotStrip
    GifImage(long j) {
        this.mNativeContext = j;
    }

    protected void finalize() {
        nativeFinalize();
    }

    public final void m15844h() {
        nativeDispose();
    }

    public final int mo2029a() {
        return nativeGetWidth();
    }

    public final int mo2032b() {
        return nativeGetHeight();
    }

    public final int mo2034c() {
        return nativeGetFrameCount();
    }

    public final int[] mo2035d() {
        return nativeGetFrameDurations();
    }

    public final int mo2036e() {
        return nativeGetLoopCount();
    }

    private GifFrame m15831c(int i) {
        return nativeGetFrame(i);
    }

    public final boolean mo2037f() {
        return false;
    }

    public final int mo2038g() {
        return nativeGetSizeInBytes();
    }

    public final AnimatedDrawableFrameInfo mo2033b(int i) {
        GifFrame c = m15831c(i);
        try {
            AnimatedDrawableFrameInfo animatedDrawableFrameInfo = new AnimatedDrawableFrameInfo(i, c.d(), c.e(), c.b(), c.c(), true, m15832d(c.f()));
            return animatedDrawableFrameInfo;
        } finally {
            c.a();
        }
    }

    private static DisposalMethod m15832d(int i) {
        if (i == 0) {
            return DisposalMethod.DISPOSE_DO_NOT;
        }
        if (i == 1) {
            return DisposalMethod.DISPOSE_DO_NOT;
        }
        if (i == 2) {
            return DisposalMethod.DISPOSE_TO_BACKGROUND;
        }
        if (i == 3) {
            return DisposalMethod.DISPOSE_TO_PREVIOUS;
        }
        return DisposalMethod.DISPOSE_DO_NOT;
    }
}
