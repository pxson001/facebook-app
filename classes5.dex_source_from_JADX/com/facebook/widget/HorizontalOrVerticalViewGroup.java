package com.facebook.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.facebook.R;
import com.facebook.debug.log.BLog;
import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;

/* compiled from: com.google.android.gms.measurement.internal.IMeasurementService */
public class HorizontalOrVerticalViewGroup extends ViewGroup {
    private static final Class<?> f5661a = HorizontalOrVerticalViewGroup.class;
    private Mode f5662b = Mode.VERTICAL;
    private int f5663c = 0;

    /* compiled from: com.google.android.gms.measurement.internal.IMeasurementService */
    public enum Mode {
        HORIZONTAL,
        VERTICAL
    }

    /* compiled from: com.google.android.gms.measurement.internal.IMeasurementService */
    public class Size {
        public final int f5659a;
        public final int f5660b;

        public Size(int i, int i2) {
            this.f5659a = i;
            this.f5660b = i2;
        }

        public String toString() {
            return Joiner.on("x").join(Integer.valueOf(this.f5659a), Integer.valueOf(this.f5660b), new Object[0]);
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof Size)) {
                return false;
            }
            Size size = (Size) obj;
            if (Objects.equal(Integer.valueOf(this.f5659a), Integer.valueOf(size.f5659a)) && Objects.equal(Integer.valueOf(this.f5660b), Integer.valueOf(size.f5660b))) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return Objects.hashCode(new Object[]{Integer.valueOf(this.f5659a), Integer.valueOf(this.f5660b)});
        }
    }

    public HorizontalOrVerticalViewGroup(Context context) {
        super(context);
        m10452a(context, null);
    }

    public HorizontalOrVerticalViewGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m10452a(context, attributeSet);
    }

    public HorizontalOrVerticalViewGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m10452a(context, attributeSet);
    }

    private final void m10452a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.HorizontalOrVerticalViewGroup);
            this.f5663c = obtainStyledAttributes.getDimensionPixelSize(0, this.f5663c);
            obtainStyledAttributes.recycle();
        }
    }

    public Mode getMode() {
        return this.f5662b;
    }

    protected void onMeasure(int i, int i2) {
        int i3 = 0;
        int childCount = getChildCount();
        Preconditions.checkState(childCount > 0, "Must have at least one child");
        Size a = m10449a(i, i2, Mode.HORIZONTAL);
        Size a2 = m10451a(a, i, i2, Mode.HORIZONTAL);
        if (a2 != null) {
            new StringBuilder("Laying out view group horizontally, size ").append(a2);
            this.f5662b = Mode.HORIZONTAL;
        } else {
            a = m10449a(i, i2, Mode.VERTICAL);
            a2 = m10451a(a, i, i2, Mode.VERTICAL);
            if (a2 != null) {
                new StringBuilder("Laying out view group vertically, size ").append(a2);
                this.f5662b = Mode.VERTICAL;
            } else {
                BLog.b(f5661a, "Children of view group " + this + " do not fit either horizontally or vertically.");
                this.f5662b = Mode.VERTICAL;
                a2 = new Size(MeasureSpec.getSize(i), MeasureSpec.getSize(i2));
            }
        }
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(a.f5659a, 1073741824);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(a.f5660b, 1073741824);
        while (i3 < childCount) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                new StringBuilder("Setting measured size of child ").append(childAt).append(" to ").append(a);
                childAt.measure(makeMeasureSpec, makeMeasureSpec2);
            }
            i3++;
        }
        setMeasuredDimension(a2.f5659a, a2.f5660b);
    }

    private Size m10449a(int i, int i2, Mode mode) {
        LayoutParams layoutParams;
        ImmutableList visibleChildren = getVisibleChildren();
        int size = visibleChildren.size();
        int i3 = this.f5663c * (size - 1);
        int i4 = Integer.MIN_VALUE;
        int i5 = Integer.MIN_VALUE;
        if (mode == Mode.HORIZONTAL) {
            layoutParams = new LayoutParams(-2, -1);
        } else {
            layoutParams = new LayoutParams(-1, -2);
        }
        for (int i6 = 0; i6 < visibleChildren.size(); i6++) {
            View view = (View) visibleChildren.get(i6);
            view.setLayoutParams(layoutParams);
            measureChild(view, i, i2);
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            new StringBuilder("Visible child ").append(i6).append(" initial measurement: ").append(measuredWidth).append("x").append(measuredHeight);
            i4 = Math.max(i4, measuredWidth);
            i5 = Math.max(i5, measuredHeight);
        }
        if (i4 == Integer.MIN_VALUE && i5 == Integer.MIN_VALUE) {
            return new Size(0, 0);
        }
        return m10450a(i, i2, mode, i4, i5, i3, size);
    }

    private static Size m10450a(int i, int i2, Mode mode, int i3, int i4, int i5, int i6) {
        if (mode != Mode.HORIZONTAL) {
            switch (MeasureSpec.getMode(i2)) {
                case Integer.MIN_VALUE:
                    i4 = Math.min(i4, (MeasureSpec.getSize(i2) - i5) / i6);
                    break;
                case 1073741824:
                    i4 = (MeasureSpec.getSize(i2) - i5) / i6;
                    break;
                default:
                    break;
            }
        }
        switch (MeasureSpec.getMode(i)) {
            case Integer.MIN_VALUE:
                i3 = Math.min(i3, (MeasureSpec.getSize(i) - i5) / i6);
                break;
            case 1073741824:
                i3 = Math.max(i3, (MeasureSpec.getSize(i) - i5) / i6);
                break;
        }
        return new Size(i3, i4);
    }

    private Size m10451a(Size size, int i, int i2, Mode mode) {
        int paddingLeft;
        int size2 = getVisibleChildren().size();
        int i3 = (size2 - 1) * this.f5663c;
        if (mode == Mode.HORIZONTAL) {
            paddingLeft = (((size2 * size.f5659a) + getPaddingLeft()) + getPaddingRight()) + i3;
            size2 = (size.f5660b + getPaddingTop()) + getPaddingBottom();
        } else {
            paddingLeft = (size.f5659a + getPaddingLeft()) + getPaddingRight();
            size2 = (((size2 * size.f5660b) + getPaddingTop()) + getPaddingBottom()) + i3;
        }
        i3 = resolveSize(Math.max(paddingLeft, getSuggestedMinimumWidth()), i);
        if (paddingLeft > i3) {
            new StringBuilder("Desired width ").append(paddingLeft).append(" > spec width ").append(i3).append(", switching modes...");
            return null;
        }
        paddingLeft = resolveSize(Math.max(size2, getSuggestedMinimumHeight()), i2);
        if (size2 <= paddingLeft) {
            return new Size(i3, paddingLeft);
        }
        new StringBuilder("Desired height ").append(size2).append(" > spec height ").append(paddingLeft);
        return null;
    }

    private ImmutableList<View> getVisibleChildren() {
        int childCount = getChildCount();
        Builder builder = ImmutableList.builder();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8) {
                builder.c(childAt);
            }
        }
        return builder.b();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        ImmutableList<View> visibleChildren = getVisibleChildren();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int i5 = paddingLeft;
        paddingLeft = paddingTop;
        for (View view : visibleChildren) {
            int measuredWidth = view.getMeasuredWidth() + i5;
            int measuredHeight = view.getMeasuredHeight() + paddingLeft;
            new StringBuilder("Laying out child ").append(view).append(" @ ").append(Joiner.on(",").join(Integer.valueOf(i5), Integer.valueOf(paddingLeft), new Object[]{Integer.valueOf(measuredWidth), Integer.valueOf(measuredHeight)}));
            view.layout(i5, paddingLeft, measuredWidth, measuredHeight);
            if (this.f5662b == Mode.HORIZONTAL) {
                i5 = this.f5663c + measuredWidth;
            } else {
                paddingLeft = this.f5663c + measuredHeight;
            }
        }
    }
}
