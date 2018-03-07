package com.facebook.fbui.widget.text;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextUtils.TruncateAt;
import com.facebook.R;
import com.facebook.fbui.widget.text.layoutbuilder.TextLayoutBuilder;

/* compiled from: request_type */
public class ResourceTextLayoutHelper {
    public static void m4263a(TextLayoutBuilder textLayoutBuilder, Context context, int i) {
        if (i > 0) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, R.styleable.TextStyle);
            int resourceId = obtainStyledAttributes.getResourceId(0, -1);
            if (resourceId > 0) {
                m4264b(textLayoutBuilder, context, resourceId);
            }
            ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(3);
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(1, 15);
            int i2 = obtainStyledAttributes.getInt(7, 0);
            float f = obtainStyledAttributes.getFloat(8, 0.0f);
            float f2 = obtainStyledAttributes.getFloat(9, 0.0f);
            float f3 = obtainStyledAttributes.getFloat(10, 0.0f);
            int i3 = obtainStyledAttributes.getInt(2, -1);
            int i4 = obtainStyledAttributes.getInt(4, 0);
            boolean z = obtainStyledAttributes.getBoolean(6, false);
            int i5 = obtainStyledAttributes.getInt(5, Integer.MAX_VALUE);
            obtainStyledAttributes.recycle();
            textLayoutBuilder.a(colorStateList);
            textLayoutBuilder.b(dimensionPixelSize);
            textLayoutBuilder.a(f3, f, f2, i2);
            if (i3 != -1) {
                textLayoutBuilder.a(Typeface.defaultFromStyle(i3));
            } else {
                textLayoutBuilder.a(null);
            }
            if (i4 <= 0 || i4 >= 4) {
                textLayoutBuilder.a(null);
            } else {
                textLayoutBuilder.a(TruncateAt.values()[i4 - 1]);
            }
            textLayoutBuilder.b(z);
            textLayoutBuilder.e(i5);
        }
    }

    public static void m4264b(TextLayoutBuilder textLayoutBuilder, Context context, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, R.styleable.TextAppearance);
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(3);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        int i2 = obtainStyledAttributes.getInt(6, 0);
        if (i2 != 0) {
            textLayoutBuilder.a(obtainStyledAttributes.getFloat(9, 0.0f), obtainStyledAttributes.getFloat(7, 0.0f), obtainStyledAttributes.getFloat(8, 0.0f), i2);
        }
        i2 = obtainStyledAttributes.getInt(2, -1);
        obtainStyledAttributes.recycle();
        if (colorStateList != null) {
            textLayoutBuilder.a(colorStateList);
        }
        if (dimensionPixelSize != 0) {
            textLayoutBuilder.b(dimensionPixelSize);
        }
        if (i2 != -1) {
            textLayoutBuilder.a(Typeface.defaultFromStyle(i2));
        }
    }
}
