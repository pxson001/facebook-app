package com.facebook.catalyst.modules.persistedqueries;

import android.content.Context;
import android.util.DisplayMetrics;
import com.facebook.react.uimanager.DisplayMetricsHolder;

/* compiled from: unknown request code */
public class PixelRatioQueryHelper {
    PixelRatioQueryHelper() {
    }

    public static double m1051a(Context context) {
        return (double) m1053b(context).density;
    }

    public static double m1052a(Context context, String str, String str2) {
        if ("window".equals(str)) {
            DisplayMetrics b = m1053b(context);
            if ("width".equals(str2)) {
                return ((double) b.widthPixels) / ((double) b.density);
            }
            if ("height".equals(str2)) {
                return ((double) b.heightPixels) / ((double) b.density);
            }
            throw new RuntimeException("Operation not supported: getDimensions " + str + " " + str2);
        }
        throw new RuntimeException("Operation not supported: getDimensions " + str + " " + str2);
    }

    private static DisplayMetrics m1053b(Context context) {
        DisplayMetricsHolder.m13806a(context);
        return DisplayMetricsHolder.f11710a;
    }
}
