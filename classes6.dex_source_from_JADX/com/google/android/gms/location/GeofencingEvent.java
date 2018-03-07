package com.google.android.gms.location;

import android.location.Location;
import java.util.List;

public class GeofencingEvent {
    public final int f6304a;
    private final int f6305b;
    private final List<Geofence> f6306c;
    private final Location f6307d;

    public GeofencingEvent(int i, int i2, List<Geofence> list, Location location) {
        this.f6304a = i;
        this.f6305b = i2;
        this.f6306c = list;
        this.f6307d = location;
    }

    public final boolean m8842a() {
        return this.f6304a != -1;
    }

    public final int m8843c() {
        return this.f6305b;
    }

    public final Location m8844d() {
        return this.f6307d;
    }
}
