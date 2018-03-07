package com.facebook.camera.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/* compiled from: allEventDeclines */
public class SquareLinearLayout extends LinearLayout {
    public SquareLinearLayout(Context context) {
        super(context);
    }

    public SquareLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SquareLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int min = Math.min(getMeasuredWidth(), getMeasuredHeight());
        setMeasuredDimension(min, min);
    }
}
