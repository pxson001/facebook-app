package com.facebook.composer.minutiae.view.stubs;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import com.facebook.widget.CustomViewStub;

/* compiled from: temperature_scale */
public class MinutiaeListViewStub extends CustomViewStub {
    public boolean f1901b = false;

    public MinutiaeListViewStub(Context context) {
        super(context);
    }

    public MinutiaeListViewStub(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MinutiaeListViewStub(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setRidgeEnabled(boolean z) {
        this.f1901b = z;
    }

    public final View m1862a() {
        View a = super.a();
        a.setId(this.f1901b ? 2131560579 : 16908298);
        return a;
    }

    protected View getInflatedLayout() {
        return LayoutInflater.from(getContext()).inflate(this.f1901b ? 2130903707 : 2130903700, null);
    }
}
