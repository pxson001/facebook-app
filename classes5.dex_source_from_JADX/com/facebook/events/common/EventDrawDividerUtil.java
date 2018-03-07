package com.facebook.events.common;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;

/* compiled from: ZOO_AQUARIUM */
public class EventDrawDividerUtil {
    private Paint f12091a = new Paint(1);

    public EventDrawDividerUtil(Resources resources) {
        this.f12091a.setStyle(Style.STROKE);
        this.f12091a.setColor(resources.getColor(2131363144));
        this.f12091a.setStrokeWidth((float) resources.getDimensionPixelSize(2131427379));
    }

    public final void m20122b(Canvas canvas) {
        m20123b(canvas, 0.0f);
    }

    public final void m20120a(Canvas canvas, float f) {
        m20121a(canvas, f, 0);
    }

    public final void m20121a(Canvas canvas, float f, int i) {
        canvas.drawLine((float) i, f, (float) (canvas.getWidth() - i), f, this.f12091a);
    }

    public final void m20123b(Canvas canvas, float f) {
        int height = canvas.getHeight();
        Canvas canvas2 = canvas;
        canvas2.drawLine(0.0f, (((float) height) - this.f12091a.getStrokeWidth()) - f, (float) canvas.getWidth(), (((float) height) - this.f12091a.getStrokeWidth()) - f, this.f12091a);
    }
}
