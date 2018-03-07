package com.facebook.instantshopping.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.common.util.SizeUtil;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;

/* compiled from: SET_OPTIMISTIC_GUEST_STATUS */
public class PickerItemColorView extends FbDraweeView {
    public int f23934c;
    public int f23935d;

    public PickerItemColorView(Context context) {
        super(context);
        m25205d();
    }

    public PickerItemColorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m25205d();
    }

    public PickerItemColorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m25205d();
    }

    private void m25205d() {
        setIsSelected(false);
    }

    public void setColor(int i) {
        this.f23934c = i;
    }

    public void setIsSelected(boolean z) {
        int color = z ? getContext().getResources().getColor(2131363674) : getContext().getResources().getColor(2131361871);
        RoundingParams roundingParams = ((GenericDraweeHierarchy) getHierarchy()).c;
        roundingParams.a(color, 2.0f);
        roundingParams.b = true;
        ((GenericDraweeHierarchy) getHierarchy()).a(roundingParams);
    }

    public void setSizeOffset(int i) {
        this.f23935d = i;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (getHeight() > 0) {
            setColorFilter(this.f23934c);
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredHeight = getMeasuredHeight() - SizeUtil.a(getContext(), (float) (this.f23935d * 2));
        setMeasuredDimension(measuredHeight, measuredHeight);
    }

    public final void m25206c() {
        int color = getContext().getResources().getColor(2131361920);
        RoundingParams roundingParams = ((GenericDraweeHierarchy) getHierarchy()).c;
        roundingParams.a(color, 2.0f);
        roundingParams.b = true;
        ((GenericDraweeHierarchy) getHierarchy()).a(roundingParams);
        this.f23934c = 16777215;
    }
}
