package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.internal.widget.TintTypedArray;
import android.support.v7.internal.widget.ViewUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.facebook.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: unit_style */
public class LinearLayoutCompat extends ViewGroup {
    public static final int HORIZONTAL = 0;
    private static final int INDEX_BOTTOM = 2;
    private static final int INDEX_CENTER_VERTICAL = 0;
    private static final int INDEX_FILL = 3;
    private static final int INDEX_TOP = 1;
    public static final int SHOW_DIVIDER_BEGINNING = 1;
    public static final int SHOW_DIVIDER_END = 4;
    public static final int SHOW_DIVIDER_MIDDLE = 2;
    public static final int SHOW_DIVIDER_NONE = 0;
    public static final int VERTICAL = 1;
    private static final int VERTICAL_GRAVITY_COUNT = 4;
    public boolean mBaselineAligned;
    private int mBaselineAlignedChildIndex;
    private int mBaselineChildTop;
    private Drawable mDivider;
    private int mDividerHeight;
    private int mDividerPadding;
    private int mDividerWidth;
    private int mGravity;
    private int[] mMaxAscent;
    private int[] mMaxDescent;
    private int mOrientation;
    private int mShowDividers;
    private int mTotalLength;
    public boolean mUseLargestChild;
    private float mWeightSum;

    /* compiled from: unit_style */
    public class LayoutParams extends MarginLayoutParams {
        public float f1293g;
        public int f1294h;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1294h = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.LinearLayoutCompat_Layout);
            this.f1293g = obtainStyledAttributes.getFloat(LinearLayoutCompat.INDEX_FILL, 0.0f);
            this.f1294h = obtainStyledAttributes.getInt(0, -1);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.f1294h = -1;
            this.f1293g = 0.0f;
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f1294h = -1;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: unit_style */
    public @interface DividerMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: unit_style */
    public @interface OrientationMode {
    }

    public LinearLayoutCompat(Context context) {
        this(context, null);
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mBaselineAligned = true;
        this.mBaselineAlignedChildIndex = -1;
        this.mBaselineChildTop = 0;
        this.mGravity = 8388659;
        TintTypedArray a = TintTypedArray.m1693a(context, attributeSet, R.styleable.LinearLayoutCompat, i, 0);
        int a2 = a.m1694a(1, -1);
        if (a2 >= 0) {
            setOrientation(a2);
        }
        a2 = a.m1694a(0, -1);
        if (a2 >= 0) {
            setGravity(a2);
        }
        boolean a3 = a.m1696a(2, true);
        if (!a3) {
            this.mBaselineAligned = a3;
        }
        this.mWeightSum = a.f1229b.getFloat(4, -1.0f);
        this.mBaselineAlignedChildIndex = a.m1694a((int) INDEX_FILL, -1);
        this.mUseLargestChild = a.m1696a(5, false);
        setDividerDrawable(a.m1695a(8));
        this.mShowDividers = a.m1694a(6, 0);
        this.mDividerPadding = a.m1701d(7, 0);
        a.m1698b();
    }

    public void setShowDividers(int i) {
        if (i != this.mShowDividers) {
            requestLayout();
        }
        this.mShowDividers = i;
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public int getShowDividers() {
        return this.mShowDividers;
    }

    public Drawable getDividerDrawable() {
        return this.mDivider;
    }

    public void setDividerDrawable(Drawable drawable) {
        boolean z = false;
        if (drawable != this.mDivider) {
            this.mDivider = drawable;
            if (drawable != null) {
                this.mDividerWidth = drawable.getIntrinsicWidth();
                this.mDividerHeight = drawable.getIntrinsicHeight();
            } else {
                this.mDividerWidth = 0;
                this.mDividerHeight = 0;
            }
            if (drawable == null) {
                z = true;
            }
            setWillNotDraw(z);
            requestLayout();
        }
    }

    public void setDividerPadding(int i) {
        this.mDividerPadding = i;
    }

    public int getDividerPadding() {
        return this.mDividerPadding;
    }

    public int getDividerWidth() {
        return this.mDividerWidth;
    }

    protected void onDraw(Canvas canvas) {
        if (this.mDivider != null) {
            if (this.mOrientation == 1) {
                drawDividersVertical(canvas);
            } else {
                drawDividersHorizontal(canvas);
            }
        }
    }

    void drawDividersVertical(Canvas canvas) {
        int virtualChildCount = getVirtualChildCount();
        int i = 0;
        while (i < virtualChildCount) {
            View virtualChildAt = getVirtualChildAt(i);
            if (!(virtualChildAt == null || virtualChildAt.getVisibility() == 8 || !hasDividerBeforeChildAt(i))) {
                drawHorizontalDivider(canvas, (virtualChildAt.getTop() - ((LayoutParams) virtualChildAt.getLayoutParams()).topMargin) - this.mDividerHeight);
            }
            i++;
        }
        if (hasDividerBeforeChildAt(virtualChildCount)) {
            int height;
            View virtualChildAt2 = getVirtualChildAt(virtualChildCount - 1);
            if (virtualChildAt2 == null) {
                height = (getHeight() - getPaddingBottom()) - this.mDividerHeight;
            } else {
                LayoutParams layoutParams = (LayoutParams) virtualChildAt2.getLayoutParams();
                height = layoutParams.bottomMargin + virtualChildAt2.getBottom();
            }
            drawHorizontalDivider(canvas, height);
        }
    }

    void drawDividersHorizontal(Canvas canvas) {
        LayoutParams layoutParams;
        int virtualChildCount = getVirtualChildCount();
        boolean a = ViewUtils.m1756a(this);
        int i = 0;
        while (i < virtualChildCount) {
            int right;
            View virtualChildAt = getVirtualChildAt(i);
            if (!(virtualChildAt == null || virtualChildAt.getVisibility() == 8 || !hasDividerBeforeChildAt(i))) {
                layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                if (a) {
                    right = layoutParams.rightMargin + virtualChildAt.getRight();
                } else {
                    right = (virtualChildAt.getLeft() - layoutParams.leftMargin) - this.mDividerWidth;
                }
                drawVerticalDivider(canvas, right);
            }
            i++;
        }
        if (hasDividerBeforeChildAt(virtualChildCount)) {
            View virtualChildAt2 = getVirtualChildAt(virtualChildCount - 1);
            if (virtualChildAt2 != null) {
                layoutParams = (LayoutParams) virtualChildAt2.getLayoutParams();
                if (a) {
                    right = (virtualChildAt2.getLeft() - layoutParams.leftMargin) - this.mDividerWidth;
                } else {
                    right = layoutParams.rightMargin + virtualChildAt2.getRight();
                }
            } else if (a) {
                right = getPaddingLeft();
            } else {
                right = (getWidth() - getPaddingRight()) - this.mDividerWidth;
            }
            drawVerticalDivider(canvas, right);
        }
    }

    void drawHorizontalDivider(Canvas canvas, int i) {
        this.mDivider.setBounds(getPaddingLeft() + this.mDividerPadding, i, (getWidth() - getPaddingRight()) - this.mDividerPadding, this.mDividerHeight + i);
        this.mDivider.draw(canvas);
    }

    void drawVerticalDivider(Canvas canvas, int i) {
        this.mDivider.setBounds(i, getPaddingTop() + this.mDividerPadding, this.mDividerWidth + i, (getHeight() - getPaddingBottom()) - this.mDividerPadding);
        this.mDivider.draw(canvas);
    }

    public boolean isBaselineAligned() {
        return this.mBaselineAligned;
    }

    public void setBaselineAligned(boolean z) {
        this.mBaselineAligned = z;
    }

    public boolean isMeasureWithLargestChildEnabled() {
        return this.mUseLargestChild;
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.mUseLargestChild = z;
    }

    public int getBaseline() {
        if (this.mBaselineAlignedChildIndex < 0) {
            return super.getBaseline();
        }
        if (getChildCount() <= this.mBaselineAlignedChildIndex) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(this.mBaselineAlignedChildIndex);
        int baseline = childAt.getBaseline();
        if (baseline != -1) {
            int i;
            int i2 = this.mBaselineChildTop;
            if (this.mOrientation == 1) {
                i = this.mGravity & 112;
                if (i != 48) {
                    switch (i) {
                        case 16:
                            i = i2 + (((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.mTotalLength) / 2);
                            break;
                        case 80:
                            i = ((getBottom() - getTop()) - getPaddingBottom()) - this.mTotalLength;
                            break;
                    }
                }
            }
            i = i2;
            return (((LayoutParams) childAt.getLayoutParams()).topMargin + i) + baseline;
        } else if (this.mBaselineAlignedChildIndex == 0) {
            return -1;
        } else {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
    }

    public int getBaselineAlignedChildIndex() {
        return this.mBaselineAlignedChildIndex;
    }

    public void setBaselineAlignedChildIndex(int i) {
        if (i < 0 || i >= getChildCount()) {
            throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
        }
        this.mBaselineAlignedChildIndex = i;
    }

    View getVirtualChildAt(int i) {
        return getChildAt(i);
    }

    int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.mWeightSum;
    }

    public void setWeightSum(float f) {
        this.mWeightSum = Math.max(0.0f, f);
    }

    protected void onMeasure(int i, int i2) {
        if (this.mOrientation == 1) {
            measureVertical(i, i2);
        } else {
            measureHorizontal(i, i2);
        }
    }

    protected boolean hasDividerBeforeChildAt(int i) {
        if (i == 0) {
            if ((this.mShowDividers & 1) != 0) {
                return true;
            }
            return false;
        } else if (i == getChildCount()) {
            if ((this.mShowDividers & 4) == 0) {
                return false;
            }
            return true;
        } else if ((this.mShowDividers & 2) == 0) {
            return false;
        } else {
            for (int i2 = i - 1; i2 >= 0; i2--) {
                if (getChildAt(i2).getVisibility() != 8) {
                    return true;
                }
            }
            return false;
        }
    }

    void measureVertical(int i, int i2) {
        int i3;
        int i4;
        Object obj;
        int i5;
        int i6;
        int i7;
        View virtualChildAt;
        this.mTotalLength = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        Object obj2 = 1;
        float f = 0.0f;
        int virtualChildCount = getVirtualChildCount();
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        Object obj3 = null;
        Object obj4 = null;
        int i12 = this.mBaselineAlignedChildIndex;
        boolean z = this.mUseLargestChild;
        int i13 = Integer.MIN_VALUE;
        int i14 = 0;
        while (i14 < virtualChildCount) {
            int i15;
            int measuredWidth;
            View virtualChildAt2 = getVirtualChildAt(i14);
            if (virtualChildAt2 == null) {
                this.mTotalLength += measureNullChild(i14);
            } else {
                Object obj5;
                float f2;
                if (virtualChildAt2.getVisibility() != 8) {
                    if (hasDividerBeforeChildAt(i14)) {
                        this.mTotalLength += this.mDividerHeight;
                    }
                    LayoutParams layoutParams = (LayoutParams) virtualChildAt2.getLayoutParams();
                    float f3 = f + layoutParams.f1293g;
                    if (mode2 == 1073741824 && layoutParams.height == 0 && layoutParams.f1293g > 0.0f) {
                        i3 = this.mTotalLength;
                        this.mTotalLength = Math.max(i3, (layoutParams.topMargin + i3) + layoutParams.bottomMargin);
                        obj4 = 1;
                    } else {
                        i3 = Integer.MIN_VALUE;
                        if (layoutParams.height == 0 && layoutParams.f1293g > 0.0f) {
                            i3 = 0;
                            layoutParams.height = -2;
                        }
                        i4 = i3;
                        measureChildBeforeLayout(virtualChildAt2, i14, i, 0, i2, f3 == 0.0f ? this.mTotalLength : 0);
                        if (i4 != Integer.MIN_VALUE) {
                            layoutParams.height = i4;
                        }
                        i3 = virtualChildAt2.getMeasuredHeight();
                        int i16 = this.mTotalLength;
                        this.mTotalLength = Math.max(i16, (((i16 + i3) + layoutParams.topMargin) + layoutParams.bottomMargin) + getNextLocationOffset(virtualChildAt2));
                        if (z) {
                            i13 = Math.max(i3, i13);
                        }
                    }
                    if (i12 >= 0 && i12 == i14 + 1) {
                        this.mBaselineChildTop = this.mTotalLength;
                    }
                    if (i14 >= i12 || layoutParams.f1293g <= 0.0f) {
                        Object obj6 = null;
                        if (mode == 1073741824 || layoutParams.width != -1) {
                            obj5 = obj3;
                        } else {
                            obj5 = 1;
                            obj6 = 1;
                        }
                        i15 = layoutParams.rightMargin + layoutParams.leftMargin;
                        measuredWidth = virtualChildAt2.getMeasuredWidth() + i15;
                        i8 = Math.max(i8, measuredWidth);
                        int a = ViewUtils.m1753a(i9, ViewCompat.m(virtualChildAt2));
                        Object obj7 = (obj2 == null || layoutParams.width != -1) ? null : 1;
                        if (layoutParams.f1293g > 0.0f) {
                            if (obj6 != null) {
                                i3 = i15;
                            } else {
                                i3 = measuredWidth;
                            }
                            obj = obj7;
                            measuredWidth = Math.max(i11, i3);
                            i5 = i10;
                            f2 = f3;
                            i3 = i13;
                            i13 = a;
                            obj3 = obj5;
                            obj5 = obj4;
                            i6 = i8;
                        } else {
                            if (obj6 == null) {
                                i15 = measuredWidth;
                            }
                            i3 = Math.max(i10, i15);
                            obj = obj7;
                            measuredWidth = i11;
                            i5 = i3;
                            f2 = f3;
                            i3 = i13;
                            i13 = a;
                            obj3 = obj5;
                            obj5 = obj4;
                            i6 = i8;
                        }
                    } else {
                        throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                    }
                }
                i3 = i13;
                f2 = f;
                obj = obj2;
                measuredWidth = i11;
                i5 = i10;
                obj5 = obj4;
                i13 = i9;
                i6 = i8;
                i14 += getChildrenSkipCount(virtualChildAt2, i14);
                obj2 = obj;
                i11 = measuredWidth;
                i10 = i5;
                i9 = i13;
                i8 = i6;
                i13 = i3;
                obj4 = obj5;
                f = f2;
            }
            i14++;
        }
        if (this.mTotalLength > 0 && hasDividerBeforeChildAt(virtualChildCount)) {
            this.mTotalLength += this.mDividerHeight;
        }
        if (z && (mode2 == Integer.MIN_VALUE || mode2 == 0)) {
            this.mTotalLength = 0;
            i7 = 0;
            while (i7 < virtualChildCount) {
                virtualChildAt = getVirtualChildAt(i7);
                if (virtualChildAt == null) {
                    this.mTotalLength += measureNullChild(i7);
                    i3 = i7;
                } else if (virtualChildAt.getVisibility() == 8) {
                    i3 = getChildrenSkipCount(virtualChildAt, i7) + i7;
                } else {
                    LayoutParams layoutParams2 = (LayoutParams) virtualChildAt.getLayoutParams();
                    int i17 = this.mTotalLength;
                    this.mTotalLength = Math.max(i17, (layoutParams2.bottomMargin + ((i17 + i13) + layoutParams2.topMargin)) + getNextLocationOffset(virtualChildAt));
                    i3 = i7;
                }
                i7 = i3 + 1;
            }
        }
        this.mTotalLength += getPaddingTop() + getPaddingBottom();
        i4 = ViewCompat.a(Math.max(this.mTotalLength, getSuggestedMinimumHeight()), i2, 0);
        i14 = (16777215 & i4) - this.mTotalLength;
        if (obj4 != null || (i14 != 0 && f > 0.0f)) {
            if (this.mWeightSum > 0.0f) {
                f = this.mWeightSum;
            }
            this.mTotalLength = 0;
            Object obj8 = obj2;
            i6 = i10;
            i5 = i9;
            int i18 = i8;
            int i19 = 0;
            int i20 = i14;
            float f4 = f;
            i16 = i20;
            while (i19 < virtualChildCount) {
                float f5;
                View virtualChildAt3 = getVirtualChildAt(i19);
                if (virtualChildAt3.getVisibility() != 8) {
                    layoutParams2 = (LayoutParams) virtualChildAt3.getLayoutParams();
                    float f6 = layoutParams2.f1293g;
                    if (f6 > 0.0f) {
                        View view;
                        i7 = (int) ((((float) i16) * f6) / f4);
                        f6 = f4 - f6;
                        measuredWidth = i16 - i7;
                        i14 = getChildMeasureSpec(i, ((getPaddingLeft() + getPaddingRight()) + layoutParams2.leftMargin) + layoutParams2.rightMargin, layoutParams2.width);
                        if (layoutParams2.height != 0 || mode2 != 1073741824) {
                            i7 += virtualChildAt3.getMeasuredHeight();
                            if (i7 < 0) {
                                i7 = 0;
                            }
                            view = virtualChildAt3;
                        } else if (i7 > 0) {
                            view = virtualChildAt3;
                        } else {
                            i7 = 0;
                            view = virtualChildAt3;
                        }
                        view.measure(i14, MeasureSpec.makeMeasureSpec(i7, 1073741824));
                        i14 = measuredWidth;
                        i16 = ViewUtils.m1753a(i5, ViewCompat.m(virtualChildAt3) & -256);
                        f5 = f6;
                    } else {
                        f5 = f4;
                        i14 = i16;
                        i16 = i5;
                    }
                    i15 = layoutParams2.leftMargin + layoutParams2.rightMargin;
                    measuredWidth = virtualChildAt3.getMeasuredWidth() + i15;
                    i5 = Math.max(i18, measuredWidth);
                    Object obj9 = (mode == 1073741824 || layoutParams2.width != -1) ? null : 1;
                    if (obj9 == null) {
                        i15 = measuredWidth;
                    }
                    measuredWidth = Math.max(i6, i15);
                    obj = (obj8 == null || layoutParams2.width != -1) ? null : 1;
                    i13 = this.mTotalLength;
                    this.mTotalLength = Math.max(i13, (layoutParams2.bottomMargin + ((virtualChildAt3.getMeasuredHeight() + i13) + layoutParams2.topMargin)) + getNextLocationOffset(virtualChildAt3));
                    i3 = measuredWidth;
                    i17 = i5;
                } else {
                    f5 = f4;
                    obj = obj8;
                    i3 = i6;
                    i17 = i18;
                    i14 = i16;
                    i16 = i5;
                }
                i19++;
                obj8 = obj;
                i6 = i3;
                i5 = i16;
                i18 = i17;
                i16 = i14;
                f4 = f5;
            }
            this.mTotalLength += getPaddingTop() + getPaddingBottom();
            obj2 = obj8;
            i3 = i6;
            i9 = i5;
            i7 = i18;
        } else {
            i6 = Math.max(i10, i11);
            if (z && mode2 != 1073741824) {
                for (i7 = 0; i7 < virtualChildCount; i7++) {
                    virtualChildAt = getVirtualChildAt(i7);
                    if (!(virtualChildAt == null || virtualChildAt.getVisibility() == 8 || ((LayoutParams) virtualChildAt.getLayoutParams()).f1293g <= 0.0f)) {
                        virtualChildAt.measure(MeasureSpec.makeMeasureSpec(virtualChildAt.getMeasuredWidth(), 1073741824), MeasureSpec.makeMeasureSpec(i13, 1073741824));
                    }
                }
            }
            i3 = i6;
            i7 = i8;
        }
        if (obj2 != null || mode == 1073741824) {
            i3 = i7;
        }
        setMeasuredDimension(ViewCompat.a(Math.max(i3 + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), i, i9), i4);
        if (obj3 != null) {
            forceUniformWidth(virtualChildCount, i2);
        }
    }

    private void forceUniformWidth(int i, int i2) {
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View virtualChildAt = getVirtualChildAt(i3);
            if (virtualChildAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                if (layoutParams.width == -1) {
                    int i4 = layoutParams.height;
                    layoutParams.height = virtualChildAt.getMeasuredHeight();
                    measureChildWithMargins(virtualChildAt, makeMeasureSpec, 0, i2, 0);
                    layoutParams.height = i4;
                }
            }
        }
    }

    void measureHorizontal(int i, int i2) {
        Object obj;
        int i3;
        int i4;
        int i5;
        int i6;
        View virtualChildAt;
        LayoutParams layoutParams;
        this.mTotalLength = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        Object obj2 = 1;
        float f = 0.0f;
        int virtualChildCount = getVirtualChildCount();
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        Object obj3 = null;
        Object obj4 = null;
        if (this.mMaxAscent == null || this.mMaxDescent == null) {
            this.mMaxAscent = new int[4];
            this.mMaxDescent = new int[4];
        }
        int[] iArr = this.mMaxAscent;
        int[] iArr2 = this.mMaxDescent;
        iArr[INDEX_FILL] = -1;
        iArr[2] = -1;
        iArr[1] = -1;
        iArr[0] = -1;
        iArr2[INDEX_FILL] = -1;
        iArr2[2] = -1;
        iArr2[1] = -1;
        iArr2[0] = -1;
        boolean z = this.mBaselineAligned;
        boolean z2 = this.mUseLargestChild;
        if (mode == 1073741824) {
            obj = 1;
        } else {
            obj = null;
        }
        int i11 = Integer.MIN_VALUE;
        int i12 = 0;
        while (i12 < virtualChildCount) {
            int i13;
            int measuredHeight;
            int i14;
            View virtualChildAt2 = getVirtualChildAt(i12);
            if (virtualChildAt2 == null) {
                this.mTotalLength += measureNullChild(i12);
            } else {
                Object obj5;
                Object obj6;
                int i15;
                float f2;
                if (virtualChildAt2.getVisibility() != 8) {
                    if (hasDividerBeforeChildAt(i12)) {
                        this.mTotalLength += this.mDividerWidth;
                    }
                    LayoutParams layoutParams2 = (LayoutParams) virtualChildAt2.getLayoutParams();
                    float f3 = f + layoutParams2.f1293g;
                    if (mode == 1073741824 && layoutParams2.width == 0 && layoutParams2.f1293g > 0.0f) {
                        if (obj != null) {
                            this.mTotalLength += layoutParams2.leftMargin + layoutParams2.rightMargin;
                        } else {
                            i3 = this.mTotalLength;
                            this.mTotalLength = Math.max(i3, (layoutParams2.leftMargin + i3) + layoutParams2.rightMargin);
                        }
                        if (z) {
                            i3 = MeasureSpec.makeMeasureSpec(0, 0);
                            virtualChildAt2.measure(i3, i3);
                        } else {
                            obj4 = 1;
                        }
                    } else {
                        i3 = Integer.MIN_VALUE;
                        if (layoutParams2.width == 0 && layoutParams2.f1293g > 0.0f) {
                            i3 = 0;
                            layoutParams2.width = -2;
                        }
                        int i16 = i3;
                        measureChildBeforeLayout(virtualChildAt2, i12, i, f3 == 0.0f ? this.mTotalLength : 0, i2, 0);
                        if (i16 != Integer.MIN_VALUE) {
                            layoutParams2.width = i16;
                        }
                        i3 = virtualChildAt2.getMeasuredWidth();
                        if (obj != null) {
                            this.mTotalLength += ((layoutParams2.leftMargin + i3) + layoutParams2.rightMargin) + getNextLocationOffset(virtualChildAt2);
                        } else {
                            int i17 = this.mTotalLength;
                            this.mTotalLength = Math.max(i17, (((i17 + i3) + layoutParams2.leftMargin) + layoutParams2.rightMargin) + getNextLocationOffset(virtualChildAt2));
                        }
                        if (z2) {
                            i11 = Math.max(i3, i11);
                        }
                    }
                    Object obj7 = null;
                    if (mode2 == 1073741824 || layoutParams2.height != -1) {
                        obj5 = obj3;
                    } else {
                        obj5 = 1;
                        obj7 = 1;
                    }
                    i13 = layoutParams2.bottomMargin + layoutParams2.topMargin;
                    measuredHeight = virtualChildAt2.getMeasuredHeight() + i13;
                    int a = ViewUtils.m1753a(i8, ViewCompat.m(virtualChildAt2));
                    if (z) {
                        i8 = virtualChildAt2.getBaseline();
                        if (i8 != -1) {
                            i4 = ((((layoutParams2.f1294h < 0 ? this.mGravity : layoutParams2.f1294h) & 112) >> 4) & -2) >> 1;
                            iArr[i4] = Math.max(iArr[i4], i8);
                            iArr2[i4] = Math.max(iArr2[i4], measuredHeight - i8);
                        }
                    }
                    i8 = Math.max(i7, measuredHeight);
                    Object obj8 = (obj2 == null || layoutParams2.height != -1) ? null : 1;
                    if (layoutParams2.f1293g > 0.0f) {
                        if (obj7 != null) {
                            i3 = i13;
                        } else {
                            i3 = measuredHeight;
                        }
                        obj6 = obj8;
                        measuredHeight = Math.max(i10, i3);
                        i15 = i9;
                        f2 = f3;
                        i3 = i11;
                        i11 = a;
                        obj3 = obj5;
                        obj5 = obj4;
                        i14 = i8;
                    } else {
                        if (obj7 == null) {
                            i13 = measuredHeight;
                        }
                        i3 = Math.max(i9, i13);
                        obj6 = obj8;
                        measuredHeight = i10;
                        i15 = i3;
                        f2 = f3;
                        i3 = i11;
                        i11 = a;
                        obj3 = obj5;
                        obj5 = obj4;
                        i14 = i8;
                    }
                } else {
                    i3 = i11;
                    f2 = f;
                    obj6 = obj2;
                    measuredHeight = i10;
                    i15 = i9;
                    obj5 = obj4;
                    i11 = i8;
                    i14 = i7;
                }
                i12 += getChildrenSkipCount(virtualChildAt2, i12);
                obj2 = obj6;
                i10 = measuredHeight;
                i9 = i15;
                i8 = i11;
                i7 = i14;
                i11 = i3;
                obj4 = obj5;
                f = f2;
            }
            i12++;
        }
        if (this.mTotalLength > 0 && hasDividerBeforeChildAt(virtualChildCount)) {
            this.mTotalLength += this.mDividerWidth;
        }
        if (iArr[1] == -1 && iArr[0] == -1 && iArr[2] == -1 && iArr[INDEX_FILL] == -1) {
            i5 = i7;
        } else {
            i5 = Math.max(i7, Math.max(iArr[INDEX_FILL], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))) + Math.max(iArr2[INDEX_FILL], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))));
        }
        if (z2 && (mode == Integer.MIN_VALUE || mode == 0)) {
            this.mTotalLength = 0;
            i6 = 0;
            while (i6 < virtualChildCount) {
                virtualChildAt = getVirtualChildAt(i6);
                if (virtualChildAt == null) {
                    this.mTotalLength += measureNullChild(i6);
                    i3 = i6;
                } else if (virtualChildAt.getVisibility() == 8) {
                    i3 = getChildrenSkipCount(virtualChildAt, i6) + i6;
                } else {
                    layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                    if (obj != null) {
                        this.mTotalLength = ((layoutParams.rightMargin + (layoutParams.leftMargin + i11)) + getNextLocationOffset(virtualChildAt)) + this.mTotalLength;
                        i3 = i6;
                    } else {
                        i4 = this.mTotalLength;
                        this.mTotalLength = Math.max(i4, (layoutParams.rightMargin + ((i4 + i11) + layoutParams.leftMargin)) + getNextLocationOffset(virtualChildAt));
                        i3 = i6;
                    }
                }
                i6 = i3 + 1;
            }
        }
        this.mTotalLength += getPaddingLeft() + getPaddingRight();
        i7 = ViewCompat.a(Math.max(this.mTotalLength, getSuggestedMinimumWidth()), i, 0);
        i4 = (16777215 & i7) - this.mTotalLength;
        View virtualChildAt3;
        if (obj4 != null || (i4 != 0 && f > 0.0f)) {
            if (this.mWeightSum > 0.0f) {
                f = this.mWeightSum;
            }
            iArr[INDEX_FILL] = -1;
            iArr[2] = -1;
            iArr[1] = -1;
            iArr[0] = -1;
            iArr2[INDEX_FILL] = -1;
            iArr2[2] = -1;
            iArr2[1] = -1;
            iArr2[0] = -1;
            i5 = -1;
            this.mTotalLength = 0;
            float f4 = f;
            Object obj9 = obj2;
            i11 = i9;
            i13 = i8;
            int i18 = 0;
            while (i18 < virtualChildCount) {
                float f5;
                Object obj10;
                virtualChildAt3 = getVirtualChildAt(i18);
                if (virtualChildAt3 == null || virtualChildAt3.getVisibility() == 8) {
                    f5 = f4;
                    i6 = i4;
                    i17 = i11;
                    obj10 = obj9;
                    i4 = i13;
                    i13 = i5;
                } else {
                    float f6;
                    layoutParams = (LayoutParams) virtualChildAt3.getLayoutParams();
                    float f7 = layoutParams.f1293g;
                    if (f7 > 0.0f) {
                        i6 = (int) ((((float) i4) * f7) / f4);
                        f7 = f4 - f7;
                        i4 -= i6;
                        i14 = getChildMeasureSpec(i2, ((getPaddingTop() + getPaddingBottom()) + layoutParams.topMargin) + layoutParams.bottomMargin, layoutParams.height);
                        if (layoutParams.width != 0 || mode != 1073741824) {
                            i6 += virtualChildAt3.getMeasuredWidth();
                            if (i6 < 0) {
                                i6 = 0;
                            }
                            virtualChildAt = virtualChildAt3;
                        } else if (i6 > 0) {
                            virtualChildAt = virtualChildAt3;
                        } else {
                            i6 = 0;
                            virtualChildAt = virtualChildAt3;
                        }
                        virtualChildAt.measure(MeasureSpec.makeMeasureSpec(i6, 1073741824), i14);
                        i14 = ViewUtils.m1753a(i13, ViewCompat.m(virtualChildAt3) & -16777216);
                        f6 = f7;
                        measuredHeight = i4;
                    } else {
                        measuredHeight = i4;
                        i14 = i13;
                        f6 = f4;
                    }
                    if (obj != null) {
                        this.mTotalLength += ((virtualChildAt3.getMeasuredWidth() + layoutParams.leftMargin) + layoutParams.rightMargin) + getNextLocationOffset(virtualChildAt3);
                    } else {
                        i6 = this.mTotalLength;
                        this.mTotalLength = Math.max(i6, (((virtualChildAt3.getMeasuredWidth() + i6) + layoutParams.leftMargin) + layoutParams.rightMargin) + getNextLocationOffset(virtualChildAt3));
                    }
                    Object obj11 = (mode2 == 1073741824 || layoutParams.height != -1) ? null : 1;
                    i12 = layoutParams.topMargin + layoutParams.bottomMargin;
                    i4 = virtualChildAt3.getMeasuredHeight() + i12;
                    i5 = Math.max(i5, i4);
                    if (obj11 != null) {
                        i6 = i12;
                    } else {
                        i6 = i4;
                    }
                    i12 = Math.max(i11, i6);
                    obj11 = (obj9 == null || layoutParams.height != -1) ? null : 1;
                    if (z) {
                        i17 = virtualChildAt3.getBaseline();
                        if (i17 != -1) {
                            i3 = ((((layoutParams.f1294h < 0 ? this.mGravity : layoutParams.f1294h) & 112) >> 4) & -2) >> 1;
                            iArr[i3] = Math.max(iArr[i3], i17);
                            iArr2[i3] = Math.max(iArr2[i3], i4 - i17);
                        }
                    }
                    f5 = f6;
                    i17 = i12;
                    i4 = i14;
                    obj10 = obj11;
                    i13 = i5;
                    i6 = measuredHeight;
                }
                i18++;
                obj9 = obj10;
                i11 = i17;
                i5 = i13;
                i13 = i4;
                f4 = f5;
                i4 = i6;
            }
            this.mTotalLength += getPaddingLeft() + getPaddingRight();
            if (!(iArr[1] == -1 && iArr[0] == -1 && iArr[2] == -1 && iArr[INDEX_FILL] == -1)) {
                i5 = Math.max(i5, Math.max(iArr[INDEX_FILL], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))) + Math.max(iArr2[INDEX_FILL], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))));
            }
            obj2 = obj9;
            i3 = i11;
            i8 = i13;
            i6 = i5;
        } else {
            i6 = Math.max(i9, i10);
            if (z2 && mode != 1073741824) {
                for (i12 = 0; i12 < virtualChildCount; i12++) {
                    virtualChildAt3 = getVirtualChildAt(i12);
                    if (!(virtualChildAt3 == null || virtualChildAt3.getVisibility() == 8 || ((LayoutParams) virtualChildAt3.getLayoutParams()).f1293g <= 0.0f)) {
                        virtualChildAt3.measure(MeasureSpec.makeMeasureSpec(i11, 1073741824), MeasureSpec.makeMeasureSpec(virtualChildAt3.getMeasuredHeight(), 1073741824));
                    }
                }
            }
            i3 = i6;
            i6 = i5;
        }
        if (obj2 != null || mode2 == 1073741824) {
            i3 = i6;
        }
        setMeasuredDimension((-16777216 & i8) | i7, ViewCompat.a(Math.max(i3 + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight()), i2, i8 << 16));
        if (obj3 != null) {
            forceUniformHeight(virtualChildCount, i);
        }
    }

    private void forceUniformHeight(int i, int i2) {
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View virtualChildAt = getVirtualChildAt(i3);
            if (virtualChildAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                if (layoutParams.height == -1) {
                    int i4 = layoutParams.width;
                    layoutParams.width = virtualChildAt.getMeasuredWidth();
                    measureChildWithMargins(virtualChildAt, i2, 0, makeMeasureSpec, 0);
                    layoutParams.width = i4;
                }
            }
        }
    }

    int getChildrenSkipCount(View view, int i) {
        return 0;
    }

    int measureNullChild(int i) {
        return 0;
    }

    void measureChildBeforeLayout(View view, int i, int i2, int i3, int i4, int i5) {
        measureChildWithMargins(view, i2, i3, i4, i5);
    }

    int getLocationOffset(View view) {
        return 0;
    }

    int getNextLocationOffset(View view) {
        return 0;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.mOrientation == 1) {
            layoutVertical(i, i2, i3, i4);
        } else {
            layoutHorizontal(i, i2, i3, i4);
        }
    }

    void layoutVertical(int i, int i2, int i3, int i4) {
        int paddingLeft = getPaddingLeft();
        int i5 = i3 - i;
        int paddingRight = i5 - getPaddingRight();
        int paddingRight2 = (i5 - paddingLeft) - getPaddingRight();
        int virtualChildCount = getVirtualChildCount();
        int i6 = this.mGravity & 8388615;
        switch (this.mGravity & 112) {
            case 16:
                i5 = getPaddingTop() + (((i4 - i2) - this.mTotalLength) / 2);
                break;
            case 80:
                i5 = ((getPaddingTop() + i4) - i2) - this.mTotalLength;
                break;
            default:
                i5 = getPaddingTop();
                break;
        }
        int i7 = 0;
        int i8 = i5;
        while (i7 < virtualChildCount) {
            View virtualChildAt = getVirtualChildAt(i7);
            if (virtualChildAt == null) {
                i8 += measureNullChild(i7);
                i5 = i7;
            } else if (virtualChildAt.getVisibility() != 8) {
                int i9;
                int measuredWidth = virtualChildAt.getMeasuredWidth();
                int measuredHeight = virtualChildAt.getMeasuredHeight();
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                i5 = layoutParams.f1294h;
                if (i5 < 0) {
                    i5 = i6;
                }
                switch (GravityCompat.a(i5, ViewCompat.h(this)) & 7) {
                    case 1:
                        i9 = ((((paddingRight2 - measuredWidth) / 2) + paddingLeft) + layoutParams.leftMargin) - layoutParams.rightMargin;
                        break;
                    case 5:
                        i9 = (paddingRight - measuredWidth) - layoutParams.rightMargin;
                        break;
                    default:
                        i9 = paddingLeft + layoutParams.leftMargin;
                        break;
                }
                if (hasDividerBeforeChildAt(i7)) {
                    i5 = this.mDividerHeight + i8;
                } else {
                    i5 = i8;
                }
                int i10 = i5 + layoutParams.topMargin;
                setChildFrame(virtualChildAt, i9, i10 + getLocationOffset(virtualChildAt), measuredWidth, measuredHeight);
                i8 = i10 + ((layoutParams.bottomMargin + measuredHeight) + getNextLocationOffset(virtualChildAt));
                i5 = getChildrenSkipCount(virtualChildAt, i7) + i7;
            } else {
                i5 = i7;
            }
            i7 = i5 + 1;
        }
    }

    void layoutHorizontal(int i, int i2, int i3, int i4) {
        int paddingLeft;
        int i5;
        int i6;
        boolean a = ViewUtils.m1756a(this);
        int paddingTop = getPaddingTop();
        int i7 = i4 - i2;
        int paddingBottom = i7 - getPaddingBottom();
        int paddingBottom2 = (i7 - paddingTop) - getPaddingBottom();
        int virtualChildCount = getVirtualChildCount();
        i7 = this.mGravity & 8388615;
        int i8 = this.mGravity & 112;
        boolean z = this.mBaselineAligned;
        int[] iArr = this.mMaxAscent;
        int[] iArr2 = this.mMaxDescent;
        switch (GravityCompat.a(i7, ViewCompat.h(this))) {
            case 1:
                paddingLeft = getPaddingLeft() + (((i3 - i) - this.mTotalLength) / 2);
                break;
            case 5:
                paddingLeft = ((getPaddingLeft() + i3) - i) - this.mTotalLength;
                break;
            default:
                paddingLeft = getPaddingLeft();
                break;
        }
        if (a) {
            i5 = -1;
            i6 = virtualChildCount - 1;
        } else {
            i5 = 1;
            i6 = 0;
        }
        int i9 = 0;
        while (i9 < virtualChildCount) {
            int i10 = i6 + (i5 * i9);
            View virtualChildAt = getVirtualChildAt(i10);
            if (virtualChildAt == null) {
                paddingLeft += measureNullChild(i10);
                i7 = i9;
            } else if (virtualChildAt.getVisibility() != 8) {
                int i11;
                int measuredWidth = virtualChildAt.getMeasuredWidth();
                int measuredHeight = virtualChildAt.getMeasuredHeight();
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                if (!z || layoutParams.height == -1) {
                    i7 = -1;
                } else {
                    i7 = virtualChildAt.getBaseline();
                }
                int i12 = layoutParams.f1294h;
                if (i12 < 0) {
                    i12 = i8;
                }
                switch (i12 & 112) {
                    case 16:
                        i11 = ((((paddingBottom2 - measuredHeight) / 2) + paddingTop) + layoutParams.topMargin) - layoutParams.bottomMargin;
                        break;
                    case 48:
                        i11 = paddingTop + layoutParams.topMargin;
                        if (i7 != -1) {
                            i11 += iArr[1] - i7;
                            break;
                        }
                        break;
                    case 80:
                        i11 = (paddingBottom - measuredHeight) - layoutParams.bottomMargin;
                        if (i7 != -1) {
                            i11 -= iArr2[2] - (virtualChildAt.getMeasuredHeight() - i7);
                            break;
                        }
                        break;
                    default:
                        i11 = paddingTop;
                        break;
                }
                if (hasDividerBeforeChildAt(i10)) {
                    i7 = this.mDividerWidth + paddingLeft;
                } else {
                    i7 = paddingLeft;
                }
                paddingLeft = i7 + layoutParams.leftMargin;
                setChildFrame(virtualChildAt, paddingLeft + getLocationOffset(virtualChildAt), i11, measuredWidth, measuredHeight);
                paddingLeft += (layoutParams.rightMargin + measuredWidth) + getNextLocationOffset(virtualChildAt);
                i7 = getChildrenSkipCount(virtualChildAt, i10) + i9;
            } else {
                i7 = i9;
            }
            i9 = i7 + 1;
        }
    }

    private void setChildFrame(View view, int i, int i2, int i3, int i4) {
        view.layout(i, i2, i + i3, i2 + i4);
    }

    public void setOrientation(int i) {
        if (this.mOrientation != i) {
            this.mOrientation = i;
            requestLayout();
        }
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public void setGravity(int i) {
        if (this.mGravity != i) {
            int i2;
            if ((8388615 & i) == 0) {
                i2 = 8388611 | i;
            } else {
                i2 = i;
            }
            if ((i2 & 112) == 0) {
                i2 |= 48;
            }
            this.mGravity = i2;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i) {
        int i2 = i & 8388615;
        if ((this.mGravity & 8388615) != i2) {
            this.mGravity = i2 | (this.mGravity & -8388616);
            requestLayout();
        }
    }

    public void setVerticalGravity(int i) {
        int i2 = i & 112;
        if ((this.mGravity & 112) != i2) {
            this.mGravity = i2 | (this.mGravity & -113);
            requestLayout();
        }
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    protected LayoutParams generateDefaultLayoutParams() {
        if (this.mOrientation == 0) {
            return new LayoutParams(-2, -2);
        }
        if (this.mOrientation == 1) {
            return new LayoutParams(-1, -2);
        }
        return null;
    }

    protected LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (VERSION.SDK_INT >= 14) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(LinearLayoutCompat.class.getName());
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (VERSION.SDK_INT >= 14) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(LinearLayoutCompat.class.getName());
        }
    }
}
