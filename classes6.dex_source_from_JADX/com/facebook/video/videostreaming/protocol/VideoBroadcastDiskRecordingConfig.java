package com.facebook.video.videostreaming.protocol;

import com.facebook.debug.log.BLog;
import com.facebook.video.videostreaming.protocol.VideoBroadcastVideoStreamingConfig.Builder;
import com.fasterxml.jackson.databind.JsonNode;

/* compiled from: role_associated_edges */
public class VideoBroadcastDiskRecordingConfig {
    private static final Class<?> f5450e = VideoBroadcastDiskRecordingConfig.class;
    public double f5451a;
    public int f5452b;
    public VideoBroadcastVideoStreamingConfig f5453c;
    public VideoBroadcastAudioStreamingConfig f5454d;

    public static VideoBroadcastVideoStreamingConfig m8133b(JsonNode jsonNode) {
        VideoBroadcastVideoStreamingConfig videoBroadcastVideoStreamingConfig = null;
        try {
            String s;
            JsonNode b = jsonNode.b("android_video_profile");
            if (b != null) {
                s = b.s();
            } else {
                s = null;
            }
            videoBroadcastVideoStreamingConfig = new Builder().m8146a(jsonNode.b("stream_disk_recording_video_width").w()).m8150b(jsonNode.b("stream_disk_recording_video_height").w()).m8151c(jsonNode.b("stream_disk_recording_video_bitrate").w()).m8152d(jsonNode.b("stream_disk_recording_video_fps").w()).m8148a(false).m8147a(s).m8149a();
        } catch (Throwable e) {
            BLog.b(f5450e, e, "Error getting VideoStreamingConfig", new Object[0]);
        }
        return videoBroadcastVideoStreamingConfig;
    }

    public static VideoBroadcastAudioStreamingConfig m8134c(JsonNode jsonNode) {
        try {
            return new VideoBroadcastAudioStreamingConfig.Builder().m8125a(jsonNode.b("stream_disk_recording_audio_sample_rate").w()).m8128c(jsonNode.b("stream_disk_recording_audio_channels").w()).m8127b(jsonNode.b("stream_disk_recording_audio_bitrate").w()).m8126a();
        } catch (Throwable e) {
            BLog.b(f5450e, e, "Error getting AudioStreamingConfig", new Object[0]);
            return null;
        }
    }
}
