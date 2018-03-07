package com.facebook.composer.ui.underwood;

import android.content.Context;
import android.view.View;
import com.facebook.composer.ui.underwood.UnderwoodController.C14022;
import com.facebook.widget.CustomViewGroup;

/* compiled from: comment_place_recommendation_delete */
public class VerticalAttachmentViewsContainer extends CustomViewGroup {
    public C14022 f17330a;

    public VerticalAttachmentViewsContainer(Context context) {
        super(context);
    }

    protected void onMeasure(int i, int i2) {
        int i3 = 0;
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int i4 = paddingBottom;
        paddingBottom = getPaddingLeft() + getPaddingRight();
        int i5 = 0;
        while (i3 < getChildCount()) {
            UnderwoodAttachmentViewController a = this.f17330a.m21134a(i3);
            View h = a.mo1351h();
            if (h.getVisibility() != 8) {
                measureChild(h, i, i2);
                if (i5 == 0) {
                    paddingBottom += h.getMeasuredWidth();
                    i5 = 1;
                }
                i4 = (int) (((float) i4) + (a.mo1350g() * ((float) h.getMeasuredHeight())));
            }
            i3++;
        }
        setMeasuredDimension(View.resolveSize(Math.max(paddingBottom, getSuggestedMinimumWidth()), i), View.resolveSize(Math.max(i4, getSuggestedMinimumHeight()), i2));
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingLeft = getPaddingLeft();
        int width = getWidth() - getPaddingRight();
        int paddingTop = getPaddingTop();
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            UnderwoodAttachmentViewController a = this.f17330a.m21134a(i5);
            View h = a.mo1351h();
            if (h.getVisibility() != 8) {
                int measuredHeight = h.getMeasuredHeight();
                h.layout(paddingLeft, paddingTop, width, paddingTop + measuredHeight);
                paddingTop = (int) (((float) paddingTop) + (a.mo1350g() * ((float) measuredHeight)));
            }
        }
    }
}
