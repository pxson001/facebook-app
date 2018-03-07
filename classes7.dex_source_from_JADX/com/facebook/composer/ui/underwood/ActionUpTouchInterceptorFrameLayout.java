package com.facebook.composer.ui.underwood;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;

/* compiled from: composerConfig */
public class ActionUpTouchInterceptorFrameLayout extends FrameLayout {
    private boolean f17115a;
    private OnTouchListener f17116b;

    public ActionUpTouchInterceptorFrameLayout(Context context) {
        super(context);
    }

    public ActionUpTouchInterceptorFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ActionUpTouchInterceptorFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setShouldInterceptTouchEvent(boolean z) {
        this.f17115a = z;
    }

    public void setOnTouchListener(OnTouchListener onTouchListener) {
        super.setOnTouchListener(onTouchListener);
        this.f17116b = onTouchListener;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f17115a && motionEvent.getAction() == 1 && this.f17116b != null) {
            this.f17116b.onTouch(this, motionEvent);
        }
        return this.f17115a;
    }
}
