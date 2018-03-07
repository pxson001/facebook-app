package com.facebook.videocodec.ffmpeg;

import android.annotation.TargetApi;
import android.media.MediaFormat;
import com.facebook.ffmpeg.FFMpegAVStream;
import com.facebook.ffmpeg.FFMpegBadDataException;
import com.facebook.ffmpeg.FFMpegBufferInfo;
import com.facebook.ffmpeg.FFMpegMediaFormat;
import com.facebook.ffmpeg.FFMpegMediaMuxer;
import com.facebook.ffmpeg.FFMpegMediaMuxerProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.videocodec.codecs.CodecBuffer;
import com.facebook.videocodec.muxers.BadSampleDataException;
import com.facebook.videocodec.muxers.CodecMuxer;
import javax.inject.Inject;

@TargetApi(16)
/* compiled from: retail_shipment */
public class FFMpegBasedCodecMuxer implements CodecMuxer {
    private final FFMpegMediaMuxerProvider f5543a;
    private FFMpegMediaMuxer f5544b;
    private FFMpegAVStream f5545c;
    private FFMpegAVStream f5546d;
    private FFMpegBufferInfo f5547e = new FFMpegBufferInfo();

    private static FFMpegBasedCodecMuxer m8218b(InjectorLike injectorLike) {
        return new FFMpegBasedCodecMuxer(FFMpegMediaMuxerProvider.b(injectorLike));
    }

    @Inject
    public FFMpegBasedCodecMuxer(FFMpegMediaMuxerProvider fFMpegMediaMuxerProvider) {
        this.f5543a = fFMpegMediaMuxerProvider;
    }

    public final void mo373a(String str) {
        this.f5544b = this.f5543a.a(str).a();
    }

    public final void mo371a(MediaFormat mediaFormat) {
        this.f5546d = this.f5544b.a(FFMpegMediaFormat.a(mediaFormat));
    }

    public final void mo375b(MediaFormat mediaFormat) {
        this.f5545c = this.f5544b.a(FFMpegMediaFormat.a(mediaFormat));
    }

    public final void mo372a(CodecBuffer codecBuffer) {
        try {
            this.f5547e.a(codecBuffer.mo365b());
            this.f5546d.a(this.f5547e, codecBuffer.mo363a());
        } catch (FFMpegBadDataException e) {
            throw new BadSampleDataException(e);
        }
    }

    public final void mo376b(CodecBuffer codecBuffer) {
        try {
            this.f5547e.a(codecBuffer.mo365b());
            this.f5545c.a(this.f5547e, codecBuffer.mo363a());
        } catch (FFMpegBadDataException e) {
            throw new BadSampleDataException(e);
        }
    }

    public final void mo369a() {
        this.f5544b.b();
    }

    public final void mo374b() {
        this.f5544b.c();
    }

    public final void mo370a(int i) {
        this.f5545c.a(i);
    }
}
