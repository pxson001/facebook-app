package com.facebook.components;

/* compiled from: friendsnearby/profile?fbid=%s&source=%s */
class FastMath {
    FastMath() {
    }

    static int m31104a(float f) {
        if (f > 0.0f) {
            return (int) (((double) f) + 0.5d);
        }
        return (int) (((double) f) - 0.5d);
    }
}
