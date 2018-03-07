package com.facebook.composer.minutiae.view.stubs;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.composer.minutiae.view.MinutiaeFooterView;
import com.facebook.widget.CustomViewStub;

/* compiled from: temperature_text */
public class MinutiaeFooterViewStub extends CustomViewStub {
    public MinutiaeFooterViewStub(Context context) {
        super(context);
    }

    public MinutiaeFooterViewStub(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MinutiaeFooterViewStub(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected View getInflatedLayout() {
        return new MinutiaeFooterView(getContext(), null);
    }
}
