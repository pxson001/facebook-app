package com.facebook.ffmpeg;

import javax.inject.Inject;

/* compiled from: WWW_PROFILE_TILE */
public class FFMpegMediaMetadataRetrieverProvider {
    private FFMpegLib f12287a;

    @Inject
    public FFMpegMediaMetadataRetrieverProvider(FFMpegLib fFMpegLib) {
        this.f12287a = fFMpegLib;
    }

    public final FFMpegMediaMetadataRetriever m20355a(String str) {
        return new FFMpegMediaMetadataRetriever(this.f12287a, str);
    }
}
