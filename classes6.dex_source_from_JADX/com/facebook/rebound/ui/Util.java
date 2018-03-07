package com.facebook.rebound.ui;

import android.content.res.Resources;
import android.util.TypedValue;

/* compiled from: serialized */
public abstract class Util {
    public static final int m23061a(float f, Resources resources) {
        return (int) TypedValue.applyDimension(1, f, resources.getDisplayMetrics());
    }
}
