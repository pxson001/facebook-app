package com.facebook.messaging.seenheads;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.shapes.OvalShape;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;

/* compiled from: deleted_post_ids */
public class CrescentShape extends OvalShape {
    private final Path f16622a = new Path();
    private float f16623b;
    private float f16624c;

    public CrescentShape(float f, float f2) {
        Preconditions.checkArgument(f != 0.0f);
        this.f16623b = f;
        this.f16624c = f2;
    }

    public void draw(Canvas canvas, Paint paint) {
        RectF rect = rect();
        float height = rect.height() / 2.0f;
        float f = (this.f16624c * 2.0f) * height;
        float f2 = height + f;
        float f3 = (this.f16623b * 2.0f) * height;
        this.f16622a.reset();
        float a = m16630a((double) f2, (double) height, (double) Math.abs(f3));
        int i = m16631a() ? 180 : 0;
        this.f16622a.addArc(rect, ((float) i) + a, 360.0f - (a * 2.0f));
        rect.offset(f3, 0.0f);
        rect.inset(-f, -f);
        float a2 = m16630a((double) height, (double) f2, (double) Math.abs(f3));
        this.f16622a.arcTo(rect, (180.0f + a2) + ((float) i), a2 * -2.0f);
        this.f16622a.close();
        canvas.drawPath(this.f16622a, paint);
    }

    @VisibleForTesting
    private boolean m16631a() {
        return this.f16623b < 0.0f;
    }

    private static float m16630a(double d, double d2, double d3) {
        boolean z;
        boolean z2 = true;
        Preconditions.checkArgument(d >= 0.0d);
        if (d2 >= 0.0d) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        if (d3 < 0.0d) {
            z2 = false;
        }
        Preconditions.checkArgument(z2);
        return (float) Math.abs(Math.toDegrees(Math.acos(((Math.pow(d2, 2.0d) + Math.pow(d3, 2.0d)) - Math.pow(d, 2.0d)) / ((2.0d * d2) * d3))));
    }
}
