package com.facebook.react.bridge;

import com.facebook.proguard.annotations.DoNotStrip;
import javax.annotation.Nullable;

@DoNotStrip
/* compiled from: manifestUrl */
public class ReactMarker {
    @Nullable
    public static MarkerListener f8362a = null;

    /* compiled from: manifestUrl */
    public interface MarkerListener {
        void mo682a(String str);
    }

    public static void m8651a(MarkerListener markerListener) {
        f8362a = markerListener;
    }

    @DoNotStrip
    public static void logMarker(String str) {
        if (f8362a != null) {
            f8362a.mo682a(str);
        }
    }
}
