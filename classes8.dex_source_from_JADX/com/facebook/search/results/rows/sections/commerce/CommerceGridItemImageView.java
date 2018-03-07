package com.facebook.search.results.rows.sections.commerce;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.drawee.fbpipeline.FbDraweeView;

/* compiled from: REMAINING_BATTERY_LEVEL */
public class CommerceGridItemImageView extends FbDraweeView {
    public CommerceGridItemImageView(Context context) {
        super(context);
    }

    public CommerceGridItemImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CommerceGridItemImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        setMeasuredDimension(measuredWidth, measuredWidth);
    }
}
