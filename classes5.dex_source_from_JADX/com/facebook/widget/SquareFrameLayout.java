package com.facebook.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import com.facebook.R;

/* compiled from: com.google.android.gms */
public class SquareFrameLayout extends CustomFrameLayout {
    private final int f5779a;

    public SquareFrameLayout(Context context) {
        super(context);
        this.f5779a = 1;
    }

    public SquareFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SquareFrameLayout);
        this.f5779a = obtainStyledAttributes.getInteger(0, 1);
        obtainStyledAttributes.recycle();
    }

    public SquareFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SquareFrameLayout, i, 0);
        this.f5779a = obtainStyledAttributes.getInteger(0, 1);
        obtainStyledAttributes.recycle();
    }

    public void onMeasure(int i, int i2) {
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        switch (mode) {
            case Integer.MIN_VALUE:
                if (this.f5779a != 0) {
                    i = MeasureSpec.makeMeasureSpec(Math.min(size, size2), Integer.MIN_VALUE);
                    break;
                } else {
                    i2 = MeasureSpec.makeMeasureSpec(Math.min(size, size2), Integer.MIN_VALUE);
                    break;
                }
            case 1073741824:
                if (this.f5779a != 0) {
                    i = i2;
                    break;
                } else {
                    i2 = i;
                    break;
                }
            default:
                if (this.f5779a != 0) {
                    i = MeasureSpec.makeMeasureSpec(size2, mode2);
                    break;
                } else {
                    i2 = MeasureSpec.makeMeasureSpec(size, mode);
                    break;
                }
        }
        super.onMeasure(i, i2);
    }
}
