package com.facebook.android.maps.model;

/* compiled from: auth_token */
public final class LatLngBounds {
    public static final LatLngBounds f8575a = new LatLngBounds(new LatLng(-90.0d, -180.0d), new LatLng(90.0d, 180.0d));
    public final LatLng f8576b;
    public final LatLng f8577c;

    /* compiled from: auth_token */
    public final class Builder {
        private boolean f8570a = false;
        private double f8571b;
        private double f8572c;
        private double f8573d;
        private double f8574e;

        public final Builder m14568a(LatLng latLng) {
            if (!this.f8570a) {
                this.f8571b = latLng.f8568a;
                this.f8572c = latLng.f8568a;
                this.f8573d = latLng.f8569b;
                this.f8574e = latLng.f8569b;
                this.f8570a = true;
            }
            if (latLng.f8568a > this.f8572c) {
                this.f8572c = latLng.f8568a;
            } else if (latLng.f8568a < this.f8571b) {
                this.f8571b = latLng.f8568a;
            }
            double b = LatLngBounds.m14571b(this.f8573d, this.f8574e);
            double b2 = LatLngBounds.m14571b(latLng.f8569b, this.f8574e);
            double b3 = LatLngBounds.m14571b(this.f8573d, latLng.f8569b);
            if (Double.compare(b2, b) > 0 || Double.compare(b3, b) > 0) {
                if (b2 <= b3) {
                    this.f8573d = latLng.f8569b;
                } else {
                    this.f8574e = latLng.f8569b;
                }
            }
            return this;
        }

        public final LatLngBounds m14569a() {
            return new LatLngBounds(new LatLng(this.f8571b, this.f8574e), new LatLng(this.f8572c, this.f8573d));
        }
    }

    public static Builder m14570a() {
        return new Builder();
    }

    public LatLngBounds(LatLng latLng, LatLng latLng2) {
        if (latLng.f8568a > latLng2.f8568a) {
            throw new IllegalArgumentException("Southern latitude (" + latLng.f8568a + ") exceeds Northern latitude (" + latLng2.f8568a + ").");
        }
        this.f8577c = latLng;
        this.f8576b = latLng2;
    }

    public final boolean m14572a(LatLng latLng) {
        return latLng.f8568a <= this.f8576b.f8568a && latLng.f8568a >= this.f8577c.f8568a && (this.f8577c.f8569b >= this.f8576b.f8569b ? latLng.f8569b >= this.f8577c.f8569b || latLng.f8569b <= this.f8576b.f8569b : latLng.f8569b >= this.f8577c.f8569b && latLng.f8569b <= this.f8576b.f8569b);
    }

    public static double m14571b(double d, double d2) {
        double d3 = d - d2;
        return ((double) (d3 < 0.0d ? 360 : 0)) + d3;
    }

    public final LatLng m14573b() {
        double d = 360.0d;
        double d2 = (this.f8577c.f8568a + this.f8576b.f8568a) / 2.0d;
        double d3 = this.f8577c.f8569b;
        double d4 = this.f8576b.f8569b;
        if (d3 <= d4) {
            d = (d3 + d4) / 2.0d;
        } else {
            d3 = ((d3 + d4) + 360.0d) / 2.0d;
            if (d3 <= 180.0d) {
                d = 0.0d;
            }
            d = d3 - d;
        }
        return new LatLng(d2, d);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LatLngBounds)) {
            return false;
        }
        LatLngBounds latLngBounds = (LatLngBounds) obj;
        if (this.f8576b.equals(latLngBounds.f8576b) && this.f8577c.equals(latLngBounds.f8577c)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return ((this.f8576b.hashCode() + 527) * 31) + this.f8577c.hashCode();
    }

    public final String toString() {
        return getClass().getSimpleName() + "{northeast=" + this.f8576b + ", southwest=" + this.f8577c + "}";
    }
}
