package com.facebook.photos.creativeediting.swipeable.common;

import com.facebook.analytics.logger.AnalyticsLogger;
import javax.inject.Inject;

/* compiled from: mEmissions */
public class FramesLogger {
    public final AnalyticsLogger f9751a;

    /* compiled from: mEmissions */
    public enum Event {
        FRAME_DELTA_RECEIVED("frame_delta_received"),
        FRAME_ASSET_DOWNLOAD_REQUEST_SUBMITTED("frame_asset_download_request_submitted"),
        FRAME_ASSET_DOWNLOAD_REQUEST_SUCCESS("frame_asset_download_request_success"),
        FRAME_ASSET_DOWNLOAD_REQUEST_FAILURE("frame_asset_download_request_failure"),
        FRAME_IGNORED_ASSET_MISSING("frame_ignored_asset_missing");
        
        private final String mName;

        private Event(String str) {
            this.mName = str;
        }

        public final String toString() {
            return this.mName;
        }
    }

    /* compiled from: mEmissions */
    public enum Extras {
        DELTA_TYPE("delta_type"),
        COLLECTION_NAME("collection_name"),
        FRAME_ID("frame_id"),
        FRAME_ASSET_URI("asset_uri");
        
        private final String mName;

        private Extras(String str) {
            this.mName = str;
        }

        public final String toString() {
            return this.mName;
        }
    }

    @Inject
    public FramesLogger(AnalyticsLogger analyticsLogger) {
        this.f9751a = analyticsLogger;
    }
}
