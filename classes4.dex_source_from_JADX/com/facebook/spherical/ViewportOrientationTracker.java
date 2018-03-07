package com.facebook.spherical;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: ping_address_failure */
public class ViewportOrientationTracker {
    private static final float[] f4742j = new float[]{0.0f, 1.0f, 0.0f, 0.0f};
    private static final float[] f4743k = new float[4];
    public final Lock f4744a = new ReentrantLock();
    public float f4745b;
    public float f4746c;
    public float f4747d;
    public float f4748e;
    public float f4749f;
    public long f4750g;
    public float f4751h;
    public float f4752i;

    public static float m5207a(float[] fArr) {
        double atan2;
        if (fArr[4] > 0.998f) {
            atan2 = Math.atan2((double) fArr[2], (double) fArr[10]);
        } else if (fArr[4] < -0.998f) {
            atan2 = Math.atan2((double) fArr[2], (double) fArr[10]);
        } else {
            atan2 = Math.atan2((double) (-fArr[8]), (double) fArr[0]);
        }
        return (float) (-Math.toDegrees(atan2));
    }

    public static float m5208c(float[] fArr) {
        double d = 0.0d;
        if (fArr[4] <= 0.998f && fArr[4] >= -0.998f) {
            d = Math.atan2((double) (-fArr[6]), (double) fArr[5]);
        }
        return (float) (-Math.toDegrees(d));
    }
}
