package com.facebook.csslayout;

/* compiled from: from_user */
public class FloatUtil {
    public static boolean m30999a(float f, float f2) {
        if (Float.isNaN(f) || Float.isNaN(f2)) {
            if (Float.isNaN(f) && Float.isNaN(f2)) {
                return true;
            }
            return false;
        } else if (Math.abs(f2 - f) >= 1.0E-5f) {
            return false;
        } else {
            return true;
        }
    }
}
