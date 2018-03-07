package com.facebook.resources.utils;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import java.util.Locale;

/* compiled from: goodwill_throwback_preferences_mobile */
public class ResourceUtils {
    private ResourceUtils() {
    }

    public static String m29970a(Context context, TypedArray typedArray, int i) {
        int resourceId = typedArray.getResourceId(i, 0);
        return resourceId != 0 ? context.getString(resourceId) : typedArray.getNonResourceString(i);
    }

    @Deprecated
    public static String m29971a(Resources resources, int i, int i2, int i3) {
        if (i3 == 1) {
            return resources.getString(i);
        }
        return resources.getString(i2, new Object[]{Integer.valueOf(i3)});
    }

    @Deprecated
    public static String m29973a(String str, String str2, int i) {
        if (i == 1) {
            return str;
        }
        return String.format(Locale.getDefault(), str2, new Object[]{Integer.valueOf(i)});
    }

    @Deprecated
    public static String m29972a(Resources resources, int i, int i2, int i3, Object... objArr) {
        return i3 == 1 ? resources.getString(i) : resources.getString(i2, objArr);
    }
}
