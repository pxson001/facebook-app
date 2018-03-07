package com.facebook.notifications.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Region.Op;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;

/* compiled from: method not supported */
public class RevealAnimationOverlayView extends View {
    Paint f9055a = new C07241(this);
    private final Path f9056b = new Path();
    private int f9057c = -1;
    private int f9058d = -1;
    private boolean f9059e = true;

    /* compiled from: method not supported */
    class C07241 extends Paint {
        final /* synthetic */ RevealAnimationOverlayView f9054a;

        C07241(RevealAnimationOverlayView revealAnimationOverlayView) {
            this.f9054a = revealAnimationOverlayView;
            setStyle(Style.FILL);
        }
    }

    public RevealAnimationOverlayView(Context context) {
        super(context);
    }

    public RevealAnimationOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RevealAnimationOverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void m10880a(int i, int i2) {
        this.f9057c = i;
        this.f9058d = i2;
    }

    public void setPct(float f) {
        int i;
        float f2;
        int width = getWidth();
        int height = getHeight();
        if (this.f9057c == -1 || this.f9058d == -1) {
            i = width / 2;
            height /= 2;
            f2 = (float) i;
        } else {
            i = this.f9057c;
            height = this.f9058d;
            f2 = (float) Math.max(this.f9057c, width - this.f9057c);
        }
        f2 *= 1.05f;
        this.f9056b.reset();
        this.f9056b.addCircle((float) i, (float) height, (f2 * f) / 100.0f, Direction.CW);
        invalidate();
    }

    public void setColor(int i) {
        this.f9055a.setColor(i);
    }

    protected void onDraw(Canvas canvas) {
        if (VERSION.SDK_INT < 18 && VERSION.SDK_INT >= 11) {
            setLayerType(1, null);
        }
        if (this.f9059e) {
            try {
                canvas.clipPath(this.f9056b, Op.DIFFERENCE);
            } catch (UnsupportedOperationException e) {
                this.f9059e = false;
            }
        }
        canvas.drawRect(0.0f, 0.0f, (float) getWidth(), (float) getHeight(), this.f9055a);
    }
}
