package com.facebook.ffmpeg;

import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.internal.Preconditions;
import java.nio.ByteBuffer;

/* compiled from: WWW_SEARCH_LOCAL_LOCALSERP */
public class FFMpegAVStream {
    @DoNotStrip
    private long mNativeContext;

    private native void nativeFinalize();

    private native void nativeSetOrientationHint(int i);

    private native void nativeWriteFrame(FFMpegBufferInfo fFMpegBufferInfo, ByteBuffer byteBuffer);

    @DoNotStrip
    FFMpegAVStream(long j) {
        this.mNativeContext = j;
    }

    protected void finalize() {
        super.finalize();
        nativeFinalize();
    }

    public final void m20328a(int i) {
        boolean z = i == 0 || i == 90 || i == 180 || i == 270;
        Preconditions.a(z);
        nativeSetOrientationHint(i);
    }

    public final void m20329a(FFMpegBufferInfo fFMpegBufferInfo, ByteBuffer byteBuffer) {
        Preconditions.a(fFMpegBufferInfo);
        Preconditions.a(byteBuffer);
        nativeWriteFrame(fFMpegBufferInfo, byteBuffer);
    }
}
