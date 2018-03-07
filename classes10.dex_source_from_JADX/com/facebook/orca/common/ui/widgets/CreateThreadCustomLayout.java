package com.facebook.orca.common.ui.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.facebook.orca.compose.ComposeMode;

/* compiled from: p2p_details_button_clicked */
public class CreateThreadCustomLayout extends ViewGroup {
    private ComposeMode f5313a = ComposeMode.SHRUNK;

    public CreateThreadCustomLayout(Context context) {
        super(context);
    }

    public CreateThreadCustomLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CreateThreadCustomLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setComposeMode(ComposeMode composeMode) {
        this.f5313a = composeMode;
        requestLayout();
    }

    protected void onMeasure(int i, int i2) {
        if (getChildCount() != 2) {
            throw new IllegalStateException("Should be two children");
        }
        int measuredHeight;
        int max;
        int measuredHeight2;
        int measuredHeight3;
        View childAt = getChildAt(0);
        View childAt2 = getChildAt(1);
        if (childAt2.getVisibility() != 8) {
            measureChildWithMargins(childAt2, i, 0, i2, 0);
            measuredHeight = childAt2.getMeasuredHeight();
            max = Math.max(0, childAt2.getMeasuredWidth());
            measuredHeight2 = childAt2.getMeasuredHeight() + 0;
        } else {
            measuredHeight = 0;
            max = 0;
            measuredHeight2 = 0;
        }
        if (this.f5313a == ComposeMode.EXPANDED && MeasureSpec.getMode(i2) == 1073741824) {
            childAt.measure(i, MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(i2) - ((getPaddingTop() + measuredHeight2) + getPaddingBottom()), 1073741824));
            measuredHeight3 = childAt.getMeasuredHeight() + measuredHeight2;
        } else {
            measureChildWithMargins(childAt, i, 0, i2, measuredHeight);
            max = Math.max(max, childAt.getMeasuredWidth());
            measuredHeight3 = childAt.getMeasuredHeight() + measuredHeight2;
        }
        setMeasuredDimension(View.resolveSize(Math.max((getPaddingLeft() + getPaddingRight()) + max, getSuggestedMinimumWidth()), i), View.resolveSize(Math.max(measuredHeight3 + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight()), i2));
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (getChildCount() != 2) {
            throw new IllegalStateException("Should be two children");
        }
        int paddingLeft = getPaddingLeft();
        getWidth();
        int paddingTop = getPaddingTop();
        int height = getHeight();
        int i5 = 0;
        int i6 = 0;
        while (i6 < 2) {
            View childAt = getChildAt(i6);
            int measuredHeight = childAt.getMeasuredHeight() + i5;
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) childAt.getLayoutParams();
            i6++;
            i5 = measuredHeight + (marginLayoutParams.bottomMargin + marginLayoutParams.topMargin);
        }
        int max = Math.max(0, height - i5);
        for (i6 = 0; i6 < 2; i6++) {
            View childAt2 = getChildAt(i6);
            marginLayoutParams = (MarginLayoutParams) childAt2.getLayoutParams();
            measuredHeight = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i7 = marginLayoutParams.leftMargin + paddingLeft;
            if (i6 == 1) {
                paddingTop += max;
            }
            paddingTop += marginLayoutParams.topMargin;
            m4712a(childAt2, i7, paddingTop, measuredHeight, measuredHeight2);
            paddingTop += marginLayoutParams.bottomMargin + measuredHeight2;
        }
    }

    private static void m4712a(View view, int i, int i2, int i3, int i4) {
        view.layout(i, i2, i + i3, i2 + i4);
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new MarginLayoutParams(-1, -1);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new MarginLayoutParams(getContext(), attributeSet);
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return layoutParams instanceof MarginLayoutParams;
    }

    protected LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return new MarginLayoutParams(layoutParams);
    }
}
