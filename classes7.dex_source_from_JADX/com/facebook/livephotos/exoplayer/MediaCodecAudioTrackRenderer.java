package com.facebook.livephotos.exoplayer;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.media.PlaybackParams;
import android.os.Handler;
import android.os.SystemClock;
import com.facebook.livephotos.exoplayer.audio.AudioCapabilities;
import com.facebook.livephotos.exoplayer.audio.AudioTrack;
import com.facebook.livephotos.exoplayer.audio.AudioTrack.InitializationException;
import com.facebook.livephotos.exoplayer.audio.AudioTrack.WriteException;
import com.facebook.livephotos.exoplayer.drm.DrmSessionManager;
import com.facebook.livephotos.exoplayer.util.MimeTypes;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.nio.ByteBuffer;
import java.util.Arrays;

@TargetApi(16)
/* compiled from: param_bitmap_height */
public class MediaCodecAudioTrackRenderer extends MediaCodecTrackRenderer implements MediaClock {
    private final EventListener f6791c;
    private final AudioTrack f6792d;
    private boolean f6793e;
    private MediaFormat f6794f;
    private int f6795g;
    private long f6796h;
    private boolean f6797i;
    private boolean f6798j;
    private long f6799k;

    /* compiled from: param_bitmap_height */
    public interface EventListener extends com.facebook.livephotos.exoplayer.MediaCodecTrackRenderer.EventListener {
    }

    public MediaCodecAudioTrackRenderer(SampleSource sampleSource, MediaCodecSelector mediaCodecSelector) {
        this(sampleSource, mediaCodecSelector, null, true);
    }

    private MediaCodecAudioTrackRenderer(SampleSource sampleSource, MediaCodecSelector mediaCodecSelector, DrmSessionManager drmSessionManager, boolean z) {
        this(sampleSource, mediaCodecSelector, drmSessionManager, z, null, null);
    }

    private MediaCodecAudioTrackRenderer(SampleSource sampleSource, MediaCodecSelector mediaCodecSelector, DrmSessionManager drmSessionManager, boolean z, Handler handler, EventListener eventListener) {
        this(sampleSource, mediaCodecSelector, drmSessionManager, z, handler, eventListener, null, 3);
    }

    private MediaCodecAudioTrackRenderer(SampleSource sampleSource, MediaCodecSelector mediaCodecSelector, DrmSessionManager drmSessionManager, boolean z, Handler handler, EventListener eventListener, AudioCapabilities audioCapabilities, int i) {
        this(new SampleSource[]{sampleSource}, mediaCodecSelector, drmSessionManager, z, handler, eventListener, audioCapabilities, i);
    }

    private MediaCodecAudioTrackRenderer(SampleSource[] sampleSourceArr, MediaCodecSelector mediaCodecSelector, DrmSessionManager drmSessionManager, boolean z, Handler handler, EventListener eventListener, AudioCapabilities audioCapabilities, int i) {
        super(sampleSourceArr, mediaCodecSelector, drmSessionManager, z, handler, (com.facebook.livephotos.exoplayer.MediaCodecTrackRenderer.EventListener) eventListener);
        this.f6791c = eventListener;
        this.f6795g = 0;
        this.f6792d = new AudioTrack(audioCapabilities, i);
    }

    protected final boolean mo388a(MediaCodecSelector mediaCodecSelector, MediaFormat mediaFormat) {
        String str = mediaFormat.f6847b;
        if (!MimeTypes.m9304a(str)) {
            return false;
        }
        if ("audio/x-unknown".equals(str) || ((m8679a(str) && mediaCodecSelector.mo392a() != null) || mediaCodecSelector.mo391a(str, false) != null)) {
            return true;
        }
        return false;
    }

    protected final DecoderInfo mo383a(MediaCodecSelector mediaCodecSelector, String str, boolean z) {
        if (m8679a(str)) {
            String a = mediaCodecSelector.mo392a();
            if (a != null) {
                this.f6793e = true;
                return new DecoderInfo(a, false);
            }
        }
        this.f6793e = false;
        return super.mo383a(mediaCodecSelector, str, z);
    }

    private boolean m8679a(String str) {
        boolean z;
        AudioTrack audioTrack = this.f6792d;
        if (audioTrack.f6927c != null) {
            if ((Arrays.binarySearch(audioTrack.f6927c.f6896b, AudioTrack.m8794b(str)) >= 0 ? 1 : null) != null) {
                z = true;
                return z;
            }
        }
        z = false;
        return z;
    }

    protected final void mo385a(MediaCodec mediaCodec, boolean z, MediaFormat mediaFormat, MediaCrypto mediaCrypto) {
        String string = mediaFormat.getString("mime");
        if (this.f6793e) {
            mediaFormat.setString("mime", "audio/raw");
            mediaCodec.configure(mediaFormat, null, mediaCrypto, 0);
            mediaFormat.setString("mime", string);
            this.f6794f = mediaFormat;
            return;
        }
        mediaCodec.configure(mediaFormat, null, mediaCrypto, 0);
        this.f6794f = null;
    }

    protected final MediaClock mo389b() {
        return this;
    }

    protected final void mo386a(MediaFormat mediaFormat) {
        boolean z = this.f6794f != null;
        AudioTrack audioTrack = this.f6792d;
        if (z) {
            mediaFormat = this.f6794f;
        }
        audioTrack.m8809a(mediaFormat, z);
    }

    protected final void mo378c() {
        super.mo378c();
        this.f6792d.m8814e();
    }

    protected final void mo379d() {
        this.f6792d.m8818i();
        super.mo379d();
    }

    protected boolean mo380e() {
        return super.mo380e() && !this.f6792d.m8817h();
    }

    protected final boolean mo381f() {
        return this.f6792d.m8817h() || super.mo381f();
    }

    public final long mo382a() {
        long a = this.f6792d.m8807a(mo380e());
        if (a != Long.MIN_VALUE) {
            if (!this.f6797i) {
                a = Math.max(this.f6796h, a);
            }
            this.f6796h = a;
            this.f6797i = false;
        }
        return this.f6796h;
    }

    protected final void mo369g() {
        this.f6795g = 0;
        try {
            this.f6792d.m8820k();
        } finally {
            super.mo369g();
        }
    }

    protected final void mo375a(long j) {
        super.mo375a(j);
        this.f6792d.m8819j();
        this.f6796h = j;
        this.f6797i = true;
    }

    protected final boolean mo387a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, BufferInfo bufferInfo, int i, boolean z) {
        if (this.f6793e && (bufferInfo.flags & 2) != 0) {
            mediaCodec.releaseOutputBuffer(i, false);
            return true;
        } else if (z) {
            mediaCodec.releaseOutputBuffer(i, false);
            r0 = this.f6765a;
            r0.f6696g++;
            this.f6792d.m8815f();
            return true;
        } else {
            if (this.f6792d.m8810a()) {
                boolean z2 = this.f6798j;
                this.f6798j = this.f6792d.m8817h();
                if (z2 && !this.f6798j && m8620s() == 3) {
                    long elapsedRealtime = SystemClock.elapsedRealtime() - this.f6799k;
                    long d = this.f6792d.m8813d();
                    m8676a(this.f6792d.m8812c(), d == -1 ? -1 : d / 1000, elapsedRealtime);
                }
            } else {
                try {
                    if (this.f6795g != 0) {
                        this.f6792d.m8805a(this.f6795g);
                    } else {
                        this.f6795g = this.f6792d.m8811b();
                    }
                    this.f6798j = false;
                    if (m8620s() == 3) {
                        this.f6792d.m8814e();
                    }
                } catch (Throwable e) {
                    m8677a((InitializationException) e);
                    throw new ExoPlaybackException(e);
                }
            }
            try {
                int a = this.f6792d.m8806a(byteBuffer, bufferInfo.offset, bufferInfo.size, bufferInfo.presentationTimeUs);
                this.f6799k = SystemClock.elapsedRealtime();
                if ((a & 1) != 0) {
                    this.f6797i = true;
                }
                if ((a & 2) == 0) {
                    return false;
                }
                mediaCodec.releaseOutputBuffer(i, false);
                r0 = this.f6765a;
                r0.f6695f++;
                return true;
            } catch (Throwable e2) {
                m8678a((WriteException) e2);
                throw new ExoPlaybackException(e2);
            }
        }
    }

    protected final void mo390h() {
        this.f6792d.m8816g();
    }

    public final void mo384a(int i, Object obj) {
        switch (i) {
            case 1:
                this.f6792d.m8808a(((Float) obj).floatValue());
                return;
            case 2:
                this.f6792d.f6931g.mo404a((PlaybackParams) obj);
                return;
            default:
                super.mo384a(i, obj);
                return;
        }
    }

    private void m8677a(final InitializationException initializationException) {
        if (this.f6766b != null && this.f6791c != null) {
            HandlerDetour.a(this.f6766b, new Runnable(this) {
                final /* synthetic */ MediaCodecAudioTrackRenderer f6741b;

                public void run() {
                }
            }, -1181011646);
        }
    }

    private void m8678a(final WriteException writeException) {
        if (this.f6766b != null && this.f6791c != null) {
            HandlerDetour.a(this.f6766b, new Runnable(this) {
                final /* synthetic */ MediaCodecAudioTrackRenderer f6743b;

                public void run() {
                }
            }, 273399234);
        }
    }

    private void m8676a(int i, long j, long j2) {
        if (this.f6766b != null && this.f6791c != null) {
            final int i2 = i;
            final long j3 = j;
            final long j4 = j2;
            HandlerDetour.a(this.f6766b, new Runnable(this) {
                final /* synthetic */ MediaCodecAudioTrackRenderer f6747d;

                public void run() {
                }
            }, -1932825061);
        }
    }
}
