package com.facebook.instantshopping.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.common.util.SizeUtil;

/* compiled from: SHOPPING */
public class InstantShoppingDividerView extends View {
    public InstantShoppingDividerView(Context context) {
        super(context);
    }

    public InstantShoppingDividerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public InstantShoppingDividerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), SizeUtil.a(getContext(), 1.0f));
    }
}
