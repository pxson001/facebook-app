package com.facebook.react.uimanager;

import android.view.View;
import android.view.ViewParent;
import com.facebook.infer.annotation.Assertions;

/* compiled from: freebasics.com */
public class RootViewUtil {
    public static RootView m13964a(View view) {
        View view2 = view;
        while (!(view2 instanceof RootView)) {
            ViewParent parent = view2.getParent();
            if (parent == null) {
                return null;
            }
            Assertions.a(parent instanceof View);
            view2 = (View) parent;
        }
        return (RootView) view2;
    }
}
