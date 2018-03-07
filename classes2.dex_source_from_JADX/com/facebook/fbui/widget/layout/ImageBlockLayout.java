package com.facebook.fbui.widget.layout;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.view.MarginLayoutParamsCompat;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import com.facebook.R;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.proxygen.HTTPTransportCallback;

/* compiled from: messenger_badge_notifications_android */
public class ImageBlockLayout extends ViewGroupWithDraweeView {
    private boolean f14139A;
    private final Rect f14140B;
    private final Rect f14141C;
    public View f14142a;
    public int f14143b;
    private Drawable f14144h;
    private int f14145i;
    private int f14146j;
    private int f14147k;
    private int f14148l;
    private int f14149m;
    private int f14150n;
    private int f14151o;
    private int f14152p;
    private int f14153q;
    private int f14154r;
    private int f14155s;
    private int f14156t;
    private Paint f14157u;
    public int f14158v;
    public int f14159w;
    public int f14160x;
    public int f14161y;
    private int f14162z;

    /* compiled from: messenger_badge_notifications_android */
    /* synthetic */ class C05911 {
        static final /* synthetic */ int[] f14171a = new int[ThumbnailType.values().length];

        static {
            try {
                f14171a[ThumbnailType.VIEW.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f14171a[ThumbnailType.DRAWABLE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* compiled from: messenger_badge_notifications_android */
    enum ThumbnailType {
        VIEW,
        DRAWABLE,
        NONE
    }

    /* compiled from: messenger_badge_notifications_android */
    public class LayoutParams extends MarginLayoutParams {
        public boolean f14276a = false;
        public boolean f14277b = false;
        public boolean f14278c = false;
        public int f14279d = -1;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ImageBlockLayout_LayoutParams);
            this.f14276a = obtainStyledAttributes.getBoolean(1, false);
            this.f14277b = obtainStyledAttributes.getBoolean(2, false);
            this.f14278c = obtainStyledAttributes.getBoolean(3, false);
            this.f14279d = obtainStyledAttributes.getInt(0, -1);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    protected /* synthetic */ android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return m20498d();
    }

    public /* synthetic */ android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return m20489a(attributeSet);
    }

    protected /* synthetic */ android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return m20490a(layoutParams);
    }

    public ImageBlockLayout(Context context) {
        this(context, null);
    }

    public ImageBlockLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 2130772353);
    }

    public ImageBlockLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14140B = new Rect();
        this.f14141C = new Rect();
        m20483a(context, attributeSet, i);
    }

    private void m20483a(Context context, AttributeSet attributeSet, int i) {
        int dimensionPixelSize;
        int dimensionPixelSize2;
        int dimensionPixelSize3;
        int dimensionPixelSize4;
        this.f14157u = new Paint(1);
        this.f14157u.setStyle(Style.FILL);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ImageBlockLayout, i, 0);
        setLayout(obtainStyledAttributes.getResourceId(6, 0));
        Drawable drawable = obtainStyledAttributes.getDrawable(7);
        if (drawable != null) {
            setThumbnailDrawable(drawable);
        }
        setOverlayDrawable(obtainStyledAttributes.getDrawable(8));
        this.f14143b = obtainStyledAttributes.getInt(0, 48);
        this.f14148l = obtainStyledAttributes.getInt(13, 48);
        this.f14145i = obtainStyledAttributes.getInt(14, 17);
        this.f14146j = obtainStyledAttributes.getLayoutDimension(11, -2);
        this.f14147k = obtainStyledAttributes.getLayoutDimension(12, -2);
        if (obtainStyledAttributes.hasValue(1)) {
            dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(1, 0);
            setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        } else {
            if (obtainStyledAttributes.hasValue(2)) {
                dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(2, 0);
            } else {
                dimensionPixelSize = 0;
            }
            if (obtainStyledAttributes.hasValue(4)) {
                dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(4, 0);
            } else {
                dimensionPixelSize2 = 0;
            }
            if (obtainStyledAttributes.hasValue(3)) {
                dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(3, 0);
            } else {
                dimensionPixelSize3 = 0;
            }
            if (obtainStyledAttributes.hasValue(5)) {
                dimensionPixelSize4 = obtainStyledAttributes.getDimensionPixelSize(5, 0);
            } else {
                dimensionPixelSize4 = 0;
            }
            setPadding(dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2, dimensionPixelSize4);
        }
        if (obtainStyledAttributes.hasValue(18)) {
            dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(18, 0);
            m20493a(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        } else {
            if (obtainStyledAttributes.hasValue(21)) {
                dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(21, 0);
            } else {
                dimensionPixelSize = 0;
            }
            if (obtainStyledAttributes.hasValue(22)) {
                dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(22, 0);
            } else {
                dimensionPixelSize2 = 0;
            }
            if (obtainStyledAttributes.hasValue(19)) {
                dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(19, 0);
            } else {
                dimensionPixelSize3 = 0;
            }
            if (obtainStyledAttributes.hasValue(20)) {
                dimensionPixelSize4 = obtainStyledAttributes.getDimensionPixelSize(20, 0);
            } else {
                dimensionPixelSize4 = 0;
            }
            m20493a(dimensionPixelSize, dimensionPixelSize3, dimensionPixelSize2, dimensionPixelSize4);
        }
        setBorderColor(obtainStyledAttributes.getColor(17, 0));
        setClipBorderToPadding(obtainStyledAttributes.getBoolean(23, false));
        m20499d(obtainStyledAttributes.getLayoutDimension(9, -2), obtainStyledAttributes.getLayoutDimension(10, -2));
        setThumbnailPadding(obtainStyledAttributes.getDimensionPixelSize(15, 0));
        setAuxViewPadding(obtainStyledAttributes.getDimensionPixelSize(16, 0));
        obtainStyledAttributes.recycle();
    }

    protected void mo2719b() {
        super.mo2719b();
        setOverlayDrawable(null);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void onMeasure(int r17, int r18) {
        /*
        r16 = this;
        r10 = 0;
        r1 = 0;
        r0 = r16;
        r0.f14155s = r1;
        r1 = 0;
        r0 = r16;
        r0.f14156t = r1;
        r1 = r16.getSpaceLeft();
        r2 = r16.getSpaceRight();
        r4 = r1 + r2;
        r1 = r16.getSpaceTop();
        r2 = r16.getSpaceBottom();
        r6 = r1 + r2;
        r5 = 0;
        r3 = 0;
        r7 = 0;
        r13 = 0;
        r2 = 0;
        r1 = 0;
        r12 = 0;
        r11 = 0;
        r14 = r16.getThumbnailType();
        r8 = com.facebook.fbui.widget.layout.ImageBlockLayout.C05911.f14171a;
        r9 = r14.ordinal();
        r8 = r8[r9];
        switch(r8) {
            case 1: goto L_0x013e;
            case 2: goto L_0x0182;
            default: goto L_0x0036;
        };
    L_0x0036:
        r8 = r2;
        r9 = r7;
        r7 = r1;
    L_0x0039:
        r1 = com.facebook.fbui.widget.layout.ImageBlockLayout.ThumbnailType.NONE;
        if (r14 == r1) goto L_0x004c;
    L_0x003d:
        r2 = r4 + r5;
        if (r8 != 0) goto L_0x01b5;
    L_0x0041:
        r1 = 0;
    L_0x0042:
        r4 = r2 + r1;
        r1 = 0;
        r2 = r7 + r3;
        r1 = java.lang.Math.max(r1, r2);
        r10 = r1;
    L_0x004c:
        r1 = r16.m20488h();
        if (r1 == 0) goto L_0x01c9;
    L_0x0052:
        r0 = r16;
        r1 = r0.f14142a;
        r1 = r1.getLayoutParams();
        r1 = (com.facebook.fbui.widget.layout.ImageBlockLayout.LayoutParams) r1;
        r2 = r1.leftMargin;
        r3 = r1.rightMargin;
        r12 = r2 + r3;
        r2 = r1.topMargin;
        r3 = r1.bottomMargin;
        r13 = r2 + r3;
        r1 = r1.height;
        r2 = -1;
        if (r1 != r2) goto L_0x01bc;
    L_0x006d:
        r1 = 1;
        r11 = r1;
    L_0x006f:
        r0 = r16;
        r2 = r0.f14142a;
        r1 = r16;
        r3 = r17;
        r5 = r18;
        r1.measureChildWithMargins(r2, r3, r4, r5, r6);
        r0 = r16;
        r1 = r0.f14142a;
        r3 = r1.getMeasuredWidth();
        r0 = r16;
        r1 = r0.f14142a;
        r2 = r1.getMeasuredHeight();
        if (r3 != 0) goto L_0x01c0;
    L_0x008e:
        r1 = 0;
    L_0x008f:
        r4 = r4 + r1;
        r1 = r2 + r13;
        r10 = java.lang.Math.max(r10, r1);
    L_0x0096:
        r1 = android.view.View.MeasureSpec.getSize(r17);
        r1 = r1 - r4;
        r5 = android.view.View.MeasureSpec.getMode(r17);
        r1 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r5);
        r5 = android.view.View.MeasureSpec.getSize(r18);
        r5 = r5 - r6;
        r12 = android.view.View.MeasureSpec.getMode(r18);
        r5 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r12);
        r0 = r16;
        r0.m20491a(r1, r5);
        r1 = 0;
        r0 = r16;
        r5 = r0.f14155s;
        r5 = java.lang.Math.max(r1, r5);
        r0 = r16;
        r1 = r0.f14156t;
        r10 = java.lang.Math.max(r10, r1);
        if (r9 == 0) goto L_0x00ef;
    L_0x00c8:
        if (r7 == r10) goto L_0x00ef;
    L_0x00ca:
        r0 = r16;
        r1 = r0.f14168f;
        r1 = r1.getLayoutParams();
        r1 = (com.facebook.fbui.widget.layout.ImageBlockLayout.LayoutParams) r1;
        r0 = r16;
        r7 = r0.f14168f;
        r9 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r8 = android.view.View.MeasureSpec.makeMeasureSpec(r8, r9);
        r9 = r1.topMargin;
        r9 = r10 - r9;
        r1 = r1.bottomMargin;
        r1 = r9 - r1;
        r9 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r1 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r9);
        r7.measure(r8, r1);
    L_0x00ef:
        if (r11 == 0) goto L_0x0118;
    L_0x00f1:
        if (r2 == r10) goto L_0x0118;
    L_0x00f3:
        r0 = r16;
        r1 = r0.f14142a;
        r1 = r1.getLayoutParams();
        r1 = (com.facebook.fbui.widget.layout.ImageBlockLayout.LayoutParams) r1;
        r0 = r16;
        r2 = r0.f14142a;
        r7 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r3 = android.view.View.MeasureSpec.makeMeasureSpec(r3, r7);
        r7 = r1.topMargin;
        r7 = r10 - r7;
        r1 = r1.bottomMargin;
        r1 = r7 - r1;
        r7 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r1 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r7);
        r2.measure(r3, r1);
    L_0x0118:
        r1 = r5 + r4;
        r2 = r10 + r6;
        r3 = r16.getSuggestedMinimumWidth();
        r1 = java.lang.Math.max(r1, r3);
        r3 = r16.getSuggestedMinimumHeight();
        r2 = java.lang.Math.max(r2, r3);
        r0 = r17;
        r1 = android.view.View.resolveSize(r1, r0);
        r0 = r18;
        r2 = android.view.View.resolveSize(r2, r0);
        r0 = r16;
        r0.setMeasuredDimension(r1, r2);
        return;
    L_0x013e:
        r0 = r16;
        r1 = r0.f14168f;
        r1 = r1.getLayoutParams();
        r1 = (com.facebook.fbui.widget.layout.ImageBlockLayout.LayoutParams) r1;
        r2 = r1.leftMargin;
        r3 = r1.rightMargin;
        r9 = r2 + r3;
        r2 = r1.topMargin;
        r3 = r1.bottomMargin;
        r8 = r2 + r3;
        r1 = r1.height;
        r2 = -1;
        if (r1 != r2) goto L_0x017f;
    L_0x0159:
        r1 = 1;
        r7 = r1;
    L_0x015b:
        r0 = r16;
        r2 = r0.f14168f;
        r1 = r16;
        r3 = r17;
        r5 = r18;
        r1.measureChildWithMargins(r2, r3, r4, r5, r6);
        r0 = r16;
        r1 = r0.f14168f;
        r2 = r1.getMeasuredWidth();
        r0 = r16;
        r1 = r0.f14168f;
        r1 = r1.getMeasuredHeight();
        r3 = r8;
        r5 = r9;
    L_0x017a:
        r8 = r2;
        r9 = r7;
        r7 = r1;
        goto L_0x0039;
    L_0x017f:
        r1 = 0;
        r7 = r1;
        goto L_0x015b;
    L_0x0182:
        r0 = r16;
        r8 = r0.f14167e;
        if (r8 == 0) goto L_0x0036;
    L_0x0188:
        r0 = r16;
        r1 = r0.f14153q;
        if (r1 >= 0) goto L_0x01a8;
    L_0x018e:
        r0 = r16;
        r1 = r0.f14167e;
        r1 = r1.getIntrinsicWidth();
    L_0x0196:
        r0 = r16;
        r2 = r0.f14154r;
        if (r2 >= 0) goto L_0x01ad;
    L_0x019c:
        r0 = r16;
        r2 = r0.f14167e;
        r2 = r2.getIntrinsicHeight();
        r15 = r2;
        r2 = r1;
        r1 = r15;
        goto L_0x017a;
    L_0x01a8:
        r0 = r16;
        r1 = r0.f14153q;
        goto L_0x0196;
    L_0x01ad:
        r0 = r16;
        r2 = r0.f14154r;
        r15 = r2;
        r2 = r1;
        r1 = r15;
        goto L_0x017a;
    L_0x01b5:
        r0 = r16;
        r1 = r0.f14149m;
        r1 = r1 + r8;
        goto L_0x0042;
    L_0x01bc:
        r1 = 0;
        r11 = r1;
        goto L_0x006f;
    L_0x01c0:
        r1 = r3 + r12;
        r5 = r16.getAuxViewPadding();
        r1 = r1 + r5;
        goto L_0x008f;
    L_0x01c9:
        r2 = r11;
        r3 = r12;
        r11 = r13;
        goto L_0x0096;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.fbui.widget.layout.ImageBlockLayout.onMeasure(int, int):void");
    }

    protected void m20491a(int i, int i2) {
        int childCount = getChildCount();
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < childCount) {
            int i6;
            int i7;
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() == 8 || !m20485b(childAt)) {
                i6 = i4;
                i7 = i5;
            } else {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int i8 = layoutParams.leftMargin + layoutParams.rightMargin;
                int i9 = layoutParams.topMargin + layoutParams.bottomMargin;
                measureChildWithMargins(childAt, i, 0, i2, 0);
                i6 = (childAt.getMeasuredHeight() + i9) + i4;
                i7 = Math.max(i5, childAt.getMeasuredWidth() + i8);
            }
            i3++;
            i4 = i6;
            i5 = i7;
        }
        m20495b(i5, i4);
    }

    protected final void m20495b(int i, int i2) {
        this.f14155s = i;
        this.f14156t = i2;
    }

    protected void measureChildWithMargins(View view, int i, int i2, int i3, int i4) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1725035473);
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i, (marginLayoutParams.leftMargin + i2) + marginLayoutParams.rightMargin, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i3, (marginLayoutParams.topMargin + i4) + marginLayoutParams.bottomMargin, marginLayoutParams.height));
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -383778001, a);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        LayoutParams layoutParams;
        int i5;
        int a;
        int b;
        int i6;
        int intrinsicHeight;
        int i7;
        int measuredWidth;
        int measuredHeight;
        int b2;
        int i8 = i3 - i;
        int i9 = i4 - i2;
        boolean c = m20497c();
        int spaceTop = getSpaceTop();
        int spaceBottom = getSpaceBottom();
        int spaceLeft = getSpaceLeft();
        int spaceRight = getSpaceRight();
        int i10 = 0;
        int i11 = 0;
        ThumbnailType thumbnailType = getThumbnailType();
        int i12;
        switch (C05911.f14171a[thumbnailType.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                layoutParams = (LayoutParams) this.f14168f.getLayoutParams();
                i12 = (layoutParams.f14279d < 0 ? 48 : layoutParams.f14279d) & 112;
                i10 = this.f14168f.getMeasuredWidth();
                i11 = this.f14168f.getMeasuredHeight();
                i5 = i10 == 0 ? 0 : this.f14149m + i10;
                a = MarginLayoutParamsCompat.m20965a(layoutParams);
                b = MarginLayoutParamsCompat.m20967b(layoutParams);
                if (i12 != 16) {
                    if (i12 != 80) {
                        this.f14152p = layoutParams.topMargin + spaceTop;
                        i6 = b;
                        b = a;
                        a = i5;
                        i5 = i6;
                        break;
                    }
                    this.f14152p = ((i9 - spaceBottom) - layoutParams.bottomMargin) - i11;
                    i6 = b;
                    b = a;
                    a = i5;
                    i5 = i6;
                    break;
                }
                this.f14152p = (layoutParams.topMargin + (((i9 - i11) - (((layoutParams.topMargin + layoutParams.bottomMargin) + spaceTop) + spaceBottom)) / 2)) + spaceTop;
                i6 = b;
                b = a;
                a = i5;
                i5 = i6;
                break;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                i12 = (this.f14148l < 0 ? 48 : this.f14148l) & 112;
                if (this.f14167e != null) {
                    i11 = this.f14153q < 0 ? this.f14167e.getIntrinsicWidth() : this.f14153q;
                    intrinsicHeight = this.f14154r < 0 ? this.f14167e.getIntrinsicHeight() : this.f14154r;
                } else {
                    intrinsicHeight = 0;
                    i11 = 0;
                }
                i5 = i11 == 0 ? 0 : this.f14149m + i11;
                if (i12 != 16) {
                    if (i12 != 80) {
                        this.f14152p = spaceTop;
                        i10 = i11;
                        i11 = intrinsicHeight;
                        i6 = i5;
                        i5 = 0;
                        b = 0;
                        a = i6;
                        break;
                    }
                    this.f14152p = (i9 - spaceBottom) - intrinsicHeight;
                    i10 = i11;
                    i11 = intrinsicHeight;
                    i6 = i5;
                    i5 = 0;
                    b = 0;
                    a = i6;
                    break;
                }
                this.f14152p = (((i9 - intrinsicHeight) - (spaceTop + spaceBottom)) / 2) + spaceTop;
                i10 = i11;
                i11 = intrinsicHeight;
                i6 = i5;
                i5 = 0;
                b = 0;
                a = i6;
                break;
            default:
                b = 0;
                a = 0;
                i5 = 0;
                break;
        }
        if (m20488h()) {
            layoutParams = (LayoutParams) this.f14142a.getLayoutParams();
            i7 = (layoutParams.f14279d < 0 ? 17 : layoutParams.f14279d) & 112;
            measuredWidth = this.f14142a.getMeasuredWidth();
            measuredHeight = this.f14142a.getMeasuredHeight();
            b2 = MarginLayoutParamsCompat.m20967b(layoutParams);
            if (i7 == 48) {
                i6 = b2;
                b2 = layoutParams.topMargin + spaceTop;
                intrinsicHeight = i6;
            } else if (i7 == 80) {
                i6 = b2;
                b2 = ((i9 - spaceBottom) - layoutParams.bottomMargin) - measuredHeight;
                intrinsicHeight = i6;
            } else {
                i6 = b2;
                b2 = (layoutParams.topMargin + (((i9 - measuredHeight) - (((layoutParams.topMargin + layoutParams.bottomMargin) + spaceTop) + spaceBottom)) / 2)) + spaceTop;
                intrinsicHeight = i6;
            }
        } else {
            intrinsicHeight = 0;
            b2 = 0;
            measuredHeight = 0;
            measuredWidth = 0;
        }
        i7 = this.f14143b & 112;
        if (i7 == 16) {
            i7 = ((((i9 - this.f14156t) - spaceTop) - spaceBottom) / 2) + spaceTop;
        } else if (i7 == 48) {
            i7 = spaceTop;
        } else {
            i7 = (i9 - spaceBottom) - this.f14156t;
        }
        if (c) {
            this.f14151o = b + spaceLeft;
            i5 += this.f14151o + a;
            intrinsicHeight = ((i8 - spaceRight) - measuredWidth) - intrinsicHeight;
        } else {
            this.f14151o = ((i8 - spaceRight) - b) - i10;
            i5 = (((i8 - spaceRight) - a) - b) - i5;
            intrinsicHeight += spaceLeft;
        }
        switch (C05911.f14171a[thumbnailType.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                this.f14168f.layout(this.f14151o, this.f14152p, i10 + this.f14151o, i11 + this.f14152p);
                break;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                this.f14167e.setBounds(this.f14151o, this.f14152p, i10 + this.f14151o, i11 + this.f14152p);
                break;
        }
        m20486f();
        if (m20488h()) {
            this.f14142a.layout(intrinsicHeight, b2, intrinsicHeight + measuredWidth, b2 + measuredHeight);
        }
        if (c) {
            intrinsicHeight = i5;
        } else {
            intrinsicHeight = i5 - this.f14155s;
        }
        if (c) {
            i5 += this.f14155s;
        }
        m20492a(intrinsicHeight, i7, i5);
    }

    protected void m20492a(int i, int i2, int i3) {
        boolean c = m20497c();
        int childCount = getChildCount();
        int i4 = 0;
        int i5 = i2;
        while (i4 < childCount) {
            int i6;
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() == 8 || !m20485b(childAt)) {
                i6 = i5;
            } else {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int i7 = (layoutParams.f14279d < 0 ? 8388611 : layoutParams.f14279d) & 7;
                int a = MarginLayoutParamsCompat.m20965a(layoutParams);
                int b = MarginLayoutParamsCompat.m20967b(layoutParams);
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (c) {
                    if (i7 == 3) {
                        i7 = i + a;
                    } else if (i7 == 5) {
                        i7 = (i3 - b) - measuredWidth;
                    } else {
                        i7 = ((((((i3 - i) - a) - measuredWidth) - b) / 2) + i) + a;
                    }
                } else if (i7 == 3) {
                    i7 = (i3 - a) - measuredWidth;
                } else if (i7 == 5) {
                    i7 = i + b;
                } else {
                    i7 = ((((((i3 - i) - a) - measuredWidth) - b) / 2) + i) + b;
                }
                i5 += layoutParams.topMargin;
                childAt.layout(i7, i5, i7 + measuredWidth, i5 + measuredHeight);
                i6 = (layoutParams.bottomMargin + measuredHeight) + i5;
            }
            i4++;
            i5 = i6;
        }
    }

    protected void dispatchDraw(Canvas canvas) {
        int i;
        int i2;
        int i3;
        Object obj;
        super.dispatchDraw(canvas);
        int spaceTop = getSpaceTop();
        int spaceBottom = getSpaceBottom();
        int spaceLeft = getSpaceLeft();
        int spaceRight = getSpaceRight();
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getThumbnailType() == ThumbnailType.DRAWABLE) {
            this.f14167e.draw(canvas);
        }
        if (m20487g() && this.f14144h != null) {
            this.f14144h.draw(canvas);
        }
        int i4 = this.f14139A ? spaceLeft : 0;
        if (this.f14139A) {
            i = measuredWidth - spaceRight;
        } else {
            i = measuredWidth;
        }
        if (this.f14139A) {
            i2 = spaceTop;
        } else {
            i2 = 0;
        }
        if (this.f14139A) {
            i3 = measuredHeight - spaceBottom;
        } else {
            i3 = measuredHeight;
        }
        if (this.f14159w == 0 && this.f14161y == 0 && this.f14158v == 0 && this.f14160x == 0) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            canvas.save();
        }
        if (this.f14159w != 0) {
            canvas.drawRect((float) i4, 0.0f, (float) i, (float) this.f14159w, this.f14157u);
        }
        if (this.f14161y != 0) {
            canvas.drawRect((float) i4, (float) (measuredHeight - this.f14161y), (float) i, (float) measuredHeight, this.f14157u);
        }
        if (this.f14158v != 0) {
            canvas.drawRect(0.0f, (float) i2, (float) this.f14158v, (float) i3, this.f14157u);
        }
        if (this.f14160x != 0) {
            canvas.drawRect((float) (measuredWidth - this.f14160x), (float) i2, (float) measuredWidth, (float) i3, this.f14157u);
        }
        if (obj != null) {
            canvas.restore();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m20486f() {
        /*
        r9 = this;
        r0 = 0;
        r5 = -1;
        r4 = -2;
        r1 = r9.f14144h;
        if (r1 != 0) goto L_0x0008;
    L_0x0007:
        return;
    L_0x0008:
        r1 = com.facebook.fbui.widget.layout.ImageBlockLayout.C05911.f14171a;
        r2 = r9.getThumbnailType();
        r2 = r2.ordinal();
        r1 = r1[r2];
        switch(r1) {
            case 1: goto L_0x0046;
            case 2: goto L_0x0054;
            default: goto L_0x0017;
        };
    L_0x0017:
        r3 = r0;
    L_0x0018:
        r1 = r9.f14146j;
        if (r1 != r5) goto L_0x0079;
    L_0x001c:
        r1 = r3;
    L_0x001d:
        r2 = r9.f14147k;
        if (r2 != r5) goto L_0x0087;
    L_0x0021:
        r2 = r0;
    L_0x0022:
        r4 = r9.f14140B;
        r5 = r9.f14151o;
        r6 = r9.f14152p;
        r7 = r9.f14151o;
        r3 = r3 + r7;
        r7 = r9.f14152p;
        r0 = r0 + r7;
        r4.set(r5, r6, r3, r0);
        r0 = r9.f14145i;
        r3 = r9.f14140B;
        r4 = r9.f14141C;
        r5 = android.support.v4.view.ViewCompat.m10967h(r9);
        android.support.v4.view.GravityCompat.a(r0, r1, r2, r3, r4, r5);
        r0 = r9.f14144h;
        r1 = r9.f14141C;
        r0.setBounds(r1);
        goto L_0x0007;
    L_0x0046:
        r0 = r9.f14168f;
        r1 = r0.getMeasuredWidth();
        r0 = r9.f14168f;
        r0 = r0.getMeasuredHeight();
    L_0x0052:
        r3 = r1;
        goto L_0x0018;
    L_0x0054:
        r1 = r9.f14167e;
        if (r1 == 0) goto L_0x0017;
    L_0x0058:
        r0 = r9.f14153q;
        if (r0 >= 0) goto L_0x0070;
    L_0x005c:
        r0 = r9.f14167e;
        r0 = r0.getIntrinsicWidth();
    L_0x0062:
        r1 = r9.f14154r;
        if (r1 >= 0) goto L_0x0073;
    L_0x0066:
        r1 = r9.f14167e;
        r1 = r1.getIntrinsicHeight();
        r8 = r1;
        r1 = r0;
        r0 = r8;
        goto L_0x0052;
    L_0x0070:
        r0 = r9.f14153q;
        goto L_0x0062;
    L_0x0073:
        r1 = r9.f14154r;
        r8 = r1;
        r1 = r0;
        r0 = r8;
        goto L_0x0052;
    L_0x0079:
        r1 = r9.f14146j;
        if (r1 != r4) goto L_0x0084;
    L_0x007d:
        r1 = r9.f14144h;
        r1 = r1.getIntrinsicWidth();
        goto L_0x001d;
    L_0x0084:
        r1 = r9.f14146j;
        goto L_0x001d;
    L_0x0087:
        r2 = r9.f14146j;
        if (r2 != r4) goto L_0x0092;
    L_0x008b:
        r2 = r9.f14144h;
        r2 = r2.getIntrinsicHeight();
        goto L_0x0022;
    L_0x0092:
        r2 = r9.f14147k;
        goto L_0x0022;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.fbui.widget.layout.ImageBlockLayout.f():void");
    }

    public void addView(View view, int i, android.view.ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            if (layoutParams2.f14276a) {
                if (this.f14168f != null) {
                    removeView(this.f14168f);
                }
                if (layoutParams2.f14279d < 0) {
                    layoutParams2.f14279d = 48;
                }
                this.f = view;
            } else if (layoutParams2.f14277b) {
                if (this.f14142a != null) {
                    removeView(this.f14142a);
                }
                if (layoutParams2.f14279d < 0) {
                    layoutParams2.f14279d = 16;
                }
                this.f14142a = view;
            }
        }
        super.addView(view, i, layoutParams);
    }

    public void removeView(View view) {
        m20484a(view);
        super.removeView(view);
    }

    public void removeViewInLayout(View view) {
        m20484a(view);
        super.removeViewInLayout(view);
    }

    private void m20484a(View view) {
        if (view != null) {
            if (view == this.f14168f) {
                this.f = null;
            } else if (view == this.f14142a) {
                this.f14142a = null;
            }
        }
    }

    private ThumbnailType getThumbnailType() {
        if (this.f14168f != null && this.f14168f.getVisibility() != 8) {
            return ThumbnailType.VIEW;
        }
        if (this.f14167e == null || !this.f14169g) {
            return ThumbnailType.NONE;
        }
        return ThumbnailType.DRAWABLE;
    }

    private boolean m20487g() {
        if (this.f14168f != null) {
            if (this.f14168f.getVisibility() == 0) {
                return true;
            }
            return false;
        } else if (this.f14167e != null) {
            return this.f14169g;
        } else {
            return false;
        }
    }

    private boolean m20488h() {
        return (this.f14142a == null || this.f14142a.getVisibility() == 8) ? false : true;
    }

    public View getThumbnailView() {
        return this.f14168f;
    }

    public void setThumbnailView(View view) {
        if (this.f14168f != null) {
            removeView(this.f14168f);
        }
        if (view != null) {
            android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (checkLayoutParams(layoutParams)) {
                layoutParams = (LayoutParams) layoutParams;
            } else if (layoutParams == null) {
                layoutParams = m20498d();
            } else {
                layoutParams = new LayoutParams(layoutParams);
            }
            layoutParams.f14276a = true;
            addView(view, -1, layoutParams);
        }
    }

    private static boolean m20485b(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        return (layoutParams.f14276a || layoutParams.f14277b || layoutParams.f14278c) ? false : true;
    }

    public final boolean m20497c() {
        return ViewCompat.m10967h(this) == 0;
    }

    public void setLayout(int i) {
        if (i > 0) {
            LayoutInflater.from(getContext()).inflate(i, this, true);
        }
    }

    protected String getFeatureTag() {
        return "thumbnail";
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return drawable == this.f14144h || super.verifyDrawable(drawable);
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f14144h != null && this.f14144h.isStateful()) {
            this.f14144h.setState(getDrawableState());
        }
    }

    @TargetApi(11)
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.f14144h != null) {
            this.f14144h.jumpToCurrentState();
        }
    }

    public int getGravity() {
        return this.f14143b;
    }

    public void setGravity(int i) {
        if (this.f14143b != i) {
            this.f14143b = i;
            requestLayout();
        }
    }

    public void setOverlayDrawable(Drawable drawable) {
        if (this.f14144h != drawable) {
            if (this.f14144h != null) {
                this.f14144h.setCallback(null);
            }
            this.f14144h = drawable;
            if (drawable != null) {
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
            }
            m20486f();
            invalidate();
        }
    }

    public void setOverlayResource(int i) {
        if (i > 0) {
            setOverlayDrawable(getResources().getDrawable(i));
        }
    }

    public int getOverlayGravity() {
        return this.f14145i;
    }

    public void setOverlayGravity(int i) {
        if (this.f14143b != i) {
            this.f14143b = i;
            m20486f();
        }
    }

    public final void m20496c(int i, int i2) {
        this.f14146j = i;
        this.f14147k = i2;
        m20486f();
    }

    public int getThumbnailPadding() {
        return this.f14149m;
    }

    public void setThumbnailPadding(int i) {
        if (this.f14149m != i) {
            this.f14149m = i;
            requestLayout();
            invalidate();
        }
    }

    public int getThumbnailGravity() {
        switch (C05911.f14171a[getThumbnailType().ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return ((LayoutParams) this.f14168f.getLayoutParams()).f14279d;
            default:
                return this.f14148l;
        }
    }

    public void setThumbnailGravity(int i) {
        this.f14148l = i;
        if (getThumbnailType() == ThumbnailType.VIEW) {
            ((LayoutParams) this.f14168f.getLayoutParams()).f14279d = i;
        }
        requestLayout();
        invalidate();
    }

    public final void m20499d(int i, int i2) {
        this.f14153q = i;
        this.f14154r = i2;
        switch (C05911.f14171a[getThumbnailType().ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                LayoutParams layoutParams = (LayoutParams) this.f14168f.getLayoutParams();
                if (layoutParams == null) {
                    android.view.ViewGroup.LayoutParams layoutParams2 = new LayoutParams(i, i2);
                    layoutParams2.f14276a = true;
                    layoutParams2.f14279d = 48;
                    this.f14168f.setLayoutParams(layoutParams2);
                    return;
                }
                layoutParams.width = i;
                layoutParams.height = i2;
                layoutParams.f14276a = true;
                this.f14168f.requestLayout();
                return;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                requestLayout();
                invalidate();
                return;
            default:
                return;
        }
    }

    public void setThumbnailSize(int i) {
        m20499d(i, i);
    }

    public int getAuxViewPadding() {
        return this.f14150n;
    }

    public void setAuxViewPadding(int i) {
        if (this.f14150n != i) {
            this.f14150n = i;
            requestLayout();
        }
    }

    public void setShowAuxView(boolean z) {
        if (this.f14142a != null) {
            this.f14142a.setVisibility(z ? 0 : 8);
        }
    }

    public View getAuxView() {
        return this.f14142a;
    }

    public int getBorderTop() {
        return this.f14159w;
    }

    public int getBorderBottom() {
        return this.f14161y;
    }

    public int getBorderLeft() {
        return this.f14158v;
    }

    public int getBorderRight() {
        return this.f14160x;
    }

    protected int getInsetTop() {
        return 0;
    }

    protected int getInsetBottom() {
        return 0;
    }

    protected int getInsetLeft() {
        return 0;
    }

    protected int getInsetRight() {
        return 0;
    }

    public int getSpaceTop() {
        return (getPaddingTop() + this.f14159w) + getInsetTop();
    }

    public int getSpaceBottom() {
        return (getPaddingBottom() + this.f14161y) + getInsetBottom();
    }

    public int getSpaceLeft() {
        return (getPaddingLeft() + this.f14158v) + getInsetLeft();
    }

    public int getSpaceRight() {
        return (getPaddingRight() + this.f14160x) + getInsetRight();
    }

    public int getMeasuredContentWidth() {
        return this.f14155s;
    }

    public int getMeasuredContentHeight() {
        return this.f14156t;
    }

    public final void m20493a(int i, int i2, int i3, int i4) {
        this.f14158v = i;
        this.f14160x = i3;
        this.f14159w = i2;
        this.f14161y = i4;
        requestLayout();
        invalidate();
    }

    public int getBorderColor() {
        return this.f14162z;
    }

    public void setBorderColor(int i) {
        if (this.f14162z != i) {
            this.f14162z = i;
            this.f14157u.setColor(i);
            invalidate();
        }
    }

    public void setClipBorderToPadding(boolean z) {
        if (this.f14139A != z) {
            this.f14139A = z;
            requestLayout();
            invalidate();
        }
    }

    protected LayoutParams m20498d() {
        return new LayoutParams(-2, -2);
    }

    public LayoutParams m20489a(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    protected LayoutParams m20490a(android.view.ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return (LayoutParams) layoutParams;
        }
        return m20498d();
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams != null && (layoutParams instanceof LayoutParams);
    }

    public int getLocaleGravity() {
        return (getResources().getConfiguration().screenLayout & 192) == HTTPTransportCallback.BODY_BYTES_RECEIVED ? 5 : 3;
    }
}
