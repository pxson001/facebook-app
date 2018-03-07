package com.facebook.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout.LayoutParams;

/* compiled from: com.google.android.gms.signin.service.START */
public class ChildSharingFrameLayout extends CustomFrameLayout {
    public ChildSharingFrameLayout(Context context) {
        super(context);
    }

    public ChildSharingFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ChildSharingFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void m10388a(View view, LayoutParams layoutParams) {
        ViewParent parent = view.getParent();
        if (parent instanceof ChildSharingFrameLayout) {
            ChildSharingFrameLayout childSharingFrameLayout = (ChildSharingFrameLayout) parent;
            childSharingFrameLayout.detachViewFromParent(view);
            attachViewToParent(view, 0, layoutParams);
            childSharingFrameLayout.requestLayout();
            childSharingFrameLayout.invalidate();
            requestLayout();
            invalidate();
        }
    }
}
