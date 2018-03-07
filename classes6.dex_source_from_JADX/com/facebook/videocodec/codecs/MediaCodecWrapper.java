package com.facebook.videocodec.codecs;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.view.Surface;
import com.facebook.videocodec.codecs.Constants.MediaCodecProcessingType;
import com.google.common.base.Preconditions;
import java.nio.ByteBuffer;

@TargetApi(16)
/* compiled from: review_step_exposed */
public class MediaCodecWrapper {
    public final MediaCodecProcessingType f5503a;
    public final MediaCodec f5504b;
    public final Surface f5505c;
    private final boolean f5506d;
    public MediaFormat f5507e;
    private boolean f5508f;
    private ByteBuffer[] f5509g;
    private ByteBuffer[] f5510h;

    public MediaCodecWrapper(MediaCodecProcessingType mediaCodecProcessingType, MediaCodec mediaCodec, Surface surface, boolean z) {
        boolean z2 = surface == null || mediaCodecProcessingType == MediaCodecProcessingType.ENCODER;
        Preconditions.checkArgument(z2);
        this.f5503a = mediaCodecProcessingType;
        this.f5504b = mediaCodec;
        this.f5505c = surface;
        this.f5506d = z;
    }

    public final void m8184a() {
        this.f5504b.start();
        this.f5508f = true;
        if (this.f5505c == null) {
            this.f5509g = this.f5504b.getInputBuffers();
        }
        this.f5510h = this.f5504b.getOutputBuffers();
    }

    public final void m8187b() {
        if (this.f5504b != null) {
            if (this.f5508f) {
                this.f5504b.stop();
                this.f5508f = false;
            }
            this.f5504b.release();
            this.f5509g = null;
            this.f5510h = null;
            this.f5507e = null;
        }
        if (this.f5505c != null) {
            this.f5505c.release();
        }
    }

    public final MediaBaseCodecBuffer m8183a(long j) {
        Preconditions.checkState(this.f5505c == null);
        int dequeueInputBuffer = this.f5504b.dequeueInputBuffer(j);
        if (dequeueInputBuffer >= 0) {
            return new MediaBaseCodecBuffer(this.f5509g[dequeueInputBuffer], dequeueInputBuffer, null);
        }
        return null;
    }

    public final void m8185a(MediaBaseCodecBuffer mediaBaseCodecBuffer) {
        this.f5504b.queueInputBuffer(mediaBaseCodecBuffer.f5491b, mediaBaseCodecBuffer.mo365b().offset, mediaBaseCodecBuffer.mo365b().size, mediaBaseCodecBuffer.mo365b().presentationTimeUs, mediaBaseCodecBuffer.mo365b().flags);
    }

    public final MediaBaseCodecBuffer m8186b(long j) {
        BufferInfo bufferInfo = new BufferInfo();
        int dequeueOutputBuffer = this.f5504b.dequeueOutputBuffer(bufferInfo, j);
        if (dequeueOutputBuffer >= 0) {
            return new MediaBaseCodecBuffer(this.f5510h[dequeueOutputBuffer], dequeueOutputBuffer, bufferInfo);
        }
        switch (dequeueOutputBuffer) {
            case -3:
                this.f5510h = this.f5504b.getOutputBuffers();
                return null;
            case -2:
                this.f5507e = this.f5504b.getOutputFormat();
                MediaBaseCodecBuffer mediaBaseCodecBuffer = new MediaBaseCodecBuffer(null, -1, null);
                mediaBaseCodecBuffer.f5493d = true;
                return mediaBaseCodecBuffer;
            case -1:
                return null;
            default:
                return null;
        }
    }

    public final void m8188b(MediaBaseCodecBuffer mediaBaseCodecBuffer) {
        if (mediaBaseCodecBuffer.m8168d()) {
            this.f5504b.releaseOutputBuffer(mediaBaseCodecBuffer.f5491b, this.f5506d);
        }
    }
}
