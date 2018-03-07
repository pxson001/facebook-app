package com.facebook.ffmpeg;

import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: WWW_PERMALINK */
public class FFMpegMediaMuxerProvider {
    private FFMpegLib f12290a;

    @Inject
    public FFMpegMediaMuxerProvider(FFMpegLib fFMpegLib) {
        this.f12290a = fFMpegLib;
    }

    public static FFMpegMediaMuxerProvider m20360b(InjectorLike injectorLike) {
        return new FFMpegMediaMuxerProvider(FFMpegLibMethodAutoProvider.a(injectorLike));
    }

    public final FFMpegMediaMuxer m20361a(String str) {
        return new FFMpegMediaMuxer(this.f12290a, str);
    }
}
