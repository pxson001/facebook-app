package com.facebook.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.widget.ProgressBar;

/* compiled from: com.google.android.gms.signin.internal.signInCallbacks */
public class CustomProgressBar extends ProgressBar {
    private LayerDrawable f5592a;
    private Drawable f5593b;

    public CustomProgressBar(Context context) {
        super(context);
        m10403b();
    }

    public CustomProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m10403b();
    }

    public CustomProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m10403b();
    }

    protected synchronized void onDraw(Canvas canvas) {
        m10402a();
        super.onDraw(canvas);
    }

    public synchronized void setProgress(int i) {
        super.setProgress(i);
        invalidate();
    }

    private void m10402a() {
        int progress = (int) (((float) (this.f5592a.getBounds().right - this.f5592a.getBounds().left)) * (((float) getProgress()) / ((float) getMax())));
        Rect bounds = this.f5593b.getBounds();
        bounds.right = progress + bounds.left;
        this.f5593b.setBounds(bounds);
    }

    private void m10403b() {
        this.f5592a = (LayerDrawable) getProgressDrawable();
        this.f5593b = this.f5592a.findDrawableByLayerId(2131559623);
    }
}
