package com.facebook.react.uimanager;

import android.util.TypedValue;

/* compiled from: friend_finder_friendable_contacts_pymk_fetched */
public class PixelUtil {
    public static float m13924a(float f) {
        return TypedValue.applyDimension(1, f, DisplayMetricsHolder.f11710a);
    }

    public static float m13923a(double d) {
        return m13924a((float) d);
    }

    public static float m13925b(float f) {
        return TypedValue.applyDimension(2, f, DisplayMetricsHolder.f11710a);
    }

    public static float m13926c(float f) {
        return f / DisplayMetricsHolder.f11710a.density;
    }
}
