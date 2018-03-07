package com.facebook.common.moving_average;

/* compiled from: ephemeral_mode_turn_off */
public class ExponentialGeometricAverage implements MovingAverage {
    private final double f12851a;
    private final int f12852b;
    private double f12853c = -1.0d;
    private int f12854d;

    public ExponentialGeometricAverage(double d) {
        int i;
        this.f12851a = d;
        if (d == 0.0d) {
            i = Integer.MAX_VALUE;
        } else {
            i = (int) Math.ceil(1.0d / d);
        }
        this.f12852b = i;
    }

    public final void m13709a(double d) {
        double d2 = 1.0d - this.f12851a;
        if (this.f12854d > this.f12852b) {
            this.f12853c = Math.exp((d2 * Math.log(this.f12853c)) + (this.f12851a * Math.log(d)));
        } else if (this.f12854d > 0) {
            d2 = (d2 * ((double) this.f12854d)) / (((double) this.f12854d) + 1.0d);
            this.f12853c = Math.exp((d2 * Math.log(this.f12853c)) + ((1.0d - d2) * Math.log(d)));
        } else {
            this.f12853c = d;
        }
        this.f12854d++;
    }

    public final double m13708a() {
        return this.f12853c;
    }

    public final void m13710b() {
        this.f12853c = -1.0d;
        this.f12854d = 0;
    }
}
