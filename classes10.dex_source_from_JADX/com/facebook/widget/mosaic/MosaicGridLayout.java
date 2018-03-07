package com.facebook.widget.mosaic;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import com.facebook.widget.CustomViewGroup;

/* compiled from: fetch_upsell_data */
public class MosaicGridLayout extends CustomViewGroup {
    private int f11736a = 6;
    private int f11737b = 6;
    public boolean f11738c = false;
    private int f11739d;
    private int f11740e;
    private int f11741f;
    private int f11742g;
    private int f11743h;
    private int f11744i;
    private int f11745j;
    private int f11746k;
    public boolean f11747l;

    /* compiled from: fetch_upsell_data */
    public class LayoutParams extends android.view.ViewGroup.LayoutParams {
        public final int f12989a;
        public final int f12990b;

        public LayoutParams(int i, int i2, int i3, int i4) {
            super(i3, i4);
            this.f12989a = i;
            this.f12990b = i2;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof LayoutParams)) {
                return false;
            }
            LayoutParams layoutParams = (LayoutParams) obj;
            if (this.f12989a == layoutParams.f12989a && this.f12990b == layoutParams.f12990b && this.height == layoutParams.height && this.width == layoutParams.width) {
                return true;
            }
            return false;
        }
    }

    protected /* synthetic */ android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return m11831a();
    }

    public MosaicGridLayout(Context context) {
        super(context);
    }

    public MosaicGridLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MosaicGridLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void m11833a(int i, int i2) {
        this.f11736a = i2;
        this.f11737b = i;
    }

    public void setResizeToFit(boolean z) {
        this.f11738c = z;
    }

    public final void m11834a(int i, int i2, int i3, int i4) {
        this.f11739d = i;
        this.f11740e = i3;
        this.f11741f = i2;
        this.f11742g = i4;
    }

    public final void m11835b(int i, int i2) {
        int i3 = i / 2;
        this.f11745j = i3;
        this.f11746k = i3;
        if (i % 2 != 0) {
            this.f11746k++;
        }
        i3 = i2 / 2;
        this.f11743h = i3;
        this.f11744i = i3;
        if (i2 % 2 != 0) {
            this.f11744i++;
        }
    }

    public void setShouldInterceptItsChildrenTouchEvents(boolean z) {
        this.f11747l = z;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f11747l;
    }

    protected void onMeasure(int i, int i2) {
        int defaultSize = View.getDefaultSize(getSuggestedMinimumWidth(), i);
        if (this.f11738c) {
            this.f11736a = m11832c();
        }
        setMeasuredDimension(defaultSize, (defaultSize / this.f11737b) * this.f11736a);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = (i3 - i) - (this.f11739d + this.f11740e);
        int i6 = (i4 - i2) - (this.f11741f + this.f11742g);
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt != null && childAt.getVisibility() == 0) {
                int i8;
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int i9 = layoutParams.f12989a + layoutParams.width;
                int i10 = layoutParams.f12990b + layoutParams.height;
                int i11 = layoutParams.f12989a == 0 ? 0 : this.f11745j;
                int i12 = layoutParams.f12990b == 0 ? 0 : this.f11743h;
                int i13 = i9 == this.f11737b ? 0 : this.f11746k;
                if (i10 == this.f11736a) {
                    i8 = 0;
                } else {
                    i8 = this.f11744i;
                }
                double d = (double) (i5 / this.f11737b);
                double d2 = (double) (i6 / this.f11736a);
                i11 = (int) ((((double) this.f11739d) + (((double) layoutParams.f12989a) * d)) + ((double) i11));
                int i14 = (int) ((((double) this.f11741f) + (((double) layoutParams.f12990b) * d2)) + ((double) i12));
                i12 = (int) (((d * ((double) i9)) + ((double) this.f11739d)) - ((double) i13));
                i13 = (int) (((((double) i10) * d2) + ((double) this.f11741f)) - ((double) i8));
                childAt.measure(MeasureSpec.makeMeasureSpec(i12 - i11, 1073741824), MeasureSpec.makeMeasureSpec(i13 - i14, 1073741824));
                childAt.layout(i11, i14, i12, i13);
            }
        }
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    private static LayoutParams m11831a() {
        return new LayoutParams(0, 0, 0, 0);
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return m11831a();
    }

    private int m11832c() {
        int childCount = getChildCount();
        int i = 0;
        int i2 = 0;
        while (i < childCount) {
            int i3;
            View childAt = getChildAt(i);
            if (childAt == null || childAt.getVisibility() != 0) {
                i3 = i2;
            } else {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                i3 = Math.max(i2, layoutParams.height + layoutParams.f12990b);
            }
            i++;
            i2 = i3;
        }
        return i2;
    }
}
