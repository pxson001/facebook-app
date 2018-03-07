package com.facebook.videocodec.resizer;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import com.facebook.ffmpeg.FFMpegMediaMuxerProvider;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.videocodec.ffmpeg.FFMpegBasedCodecMuxer;
import com.facebook.videocodec.muxers.CodecMuxer;
import com.facebook.videocodec.muxers.PlatformBasedCodecMuxer;
import javax.inject.Singleton;

@InjectorModule
/* compiled from: result_handle */
public class VideoCodecModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @Singleton
    @SuppressLint({"ProviderUsage"})
    static CodecMuxer m8266a(FFMpegMediaMuxerProvider fFMpegMediaMuxerProvider) {
        if (VERSION.SDK_INT >= 18) {
            return new PlatformBasedCodecMuxer();
        }
        return new FFMpegBasedCodecMuxer(fFMpegMediaMuxerProvider);
    }
}
