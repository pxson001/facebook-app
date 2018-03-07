package com.facebook.messaging.business.common.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchy;

/* compiled from: nav_section_mobile_sidebar */
public class BusinessBubblePreviewView extends FbDraweeView {
    public BusinessBubblePreviewView(Context context, GenericDraweeHierarchy genericDraweeHierarchy) {
        super(context, genericDraweeHierarchy);
    }

    public BusinessBubblePreviewView(Context context) {
        super(context);
    }

    public BusinessBubblePreviewView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BusinessBubblePreviewView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void onMeasure(int i, int i2) {
        int size = MeasureSpec.getSize(i);
        setMeasuredDimension(size, (int) (((double) size) / 1.9d));
    }
}
