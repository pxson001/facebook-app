package com.facebook.events.model;

/* compiled from: supports_audio_suggestion */
public class LatitudeLongitude {
    public final double f2759a;
    public final double f2760b;

    public LatitudeLongitude(double d, double d2) {
        this.f2759a = d;
        this.f2760b = d2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LatitudeLongitude latitudeLongitude = (LatitudeLongitude) obj;
        if (Double.compare(latitudeLongitude.f2759a, this.f2759a) != 0) {
            return false;
        }
        if (Double.compare(latitudeLongitude.f2760b, this.f2760b) != 0) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        long doubleToLongBits;
        long j = 0;
        if (this.f2759a != 0.0d) {
            doubleToLongBits = Double.doubleToLongBits(this.f2759a);
        } else {
            doubleToLongBits = 0;
        }
        int i = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
        if (this.f2760b != 0.0d) {
            j = Double.doubleToLongBits(this.f2760b);
        }
        return (i * 31) + ((int) (j ^ (j >>> 32)));
    }
}
