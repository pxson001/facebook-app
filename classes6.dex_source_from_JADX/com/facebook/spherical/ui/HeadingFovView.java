package com.facebook.spherical.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;

/* compiled from: equirectangular */
public class HeadingFovView extends HeadingIndicatorView {
    private float f16286b;
    private float f16287c;
    private float f16288d;
    private RectF f16289e;
    private Path f16290f;
    private Paint f16291g;

    public HeadingFovView(Context context) {
        this(context, null);
    }

    public HeadingFovView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HeadingFovView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f16286b = 70.0f;
        m23820c();
        this.f16289e = new RectF();
        this.f16290f = new Path();
    }

    public void setFov(float f) {
        this.f16286b = f;
        invalidate();
    }

    public void setFovYaw(float f) {
        this.f16287c = f;
        invalidate();
    }

    public void setCompassYaw(float f) {
        this.f16288d = f;
        invalidate();
    }

    private void m23820c() {
        this.f16291g = new Paint();
        this.f16291g.setAntiAlias(true);
        this.f16291g.setColor(-1);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f16291g.setStyle(Style.FILL);
        this.f16290f.reset();
        float a = m23816a(14.5f);
        float a2 = m23816a(2.5f) + 0.0f;
        float a3 = a - m23816a(3.0f);
        float a4 = 0.0f - m23816a(2.5f);
        float a5 = a - m23816a(3.0f);
        float a6 = m23818a(0.0f, a, this.f16288d) + ((float) (canvas.getWidth() / 2));
        a = ((float) (canvas.getHeight() / 2)) - m23819b(0.0f, a, this.f16288d);
        float a7 = m23818a(a2, a3, this.f16288d) + ((float) (canvas.getWidth() / 2));
        a2 = ((float) (canvas.getHeight() / 2)) - m23819b(a2, a3, this.f16288d);
        a3 = m23818a(a4, a5, this.f16288d) + ((float) (canvas.getWidth() / 2));
        a4 = ((float) (canvas.getHeight() / 2)) - m23819b(a4, a5, this.f16288d);
        this.f16290f.moveTo(a6, a);
        this.f16290f.lineTo(a7, a2);
        this.f16290f.lineTo(a3, a4);
        this.f16290f.lineTo(a6, a);
        this.f16290f.close();
        canvas.drawPath(this.f16290f, this.f16291g);
        if (this.f16283a) {
            this.f16291g.setStyle(Style.FILL);
            this.f16289e.left = ((float) (canvas.getWidth() / 2)) - m23816a(12.5f);
            this.f16289e.top = ((float) (canvas.getHeight() / 2)) - m23816a(12.5f);
            this.f16289e.right = ((float) (canvas.getWidth() / 2)) + m23816a(12.5f);
            this.f16289e.bottom = ((float) (canvas.getHeight() / 2)) + m23816a(12.5f);
        } else {
            this.f16291g.setStyle(Style.STROKE);
            this.f16291g.setStrokeWidth(m23816a(1.0f));
            this.f16289e.left = ((float) (canvas.getWidth() / 2)) - m23816a(12.0f);
            this.f16289e.top = ((float) (canvas.getHeight() / 2)) - m23816a(12.0f);
            this.f16289e.right = ((float) (canvas.getWidth() / 2)) + m23816a(12.0f);
            this.f16289e.bottom = ((float) (canvas.getHeight() / 2)) + m23816a(12.0f);
        }
        canvas.drawOval(this.f16289e, this.f16291g);
        this.f16291g.setStyle(Style.STROKE);
        this.f16291g.setStrokeWidth(m23816a(5.7f));
        this.f16289e.left = ((float) (canvas.getWidth() / 2)) - m23816a(6.25f);
        this.f16289e.top = ((float) (canvas.getHeight() / 2)) - m23816a(6.25f);
        this.f16289e.right = ((float) (canvas.getWidth() / 2)) + m23816a(6.25f);
        this.f16289e.bottom = ((float) (canvas.getHeight() / 2)) + m23816a(6.25f);
        if (this.f16283a) {
            this.f16291g.setXfermode(new PorterDuffXfermode(Mode.CLEAR));
            canvas.drawArc(this.f16289e, (this.f16287c - 90.0f) - ((this.f16286b * 1.7f) / 2.0f), this.f16286b * 1.7f, false, this.f16291g);
            this.f16291g.setXfermode(null);
        } else {
            canvas.drawArc(this.f16289e, (this.f16287c - 90.0f) - ((this.f16286b * 1.7f) / 2.0f), this.f16286b * 1.7f, false, this.f16291g);
        }
        this.f16291g.setStyle(Style.FILL);
        this.f16289e.left = ((float) (canvas.getWidth() / 2)) - m23816a(2.0f);
        this.f16289e.top = ((float) (canvas.getHeight() / 2)) - m23816a(2.0f);
        this.f16289e.right = ((float) (canvas.getWidth() / 2)) + m23816a(2.0f);
        this.f16289e.bottom = ((float) (canvas.getHeight() / 2)) + m23816a(2.0f);
        if (this.f16283a) {
            this.f16291g.setXfermode(new PorterDuffXfermode(Mode.CLEAR));
            canvas.drawOval(this.f16289e, this.f16291g);
            this.f16291g.setXfermode(null);
            return;
        }
        canvas.drawOval(this.f16289e, this.f16291g);
    }

    private static float m23818a(float f, float f2, float f3) {
        double toRadians = Math.toRadians((double) f3);
        return (float) ((Math.sin(toRadians) * ((double) f2)) + (Math.cos(toRadians) * ((double) f)));
    }

    private static float m23819b(float f, float f2, float f3) {
        double toRadians = Math.toRadians((double) f3);
        return (float) ((Math.cos(toRadians) * ((double) f2)) + ((-Math.sin(toRadians)) * ((double) f)));
    }
}
