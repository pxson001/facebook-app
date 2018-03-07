package com.facebook.rapidfeedback.background;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.facebook.widget.CustomFrameLayout;

/* compiled from: failedSend */
public class ClippedImageView extends CustomFrameLayout {
    public Drawable f15370a;
    public Rect f15371b;
    public Rect f15372c;

    public ClippedImageView(Context context) {
        super(context);
        setWillNotDraw(false);
    }

    public void setDrawableBounds(Rect rect) {
        if (this.f15370a != null) {
            this.f15370a.setBounds(rect);
        }
        this.f15372c = rect;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f15370a != null) {
            canvas.save();
            canvas.clipRect(this.f15371b);
            this.f15370a.draw(canvas);
            canvas.restore();
        }
    }
}
