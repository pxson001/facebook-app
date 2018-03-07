package com.facebook.messaging.photos.editing;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

/* compiled from: dispatchActivityStop */
public class LayerGroupLayout extends FrameLayout {
    public LayerGroupLayout(Context context) {
        super(context);
    }

    public LayerGroupLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public LayerGroupLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2, 17);
    }
}
