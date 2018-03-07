package com.facebook.video.videohome.logging;

/* compiled from: com.google.android.gms.maps.internal.IOnStreetViewPanoramaChangeListener */
public class VideoHomeChannelLoggingData {
    public final String f19686a;
    public final String f19687b;
    public final int f19688c;

    /* compiled from: com.google.android.gms.maps.internal.IOnStreetViewPanoramaChangeListener */
    public class Builder {
        public String f19683a;
        public String f19684b;
        public int f19685c = -1;

        public final VideoHomeChannelLoggingData m28405a() {
            return new VideoHomeChannelLoggingData(this);
        }
    }

    VideoHomeChannelLoggingData(Builder builder) {
        this.f19686a = builder.f19683a;
        this.f19687b = builder.f19684b;
        this.f19688c = builder.f19685c;
    }
}
