package com.facebook.springs;

/* compiled from: request_family */
public class SpringUtil {
    public static double m11942a(double d, double d2, double d3, double d4, double d5) {
        double d6 = d3 - d2;
        double d7 = d5 - d4;
        return (d6 == 0.0d || d7 == 0.0d) ? d4 : d4 + (((d - d2) / d6) * d7);
    }

    public static double m11941a(double d, double d2, double d3) {
        return Math.min(Math.max(d, d2), d3);
    }
}
