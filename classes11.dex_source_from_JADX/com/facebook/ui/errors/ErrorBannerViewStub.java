package com.facebook.ui.errors;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.widget.CustomViewStub;

/* compiled from: nearby_places_fallback */
public class ErrorBannerViewStub extends CustomViewStub {
    public ErrorBannerViewStub(Context context) {
        super(context);
    }

    public ErrorBannerViewStub(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ErrorBannerViewStub(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected View getInflatedLayout() {
        return new ErrorBannerView(getContext());
    }
}
