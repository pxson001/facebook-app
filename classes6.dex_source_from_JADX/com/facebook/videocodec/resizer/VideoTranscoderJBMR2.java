package com.facebook.videocodec.resizer;

import android.annotation.TargetApi;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.opengl.EGL14;
import android.opengl.EGLExt;
import com.facebook.gl.ProgramFactory;
import com.facebook.inject.InjectorLike;
import com.facebook.videocodec.codecs.Constants.MediaCodecInputType;
import com.facebook.videocodec.codecs.Constants.MediaCodecProcessingType;
import com.facebook.videocodec.codecs.Constants.MediaCodecType;
import com.facebook.videocodec.codecs.MediaBaseCodecBuffer;
import com.facebook.videocodec.codecs.MediaCodecFactory;
import com.facebook.videocodec.codecs.MediaCodecWrapper;
import com.facebook.videocodec.codecs.MediaFormatBuilderForVideoEncoder;
import com.facebook.videocodec.policy.VideoTranscodeParams;
import com.facebook.videocodec.render.TranscodeOutputSurfaceForJBMR2;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

@TargetApi(18)
/* compiled from: reshare_nux_variant */
public class VideoTranscoderJBMR2 implements VideoTranscoder {
    private final MediaCodecFactory f5700a;
    private final ProgramFactory f5701b;
    private MediaCodecWrapper f5702c;
    private MediaCodecWrapper f5703d;
    private TranscodeOutputSurfaceForJBMR2 f5704e;
    private VideoTranscodeParams f5705f;
    private boolean f5706g;

    public static VideoTranscoderJBMR2 m8310b(InjectorLike injectorLike) {
        return new VideoTranscoderJBMR2(MediaCodecFactory.m8170a(injectorLike), ProgramFactory.b(injectorLike));
    }

    @Inject
    VideoTranscoderJBMR2(MediaCodecFactory mediaCodecFactory, ProgramFactory programFactory) {
        this.f5700a = mediaCodecFactory;
        this.f5701b = programFactory;
    }

    public final void mo380a(VideoTranscodeParams videoTranscodeParams) {
        MediaFormatBuilderForVideoEncoder mediaFormatBuilderForVideoEncoder = new MediaFormatBuilderForVideoEncoder(MediaCodecType.CODEC_VIDEO_H264, videoTranscodeParams.f5577d, videoTranscodeParams.f5578e, 2130708361);
        mediaFormatBuilderForVideoEncoder.f5515e = videoTranscodeParams.f5583j;
        mediaFormatBuilderForVideoEncoder = mediaFormatBuilderForVideoEncoder;
        mediaFormatBuilderForVideoEncoder.f5517g = videoTranscodeParams.f5585l;
        mediaFormatBuilderForVideoEncoder = mediaFormatBuilderForVideoEncoder;
        mediaFormatBuilderForVideoEncoder.f5516f = videoTranscodeParams.f5584k;
        mediaFormatBuilderForVideoEncoder = mediaFormatBuilderForVideoEncoder;
        if (videoTranscodeParams.f5586m != null) {
            int i = videoTranscodeParams.f5586m.f5588a;
            int i2 = videoTranscodeParams.f5586m.f5589b;
            mediaFormatBuilderForVideoEncoder.f5519i = i;
            mediaFormatBuilderForVideoEncoder.f5520j = i2;
            mediaFormatBuilderForVideoEncoder.f5518h = true;
            mediaFormatBuilderForVideoEncoder = mediaFormatBuilderForVideoEncoder;
        }
        this.f5702c = this.f5700a.m8180a(MediaCodecType.CODEC_VIDEO_H264.value, mediaFormatBuilderForVideoEncoder.m8189a(), MediaCodecInputType.SURFACE);
        this.f5702c.m8184a();
        ProgramFactory programFactory = this.f5701b;
        MediaCodecWrapper mediaCodecWrapper = this.f5702c;
        Preconditions.checkArgument(mediaCodecWrapper.f5503a == MediaCodecProcessingType.ENCODER);
        this.f5704e = new TranscodeOutputSurfaceForJBMR2(programFactory, mediaCodecWrapper.f5505c, videoTranscodeParams);
        this.f5705f = videoTranscodeParams;
    }

    public final void mo378a(MediaFormat mediaFormat) {
        this.f5703d = this.f5700a.m8179a(mediaFormat.getString("mime"), mediaFormat, this.f5704e.f5610e);
        this.f5703d.m8184a();
    }

    public final MediaBaseCodecBuffer mo377a(long j) {
        return this.f5703d.m8183a(j);
    }

    public final void mo379a(MediaBaseCodecBuffer mediaBaseCodecBuffer) {
        this.f5703d.m8185a(mediaBaseCodecBuffer);
    }

    public final void mo383b(long j) {
        MediaBaseCodecBuffer b = this.f5703d.m8186b(j);
        if (b != null && b.m8168d()) {
            BufferInfo b2 = b.mo365b();
            this.f5703d.m8188b(b);
            if ((b2.flags & 4) != 0) {
                this.f5706g = true;
                MediaCodecWrapper mediaCodecWrapper = this.f5702c;
                Preconditions.checkArgument(mediaCodecWrapper.f5503a == MediaCodecProcessingType.ENCODER);
                mediaCodecWrapper.f5504b.signalEndOfInputStream();
                return;
            }
            TranscodeOutputSurfaceForJBMR2 transcodeOutputSurfaceForJBMR2;
            this.f5704e.f5615j.m8259a();
            this.f5704e.f5615j.m8260b();
            if (b2 != null) {
                transcodeOutputSurfaceForJBMR2 = this.f5704e;
                EGLExt.eglPresentationTimeANDROID(transcodeOutputSurfaceForJBMR2.f5611f, transcodeOutputSurfaceForJBMR2.f5613h, b2.presentationTimeUs * 1000);
            }
            transcodeOutputSurfaceForJBMR2 = this.f5704e;
            boolean eglSwapBuffers = EGL14.eglSwapBuffers(transcodeOutputSurfaceForJBMR2.f5611f, transcodeOutputSurfaceForJBMR2.f5613h);
        }
    }

    public final MediaBaseCodecBuffer mo385c(long j) {
        return this.f5702c.m8186b(j);
    }

    public final void mo384b(MediaBaseCodecBuffer mediaBaseCodecBuffer) {
        this.f5702c.m8188b(mediaBaseCodecBuffer);
    }

    public final boolean mo381a() {
        return this.f5706g;
    }

    public final void mo382b() {
        mo386c();
    }

    public final void mo386c() {
        if (this.f5703d != null) {
            this.f5703d.m8187b();
            this.f5703d = null;
        }
        if (this.f5702c != null) {
            this.f5702c.m8187b();
            this.f5702c = null;
        }
        if (this.f5704e != null) {
            TranscodeOutputSurfaceForJBMR2 transcodeOutputSurfaceForJBMR2 = this.f5704e;
            if (EGL14.eglGetCurrentContext().equals(transcodeOutputSurfaceForJBMR2.f5612g)) {
                EGL14.eglMakeCurrent(transcodeOutputSurfaceForJBMR2.f5611f, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
            }
            EGL14.eglDestroySurface(transcodeOutputSurfaceForJBMR2.f5611f, transcodeOutputSurfaceForJBMR2.f5613h);
            EGL14.eglDestroyContext(transcodeOutputSurfaceForJBMR2.f5611f, transcodeOutputSurfaceForJBMR2.f5612g);
            transcodeOutputSurfaceForJBMR2.f5610e.release();
            transcodeOutputSurfaceForJBMR2.f5611f = null;
            transcodeOutputSurfaceForJBMR2.f5612g = null;
            transcodeOutputSurfaceForJBMR2.f5613h = null;
            transcodeOutputSurfaceForJBMR2.f5614i = null;
            transcodeOutputSurfaceForJBMR2.f5610e = null;
            transcodeOutputSurfaceForJBMR2.f5608c = null;
            transcodeOutputSurfaceForJBMR2.f5615j = null;
            this.f5704e = null;
        }
    }

    public final MediaFormat mo387d() {
        return this.f5702c.f5507e;
    }

    public final int mo388e() {
        return this.f5705f.m8252a();
    }
}
