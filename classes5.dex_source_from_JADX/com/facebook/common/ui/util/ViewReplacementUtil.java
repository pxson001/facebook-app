package com.facebook.common.ui.util;

import android.view.View;
import android.view.ViewGroup;

/* compiled from: shop_nux */
public class ViewReplacementUtil {
    public static void m3888a(ViewGroup viewGroup, int i, View view) {
        m3889a(viewGroup, viewGroup.findViewById(i), view);
    }

    public static void m3889a(ViewGroup viewGroup, View view, View view2) {
        int indexOfChild = viewGroup.indexOfChild(view);
        view2.setLayoutParams(view.getLayoutParams());
        viewGroup.addView(view2, indexOfChild);
        viewGroup.removeView(view);
    }

    public static void m3890b(ViewGroup viewGroup, int i, View view) {
        m3891b(viewGroup, viewGroup.findViewById(i), view);
    }

    public static void m3891b(ViewGroup viewGroup, View view, View view2) {
        viewGroup.addView(view2, viewGroup.indexOfChild(view));
        viewGroup.removeView(view);
    }
}
