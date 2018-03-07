package com.facebook.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.facebook.R;

/* compiled from: com.google.android.gms.iid.IMessengerCompat */
public class MaxWidthFrameLayout extends FrameLayout {
    private int f5673a = Integer.MAX_VALUE;

    public MaxWidthFrameLayout(Context context) {
        super(context);
        m10461a(context, null);
    }

    public MaxWidthFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m10461a(context, attributeSet);
    }

    public MaxWidthFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m10461a(context, attributeSet);
    }

    private final void m10461a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MaxWidthLayout);
            this.f5673a = obtainStyledAttributes.getDimensionPixelSize(0, Integer.MAX_VALUE);
            obtainStyledAttributes.recycle();
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getMeasuredWidth() > this.f5673a) {
            setMeasuredDimension(this.f5673a, getMeasuredHeight());
        }
    }
}
