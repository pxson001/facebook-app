package com.facebook.photos.upload.protocol;

import com.facebook.videocodec.base.VideoMetadata;
import java.util.HashMap;
import java.util.Map;

/* compiled from: general_cell_info */
public class UploadVideoChunkSettingsParams {
    public final String f14192a;
    public final long f14193b;
    public final Map<String, Long> f14194c;
    public final Map<String, Object> f14195d;

    public UploadVideoChunkSettingsParams(long j, String str, VideoMetadata videoMetadata, long j2) {
        Map hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        this.f14192a = str;
        this.f14193b = j;
        this.f14194c = hashMap;
        this.f14194c.put("video_duration_milliseconds", Long.valueOf((videoMetadata.f5480a / 1000) + 1));
        this.f14194c.put("video_bit_rate_bps", Long.valueOf((long) videoMetadata.f5484e));
        this.f14194c.put("audio_bit_rate_bps", Long.valueOf((long) videoMetadata.f5486g));
        this.f14194c.put("video_width", Long.valueOf((long) videoMetadata.f5481b));
        this.f14194c.put("video_height", Long.valueOf((long) videoMetadata.f5482c));
        this.f14194c.put("video_original_file_size", Long.valueOf(j2));
        this.f14195d = hashMap2;
        this.f14195d.put("battery", Integer.valueOf(40));
        this.f14195d.put("quality", "standard");
    }
}
