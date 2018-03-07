package com.facebook.feedplugins.musicstory.animations;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/* compiled from: composer_exit_failure */
public class ProgressCircle extends View {
    private Paint f8294a;
    private RectF f8295b;
    private float f8296c;
    private float f8297d;
    public float f8298e;

    public ProgressCircle(Context context) {
        super(context);
        m9231b();
    }

    public ProgressCircle(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m9231b();
    }

    public ProgressCircle(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m9231b();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f8298e != 360.0f) {
            canvas.drawArc(this.f8295b, 270.0f, this.f8298e, false, this.f8294a);
        }
    }

    public float getAngle() {
        return this.f8298e;
    }

    public void setAngle(float f) {
        this.f8298e = f % 360.0f;
    }

    public final void m9232a() {
        this.f8298e = 0.0f;
    }

    private void m9231b() {
        this.f8296c = getResources().getDimension(2131434618);
        this.f8297d = getResources().getDimension(2131434617) - (this.f8296c * 2.0f);
        this.f8294a = new Paint();
        this.f8294a.setAntiAlias(true);
        this.f8294a.setStyle(Style.STROKE);
        this.f8294a.setStrokeWidth(this.f8296c);
        this.f8294a.setColor(-1);
        this.f8295b = new RectF(this.f8296c / 2.0f, this.f8296c / 2.0f, this.f8297d + ((this.f8296c * 3.0f) / 2.0f), this.f8297d + ((this.f8296c * 3.0f) / 2.0f));
    }
}
