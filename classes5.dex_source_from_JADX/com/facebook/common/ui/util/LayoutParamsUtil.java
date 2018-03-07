package com.facebook.common.ui.util;

import android.view.View;
import android.view.ViewGroup.LayoutParams;

/* compiled from: should_ask_for_menu */
public class LayoutParamsUtil {
    public static void m3871a(View view, int i) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams.width != i) {
            layoutParams.width = i;
            view.setLayoutParams(layoutParams);
        }
    }

    public static void m3873b(View view, int i) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams.height != i) {
            layoutParams.height = i;
            view.setLayoutParams(layoutParams);
        }
    }

    public static void m3872a(View view, int i, int i2) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams.width != i || layoutParams.height != i2) {
            layoutParams.width = i;
            layoutParams.height = i2;
            view.setLayoutParams(layoutParams);
        }
    }
}
