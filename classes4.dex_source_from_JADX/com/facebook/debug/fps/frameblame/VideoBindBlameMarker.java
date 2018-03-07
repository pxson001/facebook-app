package com.facebook.debug.fps.frameblame;

import com.facebook.debug.fps.FrameRateBlameMarkers.Marker;
import com.facebook.debug.fps.FrameRateBlameMarkers.Priority;

/* compiled from: perftestlogger */
public class VideoBindBlameMarker implements Marker {
    private static VideoBindBlameMarker f5099a;

    private VideoBindBlameMarker() {
    }

    public static VideoBindBlameMarker m5451c() {
        if (f5099a == null) {
            f5099a = new VideoBindBlameMarker();
        }
        return f5099a;
    }

    public final String m5452a() {
        return "video_bind";
    }

    public final Priority m5453b() {
        return Priority.VIDEO_BIND;
    }
}
