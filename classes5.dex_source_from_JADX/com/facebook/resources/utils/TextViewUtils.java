package com.facebook.resources.utils;

import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.widget.TextView;
import javax.annotation.Nullable;

/* compiled from: contact_card */
public class TextViewUtils {
    public static void m10171a(TextView textView, @Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3, @Nullable Drawable drawable4) {
        if (VERSION.SDK_INT >= 17) {
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        } else {
            textView.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        }
    }

    public static void m10172b(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (VERSION.SDK_INT >= 17) {
            textView.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        } else {
            textView.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        }
    }
}
