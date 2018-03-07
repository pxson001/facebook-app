package com.facebook.feed.util.composer.sprout;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import javax.annotation.Nullable;

/* compiled from: TSECTION; */
public class SproutIconDrawable extends Drawable {
    private final Resources f22430a;
    private final int f22431b;
    public final Paint f22432c = new Paint(1);
    private int f22433d = 0;
    @Nullable
    public ColorFilter f22434e;
    @Nullable
    public Drawable f22435f;

    public SproutIconDrawable(Resources resources) {
        this.f22430a = resources;
        this.f22431b = resources.getDimensionPixelSize(2131429788);
    }

    public final void m25031b(int i) {
        if (this.f22433d != i) {
            this.f22433d = i;
            if (i == 0) {
                this.f22435f = null;
                return;
            }
            this.f22435f = this.f22430a.getDrawable(i);
            if (this.f22435f == null) {
                throw new NullPointerException("mIconDrawable is null! resId=" + i);
            }
            if (this.f22434e != null) {
                this.f22435f.setColorFilter(this.f22434e);
            }
            this.f22435f.setBounds((this.f22431b - this.f22435f.getIntrinsicWidth()) / 2, (this.f22431b - this.f22435f.getIntrinsicHeight()) / 2, (this.f22431b + this.f22435f.getIntrinsicWidth()) / 2, (this.f22431b + this.f22435f.getIntrinsicHeight()) / 2);
            invalidateSelf();
        }
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int width = bounds.left + ((bounds.width() - this.f22431b) / 2);
        int height = ((bounds.height() - this.f22431b) / 2) + bounds.top;
        canvas.translate((float) width, (float) height);
        float f = (float) (this.f22431b / 2);
        canvas.drawCircle(f, f, (float) (this.f22431b / 2), this.f22432c);
        if (this.f22435f != null) {
            this.f22435f.draw(canvas);
        }
        canvas.translate((float) (-width), (float) (-height));
    }

    public int getIntrinsicHeight() {
        return this.f22431b;
    }

    public int getIntrinsicWidth() {
        return this.f22431b;
    }

    public void setAlpha(int i) {
        this.f22432c.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getOpacity() {
        return 0;
    }
}
