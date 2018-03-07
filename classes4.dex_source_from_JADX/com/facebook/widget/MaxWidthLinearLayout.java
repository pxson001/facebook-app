package com.facebook.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import com.facebook.R;

/* compiled from: totalTimes */
public class MaxWidthLinearLayout extends LinearLayout {
    private int f909a = Integer.MAX_VALUE;

    public MaxWidthLinearLayout(Context context) {
        super(context);
        m1233a(context, null);
    }

    public MaxWidthLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m1233a(context, attributeSet);
    }

    public MaxWidthLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m1233a(context, attributeSet);
    }

    private final void m1233a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MaxWidthLayout);
            this.f909a = obtainStyledAttributes.getDimensionPixelSize(0, Integer.MAX_VALUE);
            obtainStyledAttributes.recycle();
        }
    }

    public void setMaxWidth(int i) {
        this.f909a = i;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getMeasuredWidth() > this.f909a) {
            measure(MeasureSpec.makeMeasureSpec(this.f909a, 1073741824), i2);
        }
    }
}
