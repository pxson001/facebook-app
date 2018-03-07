package com.facebook.animated.webp;

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
/* compiled from: p2p_android_request_eligible */
public class WebPImage implements AnimatedImage, AnimatedImageDecoder {
    private static volatile boolean f10635a;
    @DoNotStrip
    private long mNativeContext;

    private static native WebPImage nativeCreateFromDirectByteBuffer(ByteBuffer byteBuffer);

    private static native WebPImage nativeCreateFromNativeMemory(long j, int i);

    private native void nativeDispose();

    private native void nativeFinalize();

    private native int nativeGetDuration();

    private native WebPFrame nativeGetFrame(int i);

    private native int nativeGetFrameCount();

    private native int[] nativeGetFrameDurations();

    private native int nativeGetHeight();

    private native int nativeGetLoopCount();

    private native int nativeGetSizeInBytes();

    private native int nativeGetWidth();

    public final /* synthetic */ AnimatedImageFrame mo2031a(int i) {
        return m15857c(i);
    }

    private static synchronized void m15858i() {
        synchronized (WebPImage.class) {
            if (!f10635a) {
                try {
                    SoLoaderShim.a("webp");
                } catch (UnsatisfiedLinkError e) {
                }
                SoLoaderShim.a("webpimage");
                f10635a = true;
            }
        }
    }

    @DoNotStrip
    WebPImage(long j) {
        this.mNativeContext = j;
    }

    protected void finalize() {
        nativeFinalize();
    }

    public final void m15869h() {
        nativeDispose();
    }

    public static WebPImage m15855a(byte[] bArr) {
        m15858i();
        Preconditions.a(bArr);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(bArr.length);
        allocateDirect.put(bArr);
        allocateDirect.rewind();
        return nativeCreateFromDirectByteBuffer(allocateDirect);
    }

    private static WebPImage m15856b(long j, int i) {
        m15858i();
        Preconditions.a(j != 0);
        return nativeCreateFromNativeMemory(j, i);
    }

    public final AnimatedImage mo2030a(long j, int i) {
        return m15856b(j, i);
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

    private WebPFrame m15857c(int i) {
        return nativeGetFrame(i);
    }

    public final int mo2038g() {
        return nativeGetSizeInBytes();
    }

    public final boolean mo2037f() {
        return true;
    }

    public final AnimatedDrawableFrameInfo mo2033b(int i) {
        WebPFrame c = m15857c(i);
        try {
            DisposalMethod disposalMethod;
            int d = c.d();
            int e = c.e();
            int b = c.b();
            int c2 = c.c();
            boolean g = c.g();
            if (c.f()) {
                disposalMethod = DisposalMethod.DISPOSE_TO_BACKGROUND;
            } else {
                disposalMethod = DisposalMethod.DISPOSE_DO_NOT;
            }
            AnimatedDrawableFrameInfo animatedDrawableFrameInfo = new AnimatedDrawableFrameInfo(i, d, e, b, c2, g, disposalMethod);
            return animatedDrawableFrameInfo;
        } finally {
            c.a();
        }
    }
}
