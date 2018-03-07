package com.facebook.videocodec.resizer;

import android.os.Build.VERSION;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: resourceId */
public class VideoTranscodeHandlerFactory {
    private final Provider<VideoTranscoderJBMR2> f5698a;
    private final Provider<VideoTranscoderOnGPU> f5699b;

    @Inject
    public VideoTranscodeHandlerFactory(Provider<VideoTranscoderJBMR2> provider, Provider<VideoTranscoderOnGPU> provider2) {
        this.f5698a = provider;
        this.f5699b = provider2;
    }

    public final VideoTranscoder m8297a() {
        if (VERSION.SDK_INT >= 18) {
            return (VideoTranscoder) this.f5698a.get();
        }
        return (VideoTranscoder) this.f5699b.get();
    }
}
