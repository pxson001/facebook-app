package com.facebook.feed.rows.core.frameblame;

import com.facebook.debug.fps.FrameRateBlameMarkers.Marker;
import com.facebook.debug.fps.FrameRateBlameMarkers.Priority;

/* compiled from: messenger_sync_per_batch_db_transactions */
public class DataChangedFrameBlameMarker implements Marker {
    public static DataChangedFrameBlameMarker f13676a;

    public final String mo2656a() {
        return "notify_data_set_changed";
    }

    public final Priority mo2657b() {
        return Priority.DATA_CHANGED;
    }
}
