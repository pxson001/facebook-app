package com.facebook.richdocument.utils;

import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.view.View;

/* compiled from: paypal */
public class UIUtils {
    public static void m6864a(View view, int i) {
        if (VERSION.SDK_INT < 16) {
            view.setBackgroundDrawable(new ColorDrawable(i));
        } else {
            view.setBackground(new ColorDrawable(i));
        }
    }
}
