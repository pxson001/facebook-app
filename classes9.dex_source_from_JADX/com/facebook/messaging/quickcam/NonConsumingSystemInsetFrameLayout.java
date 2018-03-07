package com.facebook.messaging.quickcam;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* compiled from: deltaTransferStatus */
public class NonConsumingSystemInsetFrameLayout extends FrameLayout {
    public NonConsumingSystemInsetFrameLayout(Context context) {
        super(context);
    }

    public NonConsumingSystemInsetFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public NonConsumingSystemInsetFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected boolean fitSystemWindows(Rect rect) {
        super.fitSystemWindows(rect);
        return false;
    }
}
