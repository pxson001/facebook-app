package com.facebook.common.moving_average;

/* compiled from: marauderTier required */
public class NaiveExponentialWeightedAverage implements MovingAverage {
    private final double f15119a;
    private double f15120b = -1.0d;

    public NaiveExponentialWeightedAverage(double d) {
        this.f15119a = d;
    }

    public final void mo2838a(double d) {
        if (this.f15120b > 0.0d) {
            d = (this.f15120b * (1.0d - this.f15119a)) + (this.f15119a * d);
        }
        this.f15120b = d;
    }

    public final double mo2837a() {
        return this.f15120b;
    }

    public final void mo2839b() {
        this.f15120b = -1.0d;
    }
}
