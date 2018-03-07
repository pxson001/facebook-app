package com.facebook.orca.common.ui.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;

/* compiled from: p2p_c2c_platform_context_created */
public class FloatRightCustomLayout extends ViewGroup {
    public FloatRightCustomLayout(Context context) {
        super(context);
    }

    public FloatRightCustomLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FloatRightCustomLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void onMeasure(int i, int i2) {
        if (getChildCount() != 2) {
            throw new IllegalStateException("Should be two children");
        }
        int measuredWidth;
        int measuredWidth2;
        int max;
        View childAt = getChildAt(0);
        View childAt2 = getChildAt(1);
        if (childAt2.getVisibility() != 8) {
            LayoutParams layoutParams = (LayoutParams) childAt2.getLayoutParams();
            measureChildWithMargins(childAt2, MeasureSpec.makeMeasureSpec(0, 0), 0, i2, 0);
            measuredWidth = (childAt2.getMeasuredWidth() + layoutParams.leftMargin) + layoutParams.rightMargin;
            measuredWidth2 = ((childAt2.getMeasuredWidth() + layoutParams.leftMargin) + layoutParams.rightMargin) + 0;
            max = Math.max(0, childAt2.getMeasuredHeight());
        } else {
            measuredWidth = 0;
            max = 0;
            measuredWidth2 = 0;
        }
        measureChildWithMargins(childAt, i, measuredWidth, i2, 0);
        LayoutParams layoutParams2 = (LayoutParams) childAt.getLayoutParams();
        max = Math.max(max, childAt.getMeasuredHeight()) + (getPaddingTop() + getPaddingBottom());
        setMeasuredDimension(View.resolveSize(Math.max(((layoutParams2.rightMargin + (childAt.getMeasuredWidth() + layoutParams2.leftMargin)) + measuredWidth2) + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), i), View.resolveSize(Math.max(max, getSuggestedMinimumHeight()), i2));
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (getChildCount() != 2) {
            throw new IllegalStateException("Should be two children");
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int i5 = (height - paddingTop) - paddingBottom;
        int i6 = height - paddingBottom;
        int i7 = 0;
        while (i7 < 2) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                switch (layoutParams.gravity & 112) {
                    case 16:
                        height = ((((i5 - measuredHeight) / 2) + paddingTop) + layoutParams.topMargin) - layoutParams.bottomMargin;
                        break;
                    case 48:
                        height = layoutParams.topMargin + paddingTop;
                        break;
                    case 80:
                        height = (i6 - measuredHeight) - layoutParams.bottomMargin;
                        break;
                    default:
                        height = paddingTop;
                        break;
                }
                paddingLeft += layoutParams.leftMargin;
                m4718a(childAt, paddingLeft, height, measuredWidth, measuredHeight);
                paddingBottom = (layoutParams.rightMargin + measuredWidth) + paddingLeft;
            } else {
                paddingBottom = paddingLeft;
            }
            i7++;
            paddingLeft = paddingBottom;
        }
    }

    private static void m4718a(View view, int i, int i2, int i3, int i4) {
        view.layout(i, i2, i + i3, i2 + i4);
    }

    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }
}
