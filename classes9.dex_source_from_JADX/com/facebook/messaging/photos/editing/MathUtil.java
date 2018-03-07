package com.facebook.messaging.photos.editing;

/* compiled from: dismiss_url */
public class MathUtil {
    public static float m16201a(float f, float f2, float f3) {
        return ((f2 - f) * f3) + f;
    }

    public static float m16202b(float f, float f2, float f3) {
        if (f == f2) {
            return 0.0f;
        }
        return Math.max(0.0f, Math.min((f3 - f) / (f2 - f), 1.0f));
    }
}
