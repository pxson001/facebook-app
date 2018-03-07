package com.facebook.ffmpeg;

import com.facebook.common.internal.DoNotStrip;

/* compiled from: WWW_REG */
public class FFMpegMediaMetadataRetriever {
    private final FFMpegLib f12285a;
    private final String f12286b;
    @DoNotStrip
    private long mNativeContext;

    private native void nativeFinalize();

    private native int nativeGetAudioBitRate();

    private native int nativeGetBitRate();

    private native long nativeGetDurationMs();

    private native int nativeGetHeight();

    private native int nativeGetRotation();

    private native String nativeGetSphericalMetadataXml();

    private native int nativeGetWidth();

    private native void nativeInit(String str);

    private native void nativeRelease();

    public FFMpegMediaMetadataRetriever(FFMpegLib fFMpegLib, String str) {
        this.f12285a = fFMpegLib;
        this.f12286b = str;
    }

    public final FFMpegMediaMetadataRetriever m20346a() {
        this.f12285a.b();
        nativeInit(this.f12286b);
        return this;
    }

    public final void m20347b() {
        nativeRelease();
    }

    protected void finalize() {
        super.finalize();
        nativeFinalize();
    }

    public final int m20348c() {
        return nativeGetRotation();
    }

    public final long m20349d() {
        return nativeGetDurationMs();
    }

    public final int m20350e() {
        return nativeGetWidth();
    }

    public final int m20351f() {
        return nativeGetHeight();
    }

    public final int m20352g() {
        return nativeGetBitRate();
    }

    public final int m20353h() {
        return nativeGetAudioBitRate();
    }

    public final String m20354i() {
        return nativeGetSphericalMetadataXml();
    }
}
