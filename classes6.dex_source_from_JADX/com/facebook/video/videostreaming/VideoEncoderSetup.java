package com.facebook.video.videostreaming;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaFormat;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.video.videostreaming.protocol.VideoBroadcastVideoStreamingConfig;
import java.util.Map;

@TargetApi(18)
/* compiled from: sIcls */
public class VideoEncoderSetup {
    protected static final String f5391a = VideoEncoderSetup.class.getName();

    public static VideoEncoderSetup m8095a(InjectorLike injectorLike) {
        return new VideoEncoderSetup();
    }

    public static MediaCodec m8094a(VideoBroadcastVideoStreamingConfig videoBroadcastVideoStreamingConfig, Map<String, String> map) {
        int i;
        MediaCodec a;
        int i2 = 426;
        int i3 = 524288;
        int i4 = 30;
        String str = "baseline";
        if (videoBroadcastVideoStreamingConfig != null) {
            i = videoBroadcastVideoStreamingConfig.width;
            i2 = videoBroadcastVideoStreamingConfig.height;
            i3 = videoBroadcastVideoStreamingConfig.bitRate;
            i4 = videoBroadcastVideoStreamingConfig.frameRate;
            if (videoBroadcastVideoStreamingConfig.videoProfile != null) {
                str = videoBroadcastVideoStreamingConfig.videoProfile;
            }
        } else {
            BLog.b(f5391a, "VideoStreamingConfig is null. Using default values");
            i = 426;
        }
        if (m8096a(str)) {
            try {
                a = m8092a(i, i2, i3, i4, true);
                if (map != null) {
                    map.put("video_encoding_profile", "high");
                }
            } catch (Throwable e) {
                BLog.a(f5391a, "Error getting videoencoder for high profile. Fall back to baseline ", e);
            }
            return a;
        }
        a = m8092a(i, i2, i3, i4, false);
        if (map != null) {
            map.put("video_encoding_profile", "baseline");
        }
        return a;
    }

    private static MediaCodec m8092a(int i, int i2, int i3, int i4, boolean z) {
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", i, i2);
        createVideoFormat.setInteger("color-format", 2130708361);
        createVideoFormat.setInteger("bitrate", i3);
        createVideoFormat.setInteger("frame-rate", i4);
        createVideoFormat.setInteger("i-frame-interval", 1);
        createVideoFormat.setInteger("channel-count", 1);
        if (z) {
            createVideoFormat.setInteger("profile", 8);
            createVideoFormat.setInteger("level", 256);
        }
        return m8093a(createVideoFormat);
    }

    private static boolean m8096a(String str) {
        if ("high".equalsIgnoreCase(str)) {
            return true;
        }
        return false;
    }

    private static MediaCodec m8093a(MediaFormat mediaFormat) {
        try {
            MediaCodec createEncoderByType = MediaCodec.createEncoderByType("video/avc");
            createEncoderByType.configure(mediaFormat, null, null, 1);
            return createEncoderByType;
        } catch (Throwable e) {
            throw new RuntimeException("MediaCodec creation failed", e);
        }
    }
}
