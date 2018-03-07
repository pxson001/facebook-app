package com.facebook.backstage.util;

/* compiled from: removeMontageViewer */
public class Bouncy3Conversion {
    public final double f5563a;
    public final double f5564b;
    private final double f5565c;
    private final double f5566d;

    public Bouncy3Conversion(double d, double d2) {
        this.f5565c = d;
        this.f5566d = d2;
        double b = m5766b(m5764a(d2 / 1.7d, 0.0d, 20.0d), 0.0d, 0.8d);
        this.f5563a = m5766b(m5764a(d / 1.7d, 0.0d, 20.0d), 0.5d, 200.0d);
        this.f5564b = m5770d(b, m5769d(this.f5563a), 0.01d);
    }

    private static double m5764a(double d, double d2, double d3) {
        return (d - d2) / (d3 - d2);
    }

    private static double m5766b(double d, double d2, double d3) {
        return ((d3 - d2) * d) + d2;
    }

    private static double m5768c(double d, double d2, double d3) {
        return (d * d3) + ((1.0d - d) * d2);
    }

    private double m5770d(double d, double d2, double d3) {
        return m5768c((2.0d * d) - (d * d), d2, d3);
    }

    private static double m5763a(double d) {
        return (((7.0E-4d * Math.pow(d, 3.0d)) - (0.031d * Math.pow(d, 2.0d))) + (0.64d * d)) + 1.28d;
    }

    private static double m5765b(double d) {
        return (((4.4E-5d * Math.pow(d, 3.0d)) - (0.006d * Math.pow(d, 2.0d))) + (0.36d * d)) + 2.0d;
    }

    private static double m5767c(double d) {
        return (((4.5E-7d * Math.pow(d, 3.0d)) - (3.32E-4d * Math.pow(d, 2.0d))) + (0.1078d * d)) + 5.84d;
    }

    private double m5769d(double d) {
        if (d <= 18.0d) {
            return m5763a(d);
        }
        if (d > 18.0d && d <= 44.0d) {
            return m5765b(d);
        }
        if (d > 44.0d) {
            return m5767c(d);
        }
        return 0.0d;
    }
}
