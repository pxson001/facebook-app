package com.facebook.feed.util.composer.sprout;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import javax.annotation.Nullable;

/* compiled from: TURN_ON_CONTINUOUS_SYNC */
public class MeasureAwareFrameLayout extends FrameLayout {
    @Nullable
    private OnMeasureListener f22421a;

    /* compiled from: TURN_ON_CONTINUOUS_SYNC */
    public interface OnMeasureListener {
    }

    public MeasureAwareFrameLayout(Context context) {
        super(context);
    }

    public MeasureAwareFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MeasureAwareFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setOnMeasureListener(@Nullable OnMeasureListener onMeasureListener) {
        this.f22421a = onMeasureListener;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }
}
