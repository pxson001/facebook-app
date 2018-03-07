package com.facebook.android.maps.model;

/* compiled from: audio_codec */
public final class TileOverlayOptions {
    public TileProvider f8670a;
    public boolean f8671b;
    public boolean f8672c = true;

    public final TileOverlayOptions m14619a(boolean z) {
        this.f8671b = z;
        return this;
    }

    public final TileOverlayOptions m14618a(TileProvider tileProvider) {
        this.f8670a = tileProvider;
        return this;
    }
}
