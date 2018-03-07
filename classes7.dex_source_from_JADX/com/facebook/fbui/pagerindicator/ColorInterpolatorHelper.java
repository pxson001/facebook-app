package com.facebook.fbui.pagerindicator;

import android.graphics.Color;

/* compiled from: sports_fact */
public class ColorInterpolatorHelper {
    public static int m4271a(float f, int i, int i2) {
        float a = m4270a(f);
        int alpha = Color.alpha(i);
        int red = Color.red(i);
        int green = Color.green(i);
        int blue = Color.blue(i);
        return (((int) (a * ((float) (Color.blue(i2) - blue)))) + blue) | ((((alpha + ((int) (((float) (Color.alpha(i2) - alpha)) * a))) << 24) | ((red + ((int) (((float) (Color.red(i2) - red)) * a))) << 16)) | ((((int) (((float) (Color.green(i2) - green)) * a)) + green) << 8));
    }

    public static float m4270a(float f) {
        return ((float) ((int) (f * 20.0f))) / 20.0f;
    }
}
