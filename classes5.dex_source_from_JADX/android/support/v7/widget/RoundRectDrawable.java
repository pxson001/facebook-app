package android.support.v7.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* compiled from: treehouseheaderCoverPhoto */
public class RoundRectDrawable extends Drawable {
    public float f1416a;
    public final Paint f1417b;
    private final RectF f1418c;
    private final Rect f1419d;
    public float f1420e;
    private boolean f1421f = false;
    private boolean f1422g = true;

    public RoundRectDrawable(int i, float f) {
        this.f1416a = f;
        this.f1417b = new Paint(5);
        this.f1417b.setColor(i);
        this.f1418c = new RectF();
        this.f1419d = new Rect();
    }

    final void m1950a(float f, boolean z, boolean z2) {
        if (f != this.f1420e || this.f1421f != z || this.f1422g != z2) {
            this.f1420e = f;
            this.f1421f = z;
            this.f1422g = z2;
            m1948a(null);
            invalidateSelf();
        }
    }

    public void draw(Canvas canvas) {
        canvas.drawRoundRect(this.f1418c, this.f1416a, this.f1416a, this.f1417b);
    }

    private void m1948a(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        this.f1418c.set((float) rect.left, (float) rect.top, (float) rect.right, (float) rect.bottom);
        this.f1419d.set(rect);
        if (this.f1421f) {
            float a = RoundRectDrawableWithShadow.m1951a(this.f1420e, this.f1416a, this.f1422g);
            this.f1419d.inset((int) Math.ceil((double) RoundRectDrawableWithShadow.m1954b(this.f1420e, this.f1416a, this.f1422g)), (int) Math.ceil((double) a));
            this.f1418c.set(this.f1419d);
        }
    }

    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        m1948a(rect);
    }

    public void getOutline(Outline outline) {
        outline.setRoundRect(this.f1419d, this.f1416a);
    }

    final void m1949a(float f) {
        if (f != this.f1416a) {
            this.f1416a = f;
            m1948a(null);
            invalidateSelf();
        }
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getOpacity() {
        return -3;
    }
}
