package com.facebook.photos.creativecam.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

/* compiled from: stack_child_interaction */
public class FocusView extends View {
    private final PointF f2255a = new PointF();
    private final Runnable f2256b = new C02711(this);
    public Paint f2257c;
    private Paint f2258d;
    public float f2259e;
    private float f2260f;
    public boolean f2261g;
    public float f2262h;

    /* compiled from: stack_child_interaction */
    class C02711 implements Runnable {
        final /* synthetic */ FocusView f2253a;

        C02711(FocusView focusView) {
            this.f2253a = focusView;
        }

        public void run() {
            this.f2253a.f2261g = false;
            this.f2253a.invalidate();
        }
    }

    /* compiled from: stack_child_interaction */
    class C02722 implements AnimatorUpdateListener {
        final /* synthetic */ FocusView f2254a;

        C02722(FocusView focusView) {
            this.f2254a = focusView;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f2254a.f2262h = ((Float) valueAnimator.getAnimatedValue()).floatValue() * this.f2254a.f2259e;
            this.f2254a.f2257c.setAlpha((int) (255.0f * valueAnimator.getAnimatedFraction()));
            this.f2254a.invalidate();
        }
    }

    public FocusView(Context context) {
        super(context);
        m2403d();
    }

    public FocusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m2403d();
    }

    public FocusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m2403d();
    }

    private void m2403d() {
        setWillNotDraw(false);
        this.f2257c = new Paint(1);
        this.f2257c.setColor(-1);
        this.f2257c.setStyle(Style.STROKE);
        this.f2257c.setStrokeWidth(TypedValue.applyDimension(1, 2.0f, getResources().getDisplayMetrics()));
        this.f2258d = new Paint(this.f2257c);
        this.f2258d.setColor(-3355444);
        this.f2258d.setAlpha(128);
        this.f2259e = TypedValue.applyDimension(1, 15.0f, getResources().getDisplayMetrics());
        this.f2260f = TypedValue.applyDimension(1, 15.0f, getResources().getDisplayMetrics());
    }

    public final void m2405a(int i, int i2) {
        this.f2255a.set((float) i, (float) i2);
        this.f2261g = true;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{3.0f, 1.0f});
        ofFloat.addUpdateListener(new C02722(this));
        ofFloat.setDuration(450);
        ofFloat.start();
        invalidate();
        removeCallbacks(this.f2256b);
        postDelayed(this.f2256b, 3000);
    }

    public final void m2404a() {
        this.f2261g = false;
        invalidate();
    }

    public final void m2406b() {
        this.f2258d.setColor(-256);
        invalidate();
        postDelayed(this.f2256b, 1000);
    }

    public final void m2407c() {
        this.f2258d.setColor(-65536);
        invalidate();
        postDelayed(this.f2256b, 1000);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f2261g) {
            canvas.drawCircle(this.f2255a.x, this.f2255a.y, this.f2260f + this.f2262h, this.f2258d);
            canvas.drawCircle(this.f2255a.x, this.f2255a.y, this.f2262h, this.f2257c);
        }
    }
}
