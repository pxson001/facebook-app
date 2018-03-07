package com.facebook.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import com.facebook.R;
import com.google.common.base.Preconditions;

/* compiled from: com.instagram */
public class AdvancedVerticalLinearLayout extends ViewGroup {
    private int f5533a;
    public boolean f5534b;

    /* compiled from: com.instagram */
    public class LayoutParams extends android.widget.LinearLayout.LayoutParams {
        public boolean f5531a;
        public int f5532b;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AdvancedVerticalLinearLayout_Layout);
            this.f5531a = obtainStyledAttributes.getBoolean(0, false);
            this.f5532b = obtainStyledAttributes.getDimensionPixelOffset(1, 0);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public AdvancedVerticalLinearLayout(Context context) {
        super(context);
        this.f5534b = false;
    }

    public AdvancedVerticalLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AdvancedVerticalLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5534b = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AdvancedVerticalLinearLayout);
        this.f5533a = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        obtainStyledAttributes.recycle();
    }

    protected void onMeasure(int i, int i2) {
        float f = 0.0f;
        int i3 = 0;
        int childCount = getChildCount();
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        Preconditions.checkState(mode == 1073741824);
        Preconditions.checkState(mode2 == 1073741824);
        int size = MeasureSpec.getSize(i2);
        int size2 = MeasureSpec.getSize(i);
        this.f5534b = size <= this.f5533a;
        int i4 = 0;
        while (i4 < childCount) {
            float f2;
            View childAt = getChildAt(i4);
            if (childAt == null || childAt.getVisibility() == 8) {
                mode = i3;
                f2 = f;
            } else {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (this.f5534b && layoutParams.f5531a) {
                    measureChildWithMargins(childAt, i, 0, MeasureSpec.makeMeasureSpec(0, 1073741824), 0);
                    mode = i3;
                    f2 = f;
                } else {
                    f += layoutParams.weight;
                    if (layoutParams.height != 0 || layoutParams.weight <= 0.0f) {
                        measureChildWithMargins(childAt, i, 0, i2, f == 0.0f ? i3 - layoutParams.f5532b : 0);
                        mode = Math.max(i3, (((childAt.getMeasuredHeight() + i3) + layoutParams.topMargin) + layoutParams.bottomMargin) - layoutParams.f5532b);
                        f2 = f;
                    } else {
                        mode = Math.max(i3, (layoutParams.topMargin + i3) + layoutParams.bottomMargin);
                        f2 = f;
                    }
                }
            }
            i4++;
            i3 = mode;
            f = f2;
        }
        int paddingTop = size - ((getPaddingTop() + getPaddingBottom()) + i3);
        if (paddingTop != 0 && f > 0.0f) {
            int i5 = 0;
            float f3 = f;
            while (i5 < childCount) {
                View childAt2 = getChildAt(i5);
                if (childAt2.getVisibility() != 8) {
                    LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                    if (!(this.f5534b && layoutParams2.f5531a)) {
                        float f4 = layoutParams2.weight;
                        if (f4 > 0.0f) {
                            View view;
                            mode2 = (int) ((((float) paddingTop) * f4) / f3);
                            f4 = f3 - f4;
                            int i6 = paddingTop - mode2;
                            paddingTop = getChildMeasureSpec(i, ((getPaddingLeft() + getPaddingRight()) + layoutParams2.leftMargin) + layoutParams2.rightMargin, layoutParams2.width);
                            if (layoutParams2.height != 0) {
                                mode = childAt2.getMeasuredHeight() + mode2;
                                if (mode < 0) {
                                    mode = 0;
                                }
                                mode2 = paddingTop;
                                view = childAt2;
                            } else if (mode2 > 0) {
                                mode = mode2;
                                mode2 = paddingTop;
                                view = childAt2;
                            } else {
                                mode = 0;
                                mode2 = paddingTop;
                                view = childAt2;
                            }
                            view.measure(mode2, MeasureSpec.makeMeasureSpec(mode, 1073741824));
                            mode = i6;
                            f2 = f4;
                            i5++;
                            f3 = f2;
                            paddingTop = mode;
                        }
                    }
                }
                mode = paddingTop;
                f2 = f3;
                i5++;
                f3 = f2;
                paddingTop = mode;
            }
        }
        setMeasuredDimension(size2, size);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingTop = getPaddingTop();
        int paddingLeft = getPaddingLeft();
        int right = ((getRight() - getLeft()) - paddingLeft) - getPaddingRight();
        int childCount = getChildCount();
        int i5 = 0;
        while (i5 < childCount) {
            int i6;
            View childAt = getChildAt(i5);
            if (childAt == null || childAt.getVisibility() == 8) {
                i6 = paddingTop;
            } else {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i7 = ((((right - measuredWidth) / 2) + paddingLeft) + layoutParams.leftMargin) - layoutParams.rightMargin;
                paddingTop += layoutParams.topMargin - layoutParams.f5532b;
                childAt.layout(i7, paddingTop, measuredWidth + i7, paddingTop + measuredHeight);
                i6 = (layoutParams.bottomMargin + measuredHeight) + paddingTop;
            }
            i5++;
            paddingTop = i6;
        }
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

    public final boolean m10374a() {
        return this.f5534b;
    }
}
