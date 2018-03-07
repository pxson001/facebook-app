package com.facebook.videocodec.extract;

import android.net.Uri;
import com.facebook.ffmpeg.FFMpegLib;
import com.facebook.ffmpeg.FFMpegLibMethodAutoProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.videocodec.base.VideoMetadata;
import com.facebook.videocodec.base.VideoMetadataExtractor;
import com.facebook.videocodec.ffmpeg.FFMpegVideoMetadataExtractor;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: mInMemoryWriteLock */
public class DefaultVideoMetadataExtractor implements VideoMetadataExtractor {
    private final FFMpegLib f8695a;
    private final Provider<SystemVideoMetadataExtractor> f8696b;
    private final Provider<FFMpegVideoMetadataExtractor> f8697c;

    public static DefaultVideoMetadataExtractor m8969b(InjectorLike injectorLike) {
        return new DefaultVideoMetadataExtractor(FFMpegLibMethodAutoProvider.m8972a(injectorLike), IdBasedSingletonScopeProvider.a(injectorLike, 11723), IdBasedSingletonScopeProvider.a(injectorLike, 11727));
    }

    @Inject
    public DefaultVideoMetadataExtractor(FFMpegLib fFMpegLib, Provider<SystemVideoMetadataExtractor> provider, Provider<FFMpegVideoMetadataExtractor> provider2) {
        this.f8695a = fFMpegLib;
        this.f8696b = provider;
        this.f8697c = provider2;
    }

    public final VideoMetadata mo693a(Uri uri) {
        if (!this.f8695a.m8974d()) {
            return ((SystemVideoMetadataExtractor) this.f8696b.get()).a(uri);
        }
        VideoMetadata a = ((FFMpegVideoMetadataExtractor) this.f8697c.get()).a(uri);
        try {
            VideoMetadata a2 = ((SystemVideoMetadataExtractor) this.f8696b.get()).a(uri);
            a.i = a2.i;
            a.j = a2.j;
        } catch (Exception e) {
        }
        return a;
    }

    public static DefaultVideoMetadataExtractor m8968a(InjectorLike injectorLike) {
        return m8969b(injectorLike);
    }
}
