package com.facebook.android.maps.model;

import java.util.ArrayList;
import java.util.List;

/* compiled from: audio_sample_rate */
public final class PolylineOptions {
    public int f8643a = -16777216;
    public boolean f8644b;
    public final List<LatLng> f8645c = new ArrayList();
    public boolean f8646d = true;
    public float f8647e = 10.0f;
    public float f8648f;

    public final PolylineOptions m14608a(LatLng latLng) {
        this.f8645c.add(latLng);
        return this;
    }
}
