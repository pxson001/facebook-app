package com.facebook.directinstall.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.widget.ProgressBar;

/* compiled from: og_mechanism */
public class ProgressBarCompat extends ProgressBar {
    public ProgressBarCompat(Context context) {
        super(context);
    }

    public ProgressBarCompat(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ProgressBarCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void onDraw(Canvas canvas) {
        Object obj = 1;
        if (ViewCompat.h(this) != 1) {
            obj = null;
        }
        if (obj != null) {
            canvas.save();
            canvas.rotate(180.0f, (float) (getWidth() / 2), (float) (getHeight() / 2));
        }
        super.onDraw(canvas);
        if (obj != null) {
            canvas.restore();
        }
    }
}
