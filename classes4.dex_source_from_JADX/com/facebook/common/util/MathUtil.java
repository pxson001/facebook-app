package com.facebook.common.util;

/* compiled from: vpv_seen_state */
public class MathUtil {
    public static int m246a(int i, int i2, float f) {
        return Math.round(((float) (i2 - i)) * f) + i;
    }

    public static float m244a(float f, float f2, float f3) {
        return ((f2 - f) * f3) + f;
    }

    public static double m243a(double d, double d2, double d3) {
        return ((d2 - d) * d3) + d;
    }

    public static int m247a(int i, int i2, int i3) {
        return Math.min(i3, Math.max(i2, i));
    }

    public static float m250b(float f, float f2, float f3) {
        return Math.min(f3, Math.max(f2, f));
    }

    public static double m249b(double d, double d2, double d3) {
        return Math.min(d3, Math.max(d2, d));
    }

    public static float m251c(float f, float f2, float f3) {
        return m250b((f - f2) / (f3 - f2), 0.0f, 1.0f);
    }

    public static float m245a(float f, float f2, float f3, float f4, float f5) {
        return (((f - f2) / (f3 - f2)) * (f5 - f4)) + f4;
    }

    public static String m248a(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("Invalid number");
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (j > 0) {
            stringBuilder.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt((int) (j % 64)));
            j /= 64;
        }
        stringBuilder.reverse();
        return stringBuilder.toString();
    }
}
