package com.facebook.backstage.camera;

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

/* compiled from: searchBarTextName */
public class FocusView extends View {
    public final Paint f4403a;
    private final Paint f4404b;
    public final float f4405c;
    private final PointF f4406d;
    private final Runnable f4407e;
    public boolean f4408f;
    public float f4409g;

    /* compiled from: searchBarTextName */
    class C04151 implements Runnable {
        final /* synthetic */ FocusView f4401a;

        C04151(FocusView focusView) {
            this.f4401a = focusView;
        }

        public void run() {
            this.f4401a.f4408f = false;
            this.f4401a.invalidate();
        }
    }

    /* compiled from: searchBarTextName */
    class C04162 implements AnimatorUpdateListener {
        final /* synthetic */ FocusView f4402a;

        C04162(FocusView focusView) {
            this.f4402a = focusView;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f4402a.f4409g = ((Float) valueAnimator.getAnimatedValue()).floatValue() * this.f4402a.f4405c;
            this.f4402a.f4403a.setAlpha((int) (255.0f * valueAnimator.getAnimatedFraction()));
            this.f4402a.invalidate();
        }
    }

    public FocusView(Context context) {
        this(context, null);
    }

    public FocusView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FocusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4406d = new PointF();
        this.f4407e = new C04151(this);
        setWillNotDraw(false);
        this.f4403a = new Paint(1);
        this.f4403a.setColor(-1);
        this.f4403a.setStyle(Style.STROKE);
        this.f4403a.setStrokeWidth(TypedValue.applyDimension(1, 2.0f, getResources().getDisplayMetrics()));
        this.f4404b = new Paint(this.f4403a);
        this.f4404b.setColor(-3355444);
        this.f4404b.setAlpha(128);
        this.f4405c = TypedValue.applyDimension(1, 15.0f, getResources().getDisplayMetrics());
    }

    public final void m4410a(int i, int i2) {
        this.f4406d.set((float) i, (float) i2);
        this.f4408f = true;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{3.0f, 1.0f});
        ofFloat.addUpdateListener(new C04162(this));
        ofFloat.setDuration(450);
        ofFloat.start();
        invalidate();
        removeCallbacks(this.f4407e);
        postDelayed(this.f4407e, 3000);
    }

    public final void m4409a() {
        this.f4408f = false;
        invalidate();
    }

    public final void m4411b() {
        this.f4403a.setColor(-16711936);
        invalidate();
        postDelayed(this.f4407e, 1000);
    }

    public final void m4412c() {
        this.f4403a.setColor(-65536);
        invalidate();
        postDelayed(this.f4407e, 1000);
    }

    public final void m4413d() {
        this.f4403a.setColor(-1);
        invalidate();
        removeCallbacks(this.f4407e);
        postDelayed(this.f4407e, 3000);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f4408f) {
            canvas.drawCircle(this.f4406d.x, this.f4406d.y, this.f4405c * 3.0f, this.f4404b);
            canvas.drawCircle(this.f4406d.x, this.f4406d.y, this.f4409g, this.f4403a);
        }
    }
}
