package com.facebook.components;

import android.content.res.TypedArray;
import android.util.TypedValue;

/* compiled from: setPrefillCategoryId */
class TypedArrayUtils {
    private static final TypedValue f2802a = new TypedValue();

    TypedArrayUtils() {
    }

    static boolean m3937a(TypedArray typedArray, int i) {
        boolean z;
        synchronized (f2802a) {
            typedArray.getValue(i, f2802a);
            z = f2802a.type >= 28 && f2802a.type <= 31;
        }
        return z;
    }
}
