package com.google.zxing.common.detector;

/* compiled from: event_promotion_id */
public final class MathUtils {
    private MathUtils() {
    }

    public static int m13701a(float f) {
        return (int) (0.5f + f);
    }

    public static float m13700a(int i, int i2, int i3, int i4) {
        int i5 = i - i3;
        int i6 = i2 - i4;
        return (float) Math.sqrt((double) ((i5 * i5) + (i6 * i6)));
    }
}
