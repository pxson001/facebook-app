package com.facebook.react.views.view;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewParent;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* compiled from: first_value */
public class ReactClippingViewGroupHelper {
    private static final Rect f11941a = new Rect();

    public static void m14201a(View view, Rect rect) {
        ViewParent parent = view.getParent();
        if (parent == null) {
            rect.setEmpty();
            return;
        }
        if (parent instanceof ReactClippingViewGroup) {
            ReactClippingViewGroup reactClippingViewGroup = (ReactClippingViewGroup) parent;
            if (reactClippingViewGroup.getRemoveClippedSubviews()) {
                reactClippingViewGroup.mo758a(f11941a);
                if (f11941a.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                    f11941a.offset(-view.getLeft(), -view.getTop());
                    f11941a.offset(view.getScrollX(), view.getScrollY());
                    rect.set(f11941a);
                    return;
                }
                rect.setEmpty();
                return;
            }
        }
        view.getDrawingRect(rect);
    }
}
