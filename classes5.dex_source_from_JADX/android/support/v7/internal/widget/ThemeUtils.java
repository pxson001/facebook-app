package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v4.graphics.ColorUtils;
import android.util.TypedValue;

/* compiled from: underage_fan_removal */
public class ThemeUtils {
    public static final ThreadLocal<TypedValue> f1199a = new ThreadLocal();
    private static final int[] f1200b = new int[]{-16842910};
    private static final int[] f1201c = new int[0];
    private static final int[] f1202d = new int[1];

    ThemeUtils() {
    }

    static int m1674a(Context context, int i) {
        f1202d[0] = i;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, f1202d);
        try {
            int color = obtainStyledAttributes.getColor(0, 0);
            return color;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    static ColorStateList m1676b(Context context, int i) {
        f1202d[0] = i;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, f1202d);
        try {
            ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(0);
            return colorStateList;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    static int m1677c(Context context, int i) {
        ColorStateList b = m1676b(context, i);
        if (b != null && b.isStateful()) {
            return b.getColorForState(f1200b, b.getDefaultColor());
        }
        TypedValue typedValue = (TypedValue) f1199a.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            f1199a.set(typedValue);
        }
        TypedValue typedValue2 = typedValue;
        context.getTheme().resolveAttribute(16842803, typedValue2, true);
        return m1675a(context, i, typedValue2.getFloat());
    }

    public static int m1675a(Context context, int i, float f) {
        int a = m1674a(context, i);
        return ColorUtils.m242b(a, Math.round(((float) Color.alpha(a)) * f));
    }
}
