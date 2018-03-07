package com.facebook.ffmpeg;

import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: WWW_SD_INLINE */
public class FFMpegMediaDemuxerProvider {
    private FFMpegLib f12282a;

    @Inject
    public FFMpegMediaDemuxerProvider(FFMpegLib fFMpegLib) {
        this.f12282a = fFMpegLib;
    }

    public static FFMpegMediaDemuxerProvider m20343b(InjectorLike injectorLike) {
        return new FFMpegMediaDemuxerProvider(FFMpegLibMethodAutoProvider.a(injectorLike));
    }

    public final FFMpegMediaDemuxer m20344a(String str) {
        return new FFMpegMediaDemuxer(this.f12282a, str);
    }
}
