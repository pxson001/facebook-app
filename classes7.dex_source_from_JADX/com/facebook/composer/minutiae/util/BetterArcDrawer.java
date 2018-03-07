package com.facebook.composer.minutiae.util;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import com.google.common.base.Preconditions;

/* compiled from: thank_you */
public class BetterArcDrawer {
    private Paint f1817a;
    private int f1818b;
    private final PointF f1819c;
    private final PointF f1820d;
    private final Path f1821e;

    public BetterArcDrawer(Paint paint, int i) {
        this.f1817a = paint;
        Preconditions.checkArgument(i >= 4);
        this.f1818b = i;
        this.f1819c = new PointF(0.0f, 0.0f);
        this.f1820d = new PointF(0.0f, 0.0f);
        this.f1821e = new Path();
    }

    public final void m1807a(Canvas canvas, PointF pointF, float f, float f2, float f3) {
        canvas.drawPath(m1805a(pointF, f, m1804a(f2), m1804a(f3)), this.f1817a);
    }

    private static float m1804a(float f) {
        float f2 = f % 360.0f;
        if (f2 < 0.0f) {
            return f2 + 360.0f;
        }
        return f2;
    }

    private Path m1805a(PointF pointF, float f, float f2, float f3) {
        this.f1821e.reset();
        float f4 = f3 / ((float) this.f1818b);
        Object obj = 1;
        float f5 = 0.0f;
        while (f5 < f3) {
            Object obj2;
            float f6 = f3 - f5 >= f4 ? f4 : f3 - f5;
            m1806a(pointF, f, f2 + f5, this.f1819c);
            m1806a(pointF, f, (f2 + f5) + f6, this.f1820d);
            float f7 = f5 + f6;
            if (obj != null) {
                this.f1821e.moveTo(this.f1819c.x, this.f1819c.y);
                obj2 = null;
            } else {
                obj2 = obj;
            }
            double d = (double) (this.f1819c.x - pointF.x);
            double d2 = (double) (this.f1819c.y - pointF.y);
            double d3 = (double) (this.f1820d.x - pointF.x);
            double d4 = (double) (this.f1820d.y - pointF.y);
            double d5 = (d * d) + (d2 * d2);
            double d6 = ((d * d3) + d5) + (d2 * d4);
            d6 = ((Math.sqrt((d5 * 2.0d) * d6) - d6) * 1.0d) / ((d * d4) - (d2 * d3));
            this.f1821e.cubicTo((float) ((((double) pointF.x) + d) - (d6 * d2)), (float) ((d * d6) + (d2 + ((double) pointF.y))), (float) ((((double) pointF.x) + d3) + (d6 * d4)), (float) ((((double) pointF.y) + d4) - (d3 * d6)), this.f1820d.x, this.f1820d.y);
            obj = obj2;
            f5 = f7;
        }
        return this.f1821e;
    }

    private static void m1806a(PointF pointF, float f, float f2, PointF pointF2) {
        pointF2.x = (float) (((double) pointF.x) + (((double) f) * Math.cos(Math.toRadians((double) f2))));
        pointF2.y = (float) (((double) pointF.y) + (((double) f) * Math.sin(Math.toRadians((double) f2))));
    }
}
