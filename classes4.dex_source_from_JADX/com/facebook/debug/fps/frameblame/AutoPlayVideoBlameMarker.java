package com.facebook.debug.fps.frameblame;

import com.facebook.debug.fps.FrameRateBlameMarkers.Marker;
import com.facebook.debug.fps.FrameRateBlameMarkers.Priority;

/* compiled from: parent_feedback */
public class AutoPlayVideoBlameMarker implements Marker {
    private static AutoPlayVideoBlameMarker f5363a;

    private AutoPlayVideoBlameMarker() {
    }

    public static AutoPlayVideoBlameMarker m5854c() {
        if (f5363a == null) {
            f5363a = new AutoPlayVideoBlameMarker();
        }
        return f5363a;
    }

    public final String m5855a() {
        return "autoplay";
    }

    public final Priority m5856b() {
        return Priority.AUTOPLAY;
    }
}
