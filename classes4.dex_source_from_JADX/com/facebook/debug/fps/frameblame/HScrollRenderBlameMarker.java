package com.facebook.debug.fps.frameblame;

import com.facebook.debug.fps.FrameRateBlameMarkers.Marker;
import com.facebook.debug.fps.FrameRateBlameMarkers.Priority;

/* compiled from: privacy_education_manually_expanded */
public class HScrollRenderBlameMarker implements Marker {
    private static HScrollRenderBlameMarker f4215a;

    private HScrollRenderBlameMarker() {
    }

    public static HScrollRenderBlameMarker m4745c() {
        if (f4215a == null) {
            f4215a = new HScrollRenderBlameMarker();
        }
        return f4215a;
    }

    public final String m4746a() {
        return "hscroll_render";
    }

    public final Priority m4747b() {
        return Priority.HSCROLL_RENDER;
    }
}
