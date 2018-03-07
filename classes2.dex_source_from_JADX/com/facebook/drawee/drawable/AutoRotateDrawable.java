package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;

/* compiled from: graphql */
public class AutoRotateDrawable extends ForwardingDrawable implements Runnable {
    @VisibleForTesting
    float f21943a;
    public int f21944c;
    private boolean f21945d;
    public boolean f21946e;

    public AutoRotateDrawable(Drawable drawable, int i) {
        this(drawable, i, true);
    }

    private AutoRotateDrawable(Drawable drawable, int i, boolean z) {
        super((Drawable) Preconditions.a(drawable));
        this.f21943a = 0.0f;
        this.f21946e = false;
        this.f21944c = i;
        this.f21945d = z;
    }

    public void draw(Canvas canvas) {
        int save = canvas.save();
        Rect bounds = getBounds();
        int i = bounds.right - bounds.left;
        int i2 = bounds.bottom - bounds.top;
        float f = this.f21943a;
        if (!this.f21945d) {
            f = 360.0f - this.f21943a;
        }
        canvas.rotate(f, (float) ((i / 2) + bounds.left), (float) (bounds.top + (i2 / 2)));
        super.draw(canvas);
        canvas.restoreToCount(save);
        if (!this.f21946e) {
            this.f21946e = true;
            scheduleSelf(this, SystemClock.uptimeMillis() + 20);
        }
    }

    public void run() {
        this.f21946e = false;
        this.f21943a += (float) ((int) ((20.0f / ((float) this.f21944c)) * 360.0f));
        invalidateSelf();
    }
}
