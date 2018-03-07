package com.facebook.composer.minutiae.view.stubs;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.widget.CustomViewStub;
import com.facebook.widget.error.GenericErrorView;

/* compiled from: terms_and_conditions_text */
public class MinutiaeErrorViewStub extends CustomViewStub {
    public MinutiaeErrorViewStub(Context context) {
        super(context);
    }

    public MinutiaeErrorViewStub(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MinutiaeErrorViewStub(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected View getInflatedLayout() {
        GenericErrorView genericErrorView = new GenericErrorView(getContext());
        genericErrorView.setClickable(true);
        return genericErrorView;
    }
}
