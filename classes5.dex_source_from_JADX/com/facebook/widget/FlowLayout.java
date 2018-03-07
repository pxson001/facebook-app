package com.facebook.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import com.facebook.R;
import java.util.Arrays;

/* compiled from: com.google.android.gms.signin */
public class FlowLayout extends ViewGroup {
    private boolean f5619a;
    private int f5620b = 0;
    private int f5621c = 0;
    private int f5622d = 51;
    private int f5623e = 1;
    private int f5624f;
    private int f5625g;
    private int[] f5626h;
    private int[] f5627i;

    /* compiled from: com.google.android.gms.signin */
    public class LayoutParams extends android.view.ViewGroup.LayoutParams {
        public int f5615a;
        public int f5616b;
        public int f5617c;
        public int f5618d;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842931});
            try {
                this.f5617c = obtainStyledAttributes.getInteger(0, 51);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.f5617c = 51;
        }
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    public FlowLayout(Context context) {
        super(context);
        m10422a(context, null);
    }

    public FlowLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m10422a(context, attributeSet);
    }

    public FlowLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m10422a(context, attributeSet);
    }

    private void m10422a(Context context, AttributeSet attributeSet) {
        this.f5626h = new int[this.f5623e];
        this.f5627i = new int[this.f5623e];
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FlowLayout);
            try {
                this.f5620b = obtainStyledAttributes.getDimensionPixelSize(1, this.f5620b);
                this.f5621c = obtainStyledAttributes.getDimensionPixelSize(2, this.f5621c);
                this.f5619a = obtainStyledAttributes.getBoolean(0, this.f5619a);
                obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842927});
                try {
                    this.f5622d = obtainStyledAttributes.getInteger(0, this.f5622d);
                } finally {
                    obtainStyledAttributes.recycle();
                }
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    public void setHorizontalSpacing(int i) {
        this.f5620b = i;
    }

    public void setVerticalSpacing(int i) {
        this.f5621c = i;
    }

    public void setGravity(int i) {
        if (this.f5622d != i) {
            int i2;
            if ((i & 7) == 0) {
                i2 = i | 3;
            } else {
                i2 = i;
            }
            if ((i2 & 112) == 0) {
                i2 |= 48;
            }
            this.f5622d = i2;
            requestLayout();
        }
    }

    private boolean m10423a() {
        return ViewCompat.h(this) == 0;
    }

    protected void onMeasure(int i, int i2) {
        Object obj;
        int size = (MeasureSpec.getSize(i) - getPaddingLeft()) - getPaddingRight();
        Object obj2 = MeasureSpec.getMode(i) != 0 ? 1 : null;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        this.f5624f = 0;
        this.f5625g = 0;
        int childCount = getChildCount();
        if (this.f5619a && m10424a(childCount, size, i, i2)) {
            obj = 1;
        } else {
            obj = null;
        }
        Object obj3 = 1;
        int i3 = 0;
        int i4 = 0;
        int i5 = paddingTop;
        paddingTop = paddingLeft;
        while (i3 < childCount) {
            int i6;
            Object obj4;
            Object obj5;
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                if (!this.f5619a) {
                    measureChild(childAt, i, i2);
                }
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (measuredWidth <= 0 || measuredHeight <= 0) {
                    i6 = paddingTop;
                    paddingTop = i5;
                    i5 = i4;
                    obj4 = null;
                } else {
                    if (obj != null || (obj2 != null && paddingTop + measuredWidth > size)) {
                        i5 += this.f5627i[i4] + this.f5621c;
                        paddingTop = getPaddingLeft();
                        i4++;
                        if (this.f5623e <= i4) {
                            this.f5623e = i4 + 1;
                            obj3 = new int[this.f5623e];
                            System.arraycopy(this.f5626h, 0, obj3, 0, this.f5626h.length);
                            this.f5626h = obj3;
                            obj3 = new int[this.f5623e];
                            System.arraycopy(this.f5627i, 0, obj3, 0, this.f5627i.length);
                            this.f5627i = obj3;
                        }
                    }
                    i6 = paddingTop;
                    paddingTop = i5;
                    i5 = i4;
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    layoutParams.f5616b = paddingTop;
                    layoutParams.f5618d = i5;
                    i4 = (this.f5620b + measuredWidth) + i6;
                    this.f5626h[i5] = (i4 - this.f5620b) - getPaddingLeft();
                    this.f5624f = Math.max(this.f5624f, this.f5626h[i5]);
                    this.f5627i[i5] = Math.max(this.f5627i[i5], measuredHeight);
                    i6 = i4;
                    obj4 = null;
                }
            } else {
                obj5 = obj3;
                i6 = paddingTop;
                paddingTop = i5;
                i5 = i4;
                obj4 = obj5;
            }
            i3++;
            obj5 = obj4;
            i4 = i5;
            i5 = paddingTop;
            paddingTop = i6;
            obj3 = obj5;
        }
        if (obj3 != null) {
            Arrays.fill(this.f5627i, 0);
            Arrays.fill(this.f5626h, 0);
        }
        this.f5625g = (this.f5627i[i4] + i5) - getPaddingTop();
        getPaddingRight();
        setMeasuredDimension(View.resolveSize((this.f5624f + getPaddingLeft()) + getPaddingRight(), i), View.resolveSize((this.f5627i[i4] + getPaddingBottom()) + i5, i2));
    }

    private boolean m10424a(int i, int i2, int i3, int i4) {
        int i5 = 0;
        for (int i6 = 0; i6 < i; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i3, i4);
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (measuredWidth > 0 && measuredHeight > 0) {
                    i5 += measuredWidth;
                }
            }
        }
        return i5 > i2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void onLayout(boolean r18, int r19, int r20, int r21, int r22) {
        /*
        r17 = this;
        r8 = r17.getPaddingTop();
        r2 = r17.getPaddingLeft();
        r3 = r17.getPaddingRight();
        r9 = r17.getPaddingBottom();
        r10 = r17.m10423a();
        r11 = r17.getChildCount();
        if (r10 == 0) goto L_0x008d;
    L_0x001a:
        r1 = r2;
    L_0x001b:
        r5 = 0;
        r4 = 0;
        r7 = r4;
        r4 = r5;
        r5 = r1;
    L_0x0020:
        if (r7 >= r11) goto L_0x0120;
    L_0x0022:
        r0 = r17;
        r12 = r0.getChildAt(r7);
        r1 = r12.getVisibility();
        r6 = 8;
        if (r1 == r6) goto L_0x0089;
    L_0x0030:
        r1 = r12.getLayoutParams();
        r1 = (com.facebook.widget.FlowLayout.LayoutParams) r1;
        r6 = 0;
        r13 = r1.f5618d;
        if (r13 == r4) goto L_0x0045;
    L_0x003b:
        r5 = r1.f5618d;
        if (r10 == 0) goto L_0x008f;
    L_0x003f:
        r4 = r2;
    L_0x0040:
        r16 = r5;
        r5 = r4;
        r4 = r16;
    L_0x0045:
        r1.f5615a = r5;
        r0 = r17;
        r13 = r0.f5622d;
        r13 = r13 & 7;
        switch(r13) {
            case 1: goto L_0x00a0;
            case 2: goto L_0x0050;
            case 3: goto L_0x0091;
            case 4: goto L_0x0050;
            case 5: goto L_0x00c6;
            default: goto L_0x0050;
        };
    L_0x0050:
        r0 = r17;
        r13 = r0.f5622d;
        r13 = r13 & 112;
        switch(r13) {
            case 16: goto L_0x00e0;
            case 48: goto L_0x0059;
            case 80: goto L_0x00ee;
            default: goto L_0x0059;
        };
    L_0x0059:
        r13 = r1.f5617c;
        r13 = r13 & 112;
        switch(r13) {
            case 16: goto L_0x00fb;
            case 48: goto L_0x0060;
            case 80: goto L_0x0110;
            default: goto L_0x0060;
        };
    L_0x0060:
        r13 = r1.f5616b;
        r14 = 0;
        r6 = java.lang.Math.max(r14, r6);
        r6 = r6 + r13;
        r1.f5616b = r6;
        r0 = r17;
        r6 = r0.f5620b;
        r13 = r12.getMeasuredWidth();
        r6 = r6 + r13;
        r5 = r5 + r6;
        r6 = r1.f5615a;
        r13 = r1.f5616b;
        r14 = r1.f5615a;
        r15 = r12.getMeasuredWidth();
        r14 = r14 + r15;
        r1 = r1.f5616b;
        r15 = r12.getMeasuredHeight();
        r1 = r1 + r15;
        r12.layout(r6, r13, r14, r1);
    L_0x0089:
        r1 = r7 + 1;
        r7 = r1;
        goto L_0x0020;
    L_0x008d:
        r1 = r3;
        goto L_0x001b;
    L_0x008f:
        r4 = r3;
        goto L_0x0040;
    L_0x0091:
        if (r10 != 0) goto L_0x00dc;
    L_0x0093:
        r13 = r17.getMeasuredWidth();
        r13 = r13 - r5;
        r14 = r12.getMeasuredWidth();
        r13 = r13 - r14;
        r1.f5615a = r13;
        goto L_0x0050;
    L_0x00a0:
        r13 = r17.getMeasuredWidth();
        r0 = r17;
        r14 = r0.f5626h;
        r15 = r1.f5618d;
        r14 = r14[r15];
        r13 = r13 - r14;
        r13 = r13 / 2;
        if (r10 == 0) goto L_0x00b6;
    L_0x00b1:
        r13 = r13 - r2;
        r13 = r13 + r5;
        r1.f5615a = r13;
        goto L_0x0050;
    L_0x00b6:
        r14 = r17.getMeasuredWidth();
        r13 = r14 - r13;
        r13 = r13 + r2;
        r13 = r13 - r5;
        r14 = r12.getMeasuredWidth();
        r13 = r13 - r14;
        r1.f5615a = r13;
        goto L_0x0050;
    L_0x00c6:
        if (r10 == 0) goto L_0x00dc;
    L_0x00c8:
        r13 = r17.getMeasuredWidth();
        r0 = r17;
        r14 = r0.f5626h;
        r15 = r1.f5618d;
        r14 = r14[r15];
        r13 = r13 - r14;
        r13 = r13 - r3;
        r13 = r13 - r2;
        r13 = r13 + r5;
        r1.f5615a = r13;
        goto L_0x0050;
    L_0x00dc:
        r1.f5615a = r5;
        goto L_0x0050;
    L_0x00e0:
        r6 = r17.getMeasuredHeight();
        r0 = r17;
        r13 = r0.f5625g;
        r6 = r6 - r13;
        r6 = r6 / 2;
        r6 = r6 - r8;
        goto L_0x0059;
    L_0x00ee:
        r6 = r17.getMeasuredHeight();
        r0 = r17;
        r13 = r0.f5625g;
        r6 = r6 - r13;
        r6 = r6 - r8;
        r6 = r6 - r9;
        goto L_0x0059;
    L_0x00fb:
        r13 = 0;
        r1.f5616b = r13;
        r0 = r17;
        r13 = r0.f5627i;
        r14 = r1.f5618d;
        r13 = r13[r14];
        r14 = r12.getMeasuredHeight();
        r13 = r13 - r14;
        r13 = r13 / 2;
        r6 = r6 + r13;
        goto L_0x0060;
    L_0x0110:
        r0 = r17;
        r13 = r0.f5627i;
        r14 = r1.f5618d;
        r13 = r13[r14];
        r14 = r12.getMeasuredHeight();
        r13 = r13 - r14;
        r6 = r6 + r13;
        goto L_0x0060;
    L_0x0120:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.widget.FlowLayout.onLayout(boolean, int, int, int, int):void");
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
