package com.facebook.composer.ui.underwood;

import android.graphics.Rect;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout.LayoutParams;

/* compiled from: commercial_break_employee_only_tooltip */
public class UnderwoodAttachmentUtils {

    /* compiled from: commercial_break_employee_only_tooltip */
    public class MeasureSpecs {
        public final int f17170a;
        public final int f17171b;

        public MeasureSpecs(int i, int i2) {
            this.f17170a = i;
            this.f17171b = i2;
        }
    }

    public static MeasureSpecs m21132a(float f, LayoutParams layoutParams, MeasureSpecs measureSpecs) {
        int size = MeasureSpec.getSize(measureSpecs.f17170a) - (layoutParams.leftMargin + layoutParams.rightMargin);
        return new MeasureSpecs(MeasureSpec.makeMeasureSpec(size, 1073741824), MeasureSpec.makeMeasureSpec(Math.round(((float) size) / f), 1073741824));
    }

    public static void m21133a(View view, View view2, View view3) {
        int i = 0;
        if (view != null && view2 != null && view2.getMeasuredHeight() != 0 && view2.getMeasuredWidth() != 0) {
            int[] iArr = new int[]{view2.getLeft(), view2.getTop()};
            view2.getLocationOnScreen(iArr);
            int measuredHeight = view2.getMeasuredHeight() + iArr[1];
            Rect rect = new Rect();
            view2.getGlobalVisibleRect(rect);
            if (measuredHeight >= rect.top && iArr[1] <= rect.bottom) {
                int paddingBottom = view.getPaddingBottom() + view.getMeasuredHeight();
                int measuredHeight2 = view3 != null ? view3.getMeasuredHeight() * 2 : 0;
                if (rect.top - iArr[1] > 5) {
                    i = rect.top - iArr[1];
                }
                if (Math.abs(measuredHeight - rect.bottom) > 5 && rect.height() > measuredHeight2) {
                    view.setY((float) ((rect.height() + i) - paddingBottom));
                } else if (view2.getMeasuredHeight() - paddingBottom != view.getTop()) {
                    view.setY((float) (view2.getMeasuredHeight() - paddingBottom));
                }
            }
        }
    }
}
