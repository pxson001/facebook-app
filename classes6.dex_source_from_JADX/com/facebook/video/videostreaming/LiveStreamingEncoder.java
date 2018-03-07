package com.facebook.video.videostreaming;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.Bundle;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.time.MonotonicClock;
import com.facebook.debug.log.BLog;
import com.facebook.video.videostreaming.protocol.VideoBroadcastAudioStreamingConfig;
import com.facebook.video.videostreaming.protocol.VideoBroadcastVideoStreamingConfig;
import com.facebook.video.videostreaming.protocol.VideoBroadcastVideoStreamingConfig.Builder;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

@TargetApi(19)
/* compiled from: savedState */
public class LiveStreamingEncoder {
    private static final Class<?> f5347b = LiveStreamingEncoder.class;
    final int f5348a = 1000;
    private final WeakReference<LiveStreamer> f5349c;
    public VideoBroadcastVideoStreamingConfig f5350d;
    public VideoBroadcastAudioStreamingConfig f5351e;
    public BufferInfo f5352f;
    public MediaCodec f5353g;
    private long f5354h;
    public long f5355i;
    private long f5356j;
    private int f5357k = -1;
    private long f5358l;
    public BufferInfo f5359m;
    public volatile MediaCodec f5360n;
    public RealtimeEncoderInputSurface f5361o;
    private long f5362p;
    private long f5363q;
    private int f5364r;
    private MonotonicClock f5365s;
    private LiveStreamingEncoderOutputConsumer f5366t;
    public final Map<String, String> f5367u;

    public LiveStreamingEncoder(MonotonicClock monotonicClock, LiveStreamer liveStreamer, LiveStreamingEncoderOutputConsumer liveStreamingEncoderOutputConsumer) {
        this.f5365s = monotonicClock;
        this.f5349c = new WeakReference(liveStreamer);
        this.f5366t = liveStreamingEncoderOutputConsumer;
        this.f5367u = new HashMap();
    }

    public final void m8068a() {
        this.f5364r = 0;
        this.f5350d = null;
        this.f5351e = null;
        this.f5354h = 0;
        this.f5358l = 0;
        this.f5356j = 0;
        this.f5362p = 0;
        this.f5355i = 0;
        this.f5363q = 0;
    }

    public final void m8072b() {
        if (this.f5361o != null) {
            RealtimeEncoderInputSurface realtimeEncoderInputSurface = this.f5361o;
            if (realtimeEncoderInputSurface.f5390c != null) {
                realtimeEncoderInputSurface.f5390c.release();
            }
            realtimeEncoderInputSurface.f5389b = -1;
            realtimeEncoderInputSurface.f5388a = -1;
        }
        MediaCodec mediaCodec = this.f5353g;
        if (mediaCodec != null) {
            mediaCodec.stop();
            mediaCodec.release();
        }
        mediaCodec = this.f5360n;
        if (mediaCodec != null) {
            mediaCodec.flush();
            mediaCodec.stop();
            mediaCodec.release();
        }
    }

    public final void m8073c() {
        this.f5355i += this.f5356j - this.f5354h;
        this.f5363q += this.f5362p - this.f5358l;
        long max = Math.max(this.f5355i, this.f5363q);
        Long.valueOf(this.f5355i);
        Long.valueOf(this.f5363q);
        Long.valueOf(Math.abs(this.f5355i - this.f5363q));
        this.f5363q = max;
        this.f5355i = max;
        this.f5354h = 0;
        this.f5358l = 0;
    }

    public final void m8069a(float f) {
        int c;
        if (this.f5350d != null) {
            Builder builder;
            if (f < 1.0f) {
                c = m8066c(((float) this.f5350d.width) / f);
                builder = new Builder(this.f5350d);
                builder.f5471b = c;
                this.f5350d = builder.m8149a();
            } else if (f > 1.0f) {
                c = m8066c(((float) this.f5350d.height) * f);
                builder = new Builder(this.f5350d);
                builder.f5470a = c;
                this.f5350d = builder.m8149a();
            }
        }
        this.f5367u.clear();
        int i = 426;
        this.f5359m = new BufferInfo();
        this.f5352f = new BufferInfo();
        this.f5360n = VideoEncoderSetup.m8094a(this.f5350d, this.f5367u);
        this.f5353g = AudioEncoderSetup.m7999a(this.f5351e);
        c = this.f5350d == null ? 426 : this.f5350d.width;
        if (this.f5350d != null) {
            i = this.f5350d.height;
        }
        this.f5361o = new RealtimeEncoderInputSurface(this.f5360n.createInputSurface(), c, i);
        this.f5353g.start();
        this.f5360n.start();
    }

    public final void m8070a(VideoBroadcastVideoStreamingConfig videoBroadcastVideoStreamingConfig, VideoBroadcastAudioStreamingConfig videoBroadcastAudioStreamingConfig, int i) {
        this.f5350d = videoBroadcastVideoStreamingConfig;
        this.f5351e = videoBroadcastAudioStreamingConfig;
        this.f5357k = i;
    }

    public final MediaFormat m8074e() {
        Preconditions.a(this.f5360n);
        return this.f5360n.getOutputFormat();
    }

    public final MediaFormat m8075f() {
        Preconditions.a(this.f5353g);
        return this.f5353g.getOutputFormat();
    }

    private void m8067m() {
        ByteBuffer[] outputBuffers = this.f5360n.getOutputBuffers();
        while (true) {
            int dequeueOutputBuffer = this.f5360n.dequeueOutputBuffer(this.f5359m, 1000);
            if (dequeueOutputBuffer == -1) {
                return;
            }
            if (dequeueOutputBuffer == -3) {
                outputBuffers = this.f5360n.getOutputBuffers();
            } else if (dequeueOutputBuffer == -2) {
                this.f5360n.getOutputFormat();
            } else if (dequeueOutputBuffer < 0) {
                BLog.a(f5347b, "unexpected result from encoder.dequeueOutputBuffer: %d", new Object[]{Integer.valueOf(dequeueOutputBuffer)});
            } else {
                if (this.f5358l == 0) {
                    this.f5358l = this.f5359m.presentationTimeUs / 1000;
                }
                this.f5362p = this.f5359m.presentationTimeUs / 1000;
                long j = (this.f5359m.presentationTimeUs / 1000) - this.f5358l;
                if (dequeueOutputBuffer >= outputBuffers.length) {
                    throw new RuntimeException("Encoder index out of bounds: " + dequeueOutputBuffer);
                }
                ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                byteBuffer.position(this.f5359m.offset).limit(this.f5359m.offset + this.f5359m.size);
                if (byteBuffer == null) {
                    throw new RuntimeException("encoderOutputBuffer %s was null" + dequeueOutputBuffer + " was null");
                }
                int i = (int) (this.f5363q + j);
                if (j < 0) {
                    i = ((int) this.f5363q) + 1;
                }
                if (this.f5357k != -1 && (this.f5364r % this.f5357k == 0 || this.f5364r == 1)) {
                    int i2 = this.f5350d.bitRate;
                    int a = ((LiveStreamer) this.f5349c.get()).m8041a(i2, this.f5351e.bitRate, i);
                    if (a != i2) {
                        Builder builder = new Builder(this.f5350d);
                        builder.f5472c = a;
                        this.f5350d = builder.m8149a();
                        Integer.valueOf(this.f5350d.bitRate);
                        Bundle bundle = new Bundle();
                        bundle.putInt("video-bitrate", this.f5350d.bitRate);
                        this.f5360n.setParameters(bundle);
                    }
                }
                if ((this.f5359m.flags & 2) != 0) {
                    this.f5359m.flags = 2;
                }
                this.f5366t.mo362b(byteBuffer, byteBuffer.position(), byteBuffer.remaining(), i, i, this.f5359m.flags, dequeueOutputBuffer, this.f5359m);
                this.f5360n.releaseOutputBuffer(dequeueOutputBuffer, false);
                if ((this.f5359m.flags & 4) != 0) {
                    return;
                }
            }
        }
    }

    final void m8071a(byte[] bArr, int i, boolean z) {
        ByteBuffer[] inputBuffers = this.f5353g.getInputBuffers();
        ByteBuffer[] outputBuffers = this.f5353g.getOutputBuffers();
        int dequeueInputBuffer = this.f5353g.dequeueInputBuffer(-1);
        if (dequeueInputBuffer >= 0) {
            ByteBuffer byteBuffer = inputBuffers[dequeueInputBuffer];
            byteBuffer.clear();
            byteBuffer.put(bArr, 0, i);
            this.f5353g.queueInputBuffer(dequeueInputBuffer, 0, i, this.f5365s.now() * 1000, 0);
        }
        if (z) {
            this.f5353g.signalEndOfInputStream();
        }
        ByteBuffer[] byteBufferArr = outputBuffers;
        while (true) {
            int dequeueOutputBuffer = this.f5353g.dequeueOutputBuffer(this.f5352f, 1000);
            if (dequeueOutputBuffer == -1) {
                if (!z) {
                    return;
                }
            } else if (dequeueOutputBuffer == -3) {
                byteBufferArr = this.f5353g.getOutputBuffers();
            } else if (dequeueOutputBuffer == -2) {
                BLog.a(f5347b, "Audio format changed!");
            } else if (dequeueOutputBuffer < 0) {
                BLog.a(f5347b, "unexpected result from encoder.dequeueOutputBuffer: %d", new Object[]{Integer.valueOf(dequeueOutputBuffer)});
            } else {
                ByteBuffer byteBuffer2 = byteBufferArr[dequeueOutputBuffer];
                if (byteBuffer2 == null) {
                    throw new RuntimeException("encoderOutputBuffer " + dequeueOutputBuffer + " was null");
                }
                if (this.f5354h == 0) {
                    this.f5354h = this.f5352f.presentationTimeUs / 1000;
                }
                long j = (this.f5352f.presentationTimeUs / 1000) - this.f5354h;
                byteBuffer2.position(this.f5352f.offset).limit(this.f5352f.size);
                this.f5356j = this.f5352f.presentationTimeUs / 1000;
                int i2 = (int) (j + this.f5355i);
                this.f5366t.mo361a(byteBuffer2, byteBuffer2.position(), byteBuffer2.remaining(), i2, i2, this.f5352f.flags, dequeueOutputBuffer, this.f5352f);
                this.f5353g.releaseOutputBuffer(dequeueOutputBuffer, false);
                if ((this.f5352f.flags & 4) != 0) {
                    return;
                }
            }
        }
    }

    public static int m8066c(float f) {
        return Math.round(f / 16.0f) * 16;
    }

    public final void m8076h() {
        this.f5364r++;
        m8067m();
    }
}
