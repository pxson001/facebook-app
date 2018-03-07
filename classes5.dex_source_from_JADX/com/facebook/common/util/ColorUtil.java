package com.facebook.common.util;

import android.graphics.Color;

/* compiled from: shimmedMutation_ */
public final class ColorUtil {
    public static int m3895a(int i, float f) {
        return Color.rgb(Math.round(((float) Color.red(i)) * f), Math.round(((float) Color.green(i)) * f), Math.round(((float) Color.blue(i)) * f));
    }
}
