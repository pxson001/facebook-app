package com.facebook.react.views.text;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;

/* compiled from: Received onFailure for graphql fetch */
public final class DefaultStyleValuesUtil {
    private DefaultStyleValuesUtil() {
        throw new AssertionError("Never invoke this for an Utility class!");
    }

    public static ColorStateList m11967a(Context context) {
        return m11968a(context, 16842906);
    }

    public static ColorStateList m11969b(Context context) {
        return m11968a(context, 16842904);
    }

    public static int m11970c(Context context) {
        return m11968a(context, 16842905).getDefaultColor();
    }

    private static ColorStateList m11968a(Context context, int i) {
        TypedArray typedArray = null;
        try {
            typedArray = context.getTheme().obtainStyledAttributes(new int[]{i});
            ColorStateList colorStateList = typedArray.getColorStateList(0);
            return colorStateList;
        } finally {
            if (typedArray != null) {
                typedArray.recycle();
            }
        }
    }
}
