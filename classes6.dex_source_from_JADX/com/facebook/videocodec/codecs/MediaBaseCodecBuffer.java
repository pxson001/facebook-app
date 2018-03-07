package com.facebook.videocodec.codecs;

import android.annotation.TargetApi;
import android.media.MediaCodec.BufferInfo;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;

@TargetApi(16)
/* compiled from: reviewer_context */
public class MediaBaseCodecBuffer implements CodecBuffer {
    private final WeakReference<ByteBuffer> f5490a;
    public final int f5491b;
    private BufferInfo f5492c;
    public boolean f5493d = false;

    public MediaBaseCodecBuffer(ByteBuffer byteBuffer, int i, BufferInfo bufferInfo) {
        this.f5490a = new WeakReference(byteBuffer);
        this.f5491b = i;
        this.f5492c = bufferInfo;
    }

    public final ByteBuffer mo363a() {
        return (ByteBuffer) this.f5490a.get();
    }

    public final BufferInfo mo365b() {
        return this.f5492c;
    }

    public final void mo364a(int i, int i2, long j, int i3) {
        if (this.f5492c == null) {
            this.f5492c = new BufferInfo();
        }
        this.f5492c.set(i, i2, j, i3);
    }

    public final boolean m8168d() {
        return this.f5491b >= 0;
    }

    public final boolean m8169e() {
        return this.f5493d;
    }
}
