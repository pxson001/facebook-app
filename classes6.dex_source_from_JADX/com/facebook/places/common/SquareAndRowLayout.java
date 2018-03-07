package com.facebook.places.common;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.google.common.base.Preconditions;

/* compiled from: found_face_photo_tag */
public class SquareAndRowLayout extends FrameLayout {
    public SquareAndRowLayout(Context context) {
        super(context);
    }

    public SquareAndRowLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SquareAndRowLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void onMeasure(int i, int i2) {
        Preconditions.checkState(getChildCount() == 2, "SquareAndRowLayout must have exactly two children");
        View childAt = getChildAt(0);
        View childAt2 = getChildAt(1);
        if (childAt2.getVisibility() == 8) {
            super.onMeasure(i, i2);
            return;
        }
        LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
        measureChild(childAt, i, i2);
        setMeasuredDimension((childAt.getMeasuredWidth() + layoutParams.leftMargin) + layoutParams.rightMargin, (childAt.getMeasuredHeight() + layoutParams.topMargin) + layoutParams.bottomMargin);
        LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
        int measuredHeight = getMeasuredHeight();
        getMeasuredWidth();
        measuredHeight = (measuredHeight - layoutParams2.topMargin) - layoutParams2.bottomMargin;
        measureChild(childAt2, MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824), MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
        measureChild(childAt, MeasureSpec.makeMeasureSpec(((((getMeasuredWidth() - measuredHeight) - layoutParams.leftMargin) - layoutParams.rightMargin) - layoutParams2.leftMargin) - layoutParams2.rightMargin, 1073741824), MeasureSpec.makeMeasureSpec((getMeasuredHeight() - layoutParams.topMargin) - layoutParams.bottomMargin, 1073741824));
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View childAt = getChildAt(0);
        View childAt2 = getChildAt(1);
        if (childAt2.getVisibility() == 8) {
            super.onLayout(z, i, i2, i3, i4);
            return;
        }
        LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
        int measuredWidth = layoutParams.leftMargin + childAt.getMeasuredWidth();
        childAt.layout(layoutParams.leftMargin, layoutParams.topMargin, measuredWidth, layoutParams.topMargin + childAt.getMeasuredHeight());
        LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
        int i5 = (layoutParams.rightMargin + measuredWidth) + layoutParams2.leftMargin;
        childAt2.layout(i5, layoutParams2.topMargin, childAt2.getMeasuredWidth() + i5, layoutParams2.topMargin + childAt2.getMeasuredHeight());
    }
}
