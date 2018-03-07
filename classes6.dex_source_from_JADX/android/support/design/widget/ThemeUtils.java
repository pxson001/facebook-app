package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;

/* compiled from: publishLifeEventParams */
class ThemeUtils {
    private static final int[] f7118a = new int[]{2130772048};

    ThemeUtils() {
    }

    static void m10221a(Context context) {
        int i = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(f7118a);
        if (!obtainStyledAttributes.hasValue(0)) {
            i = 1;
        }
        if (obtainStyledAttributes != null) {
            obtainStyledAttributes.recycle();
        }
        if (i != 0) {
            throw new IllegalArgumentException("You need to use a Theme.AppCompat theme (or descendant) with the design library.");
        }
    }
}
