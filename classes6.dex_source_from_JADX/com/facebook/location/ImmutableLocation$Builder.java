package com.facebook.location;

import android.location.Location;
import com.google.common.base.Preconditions;

/* compiled from: ج.م. */
public class ImmutableLocation$Builder {
    public final Location f45a = new Location(null);
    private long f46b;
    private long f47c;
    private float f48d;

    public final ImmutableLocation$Builder m37a(long j) {
        this.f46b = j;
        return this;
    }

    public final ImmutableLocation$Builder m40b(long j) {
        this.f47c = j;
        return this;
    }

    public final ImmutableLocation$Builder m36a(float f) {
        this.f48d = f;
        return this;
    }

    public final ImmutableLocation$Builder m39b(float f) {
        this.f45a.setAccuracy(f);
        return this;
    }

    public final ImmutableLocation$Builder m35a(double d) {
        this.f45a.setAltitude(d);
        return this;
    }

    public final ImmutableLocation$Builder m41c(float f) {
        this.f45a.setBearing(f);
        return this;
    }

    public final ImmutableLocation$Builder m43d(float f) {
        this.f45a.setSpeed(f);
        return this;
    }

    public final ImmutableLocation$Builder m42c(long j) {
        Preconditions.checkArgument(j != 0);
        this.f45a.setTime(j);
        return this;
    }

    public final ImmutableLocation m38a() {
        return new ImmutableLocation(this.f45a, this.f46b, this.f47c, this.f48d, (byte) 0);
    }

    public ImmutableLocation$Builder(double d, double d2) {
        this.f45a.setLatitude(d);
        this.f45a.setLongitude(d2);
    }
}
