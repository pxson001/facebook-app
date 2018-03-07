package com.facebook.facecast.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.common.util.SizeUtil;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: avc3 */
public class CircularProgressView extends View {
    private static final int f18805a = 2131361920;
    private static final int f18806b = 2131361917;
    private Paint f18807c;
    private Paint f18808d;
    private RectF f18809e;
    private float f18810f;

    public CircularProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m22409b();
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1163778031);
        super.onSizeChanged(i, i2, i3, i4);
        m22408a();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -847566848, a);
    }

    private void m22408a() {
        float a = (float) SizeUtil.a(getContext(), 2.0f);
        this.f18809e = new RectF(a, a, ((float) getWidth()) - a, ((float) getHeight()) - a);
    }

    private void m22409b() {
        this.f18807c = m22407a(f18805a);
        this.f18808d = m22407a(f18806b);
    }

    private Paint m22407a(int i) {
        Paint paint = new Paint();
        paint.setColor(getResources().getColor(i));
        paint.setStrokeWidth((float) SizeUtil.a(getContext(), 2.0f));
        paint.setStyle(Style.STROKE);
        paint.setAntiAlias(true);
        return paint;
    }

    public void setProgress(float f) {
        this.f18810f = f;
        if (this.f18810f > 1.0f) {
            this.f18810f = 1.0f;
        }
        if (this.f18810f < 0.0f) {
            this.f18810f = 0.0f;
        }
        invalidate();
    }

    public float getProgress() {
        return this.f18810f;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc(this.f18809e, 0.0f, 360.0f, false, this.f18807c);
        if (this.f18810f > 0.0f) {
            Canvas canvas2 = canvas;
            canvas2.drawArc(this.f18809e, -90.0f, 360.0f * this.f18810f, false, this.f18808d);
        }
    }
}
