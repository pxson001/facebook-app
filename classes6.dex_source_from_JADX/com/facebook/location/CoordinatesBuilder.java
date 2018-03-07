package com.facebook.location;

/* compiled from: ₹ */
public class CoordinatesBuilder {
    public Double f12a;
    public Double f13b;
    public Float f14c;

    public final CoordinatesBuilder m6a(Double d) {
        this.f12a = d;
        return this;
    }

    public final CoordinatesBuilder m7b(Double d) {
        this.f13b = d;
        return this;
    }

    public final Coordinates m8d() {
        return new Coordinates(this);
    }
}
