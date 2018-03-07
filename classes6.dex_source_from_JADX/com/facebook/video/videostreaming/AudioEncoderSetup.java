package com.facebook.video.videostreaming;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaFormat;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.video.videostreaming.protocol.VideoBroadcastAudioStreamingConfig;

@TargetApi(18)
/* compiled from: scaled_crop_rect */
public class AudioEncoderSetup {
    protected static final String f5288a = AudioEncoderSetup.class.getName();

    public static AudioEncoderSetup m8000a(InjectorLike injectorLike) {
        return new AudioEncoderSetup();
    }

    public static MediaCodec m7999a(VideoBroadcastAudioStreamingConfig videoBroadcastAudioStreamingConfig) {
        int i;
        int i2;
        int i3 = 64000;
        if (videoBroadcastAudioStreamingConfig != null) {
            i = videoBroadcastAudioStreamingConfig.sampleRate;
            i2 = videoBroadcastAudioStreamingConfig.channels;
            i3 = videoBroadcastAudioStreamingConfig.bitRate;
        } else {
            BLog.b(f5288a, "AudioStreamingConfig is null. Using default values");
            i = 44100;
            i2 = 1;
        }
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", "audio/mp4a-latm");
        mediaFormat.setInteger("aac-profile", 1);
        mediaFormat.setInteger("sample-rate", i);
        mediaFormat.setInteger("channel-count", i2);
        mediaFormat.setInteger("bitrate", i3);
        try {
            MediaCodec createEncoderByType = MediaCodec.createEncoderByType("audio/mp4a-latm");
            createEncoderByType.configure(mediaFormat, null, null, 1);
            return createEncoderByType;
        } catch (Throwable e) {
            throw new RuntimeException("MediaCodec creation failed", e);
        }
    }
}
