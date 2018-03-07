package com.facebook.widget;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.RelativeLayout.LayoutParams;
import javax.annotation.Nullable;

/* compiled from: gift_wrap */
public class CustomViewUtils {
    public static void m30283a(View view, Drawable drawable) {
        int paddingLeft = view.getPaddingLeft();
        int paddingTop = view.getPaddingTop();
        int paddingRight = view.getPaddingRight();
        int paddingBottom = view.getPaddingBottom();
        m30286b(view, drawable);
        view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    public static void m30286b(View view, @Nullable Drawable drawable) {
        if (VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    @SuppressLint({"DeprecatedMethod"})
    public static void m30284a(View view, OnGlobalLayoutListener onGlobalLayoutListener) {
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver != null) {
            if (VERSION.SDK_INT >= 16) {
                viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
            } else {
                viewTreeObserver.removeGlobalOnLayoutListener(onGlobalLayoutListener);
            }
        }
    }

    public static Rect m30282a(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        return new Rect(i, i2, view.getWidth() + i, view.getHeight() + i2);
    }

    public static Rect m30281a(Rect rect, View view) {
        Rect a = m30282a(view);
        int i = rect.left - a.left;
        int i2 = rect.top - a.top;
        return new Rect(i, i2, rect.width() + i, rect.height() + i2);
    }

    public static void m30285a(LayoutParams layoutParams, Rect rect) {
        layoutParams.leftMargin = rect.left;
        layoutParams.topMargin = rect.top;
        layoutParams.bottomMargin = 0;
        layoutParams.rightMargin = 0;
        layoutParams.width = rect.width();
        layoutParams.height = rect.height();
    }
}
