package android.support.v7.widget;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;

/* compiled from: type parameter */
public class RoundRectDrawableWithShadow extends Drawable {
    static final double f1423a = Math.cos(Math.toRadians(45.0d));
    static RoundRectHelper f1424c;
    public final int f1425b;
    public Paint f1426d;
    Paint f1427e;
    Paint f1428f;
    final RectF f1429g;
    public float f1430h;
    Path f1431i;
    float f1432j;
    public float f1433k;
    float f1434l;
    public float f1435m;
    public boolean f1436n = true;
    private final int f1437o;
    private final int f1438p;
    private boolean f1439q = true;
    private boolean f1440r = false;

    /* compiled from: type parameter */
    interface RoundRectHelper {
        void mo446a(Canvas canvas, RectF rectF, float f, Paint paint);
    }

    RoundRectDrawableWithShadow(Resources resources, int i, float f, float f2, float f3) {
        this.f1437o = resources.getColor(2131362712);
        this.f1438p = resources.getColor(2131362713);
        this.f1425b = resources.getDimensionPixelSize(2131428703);
        this.f1426d = new Paint(5);
        this.f1426d.setColor(i);
        this.f1427e = new Paint(5);
        this.f1427e.setStyle(Style.FILL);
        this.f1430h = (float) ((int) (0.5f + f));
        this.f1429g = new RectF();
        this.f1428f = new Paint(this.f1427e);
        this.f1428f.setAntiAlias(false);
        m1952a(f2, f3);
    }

    private static int m1956d(float f) {
        int i = (int) (0.5f + f);
        if (i % 2 == 1) {
            return i - 1;
        }
        return i;
    }

    public final void m1958a(boolean z) {
        this.f1439q = z;
        invalidateSelf();
    }

    public void setAlpha(int i) {
        this.f1426d.setAlpha(i);
        this.f1427e.setAlpha(i);
        this.f1428f.setAlpha(i);
    }

    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f1436n = true;
    }

    private void m1952a(float f, float f2) {
        if (f < 0.0f || f2 < 0.0f) {
            throw new IllegalArgumentException("invalid shadow size");
        }
        float d = (float) m1956d(f);
        float d2 = (float) m1956d(f2);
        if (d > d2) {
            if (!this.f1440r) {
                this.f1440r = true;
            }
            d = d2;
        }
        if (this.f1435m != d || this.f1433k != d2) {
            this.f1435m = d;
            this.f1433k = d2;
            this.f1434l = (float) ((int) (((d * 1.5f) + ((float) this.f1425b)) + 0.5f));
            this.f1432j = ((float) this.f1425b) + d2;
            this.f1436n = true;
            invalidateSelf();
        }
    }

    public boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil((double) m1951a(this.f1433k, this.f1430h, this.f1439q));
        int ceil2 = (int) Math.ceil((double) m1954b(this.f1433k, this.f1430h, this.f1439q));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    static float m1951a(float f, float f2, boolean z) {
        if (z) {
            return (float) (((double) (1.5f * f)) + ((1.0d - f1423a) * ((double) f2)));
        }
        return 1.5f * f;
    }

    static float m1954b(float f, float f2, boolean z) {
        if (z) {
            return (float) (((double) f) + ((1.0d - f1423a) * ((double) f2)));
        }
        return f;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f1426d.setColorFilter(colorFilter);
        this.f1427e.setColorFilter(colorFilter);
        this.f1428f.setColorFilter(colorFilter);
    }

    public int getOpacity() {
        return -3;
    }

    public void draw(Canvas canvas) {
        if (this.f1436n) {
            m1955b(getBounds());
            this.f1436n = false;
        }
        canvas.translate(0.0f, this.f1435m / 2.0f);
        m1953a(canvas);
        canvas.translate(0.0f, (-this.f1435m) / 2.0f);
        f1424c.mo446a(canvas, this.f1429g, this.f1430h, this.f1426d);
    }

    private void m1953a(Canvas canvas) {
        Object obj;
        float f = (-this.f1430h) - this.f1434l;
        float f2 = (this.f1430h + ((float) this.f1425b)) + (this.f1435m / 2.0f);
        Object obj2 = this.f1429g.width() - (2.0f * f2) > 0.0f ? 1 : null;
        if (this.f1429g.height() - (2.0f * f2) > 0.0f) {
            obj = 1;
        } else {
            obj = null;
        }
        int save = canvas.save();
        canvas.translate(this.f1429g.left + f2, this.f1429g.top + f2);
        canvas.drawPath(this.f1431i, this.f1427e);
        if (obj2 != null) {
            canvas.drawRect(0.0f, f, this.f1429g.width() - (2.0f * f2), -this.f1430h, this.f1428f);
        }
        canvas.restoreToCount(save);
        save = canvas.save();
        canvas.translate(this.f1429g.right - f2, this.f1429g.bottom - f2);
        canvas.rotate(180.0f);
        canvas.drawPath(this.f1431i, this.f1427e);
        if (obj2 != null) {
            canvas.drawRect(0.0f, f, this.f1429g.width() - (2.0f * f2), this.f1434l + (-this.f1430h), this.f1428f);
        }
        canvas.restoreToCount(save);
        int save2 = canvas.save();
        canvas.translate(this.f1429g.left + f2, this.f1429g.bottom - f2);
        canvas.rotate(270.0f);
        canvas.drawPath(this.f1431i, this.f1427e);
        if (obj != null) {
            canvas.drawRect(0.0f, f, this.f1429g.height() - (2.0f * f2), -this.f1430h, this.f1428f);
        }
        canvas.restoreToCount(save2);
        save2 = canvas.save();
        canvas.translate(this.f1429g.right - f2, this.f1429g.top + f2);
        canvas.rotate(90.0f);
        canvas.drawPath(this.f1431i, this.f1427e);
        if (obj != null) {
            canvas.drawRect(0.0f, f, this.f1429g.height() - (2.0f * f2), -this.f1430h, this.f1428f);
        }
        canvas.restoreToCount(save2);
    }

    private void m1957f() {
        RectF rectF = new RectF(-this.f1430h, -this.f1430h, this.f1430h, this.f1430h);
        RectF rectF2 = new RectF(rectF);
        rectF2.inset(-this.f1434l, -this.f1434l);
        if (this.f1431i == null) {
            this.f1431i = new Path();
        } else {
            this.f1431i.reset();
        }
        this.f1431i.setFillType(FillType.EVEN_ODD);
        this.f1431i.moveTo(-this.f1430h, 0.0f);
        this.f1431i.rLineTo(-this.f1434l, 0.0f);
        this.f1431i.arcTo(rectF2, 180.0f, 90.0f, false);
        this.f1431i.arcTo(rectF, 270.0f, -90.0f, false);
        this.f1431i.close();
        float f = this.f1430h / (this.f1430h + this.f1434l);
        float[] fArr = new float[]{0.0f, f, 1.0f};
        f = 0.0f;
        this.f1427e.setShader(new RadialGradient(0.0f, f, this.f1430h + this.f1434l, new int[]{this.f1437o, this.f1437o, this.f1438p}, fArr, TileMode.CLAMP));
        float f2 = 0.0f;
        this.f1428f.setShader(new LinearGradient(0.0f, (-this.f1430h) + this.f1434l, f2, (-this.f1430h) - this.f1434l, new int[]{this.f1437o, this.f1437o, this.f1438p}, new float[]{0.0f, 0.5f, 1.0f}, TileMode.CLAMP));
        this.f1428f.setAntiAlias(false);
    }

    private void m1955b(Rect rect) {
        float f = this.f1433k * 1.5f;
        this.f1429g.set(((float) rect.left) + this.f1433k, ((float) rect.top) + f, ((float) rect.right) - this.f1433k, ((float) rect.bottom) - f);
        m1957f();
    }

    final void m1959b(float f) {
        m1952a(f, this.f1433k);
    }

    final void m1960c(float f) {
        m1952a(this.f1435m, f);
    }
}
