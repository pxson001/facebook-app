package com.facebook.common.ui.util;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import javax.annotation.Nullable;

/* compiled from: pyml_profile */
public class DisplayUtils {
    public static void m13107a(@Nullable View view, int i) {
        if (view != null) {
            LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = i;
            view.setLayoutParams(layoutParams);
            view.requestLayout();
        }
    }
}
