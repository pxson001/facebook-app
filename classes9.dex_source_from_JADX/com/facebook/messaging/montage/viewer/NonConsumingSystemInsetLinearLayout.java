package com.facebook.messaging.montage.viewer;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/* compiled from: is_cached_ */
public class NonConsumingSystemInsetLinearLayout extends LinearLayout {
    public NonConsumingSystemInsetLinearLayout(Context context) {
        super(context);
    }

    public NonConsumingSystemInsetLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public NonConsumingSystemInsetLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected boolean fitSystemWindows(Rect rect) {
        super.fitSystemWindows(rect);
        return false;
    }
}
