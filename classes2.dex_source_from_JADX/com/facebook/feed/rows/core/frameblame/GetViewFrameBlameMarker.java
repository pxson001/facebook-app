package com.facebook.feed.rows.core.frameblame;

import com.facebook.debug.fps.FrameRateBlameMarkers.Marker;
import com.facebook.debug.fps.FrameRateBlameMarkers.Priority;

/* compiled from: is_awareness_unit_eligible_intent_flag */
public class GetViewFrameBlameMarker implements Marker {
    public static GetViewFrameBlameMarker f19246a;
    public int f19247b;

    public final String mo2656a() {
        return "get_view";
    }

    public final Priority mo2657b() {
        return Priority.GET_VIEW;
    }

    public final int m26964d() {
        return this.f19247b;
    }
}
