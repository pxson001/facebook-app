package com.facebook.widget.tiles;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.Shape;

/* compiled from: com.google.android.gms.location.ILocationListener */
public class BetterRoundRectShape extends RectShape {
    private float[] f19902a;
    private RectF f19903b;
    private float[] f19904c;
    private RectF f19905d;
    private Path f19906e;
    private float f19907f;
    private float f19908g;
    private float f19909h;
    private int f19910i;
    private Path f19911j;
    private RectF f19912k;

    public /* synthetic */ RectShape clone() {
        return m28626b();
    }

    public /* synthetic */ Shape m28962clone() {
        return m28626b();
    }

    public /* synthetic */ Object m28963clone() {
        return m28626b();
    }

    public BetterRoundRectShape(float[] fArr, RectF rectF, float[] fArr2) {
        if (fArr != null && fArr.length < 8) {
            throw new ArrayIndexOutOfBoundsException("outer radii must have >= 8 values");
        } else if (fArr2 == null || fArr2.length >= 8) {
            this.f19902a = fArr;
            this.f19903b = rectF;
            this.f19904c = fArr2;
            if (rectF != null) {
                this.f19905d = new RectF();
            }
            this.f19906e = new Path();
            this.f19912k = new RectF();
        } else {
            throw new ArrayIndexOutOfBoundsException("inner radii must have >= 8 values");
        }
    }

    public final void m28627a(float[] fArr) {
        if (fArr == null || fArr.length >= 8) {
            this.f19902a = fArr;
            m28625a();
            return;
        }
        throw new ArrayIndexOutOfBoundsException("outer radii must have >= 8 values");
    }

    public void draw(Canvas canvas, Paint paint) {
        if (this.f19902a == null || this.f19905d != null) {
            canvas.drawPath(this.f19906e, paint);
        } else {
            RectF rect = rect();
            this.f19912k.set(rect.left, rect.top, this.f19902a[0] * 2.0f, this.f19902a[1] * 2.0f);
            canvas.drawArc(this.f19912k, 180.0f, 90.0f, true, paint);
            this.f19912k.set(rect.right - (this.f19902a[2] * 2.0f), rect.top, rect.right, this.f19902a[3] * 2.0f);
            canvas.drawArc(this.f19912k, 270.0f, 90.0f, true, paint);
            this.f19912k.set(rect.right - (this.f19902a[4] * 2.0f), rect.bottom - (this.f19902a[5] * 2.0f), rect.right, rect.bottom);
            canvas.drawArc(this.f19912k, 0.0f, 90.0f, true, paint);
            this.f19912k.set(rect.left, rect.bottom - (this.f19902a[7] * 2.0f), rect.left + (this.f19902a[6] * 2.0f), rect.bottom);
            canvas.drawArc(this.f19912k, 90.0f, 90.0f, true, paint);
            float max = Math.max(this.f19902a[0], this.f19902a[6]) + rect.left;
            float max2 = Math.max(this.f19902a[1], this.f19902a[3]) + rect.top;
            float max3 = rect.right - Math.max(this.f19902a[2], this.f19902a[4]);
            float max4 = rect.bottom - Math.max(this.f19902a[5], this.f19902a[7]);
            canvas.drawRect(max, max2, max3, max4, paint);
            canvas.drawRect(rect.left, rect.top + this.f19902a[1], max, rect.bottom - this.f19902a[7], paint);
            canvas.drawRect(rect.left + this.f19902a[0], rect.top, rect.right - this.f19902a[2], max2, paint);
            canvas.drawRect(max3, rect.top + this.f19902a[3], rect.right, rect.bottom - this.f19902a[5], paint);
            canvas.drawRect(rect.left + this.f19902a[6], max4, rect.right - this.f19902a[4], rect.bottom, paint);
        }
        if (this.f19911j != null) {
            Paint paint2 = new Paint(paint);
            paint2.setStyle(Style.STROKE);
            paint2.setStrokeWidth(this.f19909h);
            paint2.setColor(this.f19910i);
            canvas.drawPath(this.f19911j, paint2);
        }
    }

    protected void onResize(float f, float f2) {
        this.f19907f = f;
        this.f19908g = f2;
        super.onResize(f, f2);
        m28625a();
    }

    private void m28625a() {
        RectF rect = rect();
        this.f19906e.reset();
        if (this.f19902a != null) {
            this.f19906e.addRoundRect(rect, this.f19902a, Direction.CW);
        } else {
            this.f19906e.addRect(rect, Direction.CW);
        }
        if (this.f19905d != null) {
            this.f19905d.set(rect.left + this.f19903b.left, rect.top + this.f19903b.top, rect.right - this.f19903b.right, rect.bottom - this.f19903b.bottom);
            if (this.f19905d.width() < this.f19907f && this.f19905d.height() < this.f19908g) {
                if (this.f19904c != null) {
                    this.f19906e.addRoundRect(this.f19905d, this.f19904c, Direction.CCW);
                    if (this.f19911j != null) {
                        this.f19911j.reset();
                        this.f19911j.addRoundRect(this.f19905d, this.f19904c, Direction.CCW);
                        return;
                    }
                    return;
                }
                this.f19906e.addRect(this.f19905d, Direction.CCW);
            }
        }
    }

    private BetterRoundRectShape m28626b() {
        float[] fArr;
        RectF rectF;
        RectF rectF2 = null;
        BetterRoundRectShape betterRoundRectShape = (BetterRoundRectShape) super.clone();
        betterRoundRectShape.f19902a = this.f19902a != null ? (float[]) this.f19902a.clone() : null;
        if (this.f19904c != null) {
            fArr = (float[]) this.f19904c.clone();
        } else {
            fArr = null;
        }
        betterRoundRectShape.f19904c = fArr;
        if (this.f19903b != null) {
            rectF = new RectF(this.f19903b);
        } else {
            rectF = null;
        }
        betterRoundRectShape.f19903b = rectF;
        if (this.f19905d != null) {
            rectF2 = new RectF(this.f19905d);
        }
        betterRoundRectShape.f19905d = rectF2;
        betterRoundRectShape.f19906e = new Path(this.f19906e);
        betterRoundRectShape.f19909h = this.f19909h;
        betterRoundRectShape.f19910i = this.f19910i;
        if (this.f19911j != null) {
            betterRoundRectShape.f19911j = new Path(this.f19911j);
        }
        return betterRoundRectShape;
    }
}
