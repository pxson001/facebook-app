package com.facebook.springs;

/* compiled from: response_interval_average */
public class Bouncy3Conversion {
    static final /* synthetic */ boolean f6960a = (!Bouncy3Conversion.class.desiredAssertionStatus());
    public final double f6961b;
    public final double f6962c;
    private final double f6963d;
    private final double f6964e;

    public Bouncy3Conversion(double d, double d2) {
        this.f6963d = d;
        this.f6964e = d2;
        double b = m11549b(m11547a(d2 / 1.7d, 0.0d, 20.0d), 0.0d, 0.8d);
        this.f6961b = m11549b(m11547a(d / 1.7d, 0.0d, 20.0d), 0.5d, 200.0d);
        this.f6962c = m11553d(b, m11552d(this.f6961b), 0.01d);
    }

    private static double m11547a(double d, double d2, double d3) {
        return (d - d2) / (d3 - d2);
    }

    private static double m11549b(double d, double d2, double d3) {
        return ((d3 - d2) * d) + d2;
    }

    private static double m11551c(double d, double d2, double d3) {
        return (d * d3) + ((1.0d - d) * d2);
    }

    private double m11553d(double d, double d2, double d3) {
        return m11551c((2.0d * d) - (d * d), d2, d3);
    }

    private static double m11546a(double d) {
        return (((7.0E-4d * Math.pow(d, 3.0d)) - (0.031d * Math.pow(d, 2.0d))) + (0.64d * d)) + 1.28d;
    }

    private static double m11548b(double d) {
        return (((4.4E-5d * Math.pow(d, 3.0d)) - (0.006d * Math.pow(d, 2.0d))) + (0.36d * d)) + 2.0d;
    }

    private static double m11550c(double d) {
        return (((4.5E-7d * Math.pow(d, 3.0d)) - (3.32E-4d * Math.pow(d, 2.0d))) + (0.1078d * d)) + 5.84d;
    }

    private double m11552d(double d) {
        if (d <= 18.0d) {
            return m11546a(d);
        }
        if (d > 18.0d && d <= 44.0d) {
            return m11548b(d);
        }
        if (d > 44.0d) {
            return m11550c(d);
        }
        if (f6960a) {
            return 0.0d;
        }
        throw new AssertionError();
    }
}
