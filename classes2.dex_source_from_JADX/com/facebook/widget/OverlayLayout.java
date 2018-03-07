package com.facebook.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.R;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import javax.annotation.Nullable;

/* compiled from: free_data_persistent_notification */
public class OverlayLayout extends CustomViewGroup {

    /* compiled from: free_data_persistent_notification */
    public class LayoutParams extends android.widget.FrameLayout.LayoutParams {
        public boolean f23265a;
        public int f23266b;
        @Nullable
        public View f23267c;
        public int f23268d;
        public int f23269e;
        public int f23270f;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.OverlayLayout_Layout);
            this.f23265a = obtainStyledAttributes.getBoolean(1, false);
            this.f23266b = obtainStyledAttributes.getResourceId(2, 0);
            this.f23268d = obtainStyledAttributes.getInt(0, 129);
            this.f23269e = obtainStyledAttributes.getDimensionPixelOffset(3, 0);
            this.f23270f = obtainStyledAttributes.getDimensionPixelOffset(4, 0);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    public OverlayLayout(Context context) {
        super(context);
    }

    public OverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public OverlayLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void onMeasure(int i, int i2) {
        TracerDetour.a("Overlayout.onMeasure", 190722782);
        try {
            super.onMeasure(i, i2);
        } finally {
            TracerDetour.a(-2119253687);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        TracerDetour.a("Overlayout.onLayout", 313549092);
        try {
            super.onLayout(z, i, i2, i3, i4);
        } finally {
            TracerDetour.a(151517817);
        }
    }

    protected void dispatchDraw(Canvas canvas) {
        TracerDetour.a("Overlayout.dispatchDraw", -366479263);
        try {
            super.dispatchDraw(canvas);
        } finally {
            TracerDetour.a(2022708559);
        }
    }

    private Rect m31390a(View view) {
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        view.getLocationInWindow(iArr);
        getLocationInWindow(iArr2);
        int i = iArr[0] - iArr2[0];
        int i2 = iArr[1] - iArr2[1];
        return new Rect(i, i2, (view.getRight() - view.getLeft()) + i, (view.getBottom() - view.getTop()) + i2);
    }

    protected void layoutChild(int i, int i2, int i3, int i4, View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams.f23265a) {
            View view2;
            int i5;
            if (layoutParams.f23267c != null) {
                view2 = layoutParams.f23267c;
            } else {
                i5 = layoutParams.f23266b;
                if (i5 != -1) {
                    view2 = findViewById(i5);
                } else {
                    return;
                }
            }
            if (view2 != null) {
                int i6;
                Rect a = m31390a(view2);
                int i7 = layoutParams.f23268d;
                int i8 = layoutParams.f23269e;
                int i9 = layoutParams.f23270f;
                int measuredWidth = view.getMeasuredWidth();
                int measuredHeight = view.getMeasuredHeight();
                i5 = (i7 & 256) == 256 ? a.centerX() : (i7 & HTTPTransportCallback.BODY_BYTES_RECEIVED) == HTTPTransportCallback.BODY_BYTES_RECEIVED ? a.left : (i7 & 512) == 512 ? a.right : i;
                if ((i7 & 2) == 2) {
                    i6 = i5 - (((layoutParams.leftMargin + measuredWidth) + layoutParams.rightMargin) / 2);
                } else if ((i7 & 1) == 1) {
                    i6 = i5 + layoutParams.leftMargin;
                } else if ((i7 & 4) == 4) {
                    i6 = i5 - (layoutParams.rightMargin + measuredWidth);
                } else {
                    i6 = i5;
                }
                i5 = (i7 & 2048) == 2048 ? a.centerY() : (i7 & 1024) == 1024 ? a.top : (i7 & 4096) == 4096 ? a.bottom : i3;
                int i10 = (i7 & 16) == 16 ? i5 - ((layoutParams.bottomMargin + (layoutParams.topMargin + measuredHeight)) / 2) : (i7 & 8) == 8 ? layoutParams.topMargin + i5 : (i7 & 32) == 32 ? i5 - (layoutParams.bottomMargin + measuredHeight) : i5;
                i5 = i6 + i8;
                i10 += i9;
                view.layout(Math.max(i5, i), Math.max(i10, i3), Math.min(i5 + measuredWidth, i2), Math.min(i10 + measuredHeight, i4));
                return;
            }
            return;
        }
        super.layoutChild(i, i2, i3, i4, view);
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
}
