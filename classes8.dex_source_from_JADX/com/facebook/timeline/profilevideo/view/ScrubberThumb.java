package com.facebook.timeline.profilevideo.view;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* compiled from: mGlyphDrawable is null! */
public class ScrubberThumb extends Drawable {
    private final Paint f9483a = new Paint();
    private final int f9484b;
    private final int f9485c;
    private final float f9486d;
    private final RectF f9487e;
    private final RectF f9488f;
    private final Rect f9489g;
    public Bitmap f9490h;
    public int f9491i;
    public int f9492j;

    public ScrubberThumb(Resources resources) {
        this.f9483a.setAntiAlias(true);
        this.f9484b = resources.getColor(2131361917);
        this.f9485c = resources.getColor(2131361920);
        this.f9487e = new RectF();
        this.f9488f = new RectF();
        this.f9489g = new Rect();
        this.f9486d = (float) resources.getDimensionPixelSize(2131432831);
    }

    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f9487e.set(rect);
        this.f9487e.inset(this.f9486d / 2.0f, this.f9486d / 2.0f);
        this.f9488f.set(rect);
        this.f9488f.inset(this.f9486d, this.f9486d);
    }

    public void draw(Canvas canvas) {
        this.f9483a.setStyle(Style.STROKE);
        this.f9483a.setStrokeWidth(this.f9486d);
        this.f9483a.setColor(this.f9484b);
        canvas.drawRoundRect(this.f9487e, 4.0f, 4.0f, this.f9483a);
        this.f9483a.setStyle(Style.FILL);
        if (this.f9490h != null) {
            int width;
            if (this.f9490h.getWidth() >= this.f9490h.getHeight()) {
                this.f9489g.top = 0;
                this.f9489g.bottom = this.f9490h.getHeight();
                width = (this.f9490h.getWidth() - this.f9490h.getHeight()) / 2;
                this.f9489g.left = width;
                this.f9489g.right = width + this.f9490h.getHeight();
            } else {
                this.f9489g.left = 0;
                this.f9489g.right = this.f9490h.getWidth();
                width = (this.f9490h.getHeight() - this.f9490h.getWidth()) / 2;
                this.f9489g.top = width;
                this.f9489g.bottom = width + this.f9490h.getWidth();
            }
            canvas.drawBitmap(this.f9490h, this.f9489g, this.f9488f, this.f9483a);
            return;
        }
        this.f9483a.setColor(this.f9485c);
        canvas.drawRect(this.f9488f, this.f9483a);
    }

    public int getIntrinsicWidth() {
        return this.f9492j;
    }

    public int getIntrinsicHeight() {
        return this.f9491i;
    }

    public void setAlpha(int i) {
        throw new UnsupportedOperationException("setAlpha not implemented");
    }

    public void setColorFilter(ColorFilter colorFilter) {
        throw new UnsupportedOperationException("setColorFilter not implemented");
    }

    public int getOpacity() {
        return -3;
    }
}
