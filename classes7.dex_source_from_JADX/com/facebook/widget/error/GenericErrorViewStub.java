package com.facebook.widget.error;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.widget.CustomViewStub;

/* compiled from: delay */
public class GenericErrorViewStub extends CustomViewStub {
    public GenericErrorViewStub(Context context) {
        super(context);
    }

    public GenericErrorViewStub(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public GenericErrorViewStub(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected View getInflatedLayout() {
        return new GenericErrorView(getContext());
    }
}
