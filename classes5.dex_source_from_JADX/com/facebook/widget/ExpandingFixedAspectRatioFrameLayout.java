package com.facebook.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;

@TargetApi(17)
/* compiled from: com.google.android.gms.signin.internal.ISignInCallbacks */
public class ExpandingFixedAspectRatioFrameLayout extends FrameLayout {
    public double f5612a;
    private final Rect f5613b;

    public ExpandingFixedAspectRatioFrameLayout(Context context) {
        this(context, null);
    }

    public ExpandingFixedAspectRatioFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ExpandingFixedAspectRatioFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5612a = 1.0d;
        this.f5613b = new Rect();
    }

    public void setAspectRatio(double d) {
        this.f5612a = d;
    }

    public void setPadding(Rect rect) {
        this.f5613b.set(rect);
    }

    @VisibleForTesting
    public void onMeasure(int i, int i2) {
        int size;
        boolean z = true;
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        int i3 = this.f5613b.right + this.f5613b.left;
        int i4 = this.f5613b.bottom + this.f5613b.top;
        boolean z2 = (mode == 0 && mode2 == 0) ? false : true;
        Preconditions.checkState(z2, "ExpandingFixedAspectRatioFrameLayout must have a bounded size in at least one direction");
        if (mode2 != 1073741824) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkState(z2, "ExpandingFixedAspectRatioFrameLayout does not support exact height dimensions");
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            int i5;
            mode = MeasureSpec.getSize(i) - i3;
            if (mode2 == Integer.MIN_VALUE) {
                size = MeasureSpec.getSize(i2) - i4;
                if (mode > ((int) (this.f5612a * ((double) size)))) {
                    i5 = (int) (this.f5612a * ((double) size));
                } else {
                    size = (int) (((double) mode) / this.f5612a);
                }
            } else {
                if (mode2 != 0) {
                    z = false;
                }
                Preconditions.checkState(z);
                size = (int) (((double) mode) / this.f5612a);
                i5 = mode;
            }
            mode = i5;
        } else {
            if (!(mode == 0 && mode2 == Integer.MIN_VALUE)) {
                z = false;
            }
            Preconditions.checkState(z);
            size = MeasureSpec.getSize(i2) - i4;
            mode = (int) (this.f5612a * ((double) size));
        }
        super.onMeasure(MeasureSpec.makeMeasureSpec(mode + i3, 1073741824), MeasureSpec.makeMeasureSpec(size + i4, 1073741824));
    }
}
