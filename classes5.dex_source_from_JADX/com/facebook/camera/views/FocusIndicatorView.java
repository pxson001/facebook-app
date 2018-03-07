package com.facebook.camera.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AnimationUtils;

/* compiled from: allEventMembers */
public class FocusIndicatorView extends View implements FocusIndicator {
    Context f11079a;

    public FocusIndicatorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11079a = context;
    }

    private void m19070a(int i) {
        startAnimation(AnimationUtils.loadAnimation(this.f11079a, i));
    }

    private void setDrawable(int i) {
        setBackgroundDrawable(getResources().getDrawable(i));
    }

    public final void mo1180a() {
        setDrawable(2130837943);
        setVisibility(0);
    }

    public final void mo1181b() {
        m19070a(2130968596);
        setVisibility(4);
    }

    public final void mo1182c() {
        setVisibility(4);
    }

    public final void mo1183d() {
        setBackgroundDrawable(null);
    }
}
