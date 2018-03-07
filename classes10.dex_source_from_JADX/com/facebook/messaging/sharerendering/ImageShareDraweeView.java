package com.facebook.messaging.sharerendering;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import javax.annotation.Nullable;

/* compiled from: query_param */
public class ImageShareDraweeView extends FbDraweeView {
    private int f4036c;

    public ImageShareDraweeView(Context context) {
        super(context);
    }

    public ImageShareDraweeView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ImageShareDraweeView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setImageWidthHint(int i) {
        this.f4036c = i;
        requestLayout();
    }

    public void onMeasure(int i, int i2) {
        int size = MeasureSpec.getSize(i);
        if (MeasureSpec.getMode(i) == Integer.MIN_VALUE) {
            if (size > this.f4036c) {
                size = this.f4036c;
            }
            i = MeasureSpec.makeMeasureSpec(size, 1073741824);
        }
        super.onMeasure(i, i2);
    }
}
