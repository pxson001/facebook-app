package com.facebook.spherical.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;

/* compiled from: ephemeral_ttl_mode */
public class HeadingPoiView extends HeadingIndicatorView {
    private RectF f16292b;
    private Paint f16293c;

    public HeadingPoiView(Context context) {
        this(context, null);
    }

    public HeadingPoiView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HeadingPoiView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m23821c();
    }

    private void m23821c() {
        this.f16293c = new Paint();
        this.f16293c.setAntiAlias(true);
        this.f16293c.setColor(-1);
        this.f16293c.setStyle(Style.FILL);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f16292b = new RectF(((float) (canvas.getWidth() / 2)) - m23816a(1.5f), (((float) (canvas.getHeight() / 2)) - m23816a(15.0f)) - m23816a(1.5f), ((float) (canvas.getWidth() / 2)) + m23816a(1.5f), (((float) (canvas.getHeight() / 2)) - m23816a(15.0f)) + m23816a(1.5f));
        canvas.drawOval(this.f16292b, this.f16293c);
    }
}
