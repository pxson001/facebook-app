package com.facebook.photos.creativecam.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

/* compiled from: state_category */
public class CreativeCamLayout extends LinearLayout {
    public CreativeCamLayout(Context context) {
        super(context, null);
    }

    public CreativeCamLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    public CreativeCamLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void onMeasure(int i, int i2) {
        View childAt = getChildAt(0);
        View childAt2 = getChildAt(1);
        View childAt3 = getChildAt(2);
        m2368a(childAt, i, i2);
        m2368a(childAt3, i, i2);
        int size = MeasureSpec.getSize(i2);
        int size2 = MeasureSpec.getSize(i);
        int measuredHeight = childAt.getMeasuredHeight();
        int measuredHeight2 = childAt3.getMeasuredHeight();
        int i3 = (measuredHeight + measuredHeight2) + size2;
        if (i3 <= size) {
            measuredHeight = size - i3;
            m2369b(childAt2, size2, size2);
            m2369b(childAt3, childAt3.getMeasuredWidth(), measuredHeight + childAt3.getMeasuredHeight());
        } else {
            measuredHeight = (size - measuredHeight) - measuredHeight2;
            m2369b(childAt2, measuredHeight, measuredHeight);
        }
        setMeasuredDimension(i, i2);
    }

    private void m2368a(View view, int i, int i2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams.width != -1) {
            i = 0;
        }
        if (layoutParams.height != -1) {
            i2 = 0;
        }
        measureChild(view, i, i2);
    }

    private static void m2369b(View view, int i, int i2) {
        view.measure(MeasureSpec.makeMeasureSpec(i, 1073741824), MeasureSpec.makeMeasureSpec(i2, 1073741824));
    }
}
