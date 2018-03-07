package com.facebook.components.fb.view;

import android.view.View;
import android.view.ViewGroup;

/* compiled from: transliterator_opened */
public class ComponentViewTagFinder {
    public static View m1264a(View view, int i) {
        if (view.getTag(i) != null) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                View a = m1264a(viewGroup.getChildAt(i2), i);
                if (a != null) {
                    return a;
                }
            }
        }
        return null;
    }
}
