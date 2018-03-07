package com.google.android.gms.location;

import android.os.SystemClock;
import com.google.android.gms.location.internal.ParcelableGeofence;

public interface Geofence {

    public final class Builder {
        private String f6295a = null;
        private int f6296b = 0;
        private long f6297c = Long.MIN_VALUE;
        private short f6298d = (short) -1;
        private double f6299e;
        private double f6300f;
        private float f6301g;
        private int f6302h = 0;
        private int f6303i = -1;

        public final Builder m8836a(double d, double d2, float f) {
            this.f6298d = (short) 1;
            this.f6299e = d;
            this.f6300f = d2;
            this.f6301g = f;
            return this;
        }

        public final Builder m8837a(int i) {
            this.f6296b = i;
            return this;
        }

        public final Builder m8838a(long j) {
            if (j < 0) {
                this.f6297c = -1;
            } else {
                this.f6297c = SystemClock.elapsedRealtime() + j;
            }
            return this;
        }

        public final Builder m8839a(String str) {
            this.f6295a = str;
            return this;
        }

        public final Geofence m8840a() {
            if (this.f6295a == null) {
                throw new IllegalArgumentException("Request ID not set.");
            } else if (this.f6296b == 0) {
                throw new IllegalArgumentException("Transitions types not set.");
            } else if ((this.f6296b & 4) != 0 && this.f6303i < 0) {
                throw new IllegalArgumentException("Non-negative loitering delay needs to be set when transition types include GEOFENCE_TRANSITION_DWELLING.");
            } else if (this.f6297c == Long.MIN_VALUE) {
                throw new IllegalArgumentException("Expiration not set.");
            } else if (this.f6298d == (short) -1) {
                throw new IllegalArgumentException("Geofence region not set.");
            } else if (this.f6302h >= 0) {
                return new ParcelableGeofence(this.f6295a, this.f6296b, (short) 1, this.f6299e, this.f6300f, this.f6301g, this.f6297c, this.f6302h, this.f6303i);
            } else {
                throw new IllegalArgumentException("Notification responsiveness should be nonnegative.");
            }
        }

        public final Builder m8841b(int i) {
            this.f6302h = i;
            return this;
        }
    }
}
