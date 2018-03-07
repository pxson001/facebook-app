package com.facebook.timeline.ui.common;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.facebook.R;
import javax.annotation.Nullable;

/* compiled from: select_suggestion */
public class ProfileMediaFragmentLayout extends LinearLayout {
    private int f5062a;
    private int f5063b;

    public ProfileMediaFragmentLayout(Context context) {
        super(context, null);
        m7824a(context, null);
    }

    public ProfileMediaFragmentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        m7824a(context, attributeSet);
    }

    public ProfileMediaFragmentLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m7824a(context, attributeSet);
    }

    private void m7824a(Context context, @Nullable AttributeSet attributeSet) {
        if (attributeSet == null) {
            this.f5062a = 1;
            this.f5063b = 1;
            return;
        }
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.ProfileMediaFragmentLayout, 0, 0);
        this.f5062a = obtainStyledAttributes.getInteger(0, 1);
        this.f5063b = obtainStyledAttributes.getInteger(1, 1);
        obtainStyledAttributes.recycle();
    }

    protected void onMeasure(int i, int i2) {
        View childAt = getChildAt(0);
        View childAt2 = getChildAt(1);
        View childAt3 = getChildAt(2);
        m7825a(childAt, i, i2);
        m7825a(childAt3, i, i2);
        int size = MeasureSpec.getSize(i2);
        int size2 = MeasureSpec.getSize(i);
        int measuredHeight = childAt.getMeasuredHeight();
        int measuredHeight2 = childAt3.getMeasuredHeight();
        int i3 = (measuredHeight + measuredHeight2) + size2;
        if (i3 <= size) {
            size -= i3;
            measuredHeight = (this.f5062a * size) / (this.f5062a + this.f5063b);
            size = (size * this.f5063b) / (this.f5062a + this.f5063b);
            m7826b(childAt, childAt.getMeasuredWidth(), measuredHeight + childAt.getMeasuredHeight());
            m7826b(childAt2, size2, size2);
            m7826b(childAt3, childAt3.getMeasuredWidth(), childAt3.getMeasuredHeight() + size);
        } else {
            int i4 = (size - measuredHeight) - measuredHeight2;
            m7826b(childAt2, i4, i4);
        }
        setMeasuredDimension(i, i2);
    }

    private void m7825a(View view, int i, int i2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams.width != -1) {
            i = 0;
        }
        if (layoutParams.height != -1) {
            i2 = 0;
        }
        measureChild(view, i, i2);
    }

    private static void m7826b(View view, int i, int i2) {
        view.measure(MeasureSpec.makeMeasureSpec(i, 1073741824), MeasureSpec.makeMeasureSpec(i2, 1073741824));
    }
}
