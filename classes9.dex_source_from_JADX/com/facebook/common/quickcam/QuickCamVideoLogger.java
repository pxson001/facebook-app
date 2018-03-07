package com.facebook.common.quickcam;

import android.annotation.TargetApi;
import android.media.CamcorderProfile;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.quickcam.QuickCamVideoRecordingManager.Cause;
import com.google.common.collect.Maps;
import java.util.Map;
import javax.inject.Inject;

@TargetApi(14)
/* compiled from: promoted_conversion_pixel */
public class QuickCamVideoLogger {
    private final AnalyticsLogger f6085a;

    @Inject
    public QuickCamVideoLogger(AnalyticsLogger analyticsLogger) {
        this.f6085a = analyticsLogger;
    }

    public final void m6441a(String str) {
        m6439a("messenger_record_start", m6440b(str));
    }

    public final void m6442a(String str, Cause cause) {
        Map b = m6440b(str);
        b.put("record_stop_cause", cause.toString());
        m6439a("messenger_record_stop", b);
    }

    public static Map<String, String> m6440b(String str) {
        Map c = Maps.c();
        c.put("camera_source", str);
        return c;
    }

    public final void m6443a(String str, Cause cause, CamcorderProfile camcorderProfile) {
        Map b = m6440b(str);
        b.put("quality", Integer.toString(camcorderProfile.quality));
        b.put("video_codec", Integer.toString(camcorderProfile.videoCodec));
        b.put("video_bit_rate", Integer.toString(camcorderProfile.videoBitRate));
        b.put("video_frame_rate", Integer.toString(camcorderProfile.videoFrameRate));
        b.put("video_frame_width", Integer.toString(camcorderProfile.videoFrameWidth));
        b.put("video_frame_height", Integer.toString(camcorderProfile.videoFrameHeight));
        b.put("audio_codec", Integer.toString(camcorderProfile.audioCodec));
        b.put("audio_bit_rate", Integer.toString(camcorderProfile.audioBitRate));
        b.put("audio_sample_rate", Integer.toString(camcorderProfile.audioSampleRate));
        b.put("audio_channels", Integer.toString(camcorderProfile.audioChannels));
        Map map = b;
        map.put("record_stop_cause", cause.toString());
        m6439a("messenger_record_error", map);
    }

    private void m6439a(String str, Map<String, String> map) {
        this.f6085a.a(str, map);
    }
}
