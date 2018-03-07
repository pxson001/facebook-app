package com.facebook.common.util;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewParent;

/* compiled from: production_prompts_holdout */
public class RectUtil {
    public static void m13824a(View view, ViewParent viewParent, Rect rect) {
        view.getHitRect(rect);
        ViewParent parent = view.getParent();
        while (parent != viewParent && parent != null && (parent instanceof View)) {
            View view2 = (View) parent;
            rect.offset(view2.getLeft(), view2.getTop());
            parent = view2.getParent();
        }
    }
}
