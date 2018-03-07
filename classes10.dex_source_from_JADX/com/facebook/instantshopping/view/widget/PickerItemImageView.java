package com.facebook.instantshopping.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.common.util.SizeUtil;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchy;

/* compiled from: SET_NAME */
public class PickerItemImageView extends FbDraweeView {
    private int f23936c;

    public PickerItemImageView(Context context, GenericDraweeHierarchy genericDraweeHierarchy) {
        super(context, genericDraweeHierarchy);
    }

    public PickerItemImageView(Context context) {
        super(context);
    }

    public PickerItemImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PickerItemImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setIsSelected(boolean z) {
        setBorderColor(z ? getContext().getResources().getColor(2131363674) : getContext().getResources().getColor(2131361871));
    }

    public void setSizeOffset(int i) {
        this.f23936c = i;
    }

    private void setBorderColor(int i) {
        GenericDraweeHierarchy genericDraweeHierarchy = (GenericDraweeHierarchy) getHierarchy();
        if (genericDraweeHierarchy != null) {
            genericDraweeHierarchy.a(genericDraweeHierarchy.c.a(i, (float) SizeUtil.a(getContext(), 2.0f)));
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredHeight = getMeasuredHeight() - SizeUtil.a(getContext(), (float) (this.f23936c * 2));
        setMeasuredDimension(measuredHeight, measuredHeight);
    }
}
