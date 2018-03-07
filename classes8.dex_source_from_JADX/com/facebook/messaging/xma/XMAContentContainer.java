package com.facebook.messaging.xma;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import javax.annotation.Nullable;

/* compiled from: time_to_select_first_card */
public class XMAContentContainer extends ViewGroup {
    public int f1575a = -1;

    /* compiled from: time_to_select_first_card */
    public class LayoutParams extends android.view.ViewGroup.LayoutParams {
        public SizingPreference f1574a = SizingPreference.MATCH_LARGEST_NONTEXT;

        /* compiled from: time_to_select_first_card */
        public enum SizingPreference {
            MATCH_LARGEST_NONTEXT,
            MATCH_LARGEST
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public final SizingPreference m1746a() {
            return this.f1574a;
        }

        public final void m1747a(SizingPreference sizingPreference) {
            this.f1574a = sizingPreference;
        }
    }

    public XMAContentContainer(Context context) {
        super(context);
    }

    public XMAContentContainer(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public XMAContentContainer(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -2);
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public void onMeasure(int i, int i2) {
        int i3 = 0;
        View childAt = getChildAt(0);
        if (childAt == null) {
            super.onMeasure(i, i2);
            return;
        }
        if (this.f1575a == -1) {
            childAt.measure(i, i2);
        } else {
            switch (MeasureSpec.getMode(i)) {
                case Integer.MIN_VALUE:
                    i3 = Math.min(MeasureSpec.getSize(i), this.f1575a);
                    break;
                case 0:
                    i3 = this.f1575a;
                    break;
                case 1073741824:
                    i3 = MeasureSpec.getSize(i);
                    break;
            }
            childAt.measure(MeasureSpec.makeMeasureSpec(i3, 1073741824), i2);
        }
        setMeasuredDimension(childAt.getMeasuredWidth(), childAt.getMeasuredHeight());
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View childAt = getChildAt(0);
        if (childAt != null) {
            childAt.layout(0, 0, i3 - i, i4 - i2);
        }
    }

    public void setTargetExactWidth(int i) {
        this.f1575a = i;
    }

    public SizingPreference getChildSizingPreference() {
        if (getChildAt(0) != null) {
            return ((LayoutParams) getChildAt(0).getLayoutParams()).f1574a;
        }
        return SizingPreference.MATCH_LARGEST_NONTEXT;
    }
}
