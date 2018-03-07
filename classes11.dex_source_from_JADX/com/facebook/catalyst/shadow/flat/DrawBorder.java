package com.facebook.catalyst.shadow.flat;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.PathEffect;
import javax.annotation.Nullable;

/* compiled from: mMask */
public final class DrawBorder extends AbstractDrawBorder {
    public static final Paint f5626c = new Paint(1);
    private static final float[] f5627d = new float[4];
    public float f5628e;
    public float f5629f;
    public float f5630g;
    public float f5631h;
    public int f5632i;
    public int f5633j;
    public int f5634k;
    public int f5635l;
    public int f5636m = 0;
    public int f5637n;
    @Nullable
    private DashPathEffect f5638o;

    DrawBorder() {
    }

    @Nullable
    protected final PathEffect mo156i() {
        if (m6934b(32)) {
            switch (this.f5636m) {
                case 1:
                    this.f5638o = m6949c(this.f5620g);
                    break;
                case 2:
                    this.f5638o = m6949c(this.f5620g * 3.0f);
                    break;
                default:
                    this.f5638o = null;
                    break;
            }
            m6936d(32);
        }
        return this.f5638o;
    }

    protected final void mo155c(Canvas canvas) {
        if (this.f5621h >= 0.5f) {
            if (this.f5637n != 0) {
                f5626c.setColor(this.f5637n);
                canvas.drawPath(m6941j(), f5626c);
            }
            if (this.f5620g >= 0.5f && this.f5619f != 0) {
                AbstractDrawBorder.f5616c.setColor(this.f5619f);
                AbstractDrawBorder.f5616c.setStrokeWidth(this.f5620g);
                AbstractDrawBorder.f5616c.setPathEffect(mo156i());
                canvas.drawPath(m6941j(), AbstractDrawBorder.f5616c);
                return;
            }
            return;
        }
        m6950e(canvas);
    }

    private void m6950e(Canvas canvas) {
        int g = m6938g();
        float e = m6937e();
        float a = m6947a(this.f5629f, e);
        float n = m6931n() + a;
        int a2 = m6948a(4, this.f5633j, g);
        if (!(Color.alpha(a2) == 0 || a == 0.0f)) {
            f5626c.setColor(a2);
            canvas.drawRect(m6930m(), m6931n(), m6932o(), n, f5626c);
        }
        a = m6947a(this.f5631h, e);
        float p = m6933p() - a;
        a2 = m6948a(16, this.f5635l, g);
        if (!(Color.alpha(a2) == 0 || a == 0.0f)) {
            f5626c.setColor(a2);
            canvas.drawRect(m6930m(), p, m6932o(), m6933p(), f5626c);
        }
        a = m6947a(this.f5628e, e);
        float m = m6930m() + a;
        a2 = m6948a(2, this.f5632i, g);
        if (!(Color.alpha(a2) == 0 || a == 0.0f)) {
            f5626c.setColor(a2);
            canvas.drawRect(m6930m(), n, m, p, f5626c);
        }
        a = m6947a(this.f5630g, e);
        float o = m6932o() - a;
        a2 = m6948a(8, this.f5634k, g);
        if (!(Color.alpha(a2) == 0 || a == 0.0f)) {
            f5626c.setColor(a2);
            canvas.drawRect(o, n, m6932o(), p, f5626c);
        }
        if (Color.alpha(this.f5637n) != 0) {
            f5626c.setColor(this.f5637n);
            canvas.drawRect(m, n, o, p, f5626c);
        }
    }

    private int m6948a(int i, int i2, int i3) {
        return m6934b(i) ? i2 : i3;
    }

    private static float m6947a(float f, float f2) {
        return f == 0.0f ? f2 : f;
    }

    private static DashPathEffect m6949c(float f) {
        for (int i = 0; i < 4; i++) {
            f5627d[i] = f;
        }
        return new DashPathEffect(f5627d, 0.0f);
    }
}
