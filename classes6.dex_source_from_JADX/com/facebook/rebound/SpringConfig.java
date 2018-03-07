package com.facebook.rebound;

/* compiled from: f6fb3fb3da5d3a74f03af5825a8c73f7 */
public class SpringConfig {
    public static SpringConfig f15441c = m23058a(40.0d, 7.0d);
    public double f15442a;
    public double f15443b;

    public SpringConfig(double d, double d2) {
        this.f15443b = d;
        this.f15442a = d2;
    }

    public static SpringConfig m23058a(double d, double d2) {
        double d3 = 0.0d;
        if (d != 0.0d) {
            d3 = ((d - 30.0d) * 3.62d) + 194.0d;
        }
        return new SpringConfig(d3, OrigamiValueConverter.m23038b(d2));
    }
}
