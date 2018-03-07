package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v4.graphics.ColorUtils;
import android.util.TypedValue;

/* compiled from: underage_fan_removal */
public class ThemeUtils {
    public static final int[] f1535a = new int[]{-16842910};
    static final int[] f1536b = new int[]{16842908};
    static final int[] f1537c = new int[]{16843518};
    static final int[] f1538d = new int[]{16842919};
    static final int[] f1539e = new int[]{16842912};
    static final int[] f1540f = new int[]{16842913};
    public static final int[] f1541g = new int[]{-16842919, -16842908};
    public static final int[] f1542h = new int[0];
    public static final ThreadLocal<TypedValue> f1543i = new ThreadLocal();
    private static final int[] f1544j = new int[1];

    ThemeUtils() {
    }

    public static int m2105a(Context context, int i) {
        f1544j[0] = i;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, f1544j);
        try {
            int color = obtainStyledAttributes.getColor(0, 0);
            return color;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static ColorStateList m2107b(Context context, int i) {
        f1544j[0] = i;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, f1544j);
        try {
            ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(0);
            return colorStateList;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static int m2108c(Context context, int i) {
        ColorStateList b = m2107b(context, i);
        if (b != null && b.isStateful()) {
            return b.getColorForState(f1535a, b.getDefaultColor());
        }
        TypedValue typedValue = (TypedValue) f1543i.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            f1543i.set(typedValue);
        }
        TypedValue typedValue2 = typedValue;
        context.getTheme().resolveAttribute(16842803, typedValue2, true);
        return m2106a(context, i, typedValue2.getFloat());
    }

    static int m2106a(Context context, int i, float f) {
        int a = m2105a(context, i);
        return ColorUtils.m242b(a, Math.round(((float) Color.alpha(a)) * f));
    }
}
