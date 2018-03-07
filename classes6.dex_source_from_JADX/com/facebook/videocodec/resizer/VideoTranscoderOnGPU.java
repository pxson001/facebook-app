package com.facebook.videocodec.resizer;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.Build;
import android.view.Surface;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.gl.ProgramFactory;
import com.facebook.inject.InjectorLike;
import com.facebook.libyuv.YUVColorConverter;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.videocodec.codecs.Constants.MediaCodecInputType;
import com.facebook.videocodec.codecs.Constants.MediaCodecType;
import com.facebook.videocodec.codecs.MediaBaseCodecBuffer;
import com.facebook.videocodec.codecs.MediaCodecFactory;
import com.facebook.videocodec.codecs.MediaCodecWrapper;
import com.facebook.videocodec.codecs.MediaFormatBuilderForVideoEncoder;
import com.facebook.videocodec.codecs.VideoDecoderInfo;
import com.facebook.videocodec.codecs.VideoEncoderInfo;
import com.facebook.videocodec.policy.VideoTranscodeParams;
import com.facebook.videocodec.render.TranscodeOutputSurfaceForGpu;
import com.facebook.videocodec.render.TranscodedFrameResult;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import java.nio.ByteBuffer;
import java.util.Queue;
import javax.inject.Inject;
import javax.microedition.khronos.egl.EGL10;

@TargetApi(16)
/* compiled from: reshare_message */
public class VideoTranscoderOnGPU implements VideoTranscoder {
    private static final ImmutableSet<Integer> f5707a = ImmutableSet.of(Integer.valueOf(21), Integer.valueOf(19));
    private final MediaCodecFactory f5708b;
    private final ProgramFactory f5709c;
    private final YUVColorConverter f5710d;
    private final AbstractFbErrorReporter f5711e;
    private VideoEncoderInfo f5712f;
    private VideoDecoderInfo f5713g;
    private MediaCodecWrapper f5714h;
    private MediaCodecWrapper f5715i;
    private MediaFormat f5716j;
    private VideoTranscodeParams f5717k;
    private int f5718l;
    private int f5719m;
    private boolean f5720n;
    private boolean f5721o;
    private TranscodeOutputSurfaceForGpu f5722p;
    private TranscodedFrameResult f5723q;
    private Queue<Long> f5724r;

    public static VideoTranscoderOnGPU m8325b(InjectorLike injectorLike) {
        return new VideoTranscoderOnGPU(MediaCodecFactory.m8170a(injectorLike), ProgramFactory.b(injectorLike), YUVColorConverter.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    VideoTranscoderOnGPU(MediaCodecFactory mediaCodecFactory, ProgramFactory programFactory, YUVColorConverter yUVColorConverter, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f5708b = mediaCodecFactory;
        this.f5709c = programFactory;
        this.f5710d = yUVColorConverter;
        this.f5711e = abstractFbErrorReporter;
    }

    public final void mo380a(VideoTranscodeParams videoTranscodeParams) {
        this.f5712f = this.f5708b.m8181a();
        Preconditions.checkArgument(f5707a.contains(Integer.valueOf(this.f5712f.f5525b)), "Unsupported color format: " + this.f5712f.f5525b);
        MediaFormatBuilderForVideoEncoder mediaFormatBuilderForVideoEncoder = new MediaFormatBuilderForVideoEncoder(MediaCodecType.CODEC_VIDEO_H264, videoTranscodeParams.f5577d, videoTranscodeParams.f5578e, this.f5712f.f5525b);
        mediaFormatBuilderForVideoEncoder.f5515e = videoTranscodeParams.f5583j;
        mediaFormatBuilderForVideoEncoder = mediaFormatBuilderForVideoEncoder;
        mediaFormatBuilderForVideoEncoder.f5517g = videoTranscodeParams.f5585l;
        mediaFormatBuilderForVideoEncoder = mediaFormatBuilderForVideoEncoder;
        mediaFormatBuilderForVideoEncoder.f5516f = videoTranscodeParams.f5584k;
        this.f5716j = mediaFormatBuilderForVideoEncoder.m8189a();
        MediaCodecFactory mediaCodecFactory = this.f5708b;
        String str = this.f5712f.f5524a;
        this.f5714h = MediaCodecFactory.m8172a(MediaCodec.createByCodecName(str), this.f5716j, MediaCodecInputType.BUFFERS);
        this.f5714h.m8184a();
        this.f5717k = videoTranscodeParams;
    }

    public final void mo378a(MediaFormat mediaFormat) {
        this.f5713g = this.f5708b.m8182b(mediaFormat.getString("mime"));
        this.f5722p = new TranscodeOutputSurfaceForGpu(this.f5709c, this.f5717k, this.f5713g.f5523c);
        MediaCodecFactory mediaCodecFactory = this.f5708b;
        String str = this.f5713g.f5521a;
        Surface surface = this.f5722p.f5598i;
        MediaCodec createByCodecName = MediaCodec.createByCodecName(str);
        if (Objects.equal(str, "OMX.qcom.video.decoder.avc") && MediaCodecFactory.f5500f.contains(Build.MODEL)) {
            mediaFormat.setInteger("max-input-size", 0);
        }
        this.f5715i = MediaCodecFactory.m8171a(createByCodecName, mediaFormat, surface);
        this.f5715i.m8184a();
        this.f5724r = Lists.b();
    }

    public final MediaBaseCodecBuffer mo377a(long j) {
        return this.f5715i.m8183a(j);
    }

    public final void mo379a(MediaBaseCodecBuffer mediaBaseCodecBuffer) {
        this.f5715i.m8185a(mediaBaseCodecBuffer);
        this.f5724r.add(Long.valueOf(mediaBaseCodecBuffer.mo365b().presentationTimeUs));
        this.f5718l++;
    }

    public final void mo383b(long j) {
        if (!this.f5721o) {
            if (!this.f5720n) {
                m8324a(j, false);
                MediaBaseCodecBuffer b = this.f5715i.m8186b(j);
                if (b != null && b.m8168d()) {
                    BufferInfo b2 = b.mo365b();
                    if ((b2.flags & 4) != 0) {
                        this.f5720n = true;
                        this.f5715i.m8188b(b);
                        return;
                    }
                    long j2;
                    this.f5715i.m8188b(b);
                    Long l = (Long) this.f5724r.poll();
                    if (!this.f5713g.f5522b || l == null) {
                        j2 = b2.presentationTimeUs;
                    } else {
                        j2 = l.longValue();
                    }
                    TranscodeOutputSurfaceForGpu transcodeOutputSurfaceForGpu = this.f5722p;
                    Preconditions.checkState(!transcodeOutputSurfaceForGpu.f5605p);
                    transcodeOutputSurfaceForGpu.f5597h.m8259a();
                    transcodeOutputSurfaceForGpu.f5597h.m8260b();
                    transcodeOutputSurfaceForGpu.f5604o = j2;
                    transcodeOutputSurfaceForGpu.f5605p = true;
                }
            } else if (m8324a(j, true)) {
                MediaBaseCodecBuffer a = this.f5714h.m8183a(-1);
                a.mo364a(0, 0, 0, 4);
                this.f5714h.m8185a(a);
                this.f5721o = true;
            }
        }
    }

    public final int mo388e() {
        return this.f5717k.m8252a();
    }

    private boolean m8324a(long j, boolean z) {
        while (true) {
            if (this.f5723q == null) {
                TracerDetour.a("readNextFrame", -1106586432);
                try {
                    this.f5723q = this.f5722p.m8256c();
                    if (this.f5723q == null) {
                        return z;
                    }
                } finally {
                    TracerDetour.a(-1603323287);
                }
            }
            MediaBaseCodecBuffer a = this.f5714h.m8183a(j);
            if (a == null) {
                return false;
            }
            TracerDetour.a("convertColor", 1092864989);
            try {
                m8323a(this.f5723q.f5632a, a, this.f5723q.f5633b);
                TracerDetour.a(760478210);
                this.f5714h.m8185a(a);
                this.f5723q = null;
            } catch (Throwable th) {
                TracerDetour.a(-1954141798);
            }
        }
    }

    private void m8323a(ByteBuffer byteBuffer, MediaBaseCodecBuffer mediaBaseCodecBuffer, long j) {
        int i = this.f5717k.f5577d;
        int i2 = this.f5717k.f5578e;
        byteBuffer.rewind();
        int i3;
        int i4;
        ByteBuffer slice;
        ByteBuffer slice2;
        switch (this.f5712f.f5525b) {
            case 19:
                int i5 = ((i * i2) * 3) / 2;
                if (mediaBaseCodecBuffer.mo363a().capacity() < i5) {
                    throw new IllegalStateException("Encoder buffer too small");
                }
                i3 = i * i2;
                i4 = i3 / 4;
                slice = mediaBaseCodecBuffer.mo363a().slice();
                ByteBuffer slice3 = mediaBaseCodecBuffer.mo363a().slice();
                slice2 = mediaBaseCodecBuffer.mo363a().slice();
                slice.position(0);
                slice3.position(i3);
                slice2.position(i3 + i4);
                ByteBuffer byteBuffer2 = byteBuffer;
                YUVColorConverter.a(byteBuffer2, i * 4, slice, i, slice2, i / 2, slice3, i / 2, i, -i2);
                mediaBaseCodecBuffer.mo364a(0, i5, j, 0);
                return;
            case 21:
                int i6;
                i4 = i * i2;
                i3 = this.f5712f.f5526c;
                if (i3 == 0 || i4 % i3 == 0) {
                    i6 = 0;
                    i3 = i4;
                } else {
                    i6 = i3 - (i4 % i3);
                    i3 = i4 + i6;
                }
                int i7 = ((i4 * 3) / 2) + i6;
                if (mediaBaseCodecBuffer.mo363a().capacity() < i7) {
                    throw new IllegalStateException("Encoder buffer too small");
                }
                slice = mediaBaseCodecBuffer.mo363a().slice();
                slice2 = mediaBaseCodecBuffer.mo363a().slice();
                slice.position(0);
                slice2.position(i3);
                YUVColorConverter.a(byteBuffer, i * 4, slice, i, slice2, i, i, -i2);
                mediaBaseCodecBuffer.mo364a(0, i7, j, 0);
                return;
            default:
                throw new IllegalStateException("Unsupported color format");
        }
    }

    public final MediaBaseCodecBuffer mo385c(long j) {
        MediaBaseCodecBuffer b = this.f5714h.m8186b(j);
        if (b != null && b.m8168d()) {
            this.f5719m++;
        }
        return b;
    }

    public final void mo384b(MediaBaseCodecBuffer mediaBaseCodecBuffer) {
        this.f5714h.m8188b(mediaBaseCodecBuffer);
    }

    public final boolean mo381a() {
        return this.f5721o;
    }

    public final void mo382b() {
        if (this.f5721o && this.f5718l != this.f5719m) {
            this.f5711e.a("VideoTranscoderOnGPU_mismatched_frame_count", "input count=" + this.f5718l + ", output count=" + this.f5719m);
        }
        mo386c();
    }

    public final void mo386c() {
        if (this.f5715i != null) {
            this.f5715i.m8187b();
            this.f5715i = null;
        }
        if (this.f5714h != null) {
            this.f5714h.m8187b();
            this.f5714h = null;
        }
        if (this.f5722p != null) {
            TranscodeOutputSurfaceForGpu transcodeOutputSurfaceForGpu = this.f5722p;
            if (transcodeOutputSurfaceForGpu.f5600k != EGL10.EGL_NO_DISPLAY) {
                transcodeOutputSurfaceForGpu.f5599j.eglDestroySurface(transcodeOutputSurfaceForGpu.f5600k, transcodeOutputSurfaceForGpu.f5602m);
                transcodeOutputSurfaceForGpu.f5599j.eglDestroyContext(transcodeOutputSurfaceForGpu.f5600k, transcodeOutputSurfaceForGpu.f5601l);
                transcodeOutputSurfaceForGpu.f5599j.eglMakeCurrent(transcodeOutputSurfaceForGpu.f5600k, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                transcodeOutputSurfaceForGpu.f5599j.eglTerminate(transcodeOutputSurfaceForGpu.f5600k);
            }
            transcodeOutputSurfaceForGpu.f5600k = EGL10.EGL_NO_DISPLAY;
            transcodeOutputSurfaceForGpu.f5601l = EGL10.EGL_NO_CONTEXT;
            transcodeOutputSurfaceForGpu.f5602m = EGL10.EGL_NO_SURFACE;
            if (transcodeOutputSurfaceForGpu.f5598i != null) {
                transcodeOutputSurfaceForGpu.f5598i.release();
            }
            transcodeOutputSurfaceForGpu.f5595f = null;
            transcodeOutputSurfaceForGpu.f5598i = null;
            transcodeOutputSurfaceForGpu.f5596g = null;
            this.f5722p = null;
        }
    }

    public final MediaFormat mo387d() {
        return this.f5716j;
    }
}
