package com.facebook.uicontrib.circularreveal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path.Direction;
import android.util.AttributeSet;
import com.facebook.widget.CustomFrameLayout;

/* compiled from: TURN_ON_NOTIFICATION */
public class CircularRevealFrameLayout extends CustomFrameLayout implements CircularRevealLayoutHelper$Client {
    private CircularRevealLayoutHelper<CircularRevealFrameLayout> f22407a;

    public CircularRevealFrameLayout(Context context) {
        super(context);
        mo1554a();
    }

    public CircularRevealFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        mo1554a();
    }

    public CircularRevealFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        mo1554a();
    }

    private void mo1554a() {
        this.f22407a = new CircularRevealLayoutHelper(this);
    }

    public void mo1555a(float f, float f2) {
        CircularRevealLayoutHelper circularRevealLayoutHelper = this.f22407a;
        circularRevealLayoutHelper.c = f;
        circularRevealLayoutHelper.d = f2;
    }

    public void setRevealRadius(float f) {
        CircularRevealLayoutHelper circularRevealLayoutHelper = this.f22407a;
        if (!Float.isNaN(f) || !Float.isNaN(circularRevealLayoutHelper.e)) {
            circularRevealLayoutHelper.e = f;
            circularRevealLayoutHelper.b.reset();
            circularRevealLayoutHelper.b.addCircle(circularRevealLayoutHelper.c, circularRevealLayoutHelper.d, circularRevealLayoutHelper.e, Direction.CW);
            circularRevealLayoutHelper.a.invalidate();
        }
    }

    public void draw(Canvas canvas) {
        this.f22407a.a(canvas);
    }

    public final void mo1552a(Canvas canvas) {
        super.draw(canvas);
    }

    protected void dispatchDraw(Canvas canvas) {
        this.f22407a.b(canvas);
    }

    public final void mo1553b(Canvas canvas) {
        super.dispatchDraw(canvas);
    }
}
