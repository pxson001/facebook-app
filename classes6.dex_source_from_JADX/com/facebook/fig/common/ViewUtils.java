package com.facebook.fig.common;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.UiThread;
import android.view.View;

/* compiled from: proximity cm changed to  */
public class ViewUtils {
    private static final Rect f10489a = new Rect();

    @UiThread
    public static Rect m16663a() {
        f10489a.setEmpty();
        return f10489a;
    }

    @UiThread
    public static void m16664a(View view, Drawable drawable) {
        if (VERSION.SDK_INT < 16) {
            view.setBackgroundDrawable(drawable);
        } else {
            view.setBackground(drawable);
        }
    }
}
