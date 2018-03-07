package com.facebook.video.videohome.logging;

import com.fasterxml.jackson.databind.JsonNode;

/* compiled from: com.google.android.gms.maps.internal.IOnStreetViewPanoramaCameraChangeListener */
public class VideoHomeStoryLoggingData {
    public final String f19693a;
    public final JsonNode f19694b;
    public final String f19695c;
    public final int f19696d;

    /* compiled from: com.google.android.gms.maps.internal.IOnStreetViewPanoramaCameraChangeListener */
    public class Builder {
        public String f19689a;
        public JsonNode f19690b;
        public String f19691c;
        public int f19692d = -1;

        public final VideoHomeStoryLoggingData m28406a() {
            return new VideoHomeStoryLoggingData(this);
        }
    }

    VideoHomeStoryLoggingData(Builder builder) {
        this.f19693a = builder.f19689a;
        this.f19694b = builder.f19690b;
        this.f19695c = builder.f19691c;
        this.f19696d = builder.f19692d;
    }
}
