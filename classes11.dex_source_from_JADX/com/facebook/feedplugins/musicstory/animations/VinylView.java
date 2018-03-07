package com.facebook.feedplugins.musicstory.animations;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import com.google.common.base.Preconditions;

/* compiled from: composer_collapse_inline_sprout_event */
public class VinylView extends View {
    private final Path f8307a = new Path();
    private final Path f8308b = new Path();
    public Drawable f8309c;
    private float f8310d;
    private float f8311e;
    private RectF f8312f;

    public VinylView(Context context) {
        super(context);
        m9237b();
    }

    public VinylView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m9237b();
    }

    public VinylView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m9237b();
    }

    private void m9237b() {
        if (VERSION.SDK_INT < 18) {
            setLayerType(1, null);
        }
    }

    public void setDrawable(Drawable drawable) {
        this.f8309c = drawable;
    }

    public void setRectangularity(float f) {
        boolean z = f >= 0.0f && f <= 1.0f;
        Preconditions.checkArgument(z);
        this.f8310d = f;
    }

    public final void m9238a() {
        this.f8310d = 0.0f;
        clearAnimation();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.f8311e = (float) (i3 - i);
            this.f8308b.addCircle(this.f8311e / 2.0f, this.f8311e / 2.0f, this.f8311e / 2.0f, Direction.CW);
            this.f8312f = new RectF(0.0f, 0.0f, this.f8311e, this.f8311e);
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f8309c != null && this.f8308b != null && this.f8312f != null) {
            if (this.f8310d == 0.0f) {
                canvas.clipPath(this.f8308b);
            } else {
                this.f8307a.reset();
                this.f8307a.addRoundRect(this.f8312f, (1.0f - this.f8310d) * this.f8311e, (1.0f - this.f8310d) * this.f8311e, Direction.CW);
                canvas.clipPath(this.f8307a);
            }
            this.f8309c.draw(canvas);
        }
    }
}
