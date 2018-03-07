package com.facebook.common.util;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;

/* compiled from: name DESC */
public class SizeUtil {
    public static int m19191a(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    public static int m19192a(Resources resources, float f) {
        return (int) ((resources.getDisplayMetrics().density * f) + 0.5f);
    }

    public static int m19195b(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().scaledDensity * f) + 0.5f);
    }

    public static int m19198c(Context context, float f) {
        return (int) (f / context.getResources().getDisplayMetrics().density);
    }

    public static int m19196b(Resources resources, float f) {
        return (int) (f / resources.getDisplayMetrics().density);
    }

    public static String m19194a(Resources resources) {
        if (resources == null) {
            return "1";
        }
        int i = resources.getDisplayMetrics().densityDpi;
        if (i <= 160) {
            return "1";
        }
        if (i >= 320) {
            return "2";
        }
        return "1.5";
    }

    public static int m19193a(Resources resources, int i) {
        return Math.round(((float) resources.getDimensionPixelSize(i)) * resources.getConfiguration().fontScale);
    }

    public static int m19197b(Resources resources, int i) {
        return m19196b(resources, resources.getDimension(i));
    }

    public static int m19199c(Resources resources, int i) {
        TypedValue typedValue = new TypedValue();
        resources.getValue(i, typedValue, false);
        return Math.round(TypedValue.complexToFloat(typedValue.data));
    }
}
