package com.facebook.ffmpeg;

import com.facebook.common.internal.DoNotStrip;

/* compiled from: WWW_PROFILE_INTRO_CARD */
public class FFMpegMediaMuxer {
    private final String f12288a;
    private final FFMpegLib f12289b;
    @DoNotStrip
    private long mNativeContext;

    private native FFMpegAVStream nativeAddStream(FFMpegMediaFormat fFMpegMediaFormat);

    private native void nativeFinalize();

    private native void nativeInit(String str);

    private native void nativeStart();

    private native void nativeStop();

    public FFMpegMediaMuxer(FFMpegLib fFMpegLib, String str) {
        this.f12289b = fFMpegLib;
        this.f12288a = str;
    }

    public final FFMpegMediaMuxer m20357a() {
        this.f12289b.b();
        nativeInit(this.f12288a);
        return this;
    }

    protected void finalize() {
        super.finalize();
        nativeFinalize();
    }

    public final FFMpegAVStream m20356a(FFMpegMediaFormat fFMpegMediaFormat) {
        return nativeAddStream(fFMpegMediaFormat);
    }

    public final void m20358b() {
        nativeStart();
    }

    public final void m20359c() {
        nativeStop();
    }
}
