package com.facebook.ffmpeg;

import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.internal.Preconditions;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: WWW_SEARCH_LOCAL_ECHO */
public class FFMpegMediaDemuxer {
    private final FFMpegLib f12279a;
    private final String f12280b;
    @Nullable
    private final Options f12281c;
    @DoNotStrip
    private long mNativeContext;

    @DoNotStrip
    /* compiled from: WWW_SEARCH_LOCAL_ECHO */
    public class Options {
        @DoNotStrip
        public boolean autoConvertPacketData = false;
        @DoNotStrip
        public boolean ensureSafeFileNames = false;
    }

    private native boolean nativeAdvance();

    private native void nativeFinalize();

    private native long nativeGetSampleDuration();

    private native int nativeGetSampleFlags();

    private native long nativeGetSampleTime();

    private native int nativeGetSampleTrackIndex();

    private native int nativeGetTrackCount();

    private native FFMpegMediaFormat nativeGetTrackFormat(int i);

    private native void nativeInit(String str, Options options);

    private native int nativeReadSampleData(ByteBuffer byteBuffer, int i);

    private native void nativeRelease();

    private native void nativeSeekTo(int i, long j, int i2);

    private native void nativeSelectTrack(int i);

    private native void nativeUnselectTrack(int i);

    public FFMpegMediaDemuxer(FFMpegLib fFMpegLib, String str) {
        this(fFMpegLib, str, null);
    }

    private FFMpegMediaDemuxer(FFMpegLib fFMpegLib, String str, Options options) {
        this.f12279a = fFMpegLib;
        this.f12280b = str;
        this.f12281c = options;
    }

    public final FFMpegMediaDemuxer m20333a() {
        this.f12279a.b();
        nativeInit(this.f12280b, this.f12281c);
        return this;
    }

    protected void finalize() {
        super.finalize();
        nativeFinalize();
    }

    public final boolean m20337b() {
        return nativeAdvance();
    }

    public final int m20338c() {
        return nativeGetSampleFlags();
    }

    public final long m20339d() {
        return nativeGetSampleTime();
    }

    public final int m20340e() {
        return nativeGetSampleTrackIndex();
    }

    public final int m20341f() {
        return nativeGetTrackCount();
    }

    public final FFMpegMediaFormat m20334a(int i) {
        return nativeGetTrackFormat(i);
    }

    public final int m20332a(ByteBuffer byteBuffer, int i) {
        Preconditions.a(byteBuffer);
        return nativeReadSampleData(byteBuffer, i);
    }

    public final void m20342g() {
        nativeRelease();
    }

    public final void m20335a(int i, long j, int i2) {
        boolean z = true;
        if (!(i2 == 2 || i2 == 1 || i2 == 0)) {
            z = false;
        }
        Preconditions.a(z);
        nativeSeekTo(i, j, i2);
    }

    public final void m20336b(int i) {
        nativeSelectTrack(i);
    }
}
