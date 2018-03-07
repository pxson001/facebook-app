package com.facebook.messaging.audio.playback;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.widget.CustomViewGroup;

/* compiled from: order_param */
public class ClipProgressLayout extends CustomViewGroup {
    private double f8078a;

    public ClipProgressLayout(Context context) {
        this(context, null);
    }

    public ClipProgressLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ClipProgressLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8078a = 1.0d;
    }

    public void setProgress(double d) {
        this.f8078a = d;
        requestLayout();
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        setMeasuredDimension(paddingLeft + ((int) (((double) (getMeasuredWidth() - paddingLeft)) * this.f8078a)), getMeasuredHeight());
    }
}
