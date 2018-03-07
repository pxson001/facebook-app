package com.facebook.spherical.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;

/* compiled from: errMsg= */
public class HeadingBackgroundView extends HeadingIndicatorView {
    private RectF f16284b;
    private Paint f16285c;

    public HeadingBackgroundView(Context context) {
        this(context, null);
    }

    public HeadingBackgroundView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HeadingBackgroundView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m23817c();
    }

    private void m23817c() {
        this.f16285c = new Paint();
        this.f16285c.setAntiAlias(true);
        this.f16285c.setColor(-16777216);
        this.f16285c.setStyle(Style.FILL);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f16284b = new RectF(((float) (canvas.getWidth() / 2)) - m23816a(17.5f), ((float) (canvas.getHeight() / 2)) - m23816a(17.5f), ((float) (canvas.getWidth() / 2)) + m23816a(17.5f), ((float) (canvas.getHeight() / 2)) + m23816a(17.5f));
        canvas.drawOval(this.f16284b, this.f16285c);
    }
}
