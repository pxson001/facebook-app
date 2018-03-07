package com.facebook.securitycheckup.items;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.facebook.widget.CustomRelativeLayout;

/* compiled from: image_link_click */
public class DisableScrollRelativeLayout extends CustomRelativeLayout {
    public DisableScrollRelativeLayout(Context context) {
        super(context);
    }

    public DisableScrollRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DisableScrollRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return false;
    }
}
