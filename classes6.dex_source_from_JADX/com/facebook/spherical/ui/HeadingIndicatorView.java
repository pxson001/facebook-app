package com.facebook.spherical.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/* compiled from: errStr */
public abstract class HeadingIndicatorView extends View {
    public boolean f16283a = false;

    public HeadingIndicatorView(Context context) {
        super(context);
    }

    public HeadingIndicatorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public HeadingIndicatorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected final float m23816a(float f) {
        return getResources().getDisplayMetrics().density * f;
    }
}
