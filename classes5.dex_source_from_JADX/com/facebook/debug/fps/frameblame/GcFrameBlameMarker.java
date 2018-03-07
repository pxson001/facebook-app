package com.facebook.debug.fps.frameblame;

import com.facebook.debug.fps.FrameRateBlameMarkers.Marker;
import com.facebook.debug.fps.FrameRateBlameMarkers.Priority;

/* compiled from: _ */
public class GcFrameBlameMarker implements Marker {
    public static GcFrameBlameMarker f11790a;

    public final String m19812a() {
        return "gc";
    }

    public final Priority m19813b() {
        return Priority.GARBAGE_COLLECTION;
    }
}
