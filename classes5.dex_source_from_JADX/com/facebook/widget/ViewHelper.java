package com.facebook.widget;

import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.support.annotation.ColorInt;
import android.view.View;

/* compiled from: com.google.android.auth.IAuthManagerService */
public class ViewHelper {
    public static void m10550a(View view, @ColorInt int i) {
        if (VERSION.SDK_INT >= 17) {
            view.setBackgroundColor(i);
        } else {
            view.setBackgroundDrawable(new ColorDrawable(i));
        }
    }
}
