package com.facebook.messaging.business.airline.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;

/* compiled from: thread_group_settings_video */
public class AirlineGridView extends ViewGroup {

    /* compiled from: thread_group_settings_video */
    public class LayoutParams extends android.view.ViewGroup.LayoutParams {
        public int f1579a;
        public int f1580b;
        public int f1581c;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    public AirlineGridView(Context context) {
        super(context);
    }

    public AirlineGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AirlineGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void onMeasure(int i, int i2) {
        int size = MeasureSpec.getSize(i);
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (i3 < getChildCount()) {
            int i9;
            View childAt = getChildAt(i3);
            measureChild(childAt, i, i2);
            if (childAt.getMeasuredWidth() + i8 > size) {
                m1572a(size - i8, i4, i3 - 1);
                i8 = i7 + i5;
                i7 = i6 + 1;
                i5 = i3;
                i6 = 0;
                i9 = 0;
            } else {
                i9 = i8;
                i8 = i7;
                i7 = i6;
                i6 = i5;
                i5 = i4;
            }
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            layoutParams.f1579a = i9;
            layoutParams.f1580b = i8;
            layoutParams.f1581c = i7;
            i9 += childAt.getMeasuredWidth();
            i3++;
            i4 = i5;
            i5 = Math.max(i6, childAt.getMeasuredHeight());
            i6 = i7;
            i7 = i8;
            i8 = i9;
        }
        m1572a(size - i8, i4, getChildCount() - 1);
        setMeasuredDimension(View.resolveSize(size, i), View.resolveSize(i7 + i5, i2));
    }

    private void m1572a(int i, int i2, int i3) {
        if (i2 < i3) {
            int i4 = i / (i3 - i2);
            for (int i5 = i2 + 1; i5 <= i3; i5++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i5).getLayoutParams();
                layoutParams.f1579a += (i5 - i2) * i4;
            }
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            childAt.layout(layoutParams.f1579a, layoutParams.f1580b, layoutParams.f1579a + childAt.getMeasuredWidth(), layoutParams.f1580b + childAt.getMeasuredHeight());
        }
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams.width, layoutParams.height);
    }
}
