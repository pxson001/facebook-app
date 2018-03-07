package com.facebook.composer.minutiae.titlebar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.widget.CustomViewStub;

/* compiled from: thank_you_text */
public class RidgeTitleBarStub extends CustomViewStub {
    public RidgeTitleBarStub(Context context) {
        super(context);
    }

    public RidgeTitleBarStub(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RidgeTitleBarStub(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected View getInflatedLayout() {
        return new RidgeTitleBar(getContext());
    }
}
